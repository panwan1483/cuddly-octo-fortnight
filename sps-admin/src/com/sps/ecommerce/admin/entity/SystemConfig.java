package com.sps.ecommerce.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author long&yu
 *
 */
public class SystemConfig implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 自动增加ID
	 */
	private Long id;
	/**
	 * 参数编码
	 */
	private String paramCode;
	
	/**
	 * 参数名称
	 */
	private String paramName;
	
	/**
	 * 参数值
	 */
	private String paramValue;
	/**
	 * 参数描述
	 */
	private String paramDesc;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public SystemConfig() {
		super();
	}
	
	public SystemConfig(Long id, String paramCode, String paramName, String paramValue, String paramDesc, Date createTime) {
		super();
		this.id = id;
		this.paramCode = paramCode;
		this.paramName = paramName;
		this.paramValue = paramValue;
		this.paramDesc = paramDesc;
		this.createTime = createTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getParamCode() {
		return paramCode;
	}
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	public String getParamDesc() {
		return paramDesc;
	}
	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}