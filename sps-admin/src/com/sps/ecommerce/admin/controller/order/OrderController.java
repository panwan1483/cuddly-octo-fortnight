package com.sps.ecommerce.admin.controller.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 订单信息
 * @author wangfucai
 */
@RequestMapping("/admin")
public class OrderController {

	/**
	 * 订单列表
	 */
	@RequestMapping(value = "/orderList", method = { RequestMethod.POST })
    public String orderList(HttpServletRequest request, HttpServletResponse response)
    {
		return "";
    }
}