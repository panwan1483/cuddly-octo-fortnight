package com.sps.ecommerce.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sps.ecommerce.admin.entity.Address;

public interface AddressDao {

	public List<Address> listAddress(@Param("phone") String telephone,@Param("name") String trueName,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
	
	public int getPageCount(@Param("phone") String telephone,@Param("name") String trueName);
	
	public int deleteAddress(Long id);
}
