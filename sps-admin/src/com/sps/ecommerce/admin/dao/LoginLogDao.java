package com.sps.ecommerce.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sps.ecommerce.admin.entity.LoginLog;

public interface LoginLogDao {

	/**
	 * 日志管理
	 * @param username
	 * */
	public List<LoginLog> listSysUsersLogin(@Param("username") String username,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
	
	public int getPageCount(@Param("username") String username);
	
	//添加登录日志
	public int saveLoginLog(LoginLog loginLog);
}
