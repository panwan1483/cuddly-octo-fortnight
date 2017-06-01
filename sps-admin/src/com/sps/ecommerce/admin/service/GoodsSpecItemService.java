package com.sps.ecommerce.admin.service;

import java.util.List;

import com.sps.ecommerce.admin.entity.GoodsSpecItem;

public interface GoodsSpecItemService {
	
	public boolean updateGoodsSpecItem(GoodsSpecItem goodsSpecItem);
	
	public List<GoodsSpecItem> listGoodsSpecItem(int pageNum,int pageSize);
}
