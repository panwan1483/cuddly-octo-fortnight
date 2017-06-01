package com.sps.ecommerce.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sps.ecommerce.admin.entity.GoodsSpec;

public interface GoodsSpecDao {

	public int saveGoodsSpec(GoodsSpec goodsSpec);

	public int deleteGoodsSpec(Long id);

	public int updateGoodsSpec(GoodsSpec goodsSpec);

	public GoodsSpec getGoodsSpecById(Long id);

	public List<GoodsSpec> listGoodsSpec(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

	public int PageCount();

	public GoodsSpec getGoodsSpecByName(String name);

	public GoodsSpec getGoodsSpecBySeq(int sequence);

	public int getSpecIdByName(String name);

}
