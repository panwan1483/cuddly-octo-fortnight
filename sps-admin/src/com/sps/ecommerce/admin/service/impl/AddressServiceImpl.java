package com.sps.ecommerce.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sps.ecommerce.admin.dao.AddressDao;
import com.sps.ecommerce.admin.entity.Address;
import com.sps.ecommerce.admin.service.AddressService;

/**
 * 地址信息管理
 * @author wangfucai
 */

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressDao addressDao;
	
	@Override
	public List<Address> listAddress(String telephone, String trueName, int pageNum, int pageSize) {
		if(pageNum!=0)
		{
			pageNum=(pageNum-1)*pageSize;
		}
		return addressDao.listAddress(telephone,trueName, pageNum, pageSize);
	}

	@Override
	public int getPageCount(String telephone, String trueName) {
		return addressDao.getPageCount(telephone, trueName);
	}

	@Override
	public int deleteAddress(Long id) {
		return addressDao.deleteAddress(id);
	}
}