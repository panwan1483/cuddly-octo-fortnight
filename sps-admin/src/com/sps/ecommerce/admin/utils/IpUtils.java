package com.sps.ecommerce.admin.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;

/**
 *  IP地址工具类
 * @author wangfucai
 */
public class IpUtils {
	
	/**
	 * 淘宝提供的IP
	 */
	public static final String TAOBAO_IP="http://ip.taobao.com/service/getIpInfo.php?ip=";
	
	/**
	 * 通过request文件头拿到真实IP地址
	 */
	public static String getRealIp(HttpServletRequest request) 
	{
		String realIp = request.getHeader("X-Real-IP");
		if (StringUtils.isNotBlank(realIp)) {
			return realIp;
		}
		
		String ip = request.getHeader("X-Forwarded-For");
		if (StringUtils.isBlank(ip)) {
			return request.getRemoteAddr();
		}
		ip = ip.split(", ")[0].trim();
		if ("127.0.0.1".equals(ip) || !isLicitIp(ip)) {
			return request.getRemoteAddr();
		}
		return ip;
	}
	
	private static boolean isLicitIp(String ip) {
		if (StringUtils.isEmpty(ip))
			return false;
		String regex = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(ip);
		return m.find();
	}
}