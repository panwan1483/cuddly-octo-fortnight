package com.sps.ecommerce.admin.dao;

import java.util.List;

import com.sps.ecommerce.admin.entity.RoleMenu;

public interface RoleMenuDao {

	public int saveRoleMenu(RoleMenu roleMenu);
	
	public int deleteRoleMenu(Long id);
	
	public int updateRoleMenu(RoleMenu roleMenu);
	
	public RoleMenu getRoleMenuById(Long id);
	
	public List<RoleMenu> listRoleMenu();
}
