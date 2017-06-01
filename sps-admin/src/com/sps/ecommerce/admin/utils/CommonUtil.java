package com.sps.ecommerce.admin.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
/**
 * 公共工具类
 * 
 * @author wangfuai
 */

public class CommonUtil {
	/**
	 * 获得请求的URL
	 * 
	 * @param request
	 * @return
	 */
	public static String getURL(HttpServletRequest request) {
		String contextPath = request.getContextPath().equals("/") ? ""
				: request.getContextPath();
		String url = "http://" + request.getServerName();
		if (request.getServerPort() != 80) {
			url = url + ":" + request.getServerPort() + contextPath;
		} else {
			url = url + contextPath;
		}
		return url;
	}

	/***
	 * 是否是手机浏览平台
	 * @param userAgent
	 */
	public boolean checkMobile(String userAgent) 
	{
		if (StringUtils.isBlank(userAgent)) 
		{
			return false;
		}

		String phoneReg = "\\b(ip(hone|od)|android|opera m(ob|in)i"
				+ "|windows (phone|ce)|blackberry"
				+ "|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp"
				+ "|laystation portable)|nokia|fennec|htc[-_]"
				+ "|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";

		String tableReg = "\\b(ipad|tablet|(Nexus 7)|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";

		Pattern phonePat = Pattern.compile(phoneReg, Pattern.CASE_INSENSITIVE);

		Pattern tablePat = Pattern.compile(tableReg, Pattern.CASE_INSENSITIVE);

		Matcher matcherPhone = phonePat.matcher(userAgent);
		
		Matcher matcherTable = tablePat.matcher(userAgent);
		
		if (matcherPhone.find() || matcherTable.find()) {
			return true;
		} else {
			return false;
		}
	}
}