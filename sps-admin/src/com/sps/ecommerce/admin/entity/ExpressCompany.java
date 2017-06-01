package com.sps.ecommerce.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 快递公司信息表
 * @author wangfucai
 */
public class ExpressCompany implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 自动增加ID
	 */
	private Long id;
	
	/**
	 * 公司编码
	 */
	private String companyCode;
	
	/**
	 * 公司名称
	 */
	private String companyName;
	
	/**
	 * 序列，排序序列
	 */
	private String companySequence;
	
	/**
	 * 公司分类,默认EXPRESS
	 */
	private String companyType;
	
	/**
	 * 创建时间
	 */
	private Date createTime;

	public ExpressCompany() {
		super();
	}

	public ExpressCompany(Long id, String companyCode, String companyName, String companySequence, String companyType,
			Date createTime) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.companySequence = companySequence;
		this.companyType = companyType;
		this.createTime = createTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanySequence() {
		return companySequence;
	}

	public void setCompanySequence(String companySequence) {
		this.companySequence = companySequence;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}