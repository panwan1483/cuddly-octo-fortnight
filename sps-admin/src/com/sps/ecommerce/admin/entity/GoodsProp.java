package com.sps.ecommerce.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class GoodsProp implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 自动增加ID
	 */
	private Long id;
	/**
	 * 属性名字
	 */
	private String name;
	/**
	 * 属性排序
	 */
	private int sequence;
	/**
	 * 所属类型，值为text或者img
	 */
	private String type;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public GoodsProp() {
		super();
	}
	public GoodsProp(Long id, String name, int sequence, String type, Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.sequence = sequence;
		this.type = type;
		this.createTime = createTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsProp [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", sequence=");
		builder.append(sequence);
		builder.append(", type=");
		builder.append(type);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}
	
}
