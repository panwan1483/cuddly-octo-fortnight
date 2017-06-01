package com.sps.ecommerce.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 首页
 * @author wangfucai
 */
@Controller
public class IndexController {

	@RequestMapping(value={"/"},method={RequestMethod.GET,RequestMethod.POST})
	public String index() {
		return "index";
	}
	
	@RequestMapping(value={"/manage"},method={RequestMethod.GET,RequestMethod.POST})
	public String manage() {
		return "manage";
	}
	
	@RequestMapping(value={"/welcome"},method={RequestMethod.GET,RequestMethod.POST})
	public String welcome() {
		return "welcome";
	}
	
}