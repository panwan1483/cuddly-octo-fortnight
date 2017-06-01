package com.sps.ecommerce.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class GoodsPropItem implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 自动增加ID
	 */
	private Long id;
	/**
	 * 对应的属性ID
	 */
	private Long propId;
	/**
	 * 属性值
	 */
	private String value;
	/**
	 * 属性图片
	 */
	private String img;
	/**
	 * 属性排序
	 */
	private int sequence;
	/**
	 * 创建时间
	 */
	private Date createTime;
	public GoodsPropItem(Long id, Long propId, String value, String img, int sequence, Date createTime) {
		super();
		this.id = id;
		this.propId = propId;
		this.value = value;
		this.img = img;
		this.sequence = sequence;
		this.createTime = createTime;
	}
	public GoodsPropItem() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPropId() {
		return propId;
	}
	public void setPropId(Long propId) {
		this.propId = propId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsPropItem [id=");
		builder.append(id);
		builder.append(", propId=");
		builder.append(propId);
		builder.append(", value=");
		builder.append(value);
		builder.append(", img=");
		builder.append(img);
		builder.append(", sequence=");
		builder.append(sequence);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}
	
}
