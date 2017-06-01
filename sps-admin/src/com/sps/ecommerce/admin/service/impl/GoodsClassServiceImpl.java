package com.sps.ecommerce.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sps.ecommerce.admin.dao.GoodsClassDao;
import com.sps.ecommerce.admin.entity.GoodsClass;
import com.sps.ecommerce.admin.service.GoodsClassService;

@Service(value="GoodsClassService")
public class GoodsClassServiceImpl implements GoodsClassService{

	@Autowired
	private GoodsClassDao goodsClassDao;
	
	@Override
	public int saveGoodsClass(GoodsClass goodsClass) {
		return goodsClassDao.saveGoodsClass(goodsClass);
	}

	@Override
	public int deleteGoodsClass(Long id) {
		return goodsClassDao.deleteGoodsClass(id);
	}

	@Override
	public int updateGoodsClass(GoodsClass goodsClass) {
		return goodsClassDao.updateGoodsClass(goodsClass);
	}

	@Override
	public GoodsClass getGoodsClassById(Long id) {
		return goodsClassDao.getGoodsClassById(id);
	}

	@Override
	public List<GoodsClass> listGoodsClass(int pageNum,int pageSize) {
		if(pageNum!=0)
		{
			pageNum=(pageNum-1)*pageSize;
		}
		return goodsClassDao.listGoodsClass(pageNum,pageSize);
	}

	@Override
	public int PageCount() {
		return goodsClassDao.PageCount();
	}

	@Override
	public GoodsClass getGoodsClassByName(String className) {
		return goodsClassDao.getGoodsClassByName(className);
	}

	@Override
	public GoodsClass getGoodsClassBySeq(int sequence) {
		return goodsClassDao.getGoodsClassBySeq(sequence);
	}
	
	@Override
	public List<GoodsClass> getGoodsClassByLevel(int level){
		return goodsClassDao.getGoodsClassByLevel(level);
	}

}
