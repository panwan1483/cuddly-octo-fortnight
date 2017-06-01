package com.sps.ecommerce.admin.service;

import java.util.List;

import com.sps.ecommerce.admin.entity.Withdrawal;

/**
 * 用户提现信息表
 * @author wangfucai
 */
public interface WithdrawalService {

	public Withdrawal getWithdrawalById(Long withdrawalId);
	
	public List<Withdrawal> listWithdrawal(int status,String applyer,String applyOrder,String beginTime,String endTime,int pageNum,int pageSize);
	
	public int getPageCount(int status,String applyer,String applyOrder,String beginTime,String endTime);
	
	public int updateWithdrawal(Withdrawal withdrawal);
	
}