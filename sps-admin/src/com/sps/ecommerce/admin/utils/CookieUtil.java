package com.sps.ecommerce.admin.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	// cookie的存在时间 ,默认30天
	private static final int maxAge = 30 * 24 * 60 * 60;

	/**
	 * 设置cookie（接口方法）
	 * 
	 * @author hexing
	 * @param response
	 * @param name
	 *            cookie名字
	 * @param value
	 *            cookie值
	 */
	public static void addCookie(HttpServletResponse response, String name,
			String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		if (maxAge > 0) {
			cookie.setMaxAge(maxAge);
		}
		response.addCookie(cookie);
	}

	/**
	 * 根据名字获取cookie（接口方法）
	 * 
	 * @author hexing
	 * @param request
	 * @param name
	 *            cookie名字
	 * @return
	 */
	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}
	}

	/**
	 * 将cookie封装到Map里面（非接口方法）
	 * 
	 * @author hexing
	 * @param request
	 * @return
	 */
	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}
	
	/**
     * 清空cookie
     */
    public static void clearCookie(HttpServletRequest request,HttpServletResponse response) 
    {
    	
      Cookie[] cookies = request.getCookies();
      try
      {
    	  if (cookies!=null&&cookies.length>0) 
  	      {
    		  for(int i=0;i<cookies.length;i++)    
              { 
	             Cookie cookie = new Cookie(cookies[i].getName(), null);
	             cookie.setMaxAge(0);
	             cookie.setPath("/");    
	             response.addCookie(cookie);
    		  }
  		  }
      }catch(Exception ex)
      {
         //nothing to do
      } 
    }
}