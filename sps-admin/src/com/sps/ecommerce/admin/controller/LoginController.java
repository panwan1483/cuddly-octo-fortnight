package com.sps.ecommerce.admin.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sps.ecommerce.admin.constants.JsonResult;
import com.sps.ecommerce.admin.constants.JsonResultCode;
import com.sps.ecommerce.admin.constants.SysConstant;
import com.sps.ecommerce.admin.entity.LoginLog;
import com.sps.ecommerce.admin.entity.SysUsers;
import com.sps.ecommerce.admin.service.LoginLogService;
import com.sps.ecommerce.admin.service.SysUsersService;
import com.sps.ecommerce.admin.utils.EncryptUtil;
import com.sps.ecommerce.admin.utils.IpUtils;
import com.sps.ecommerce.admin.utils.UserAgentUtils;

/***
 * 登陆
 * @author wangfucai
 */
@Controller
@RequestMapping("/sys")
public class LoginController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * 禁止
	 */
	public static final int FORBIDDEN = -1;
	
	public static final int SUCCESS = 1;

	@Autowired
	private SysUsersService sysUsersService;
	
	@Autowired
	private LoginLogService loginLogService;

	/*
	 * 用户的登陆
	 * @param user
	 * @param request
	 * @return json格式的对象
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public Object login(HttpServletRequest request, HttpServletResponse response) {

		// 基本参数检查
		String username = this.getNotNull("username", request);

		String password = this.getNotNull("password", request);
		
		String code = this.getNotNull("code", request);

		if (StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(code)) {
			logger.info("[LoginController][login] username:" + username + " password: " + password+" code:" +code);
			return new JsonResult(JsonResultCode.FAILURE, "用户名或者密码或者验证码为空", "");
		}
		try
		{
			//比对验证码
			String sessionCode=(String)request.getSession().getAttribute(SysConstant.SESSION_SECURITY_CODE);
			
			if(!code.equalsIgnoreCase(sessionCode))
			{
				return new JsonResult(JsonResultCode.FAILURE,"验证码不正确","");
			}
			
			SysUsers sysUsers = this.sysUsersService.getSysUsersByUsername(username) ;

			if (sysUsers == null) {
				return new JsonResult(JsonResultCode.FAILURE, "用户名不存在", "");
			}

			if (sysUsers.getStatus() == FORBIDDEN) {
				return new JsonResult(JsonResultCode.FAILURE, "账号已经被禁用,请联系系统管理员", "");
			}

			if (!EncryptUtil.getMD5(password).equalsIgnoreCase(sysUsers.getPassword())) {
				
				//失败日志
				loginLogService.saveLoginLog(createLoginLog(sysUsers,request,FORBIDDEN));
				return new JsonResult(JsonResultCode.FAILURE, "登陆的密码错误", "");
			}

			// 登录成功，创建session
			request.getSession().setAttribute(SysConstant.SESSION_SYS, sysUsers);
			
			Map<String,String> paramMap =new HashMap<String,String>();
			
			paramMap.put("url",request.getContextPath()+"/manage");
			
			//成功日志
			loginLogService.saveLoginLog(createLoginLog(sysUsers,request,SUCCESS));
			
			
			return new JsonResult(JsonResultCode.SUCCESS, "登陆成功",paramMap);
			
		}catch(Exception e)
		{
			logger.error("[LoginController][login] exception:",e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

	/**
	 * 用户注销
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// 注销session
		session.removeAttribute(SysConstant.SESSION_SYS);
		session.invalidate();
		return "redirect:/login.jsp";
	}
	
	
	private LoginLog createLoginLog(SysUsers sysUsers,HttpServletRequest request,int status)
	{
		LoginLog log=new LoginLog();
		
		log.setSysId(sysUsers.getId());
		log.setUsername(sysUsers.getUsername());
		log.setIp(IpUtils.getRealIp(request));
		log.setOs(UserAgentUtils.getClientOS(request));
		log.setStatus(status);
		log.setBrowser(UserAgentUtils.getBrowserInfo(request));
		log.setCreateTime(new Date());
		return log;
	}
}