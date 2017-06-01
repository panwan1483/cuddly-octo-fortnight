package com.sps.ecommerce.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sps.ecommerce.admin.entity.WithdrawalPassword;

public interface WithdrawalPasswordDao {
	
	/**
	 * 提现密码列表
	 * @return
	 */
	public List<WithdrawalPassword> listWithdrawalPassword(@Param("userid") Long uid,@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
	
	public int getPageCount();
	
	public int updateWithdrawalPassword(Long uid,String password);
	
	public WithdrawalPassword getWithdrawalPasswordByUid(Long uid);
}
