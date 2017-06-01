package com.sps.ecommerce.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户提现
 * @author long&yu
 */
public class Withdrawal implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 自动增加ID
	 */
	private Long id;
	/**
	 * 提现申请人
	 */
	private String uid;

	/**
	 * 银行卡对应的姓名
	 */
	private String applyer;
	/**
	 * 提现订单号
	 */
	private String applyOrder;
	/**
	 * 用户对应的银行卡的ID
	 */
	private String applyBankCode;
	
	/**
	 * 用户对应的银行卡的名字
	 */
	private String applyBankName;
	
	/**
	 * 用户对应的银行卡卡号
	 */
	private String applyBankNumber;
	
	/**
	 * 申请提现的金额
	 */
	private BigDecimal applyRmb;
	
	/**
	 * 申请提现的时间
	 */
	private Date applyTime;
	/**
	 * 提现状态,0表示申请提现,1表示审批通过,2,交易完成 -1审批不通过
	 */
	private int status;
	
	/**
	 * 备注
	 */
	private String remark;
	
	public Withdrawal() {
		super();
	}
	
	public Withdrawal(Long id, String uid, String applyer, String applyOrder, String applyBankCode,
			String applyBankName, String applyBankNumber, BigDecimal applyRmb, Date applyTime, int status,
			String remark) {
		super();
		this.id = id;
		this.uid = uid;
		this.applyer = applyer;
		this.applyOrder = applyOrder;
		this.applyBankCode = applyBankCode;
		this.applyBankName = applyBankName;
		this.applyBankNumber = applyBankNumber;
		this.applyRmb = applyRmb;
		this.applyTime = applyTime;
		this.status = status;
		this.remark = remark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getApplyer() {
		return applyer;
	}

	public void setApplyer(String applyer) {
		this.applyer = applyer;
	}

	public String getApplyOrder() {
		return applyOrder;
	}

	public void setApplyOrder(String applyOrder) {
		this.applyOrder = applyOrder;
	}

	public String getApplyBankCode() {
		return applyBankCode;
	}

	public void setApplyBankCode(String applyBankCode) {
		this.applyBankCode = applyBankCode;
	}

	public String getApplyBankName() {
		return applyBankName;
	}

	public void setApplyBankName(String applyBankName) {
		this.applyBankName = applyBankName;
	}

	public String getApplyBankNumber() {
		return applyBankNumber;
	}

	public void setApplyBankNumber(String applyBankNumber) {
		this.applyBankNumber = applyBankNumber;
	}

	public BigDecimal getApplyRmb() {
		return applyRmb;
	}

	public void setApplyRmb(BigDecimal applyRmb) {
		this.applyRmb = applyRmb;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}