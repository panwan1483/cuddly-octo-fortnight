package com.sps.ecommerce.admin.dao;

import java.util.List;

import com.sps.ecommerce.admin.entity.WithdrawalLog;

public interface WithdrawalLogDao {

	public int saveWithdrawalLog(WithdrawalLog withdrawalLog);
	
	public int deleteWithdrawalLog(Long id);
	
	public int updateWithdrawalLog(WithdrawalLog withdrawalLog);
	
	public WithdrawalLogDao getWithdrawalLogById(Long id);
	
	public List<WithdrawalLog> listWithdrawalLog();
}
