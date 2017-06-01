package com.sps.ecommerce.admin.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sps.ecommerce.admin.dao.WithdrawalDao;
import com.sps.ecommerce.admin.entity.Withdrawal;
import com.sps.ecommerce.admin.service.WithdrawalService;

@Service
public class WithdrawalServiceImpl implements WithdrawalService {
	
	private static final Logger logger=LoggerFactory.getLogger(WithdrawalServiceImpl.class);

	@Autowired
	private WithdrawalDao withdrawalDao;
	
	@Override
	public int getPageCount(int status,String applyer,String applyOrder,String beginTime,String endTime) {
		return withdrawalDao.getPageCount(status,applyer,applyOrder,beginTime,endTime);
	}

	@Override
	public Withdrawal getWithdrawalById(Long withdrawalId) {
		return withdrawalDao.getWithdrawalById(withdrawalId);
	}

	@Override
	public int updateWithdrawal(Withdrawal withdrawal) {
		return withdrawalDao.updateWithdrawal(withdrawal);
	}

	@Override
	public List<Withdrawal> listWithdrawal(int status,String applyer,String applyOrder,String beginTime,String endTime,int pageNum, int pageSize) {
		if(pageNum!=0)
		{
			pageNum=(pageNum-1)*pageSize;
		}
		return withdrawalDao.listWithdrawal(status,applyer,applyOrder,beginTime,endTime,pageNum, pageSize);
	}
}