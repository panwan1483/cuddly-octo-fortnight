package com.sps.ecommerce.admin.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sps.ecommerce.admin.dao.GoodsSpecItemDao;
import com.sps.ecommerce.admin.entity.GoodsPropItem;
import com.sps.ecommerce.admin.entity.GoodsSpecItem;
import com.sps.ecommerce.admin.service.GoodsSpecItemService;

@Service(value="GoodsSpecItemService")
public class GoodsSpecItemServiceImpl implements GoodsSpecItemService{

	
	private static final Logger logger = Logger.getLogger(GoodsSpecItemServiceImpl.class);
	

	@Autowired
	private GoodsSpecItemDao goodsSpecItemDao;
	
	
	@Override
	public boolean updateGoodsSpecItem(GoodsSpecItem goodsSpecItem) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = goodsSpecItemDao.updateGoodsSpecItem(goodsSpecItem);
		} catch (Exception e) {
			logger.error("[GoodsSpecItemServiceImpl][updateGoodsSpecItem] goodsSpecItem:" + goodsSpecItem + "-"+ e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
		}
		return result > 0 ? true : false;
	}



	@Override
	public List<GoodsSpecItem> listGoodsSpecItem(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		List<GoodsSpecItem> goodsSpecItem = null;
		try {
			if(pageNum!=0)
			{
				pageNum=(pageNum-1)*pageSize;
			}
			goodsSpecItem = goodsSpecItemDao.listGoodsSpecItem();
		} catch (Exception e) {
			logger.error("[GoodsSpecItemServiceImpl][listGoodsSpecItem] goodsSpecItem:" + goodsSpecItem + "-"+ e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
		}
		return goodsSpecItem;
	}

}
