package com.sps.ecommerce.admin.service;

import java.util.List;

import com.sps.ecommerce.admin.entity.Address;

public interface AddressService {

	public List<Address> listAddress(String telephone,String trueName,int pageNum,int pageSize);
	
	public int getPageCount(String telephone,String trueName);
	
	public int deleteAddress(Long id);
}
