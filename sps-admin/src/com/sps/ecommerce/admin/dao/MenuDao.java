package com.sps.ecommerce.admin.dao;

import java.util.List;

import com.sps.ecommerce.admin.entity.Menu;

public interface MenuDao {

	public int saveMenu(Menu menu);
	
	public int deleteMenu(Long id);
	
	public int updateMenu(Menu menu);
	
	public Menu getMenuById(Long id);
	
	public List<Menu> listMenu();
}
