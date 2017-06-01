package com.sps.ecommerce.admin.controller.address;

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
import com.sps.ecommerce.admin.entity.Address;
import com.sps.ecommerce.admin.service.AddressService;
import com.sps.ecommerce.admin.utils.PageUtil;


/*
 * 买家地址管理(收货地址管理)
 * 一个人只允许添加5条地址信息，类似于淘宝
 */
@Controller
@RequestMapping("/admin")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	//TODO 分页查询，根据手机号与真实姓名查询
	//TODO 管理员可以删除地址
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * 
	 * 分页查询，根据手机号与真实姓名查询
	 * */
	@RequestMapping(value="/address/list",method={RequestMethod.GET,RequestMethod.POST})
	public String addressList(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		int currentPageNum = 0;
		int currentPageSize = 10;

		String pageNum = request.getParameter("page_num");
		String pageSize= request.getParameter("page_size");
		String telephone = request.getParameter("telephone");
		String trueName =request.getParameter("trueName");
		
		if (StringUtils.isNotBlank(pageNum)) {
			currentPageNum = NumberUtils.toInt(pageNum);
		}
		
		if (StringUtils.isNotBlank(pageSize)) {
			currentPageSize =NumberUtils.toInt(pageSize);
		}
		
		List<Address> list = this.addressService.listAddress(telephone, trueName, currentPageNum, currentPageSize);
		
		int total = this.addressService.getPageCount(telephone,trueName);
		
		PageUtil paging_vo = new PageUtil(currentPageSize, total, currentPageNum);
		
		paging_vo.setObject(list);
		
		model.addAttribute("paging_vo",paging_vo);
		model.addAttribute("telephone",telephone);
		model.addAttribute("trueName",trueName);
		
		return "address/addressList";
	}
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * 
	 * 后台删除买家地址
	 * **/
	@ResponseBody
	@RequestMapping(value="/address/delete",method={RequestMethod.GET,RequestMethod.POST})
	public Object deleteAddress(HttpServletRequest request,HttpServletResponse response,Model model,Address address)
	{
		try{
		Long id = NumberUtils.toLong(request.getParameter("id"));
		
		int result=addressService.deleteAddress(id);
		
		if (result>0) {
			Map<String,String> paramMap =new HashMap<String,String>();
			
			paramMap.put("url",request.getContextPath()+"/admin/address/list");
			
			return new JsonResult(JsonResultCode.SUCCESS,"删除成功",paramMap);
		}else{
			return new JsonResult(JsonResultCode.FAILURE,"删除失败","");
		}
		  }
		catch(Exception ex){
			return new JsonResult(JsonResultCode.FAILURE,"系统错误，请联系管理员","");
		}
	}
}