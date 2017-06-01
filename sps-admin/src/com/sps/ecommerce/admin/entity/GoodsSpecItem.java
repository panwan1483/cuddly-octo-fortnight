package com.sps.ecommerce.admin.entity;
import java.io.Serializable;
import java.util.Date;

public class GoodsSpecItem implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 自动增加ID
	 */
	private Long id;
	/**
	 * 对应的规格ID
	 */
	private Long specId;
	/**
	 * 序列
	 */
	private int sequence;
	/**
	 * 规格对应的值
	 */
	private String value;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public GoodsSpecItem(Long id, Long specId, int sequence, String value,  Date createTime) {
		super();
		this.id = id;
		this.specId = specId;
		this.sequence = sequence;
		this.value = value;
		this.createTime = createTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSpecId() {
		return specId;
	}
	public void setSpecId(Long specId) {
		this.specId = specId;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
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
