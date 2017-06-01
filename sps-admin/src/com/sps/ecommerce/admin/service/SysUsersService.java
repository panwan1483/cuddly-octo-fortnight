package com.sps.ecommerce.admin.service;

import java.util.List;

import com.sps.ecommerce.admin.entity.LoginLog;
import com.sps.ecommerce.admin.entity.SysUsers;

public interface SysUsersService {

	public SysUsers getSysUsersById(Long id) throws Exception;
	
	public SysUsers getSysUsersByUsername(String username) throws Exception;
	
	public List<SysUsers> pageListSysUsers(int pageNum,int pageSize) throws Exception;
	
	public int pageCount(int pageNum,int pageSize) throws Exception;

	public int saveSysUsers(SysUsers sysUsers) throws Exception;
	
	public int updateSysUsers(SysUsers sysUsers) throws Exception;
	
	public List<SysUsers> listSysUsers(String cnname,int status,int pageNum,int pageSize) throws Exception;
	
	public int getPageCount(String cnname,int status,int pageNum,int pageSize) throws Exception;

	/**
	 * 修改密码
	 * @param password
	 * @return
	 */
	public int updateSysUsersPassword(Long sysId,String password) throws Exception;
	
	public int deleteSysUsers(Long id,int status) throws Exception;
}