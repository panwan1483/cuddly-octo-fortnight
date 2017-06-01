package com.sps.ecommerce.admin.service;

import java.util.*;

import com.sps.ecommerce.admin.entity.SystemConfig;

/**
 * 系统设置的service层
 * @author wangfucai
 */
public interface SystemConfigService 
{
	public int saveSystemConfig(SystemConfig systemConfig);
	
	public int modifySystemConfig(SystemConfig systemConfig);
	
	public SystemConfig getSystemConfigById(Long id);
	
	public SystemConfig getSystemConfigByParamCode(String paramCode);
	
	public List<SystemConfig> listSystemConfig();
	
	public List<SystemConfig> getAllSystemConfig(String paramName,String paramCode,int pageNum, int pageSize);
	
	public int getPageCount(String paramName,String paramCode);
	
	//删除系统变量
	public int deleteSystemConfig(Long id);
}