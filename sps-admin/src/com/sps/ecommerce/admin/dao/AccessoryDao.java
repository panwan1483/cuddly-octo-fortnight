package com.sps.ecommerce.admin.dao;

import java.util.List;

import com.sps.ecommerce.admin.entity.Accessory;

public interface AccessoryDao {

	public int saveAccessory(Accessory accessory);
	
	public int deleteAccessory(Long id);
	
	public int updateAccessory(Accessory accessory);
	
	public Accessory getAccessoryById(Long id);
	
	public List<Accessory> listAccessory();
}
