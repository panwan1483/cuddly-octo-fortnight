package com.sps.ecommerce.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sps.ecommerce.admin.dao.SysConfigDao;
import com.sps.ecommerce.admin.entity.SystemConfig;
import com.sps.ecommerce.admin.service.SystemConfigService;

@Service
public class SystemConfigServiceImpl implements SystemConfigService {
	
	@Autowired
	private SysConfigDao sysConfigDao;

	@Override
	public int modifySystemConfig(SystemConfig systemConfig) {
		return sysConfigDao.modifySystemConfig(systemConfig);
	}

	@Override
	public SystemConfig getSystemConfigById(Long id) {
		return sysConfigDao.getSystemConfigById(id);
	}

	@Override
	public List<SystemConfig> listSystemConfig() {
		return sysConfigDao.listSystemConfig();
	}

	@Override
	public List<SystemConfig> getAllSystemConfig(String paramName,String paramCode,int pageNum, int pageSize) {
		if(pageNum!=0)
		{
			pageNum=(pageNum-1)*pageSize;
		}
		return sysConfigDao.getAllSystemConfig(paramName,paramCode,pageNum, pageSize);
	}

	@Override
	public int getPageCount(String paramName,String paramCode) 
	{
		return sysConfigDao.getPageCount(paramName,paramCode);
	}

	@Override
	public int deleteSystemConfig(Long id) 
	{
		return sysConfigDao.deleteSystemConfig(id);
	}

	@Override
	public int saveSystemConfig(SystemConfig systemConfig) {
		return sysConfigDao.saveSystemConfig(systemConfig);
	}

	@Override
	public SystemConfig getSystemConfigByParamCode(String paramCode) {
		return sysConfigDao.getSystemConfigByParamCode(paramCode);
	}
}