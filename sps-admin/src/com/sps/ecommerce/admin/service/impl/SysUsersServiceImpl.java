package com.sps.ecommerce.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sps.ecommerce.admin.dao.SysUsersDao;
import com.sps.ecommerce.admin.entity.SysUsers;
import com.sps.ecommerce.admin.service.SysUsersService;

@Service
public class SysUsersServiceImpl implements SysUsersService {

	@Autowired
	private SysUsersDao sysUsersDao;
	
	@Override
	public SysUsers getSysUsersById(Long id) throws Exception {
		return sysUsersDao.getSysUsersById(id);
	}

	@Override
	public SysUsers getSysUsersByUsername(String username)  throws Exception {
		return sysUsersDao.getSysUsersByUsername(username);
	}

	@Override
	public List<SysUsers> pageListSysUsers(int pageNum, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int pageCount(int pageNum, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveSysUsers(SysUsers sysUsers) throws Exception {
		// TODO Auto-generated method stub
		return sysUsersDao.saveSysUsers(sysUsers);
	}

	@Override
	public int updateSysUsers(SysUsers sysUsers) throws Exception {
		// TODO Auto-generated method stub
		return sysUsersDao.updateSysUsers(sysUsers);
	}

	@Override
	public int updateSysUsersPassword(Long sysId, String password) throws Exception {
		// TODO Auto-generated method stub
		return sysUsersDao.updateSysUsersPassword(sysId, password);
	}

	@Override
	public List<SysUsers> listSysUsers(String cnname, int status, int pageNum, int pageSize) throws Exception {
		if(pageNum!=0)
		{
			pageNum=(pageNum-1)*pageSize;
		}
		return sysUsersDao.listSysUsers(cnname, status, pageNum, pageSize);
	}

	@Override
	public int getPageCount(String cnname, int status, int pageNum, int pageSize) throws Exception {
		return sysUsersDao.getPageCount(cnname, status);
	}

	@Override
	public int deleteSysUsers(Long id,int status) throws Exception {
		return sysUsersDao.deleteSysUsers(id,status);
	}
}