package com.sps.ecommerce.admin.entity;
import java.io.Serializable;

/**
 * 角色菜单关系表
 * @author wangfucai
 */

public class RoleMenu implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 自动增加ID
	 */
	private int id;
	/**
	 * 角色ID
	 */
	private int roleId;
	/**
	 * 菜单ID
	 */
	private int menuId;
	
	public RoleMenu(){
		super();
	}
	
	public RoleMenu(int id, int roleId, int menuId) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.menuId = menuId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
}