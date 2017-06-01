package com.sps.ecommerce.admin.constants;

/**
 * 提现常量
 * @author wangfucai
 */
public class WithdrawalConstant {
	
	//提现状态,0表示申请提现,1表示审批通过,提现进行中,2,交易完成 -1审批不通过.
	/*初始状态,申请提现*/
	public static final int APPLY_WITHDRAWAL=0;
	
	/*提现通过*/
	public static final int PASS_WITHDRAWAL=1;
	
	/*交易完成*/
	public static final int FINISH_WITHDRAWAL=2;
	
	/*提现拒绝*/
	public static final int REJECT_WITHDRAWAL=-1;
}
