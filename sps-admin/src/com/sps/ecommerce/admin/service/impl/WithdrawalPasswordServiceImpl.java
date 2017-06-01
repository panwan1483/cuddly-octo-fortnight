package com.sps.ecommerce.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sps.ecommerce.admin.dao.WithdrawalPasswordDao;
import com.sps.ecommerce.admin.entity.WithdrawalPassword;
import com.sps.ecommerce.admin.service.WithdrawalPasswordService;
import com.sps.ecommerce.admin.utils.EncryptUtil;

@Service
public class WithdrawalPasswordServiceImpl implements WithdrawalPasswordService {

	@Autowired
	private WithdrawalPasswordDao withdrawalPasswordDao;
	
	@Override
	public List<WithdrawalPassword> listWithdrawalPassword(Long uid,int pageNum, int pageSize) 
	{
		if(pageNum!=0)
		{
			pageNum=(pageNum-1)*pageSize;
		}
		List<WithdrawalPassword> pageList=withdrawalPasswordDao.listWithdrawalPassword(uid,pageNum,pageSize);
		return pageList;
	}

	@Override
	public int getPageCount() {
		int total=withdrawalPasswordDao.getPageCount();;
		return total;
	}
	//重置提现密码
	public int updateWithdrawalPassword(Long uid, String password) {
		if (password.equals(withdrawalPasswordDao.getWithdrawalPasswordByUid(uid).getPassword())) {
			return withdrawalPasswordDao.updateWithdrawalPassword(uid,EncryptUtil.getMD5(password));
		}
		   return 0;
	}

	@Override
	public WithdrawalPassword getWithdrawalPasswordByUid(Long uid) {
		return withdrawalPasswordDao.getWithdrawalPasswordByUid(uid);
	}
}