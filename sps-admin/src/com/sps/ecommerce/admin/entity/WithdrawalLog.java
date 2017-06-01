package com.sps.ecommerce.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户提现的操作记录表
 */
public class WithdrawalLog implements Serializable{
	
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
	 * 提现申请的订单号
	 */
	private String applyOrder;
	
	/**
	 * 订单的状态,0表示申请提现,1表示审批通过,提现进行中,2,交易完成 -1审批不通过.
	 */
	private  String status;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 审批人
	 */
	private Long approver;
	
	/**
	 * 审批时间
	 */
	private Date approverTime;

	public WithdrawalLog() {
		super();
	}
	
	public WithdrawalLog(Long id, Long uid, String applyOrder, String status, Date createTime, Long approver,
			Date approverTime) {
		super();
		this.id = id;
		this.uid = uid;
		this.applyOrder = applyOrder;
		this.status = status;
		this.createTime = createTime;
		this.approver = approver;
		this.approverTime = approverTime;
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

	public String getApplyOrder() {
		return applyOrder;
	}

	public void setApplyOrder(String applyOrder) {
		this.applyOrder = applyOrder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getApprover() {
		return approver;
	}

	public void setApprover(Long approver) {
		this.approver = approver;
	}

	public Date getApproverTime() {
		return approverTime;
	}

	public void setApproverTime(Date approverTime) {
		this.approverTime = approverTime;
	}
}