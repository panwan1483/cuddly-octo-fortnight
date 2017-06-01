package com.sps.ecommerce.admin.entity;
import java.io.Serializable;
import java.util.Date;

public class Area implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 地区编码
	 */
	private Long id;
	/**
	 * 地区名称
	 */
	private String areaName;
	/**
	 * 区域的父类编号
	 */
	private Long parentId;
	/**
	 * 所属级别
	 */
	private int level;
	/**
	 * 序列
	 */
	private int sequence;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	
	
	public Area() {
		super();
	}
	public Area(Long id, String areaName, Long parentId, int level, int sequence, Date createTime) {
		super();
		this.id = id;
		this.areaName = areaName;
		this.parentId = parentId;
		this.level = level;
		this.sequence = sequence;
		this.createTime = createTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}



