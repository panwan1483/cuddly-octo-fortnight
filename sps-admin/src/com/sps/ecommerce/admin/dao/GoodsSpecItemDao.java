package com.sps.ecommerce.admin.dao;

import java.util.List;

import com.sps.ecommerce.admin.entity.GoodsSpecItem;

public interface GoodsSpecItemDao {
	
	public int deleteGoodsSpecItem(Long specId);
	
	public int updateGoodsSpecItem(GoodsSpecItem goodsSpecItem);
	
	public List<GoodsSpecItem> listGoodsSpecItem();
	
	public void addGoodsSpecItem(GoodsSpecItem item);
	
	public List<GoodsSpecItem> getGoodsSpecItemById(long specId);
}
