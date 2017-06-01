package com.sps.ecommerce.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sps.ecommerce.admin.entity.LoginLog;
import com.sps.ecommerce.admin.service.LoginLogService;
import com.sps.ecommerce.admin.utils.PageUtil;

@Controller
@RequestMapping("/loginLog")
public class LoginLogController extends BaseController{

	@Autowired
	private LoginLogService loginLogService;
	
	    //日志管理
		@RequestMapping(value="/listSysUsersLogin",method={RequestMethod.POST,RequestMethod.GET})
		public String listSysUsersLogin(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception
		{
			int currentPageNum = 0;
			int currentPageSize = 10;
			
			String pageNum = request.getParameter("page_num");
			String pageSize = request.getParameter("page_size");
			
			String username= request.getParameter("username");
			
			if (StringUtils.isNotBlank(pageNum)) {
				currentPageNum = NumberUtils.toInt(pageNum);
			}

			if (StringUtils.isNotBlank(pageSize)) {
				currentPageSize = NumberUtils.toInt(pageSize);
			}
			
			List<LoginLog> list=this.loginLogService.listSysUsersLogin(username, currentPageNum, currentPageSize);
				
			int total=this.loginLogService.getPageCount(username);
		
			
			PageUtil paging_vo = new PageUtil(currentPageSize, total, currentPageNum);

			paging_vo.setObject(list);
			model.addAttribute("paging_vo", paging_vo);
			model.addAttribute("username",username);

			return "sys/sysUsersLoginList";
		}
}
