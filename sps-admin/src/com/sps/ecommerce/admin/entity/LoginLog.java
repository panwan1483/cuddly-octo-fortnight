package com.sps.ecommerce.admin.entity;
import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 自动增加ID
	 */
	private Long id;
	/**
	 * 系统用户的ID
	 */
	private Long sysId;
	/**
	 * 用户名 
	 */
	private String username;
	/**
	 * ip地址
	 */
	private String ip;
	/**
	 * 浏览器
	 */
	private String browser;
	/**
	 * 操作系统
	 */
	private String os;
	/**
	 * 登录状态，1为成功，-1 为失败
	 */
	private int status;
	/**
	 * 用户记录的时间
	 */
	private Date createTime;
	
	public LoginLog(){
		super();
	}
	
	public LoginLog(Long id, Long sysId, String username, String ip, String browser, String os, int status,
			Date createTime) {
		super();
		this.id = id;
		this.sysId = sysId;
		this.username = username;
		this.ip = ip;
		this.browser = browser;
		this.os = os;
		this.status = status;
		this.createTime = createTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSysId() {
		return sysId;
	}
	public void setSysId(Long sysId) {
		this.sysId = sysId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
