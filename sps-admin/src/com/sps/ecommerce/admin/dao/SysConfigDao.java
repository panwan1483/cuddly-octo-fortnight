package com.sps.ecommerce.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sps.ecommerce.admin.entity.SystemConfig;

public interface SysConfigDao {
	
	public List<SystemConfig> listSystemConfig();
	
	public SystemConfig getSystemConfigById(Long id);
	
	public SystemConfig getSystemConfigByParamCode(String paramCode);

	public List<SystemConfig> getAllSystemConfig(@Param("name") String paramName,@Param("code") String paramCode,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
	
	public int getPageCount(@Param("name") String paramName,@Param("code") String paramCode);
	
	public int saveSystemConfig(SystemConfig systemConfig);
	
	public int modifySystemConfig(SystemConfig systemConfig);
	
	public int deleteSystemConfig(Long id);
}
