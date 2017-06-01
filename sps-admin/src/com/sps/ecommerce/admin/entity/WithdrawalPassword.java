package com.sps.ecommerce.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 提现密码
 * @author wangfucai
 *
 */
public class WithdrawalPassword implements Serializable{

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
	 * 提现的密码
	 */
	private String password;
	
	/**
	 * 时间时间
	 */
	private Date createTime;
	
	/**
	 * 最后一次修改人
	 */
	private Long lastUpdateBy;
	
	/**
	 * 最后一次修改时间
	 */
	private Date lastUpdateTime;
	
	public WithdrawalPassword() {
		super();
	}

	public WithdrawalPassword(Long id, Long uid, String password, Date createTime, Long lastUpdateBy,
			Date lastUpdateTime) {
		super();
		this.id = id;
		this.uid = uid;
		this.password = password;
		this.createTime = createTime;
		this.lastUpdateBy = lastUpdateBy;
		this.lastUpdateTime = lastUpdateTime;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(Long lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
}
