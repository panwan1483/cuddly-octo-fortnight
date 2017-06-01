package com.sps.ecommerce.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单管理
 * @author wangfucai
 */
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 自动增加ID
	 */
	private int id;
	/**
	 * 菜单名称
	 */
	private String menuName;
	/**
	 * 菜单URL
	 */
	private String menuUrl;
	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 父类菜单
	 */
	private int parentId;
	/**
	 * 排列的顺序
	 */
	private int sequence;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public Menu(){
		super();
	}

	public Menu(int id, String menuName, String menuUrl, String icon, int parentId, int sequence, Date createTime) {
		super();
		this.id = id;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.icon = icon;
		this.parentId = parentId;
		this.sequence = sequence;
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}