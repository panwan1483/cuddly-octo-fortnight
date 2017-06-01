package com.sps.ecommerce.admin.service;

import java.util.List;

import com.sps.ecommerce.admin.entity.GoodsClass;

public interface GoodsClassService {

	public int saveGoodsClass(GoodsClass goodsClass);
	
	public int deleteGoodsClass(Long id);
	
	public int updateGoodsClass(GoodsClass goodsClass);
	
	public GoodsClass getGoodsClassById(Long id);
	
	public GoodsClass getGoodsClassByName(String className);
	
	public GoodsClass getGoodsClassBySeq(int sequence);
	
	public List<GoodsClass> listGoodsClass(int pageNum,int pageSize);
	
	public int PageCount();
	
	public List<GoodsClass> getGoodsClassByLevel(int level);
}
