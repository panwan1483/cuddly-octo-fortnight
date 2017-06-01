package com.sps.ecommerce.admin.service;

import java.util.List;

import com.sps.ecommerce.admin.entity.GoodsSpec;
import com.sps.ecommerce.admin.entity.GoodsSpecItem;

public interface GoodsSpecService {

	public boolean deleteGoodsSpecItem(Long specId);
	
	public boolean saveGoodsSpec(GoodsSpec goodsSpec);
	
	public boolean addGoodsSpecItem(List<GoodsSpecItem> listGoodsSpecItem);
	
	public List<GoodsSpecItem> getSpecItemById(Long id);
	
	public boolean deleteGoodsSpec(Long id);
	
	public boolean updateGoodsSpec(GoodsSpec goodsSpec);
	
	public GoodsSpec getGoodsSpecById(Long id);
	
	public int PageCount();
	
	public long getSpecIdByName(String name);
	
	public boolean checkGoodSpecName(String name);
	
	public List<GoodsSpec> listGoodsSpec(int pageNum,int pageSize);
}