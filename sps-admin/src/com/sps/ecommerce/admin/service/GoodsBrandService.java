package com.sps.ecommerce.admin.service;

import java.util.List;

import com.sps.ecommerce.admin.entity.GoodsBrand;

public interface GoodsBrandService {

	public int saveGoodsBrand(GoodsBrand goodsBrand);
	
	public int deleteGoodsBrand(Long id);
	
	public int updateGoodsBrand(GoodsBrand goodsBrand);
	
	public int PageCount();
	
	public List<GoodsBrand> listGoodsBrand(int pageNum,int pageSize);
}
