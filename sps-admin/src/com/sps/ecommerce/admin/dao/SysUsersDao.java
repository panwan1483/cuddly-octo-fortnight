package com.sps.ecommerce.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sps.ecommerce.admin.entity.LoginLog;
import com.sps.ecommerce.admin.entity.SysUsers;

public interface SysUsersDao {

	public SysUsers getSysUsersById(Long id);
	
	public SysUsers getSysUsersByUsername(String username);
	
	public int updateSysUsersPassword(@Param("sysId") Long sysId,@Param("password") String password);
	
	public int getPageCount(@Param("cnname") String cnname,@Param("status") int status);
	
	public List<SysUsers> listSysUsers(@Param("cnname") String cnname,@Param("status") int status,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
	
	public int updateSysUsers(SysUsers sysUsers);
	
	//启用与禁用
	//status 0为启用，-1为禁用
	public int deleteSysUsers(@Param("id") Long id,@Param("status")  int status);
	
	public int saveSysUsers(SysUsers sysUsers);
}
