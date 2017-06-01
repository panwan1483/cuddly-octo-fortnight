package com.sps.ecommerce.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 自动增加ID
	 */
	private Long id;
	/**
	 * 用户ID
	 */
	private Long uid;
	/**
	 * 详细地址信息
	 */
	private String areaInfo;
	/**
	 * 电话号码
	 */
	private String mobile;
	/**
	 * 手机号码
	 */
	private String telephone;
	/**
	 * 真实姓名
	 */
	private String trueName;
	/**
	 * 邮编
	 */
	private String zip;
	/**
	 * 所属地区
	 */
	private Long areaId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public Address(){
		super();
	}
	
	public Address(Long id, Long uid, String areaInfo, String mobile, String telephone, String trueName, String zip,
			Long areaId, Date createTime) {
		super();
		this.id = id;
		this.uid = uid;
		this.areaInfo = areaInfo;
		this.mobile = mobile;
		this.telephone = telephone;
		this.trueName = trueName;
		this.zip = zip;
		this.areaId = areaId;
		this.createTime = createTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getAreaInfo() {
		return areaInfo;
	}
	public void setAreaInfo(String areaInfo) {
		this.areaInfo = areaInfo;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public Long getAreaId() {
		return areaId;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}