package com.sps.ecommerce.admin.controller.withdrawal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sps.ecommerce.admin.constants.JsonResult;
import com.sps.ecommerce.admin.constants.JsonResultCode;
import com.sps.ecommerce.admin.constants.SysConstant;
import com.sps.ecommerce.admin.controller.BaseController;
import com.sps.ecommerce.admin.entity.Withdrawal;
import com.sps.ecommerce.admin.entity.WithdrawalPassword;
import com.sps.ecommerce.admin.service.WithdrawalPasswordService;
import com.sps.ecommerce.admin.utils.PageUtil;

/**
 * 后台提现密码功能
 * @author wangfucai
 */
@Controller
@RequestMapping("/admin")
public class WithdrawalPasswordController extends BaseController{

	private static final Logger logger=LoggerFactory.getLogger(WithdrawalPasswordController.class);
	
	@Autowired
	private WithdrawalPasswordService withdrawalPasswordService;
	/**
	 * 提现密码管理列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/withdrawal/passwordList",method={RequestMethod.GET,RequestMethod.POST})
	public String withdrawalPasswordList(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		int currentPageNum = 0;
		int currentPageSize = 10;

		String pageNum = request.getParameter("page_num");
		String pageSize=request.getParameter("page_size");
		Long uid= NumberUtils.toLong(request.getParameter("uid"));

		if (StringUtils.isNotBlank(pageNum)) {
			currentPageNum = NumberUtils.toInt(pageNum);
		}
		
		if (StringUtils.isNotBlank(pageSize)) {
			currentPageSize =NumberUtils.toInt(pageSize);
		}
		
		List<WithdrawalPassword> list = this.withdrawalPasswordService.listWithdrawalPassword(uid,currentPageNum, currentPageSize);
		
		int total = this.withdrawalPasswordService.getPageCount();

		PageUtil paging_vo = new PageUtil(currentPageSize, total, currentPageNum);

		paging_vo.setObject(list);
		
		model.addAttribute("paging_vo", paging_vo);
		if (uid!=0) {
			model.addAttribute("uid",uid);
		}
		
		return "withdrawal/withdrawalPasswordList";
	}
	
	/**
	 * 重置提现密码,返回json格式
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/withdrawal/reset",method={RequestMethod.GET,RequestMethod.POST})
	public Object updateWithdrawalPassword(Withdrawal withdrawal,HttpServletRequest request,HttpServletResponse response,Model model)
	{
		Long uid = NumberUtils.toLong(request.getParameter("uid"));
		
		if (uid==0) 
		{
			return new JsonResult(JsonResultCode.FAILURE,"系统参数有无","");
		}
		
		//查询数据库
		WithdrawalPassword withdrawalPassword=this.withdrawalPasswordService.getWithdrawalPasswordByUid(uid);
		
		if(withdrawalPassword==null)
		{
			return new JsonResult(JsonResultCode.FAILURE,"该用户没有任何提现密码","");
		}
		
		int result=0;
		try
		{
			result=withdrawalPasswordService.updateWithdrawalPassword(uid, SysConstant.DEFAULT_WITHDRAWAL_PASSWORD);
		}catch(Exception e)
		{
			logger.error("[WithdrawalPasswordController][updateWithdrawalPassword]",e);
			return new JsonResult(JsonResultCode.FAILURE,"系统错误，重置失败","");
		}
		
		if (result>0) 
		{
			return new JsonResult(JsonResultCode.SUCCESS,"密码修改成功","");
		}else 
		{
			return new JsonResult(JsonResultCode.FAILURE,"密码修改失败，请联系管理员","");
		}
	}
}