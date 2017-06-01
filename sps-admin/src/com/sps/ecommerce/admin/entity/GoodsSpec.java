package com.sps.ecommerce.admin.entity;
import java.io.Serializable;
import java.util.Date;

public class GoodsSpec implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 自动增加ID
	 */
	private Long id;
	/**
	 * 规格名称
	 */
	private String name;
	/**
	 * 排序
	 */
	private int sequence;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 用来存放规格值
	 */
	private String valueGroup;
	
	public GoodsSpec(){
		super();
	}
	
	public GoodsSpec(Long id, String name, int sequence,  Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.sequence = sequence;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getValueGroup() {
		return valueGroup;
	}

	public void setValueGroup(String valueGroup) {
		this.valueGroup = valueGroup;
	}
	
}
