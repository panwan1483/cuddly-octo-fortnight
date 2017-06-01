package com.sps.ecommerce.admin.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sps.ecommerce.admin.dao.GoodsSpecDao;
import com.sps.ecommerce.admin.dao.GoodsSpecItemDao;
import com.sps.ecommerce.admin.entity.GoodsSpec;
import com.sps.ecommerce.admin.entity.GoodsSpecItem;
import com.sps.ecommerce.admin.service.GoodsSpecService;

@Service
public class GoodsSpecServiceImpl implements GoodsSpecService{

	private static final Logger logger = Logger.getLogger(GoodsSpecServiceImpl.class);
	
	@Autowired
	private GoodsSpecDao goodsSpecDao;
	
	@Autowired
	private GoodsSpecItemDao goodsSpecItemDao;
	
	@Override
	public boolean saveGoodsSpec(GoodsSpec goodsSpec) {
		int result = 0;
		try {
			result = goodsSpecDao.saveGoodsSpec(goodsSpec);
		} catch (Exception e) {
			logger.error("[GoodsSpecServiceImpl][saveGoodsSpec] goodsSpec:" + goodsSpec + "-"+ e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
		}
		return result > 0 ? true : false;
	}

	@Override
	public boolean deleteGoodsSpec(Long id) {
		int result = 0;
		try {
			result = goodsSpecDao.deleteGoodsSpec(id);
		} catch (Exception e) {
			logger.error("[GoodsSpecServiceImpl][deleteGoodsSpec] id:" + id + "-"+ e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
		}
		return result > 0 ? true : false;
	}

	@Override
	public boolean updateGoodsSpec(GoodsSpec goodsSpec) {
		int result = 0;
		try {
			result = goodsSpecDao.updateGoodsSpec(goodsSpec);
		} catch (Exception e) {
			logger.error("[GoodsSpecServiceImpl][updateGoodsSpec] goodsSpec:" + goodsSpec + "-"+ e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
		}
		return result > 0 ? true : false;
	}

	@Override
	public GoodsSpec getGoodsSpecById(Long id) {
		// TODO Auto-generated method stub
		GoodsSpec goodsSpec = new GoodsSpec();
		try {
			goodsSpec = goodsSpecDao.getGoodsSpecById(id);
		} catch (Exception e) {
			logger.error("[GoodsSpecServiceImpl][getGoodsSpecById] goodsSpec:" + goodsSpec + "-"+ e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
		}
		return goodsSpec;
	}

	@Override
	public int PageCount() {
		int result = 0;
		try {
			result = goodsSpecDao.PageCount();
		} catch (Exception e) {
			logger.error("[GoodsSpecServiceImpl][PageCount]:" + "-"+ e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
		}
		return result;
	}

	@Override
	public boolean checkGoodSpecName(String name) {
		int result = 0;
		try {
			result = goodsSpecDao.getSpecIdByName(name);
		} catch (Exception e) {
			logger.error("[GoodsSpecServiceImpl][checkGoodSpecName] name:" + name + "-"+ e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
		}
		return result > 0 ? true : false;
	}

	@Override
	public long getSpecIdByName(String name) {
		// TODO Auto-generated method stub
		long result = 0;
		try {
			result = goodsSpecDao.getSpecIdByName(name);
		} catch (Exception e) {
			logger.error("[GoodsSpecServiceImpl][getSpecIdByName] name :" + name +"-"+ e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
		}
		return result;
	}
	
	@Override
	public boolean deleteGoodsSpecItem(Long specId) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = goodsSpecItemDao.deleteGoodsSpecItem(specId);
		} catch (Exception e) {
			logger.error("[GoodsSpecItemServiceImpl][deleteGoodsSpecItem] SpecId:" + specId + "-"+ e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
		}
		return result > 0 ? true : false;
	}
	

	@Override
	public boolean addGoodsSpecItem(List<GoodsSpecItem> listGoodsSpecItem) {
		return false;
	}

	@Override
	public List<GoodsSpecItem> getSpecItemById(Long id) {
		return null;
	}

	@Override
	public List<GoodsSpec> listGoodsSpec(int pageNum, int pageSize) {
		return null;
	}
}