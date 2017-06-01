package com.sps.ecommerce.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员信息表
 * 
 * @author wangfucai
 */
public class SysUsers implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 自动增加ID
	 */
	private Long id;

	/**
	 * 账号
	 */
	private String username;

	/**
	 * 账号密码
	 */
	private String password;

	/**
	 * 姓名
	 */
	private String cnname;

	/**
	 * 手机号码
	 */
	private String phone;

	/**
	 * 性别
	 */
	private int gender;

	/**
	 * 默认0表示可用，-1表示禁用。
	 */
	private int status;

	/**
	 * 创建时间
	 */
	private Date createTime;

	public SysUsers() {
		super();
	}

	public SysUsers(Long id, String username, String password, String cnname, String phone, int gender, int status,
			Date createTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.cnname = cnname;
		this.phone = phone;
		this.gender = gender;
		this.status = status;
		this.createTime = createTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCnname() {
		return cnname;
	}

	public void setCnname(String cnname) {
		this.cnname = cnname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}