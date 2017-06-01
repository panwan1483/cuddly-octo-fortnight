package com.sps.ecommerce.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sps.ecommerce.admin.entity.GoodsClass;

public interface GoodsClassDao {

	public int saveGoodsClass(GoodsClass goodsClass);
	
	public int deleteGoodsClass(Long id);
	
	public int updateGoodsClass(GoodsClass goodsClass);
	
	public GoodsClass getGoodsClassById(Long id);
	
	public GoodsClass getGoodsClassBySeq(int sequence);
	
	public GoodsClass getGoodsClassByName(String className);
	
	public List<GoodsClass> listGoodsClass(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
	
	public int PageCount();

	public List<GoodsClass> getGoodsClassByLevel(int level);
}
