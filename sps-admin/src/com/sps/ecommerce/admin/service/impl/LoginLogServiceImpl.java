package com.sps.ecommerce.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sps.ecommerce.admin.dao.LoginLogDao;
import com.sps.ecommerce.admin.entity.LoginLog;
import com.sps.ecommerce.admin.service.LoginLogService;

@Service
public class LoginLogServiceImpl implements LoginLogService{

	@Autowired
	private LoginLogDao loginLogDao;
	/**
	 * 日志管理
	 * @param username
	 * */
	@Override
	public List<LoginLog> listSysUsersLogin(String username,int pageNum, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		if(pageNum!=0)
		{
			pageNum=(pageNum-1)*pageSize;
		}
		return loginLogDao.listSysUsersLogin(username, pageNum, pageSize);
	}

	@Override
	public int getPageCount(String username) throws Exception {
		// TODO Auto-generated method stub
		return loginLogDao.getPageCount(username);
	}

	//添加登录日志
	@Override
	public int saveLoginLog(LoginLog loginLog) throws Exception {
		// TODO Auto-generated method stub
		return loginLogDao.saveLoginLog(loginLog);
	}

}
