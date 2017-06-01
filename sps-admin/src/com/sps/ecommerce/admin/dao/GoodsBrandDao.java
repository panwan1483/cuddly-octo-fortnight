package com.sps.ecommerce.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sps.ecommerce.admin.entity.GoodsBrand;

public interface GoodsBrandDao {

	/**
	 * 保存
	 */
	public int saveGoodsBrand(GoodsBrand goodsBrand);
	
	/**
	 * 删除
	 */
	public int deleteGoodsBrand(Long id);
	
	/**
	 * 更新
	 */
	public int updateGoodsBrand(GoodsBrand goodsBrand);
	
	/**
	 * 获取ID
	 */
	public GoodsBrand getGoodsBrandById(Long id);
	
	/**
	 * 品牌列表
	 */
	public List<GoodsBrand> listGoodsBrand(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
	
	/**
	 * 计算页数
	 */
	public int PageCount();
}
