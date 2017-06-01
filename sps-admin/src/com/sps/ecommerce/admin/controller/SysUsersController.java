package com.sps.ecommerce.admin.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.client.protocol.RequestTargetAuthentication;
import org.aspectj.weaver.Shadow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sps.ecommerce.admin.constants.JsonResult;
import com.sps.ecommerce.admin.constants.JsonResultCode;
import com.sps.ecommerce.admin.constants.SysConstant;
import com.sps.ecommerce.admin.entity.LoginLog;
import com.sps.ecommerce.admin.entity.SysUsers;
import com.sps.ecommerce.admin.service.SysUsersService;
import com.sps.ecommerce.admin.utils.EncryptUtil;
import com.sps.ecommerce.admin.utils.PageUtil;

@Controller
@RequestMapping("/sysUsers")
public class SysUsersController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private SysUsersService sysUsersService;
	
	@RequestMapping(value="/show",method={ RequestMethod.POST ,RequestMethod.GET})
	public String showSysUsers(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		return "sys/addsysUsers";
	}

	@ResponseBody
	@RequestMapping(value = "/save", method = { RequestMethod.POST ,RequestMethod.GET})
	public Object saveSysUsers(HttpServletRequest request,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "confirmpassword") String confirmpassword,
			SysUsers sysUsers) {
		try 
		{
			//基准参数检查
			String username=sysUsers.getUsername();
			
			if (StringUtils.isBlank(username)) {
				return new JsonResult(JsonResultCode.FAILURE,"账号有误，请重试","");
			}
			
			SysUsers querySysUsers=this.sysUsersService.getSysUsersByUsername(username);
			
			if (querySysUsers!=null) {
				return new JsonResult(JsonResultCode.FAILURE,"该账号已经被占用，请更换","");
			}
			
			//去掉前后端空格
			password=password.trim();
			confirmpassword=confirmpassword.trim();
			
			if (!password.equals(confirmpassword)) 
			{
				return new JsonResult(JsonResultCode.FAILURE, "密码与确认密码输入不一致", "");
			}
			
			sysUsers.setPassword(EncryptUtil.getMD5(password));
			sysUsers.setCreateTime(new Date());
			
			int result = this.sysUsersService.saveSysUsers(sysUsers);
			
			if(result>0)
			{
                Map<String,String> paramMap=new HashMap<String,String>();
				
				paramMap.put("url",request.getContextPath()+"/sysUsers/listSysUsers");
				
				return new JsonResult(JsonResultCode.SUCCESS, "添加成功",paramMap);
			}else
			{
				return new JsonResult(JsonResultCode.FAILURE, "添加失败", "");
			}
		} catch (Exception e) 
		{
			logger.error("[SysUsersController][saveUsers] exception:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public Object updateSysUsers(HttpServletRequest request, HttpServletResponse response, SysUsers sysUsers) {
		try 
		{
			int result = this.sysUsersService.updateSysUsers(sysUsers);
			
			if(result>0)
			{
				return new JsonResult(JsonResultCode.SUCCESS, "修改成功", "");
			}else
			{
				return new JsonResult(JsonResultCode.FAILURE, "修改失败", "");
			}
		} catch (Exception e) 
		{
			logger.error("[SysUsersController][saveUsers] exception:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}
	
	@RequestMapping(value="/showModifyPassword",method={RequestMethod.GET,RequestMethod.POST})
	public String showModifyPassword(Model model,HttpServletRequest request) 
	{
		return "sys/modifyPassword";
	}
	
	/***
	 * 修改个人密码
	 * @param model
	 * @param oldPassword  旧密码
	 * @param newPassword  新密码
	 * @param confirmPassword 确认密码
	 * @param request  
	 * @return JSON格式，是否成功
	 */
	@ResponseBody
	@RequestMapping(value="/modifyPassword",method={RequestMethod.POST})
	public Object modifyPassword(Model model,
			@RequestParam(value = "oldPassword") String oldPassword,
			@RequestParam(value = "newPassword") String newPassword,
			@RequestParam(value = "confirmPassword") String confirmPassword,
			HttpServletRequest request) {
		
		try 
		{
				//基本参数检查
				if (StringUtils.isBlank(oldPassword)|| StringUtils.isBlank(newPassword)||StringUtils.isBlank(confirmPassword)) {
					return new JsonResult(JsonResultCode.FAILURE, "旧密码或新密码或者确认新密码不能为空", "");
				}
				
				//去掉前后端空格
				oldPassword=oldPassword.trim();
				newPassword=newPassword.trim();
				confirmPassword=confirmPassword.trim();
				
				if (!newPassword.equals(confirmPassword)) 
				{
					return new JsonResult(JsonResultCode.FAILURE, "新密码与确认密码输入不一致", "");
				}
				
				//获取session对象
				SysUsers loginUsers = (SysUsers) request.getSession().getAttribute(SysConstant.SESSION_SYS);
				
				if(loginUsers==null)
				{
					return new JsonResult(JsonResultCode.FAILURE, "请先登录，再修改密码", "");
				}
				
				Long sysId=loginUsers.getId();
				
				if(!EncryptUtil.getMD5(oldPassword).equalsIgnoreCase(loginUsers.getPassword())) 
				{
					return new JsonResult(JsonResultCode.FAILURE, "原密码输入错误", "");
				}
				
				int result=this.sysUsersService.updateSysUsersPassword(sysId, EncryptUtil.getMD5(newPassword));
				
				if(result>0)
				{
					
					Map<String,Object> dataMap=new HashMap<String,Object>();
					
					dataMap.put("url", request.getContextPath()+"/sys/logout");
					
					return new JsonResult(JsonResultCode.SUCCESS, "修改成功,返回页面重新登录", dataMap);
					
				}else
				{
					return new JsonResult(JsonResultCode.FAILURE, "密码修改失败，请联系管理员", "");
				}
				
		} catch (Exception e) 
		{
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}
	
	@RequestMapping(value="/listSysUsers",method={RequestMethod.POST,RequestMethod.GET})
	public String listSysUsers(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception
	{
		int currentPageNum = 0;
		int currentPageSize = 10;
		
		String pageNum = request.getParameter("page_num");
		String pageSize = request.getParameter("page_size");
		
		String cnname= request.getParameter("cnname");
		
		String reqStatus=request.getParameter("status");
		
		int status=0;
		
		if(StringUtils.isBlank(reqStatus))
		{
			//1表示查询所有
			status=1;
		}else
		{
			status=NumberUtils.toInt(reqStatus);
		}
		
		if (StringUtils.isNotBlank(pageNum)) {
			currentPageNum = NumberUtils.toInt(pageNum);
		}

		if (StringUtils.isNotBlank(pageSize)) {
			currentPageSize = NumberUtils.toInt(pageSize);
		}
		
		List<SysUsers> list=this.sysUsersService.listSysUsers(cnname, status, currentPageNum, currentPageSize);
			
		int total=this.sysUsersService.getPageCount(cnname, status, currentPageNum, currentPageSize);
	
		
		PageUtil paging_vo = new PageUtil(currentPageSize, total, currentPageNum);

		paging_vo.setObject(list);
		model.addAttribute("paging_vo", paging_vo);
		model.addAttribute("cnname",cnname);
		model.addAttribute("status",status);

		return "sys/sysUsersList";
	}
	
	@ResponseBody
	@RequestMapping(value="/delete",method={RequestMethod.POST,RequestMethod.GET})
	public Object deleteSysUsers(HttpServletRequest request,HttpServletResponse response,Model model,int status)
	{
		try 
		{
			Long id= NumberUtils.toLong(request.getParameter("id"));
			
			int result = this.sysUsersService.deleteSysUsers(id,status);
			
			if(result>0)
			{
				Map<String,Object> dataMap=new HashMap<String,Object>();
				
				dataMap.put("url",request.getContextPath()+"/sysUsers/listSysUsers");
				
				return new JsonResult(JsonResultCode.SUCCESS, "操作成功",dataMap);
			}else
			{
				return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
			}
		} catch (Exception e) 
		{
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}
}