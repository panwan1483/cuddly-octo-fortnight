package com.sps.ecommerce.admin.service;

import java.util.List;

import com.sps.ecommerce.admin.entity.WithdrawalPassword;

/**
 * 提现密码相关
 * @author wangfucai
 */
public interface WithdrawalPasswordService {
	/**
	 * 查询提现列表
	 * @return
	 */
	public List<WithdrawalPassword> listWithdrawalPassword(Long uid,int pageNum,int pageSize);
	
	public int getPageCount();
	
	public WithdrawalPassword getWithdrawalPasswordByUid(Long uid);
	
	//重置提现密码为'123456'
	public int updateWithdrawalPassword(Long uid,String password);
	
}