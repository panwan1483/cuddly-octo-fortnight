package com.sps.ecommerce.admin.dao;

import java.util.List;

import com.sps.ecommerce.admin.entity.Role;

public interface RoleDao {

	public int saveRole(Role role);
	
	public int deleteRole(Long id);
	
	public int updateRole(Role role);
	
	public Role getRoleById(Long id);
	
	public List<Role> listRole();
}
