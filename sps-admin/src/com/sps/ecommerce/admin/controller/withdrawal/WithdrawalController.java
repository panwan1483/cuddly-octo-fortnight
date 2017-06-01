package com.sps.ecommerce.admin.controller.withdrawal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sps.ecommerce.admin.constants.JsonResult;
import com.sps.ecommerce.admin.constants.JsonResultCode;
import com.sps.ecommerce.admin.constants.WithdrawalConstant;
import com.sps.ecommerce.admin.controller.BaseController;
import com.sps.ecommerce.admin.entity.Withdrawal;
import com.sps.ecommerce.admin.service.WithdrawalService;
import com.sps.ecommerce.admin.utils.PageUtil;

/**
 * 后台提现功能
 * 
 * @author wangfucai
 */
@Controller
@RequestMapping("/admin")
public class WithdrawalController extends BaseController {

	@Autowired
	private WithdrawalService withdrawalService;

	/**
	 * 待审核提现列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/withdrawal/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String withdrawalList(HttpServletRequest request, HttpServletResponse response, Model model) {
		int currentPageNum = 0;
		int currentPageSize = 10;

		String pageNum = request.getParameter("page_num");
		String pageSize = request.getParameter("page_size");

		String applyer = request.getParameter("applyer");
		String applyOrder = request.getParameter("applyOrder");
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("endTime");

		if (StringUtils.isNotBlank(pageNum)) {
			currentPageNum = NumberUtils.toInt(pageNum);
		}

		if (StringUtils.isNotBlank(pageSize)) {
			currentPageSize = NumberUtils.toInt(pageSize);
		}

		List<Withdrawal> list = this.withdrawalService.listWithdrawal(WithdrawalConstant.APPLY_WITHDRAWAL, applyer,
				applyOrder, beginTime, endTime, currentPageNum, currentPageSize);

		int total = this.withdrawalService.getPageCount(WithdrawalConstant.APPLY_WITHDRAWAL, applyer, applyOrder,
				beginTime, endTime);

		PageUtil paging_vo = new PageUtil(currentPageSize, total, currentPageNum);

		paging_vo.setObject(list);

		model.addAttribute("paging_vo", paging_vo);
		model.addAttribute("applyer", applyer);
		model.addAttribute("applyOrder", applyOrder);
		model.addAttribute("beginTime", beginTime);
		model.addAttribute("endTime", endTime);
		return "withdrawal/withdrawalList";
	}

	/**
	 * 已经审核列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/withdrawal/passList", method = { RequestMethod.GET, RequestMethod.POST })
	public String withdrawalPassList(HttpServletRequest request, HttpServletResponse response, Model model) {
		int currentPageNum = 0;
		int currentPageSize = 10;

		String pageNum = request.getParameter("page_num");
		String pageSize = request.getParameter("page_size");

		String applyer = request.getParameter("applyer");
		String applyOrder = request.getParameter("applyOrder");
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("endTime");

		if (StringUtils.isNotBlank(pageNum)) {
			currentPageNum = NumberUtils.toInt(pageNum);
		}

		if (StringUtils.isNotBlank(pageSize)) {
			currentPageSize = NumberUtils.toInt(pageSize);
		}

		List<Withdrawal> list = this.withdrawalService.listWithdrawal(WithdrawalConstant.PASS_WITHDRAWAL, applyer,
				applyOrder, beginTime, endTime, currentPageNum, currentPageSize);

		int total = this.withdrawalService.getPageCount(WithdrawalConstant.PASS_WITHDRAWAL, applyer, applyOrder,
				beginTime, endTime);

		PageUtil paging_vo = new PageUtil(currentPageSize, total, currentPageNum);

		paging_vo.setObject(list);

		model.addAttribute("paging_vo", paging_vo);
		model.addAttribute("applyer", applyer);
		model.addAttribute("applyOrder", applyOrder);
		model.addAttribute("beginTime", beginTime);
		model.addAttribute("endTime", endTime);

		return "withdrawal/withdrawalPassList";
	}

	/**
	 * 交易完成提现
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/withdrawal/finishList", method = { RequestMethod.GET, RequestMethod.POST })
	public String withdrawalFinishList(HttpServletRequest request, HttpServletResponse response, Model model) {
		int currentPageNum = 0;
		int currentPageSize = 10;

		String pageNum = request.getParameter("page_num");
		String pageSize = request.getParameter("page_size");

		String applyer = request.getParameter("applyer");
		String applyOrder = request.getParameter("applyOrder");
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("end_time");

		if (StringUtils.isNotBlank(pageNum)) {
			currentPageNum = NumberUtils.toInt(pageNum);
		}

		if (StringUtils.isNotBlank(pageSize)) {
			currentPageSize = NumberUtils.toInt(pageSize);
		}

		List<Withdrawal> list = this.withdrawalService.listWithdrawal(WithdrawalConstant.FINISH_WITHDRAWAL, applyer,
				applyOrder, beginTime, endTime, currentPageNum, currentPageSize);

		int total = this.withdrawalService.getPageCount(WithdrawalConstant.FINISH_WITHDRAWAL, applyer, applyOrder,
				beginTime, endTime);

		PageUtil paging_vo = new PageUtil(currentPageSize, total, currentPageNum);

		paging_vo.setObject(list);

		model.addAttribute("paging_vo", paging_vo);
		model.addAttribute("applyer", applyer);
		model.addAttribute("applyOrder", applyOrder);
		model.addAttribute("beginTime", beginTime);
		model.addAttribute("endTime", endTime);

		return "withdrawal/withdrawalFinishList";
	}

	/**
	 * 拒绝审核列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/withdrawal/rejectList", method = { RequestMethod.GET, RequestMethod.POST })
	public String withdrawalRejectList(HttpServletRequest request, HttpServletResponse response, Model model) {
		int currentPageNum = 0;
		int currentPageSize = 10;

		String pageNum = request.getParameter("page_num");
		String pageSize = request.getParameter("page_size");

		String applyer = request.getParameter("applyer");
		String applyOrder = request.getParameter("applyOrder");
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("end_time");

		if (StringUtils.isNotBlank(pageNum)) {
			currentPageNum = NumberUtils.toInt(pageNum);
		}

		if (StringUtils.isNotBlank(pageSize)) {
			currentPageSize = NumberUtils.toInt(pageSize);
		}

		List<Withdrawal> list = this.withdrawalService.listWithdrawal(WithdrawalConstant.REJECT_WITHDRAWAL, applyer,
				applyOrder, beginTime, endTime, currentPageNum, currentPageSize);

		int total = this.withdrawalService.getPageCount(WithdrawalConstant.REJECT_WITHDRAWAL, applyer, applyOrder,
				beginTime, endTime);

		PageUtil paging_vo = new PageUtil(currentPageSize, total, currentPageNum);

		paging_vo.setObject(list);

		model.addAttribute("paging_vo", paging_vo);
		model.addAttribute("applyer", applyer);
		model.addAttribute("applyOrder", applyOrder);
		model.addAttribute("beginTime", beginTime);
		model.addAttribute("endTime", endTime);

		return "withdrawal/withdrawalRejectList";
	}

	/**
	 * 提现订单详细信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/withdrawal/detail", method = { RequestMethod.GET, RequestMethod.POST })
	public String withdrawalDetail(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long withdrawalId = NumberUtils.toLong(request.getParameter("withdrawalId"));

		Withdrawal withdrawal = withdrawalService.getWithdrawalById(withdrawalId);

		model.addAttribute("withdrawal", withdrawal);

		return "withdrawal/withdrawalDetail";

	}

	/**
	 * 同意提现申请
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/withdrawal/pass", method = { RequestMethod.GET, RequestMethod.POST })
	public Object withdrawalPass(Withdrawal withdrawal, HttpServletRequest request, HttpServletResponse response) {
		try {
			// 执行同意结果
			withdrawal.setStatus(WithdrawalConstant.FINISH_WITHDRAWAL);
			int result = this.withdrawalService.updateWithdrawal(withdrawal);
			if (result > 0) {

				Map<String, String> paramMap = new HashMap<String, String>();

				paramMap.put("url", request.getContextPath() + "/admin/withdrawal/list");

				return new JsonResult(JsonResultCode.SUCCESS, "系统提现审核成功", paramMap);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "系统提现失败", "");
			}
		} catch (Exception e) {
			return new JsonResult(JsonResultCode.FAILURE, "系统错误，请联系管理员", "");
		}
	}

	/**
	 * 拒绝提现申请
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/withdrawal/reject", method = { RequestMethod.GET, RequestMethod.POST })
	public Object withdrawalReject(Withdrawal withdrawal, HttpServletRequest request, HttpServletResponse response) {
		try 
		{
			// 执行拒绝提现
			String remark = request.getParameter("withdrawal.remark");
			withdrawal.setRemark(remark);
			withdrawal.setStatus(WithdrawalConstant.REJECT_WITHDRAWAL);
			int result = this.withdrawalService.updateWithdrawal(withdrawal);
			if (result > 0) {

				Map<String, String> paramMap = new HashMap<String, String>();

				paramMap.put("url", request.getContextPath() + "/admin/withdrawal/list");

				return new JsonResult(JsonResultCode.SUCCESS, "提现审核不通过", paramMap);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "系统拒绝提现失败", "");
			}
		} catch (Exception e) {
			return new JsonResult(JsonResultCode.FAILURE, "系统错误，请联系管理员", "");
		}
	}
}