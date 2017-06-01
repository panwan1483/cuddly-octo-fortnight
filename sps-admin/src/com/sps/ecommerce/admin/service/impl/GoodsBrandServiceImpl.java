package com.sps.ecommerce.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sps.ecommerce.admin.dao.GoodsBrandDao;
import com.sps.ecommerce.admin.entity.GoodsBrand;
import com.sps.ecommerce.admin.service.GoodsBrandService;

@Service
public class GoodsBrandServiceImpl implements GoodsBrandService{

	@Autowired
	private GoodsBrandDao goodsBrandDao;
	
	@Override
	public int saveGoodsBrand(GoodsBrand goodsBrand) {
		return goodsBrandDao.saveGoodsBrand(goodsBrand);
	}

	@Override
	public int deleteGoodsBrand(Long id) {
		return goodsBrandDao.deleteGoodsBrand(id);
	}

	@Override
	public int updateGoodsBrand(GoodsBrand goodsBrand) {
		return goodsBrandDao.updateGoodsBrand(goodsBrand);
	}

	@Override
	public int PageCount() {
		return goodsBrandDao.PageCount();
	}

	@Override
	public List<GoodsBrand> listGoodsBrand(int pageNum, int pageSize) {
		return goodsBrandDao.listGoodsBrand(pageNum,pageSize);
	}
}