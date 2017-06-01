package com.sps.ecommerce.admin.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	@RequestMapping("/404")
	public String pageNoFound()
	{
		return "404";
	}
	
	@RequestMapping("/500")
	public String processError()
	{
		return "500";
	}
}
