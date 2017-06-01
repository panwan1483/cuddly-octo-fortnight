package com.sps.ecommerce.admin.dao;

import com.sps.ecommerce.admin.entity.Area;

public interface AreaDao {

	public int saveArea(Area area);
	
	public int deleteArea(Long id);
	
	public int updateArea(Area area);
	
	public Area getAreaById(Long id);
	
	public Area listArea();
}
