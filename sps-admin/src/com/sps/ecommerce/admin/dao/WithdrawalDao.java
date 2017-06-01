package com.sps.ecommerce.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sps.ecommerce.admin.entity.Withdrawal;

public interface WithdrawalDao {

	public Withdrawal getWithdrawalById(Long withdrawalId);
	 
	public List<Withdrawal> listWithdrawal(@Param("status") int status,@Param("name") String applyer,@Param("applyOrder") String applyOrder,@Param("beginTime") String beginTime,@Param("endTime") String endTime,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
	
	public int getPageCount(@Param("status") int status,@Param("name") String applyer,@Param("applyOrder") String applyOrder,@Param("beginTime") String beginTime,@Param("endTime") String endTime);
	
	public int updateWithdrawal(Withdrawal withdrawal);
}