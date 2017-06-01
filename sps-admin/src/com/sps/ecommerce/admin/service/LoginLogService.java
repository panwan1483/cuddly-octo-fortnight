package com.sps.ecommerce.admin.service;

import java.util.List;

import com.sps.ecommerce.admin.entity.LoginLog;

public interface LoginLogService {

	/**
	 * 日志管理
	 * @param username
	 */
	 public List<LoginLog> listSysUsersLogin(String username,int pageNum,int pageSize) throws Exception;
	 
	 public int getPageCount(String username) throws Exception;
	 
	 //添加登录日志
	 public int saveLoginLog(LoginLog loginLog) throws Exception;
}
