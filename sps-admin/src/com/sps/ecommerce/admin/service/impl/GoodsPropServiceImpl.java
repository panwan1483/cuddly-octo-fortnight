package com.sps.ecommerce.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sps.ecommerce.admin.dao.GoodsPropDao;
import com.sps.ecommerce.admin.dao.GoodsPropItemDao;
import com.sps.ecommerce.admin.entity.GoodsProp;
import com.sps.ecommerce.admin.entity.GoodsPropItem;
import com.sps.ecommerce.admin.service.GoodsPropService;

@Service(value="GoodsPropService")
public class GoodsPropServiceImpl implements GoodsPropService{
	
	private static final Logger logger=LoggerFactory.getLogger(GoodsPropServiceImpl.class);

	@Autowired
	private GoodsPropDao goodsPropDao;
	@Autowired
	private GoodsPropItemDao goodsPropItemDao;

	@Override
	public List<GoodsProp> listGoodsProp(int pageNum, int pageSize) {
		if(pageNum!=0)
		{
			pageNum=(pageNum-1)*pageSize;
		}
		List<GoodsProp> list= null;
		try 
		{
			list =goodsPropDao.selectGoodsPropByPage(pageNum, pageSize);
		} catch (Exception ex) {
			logger.error("[ExperimentServiceImpl][listExperimentByPage] "+"pageNum: "+pageNum+"pageSize: "+pageSize+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return list;
	}

	@Override
	public boolean addGoodsProp(GoodsProp goodsProp) {
		int result=0;
		try 
		{
			result =goodsPropDao.insertGoodsProp(goodsProp);
		} catch (Exception ex) {
			logger.error("[ExperimentServiceImpl][addGoodsProp] goodsProp: "+goodsProp+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result>0?true:false;
	}
	
	@Override
	public int PageCount() {
		int result=0;
		try 
		{
			result =goodsPropDao.selectPageCount();
		} catch (Exception ex) {
			logger.error("[GoodsPropServiceImpl][getPageCount] "+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result;
	}

	@Override
	public boolean deleteGoodsProp(Long id) {
		int result=0;
		try 
		{
			result =goodsPropDao.deleteGoodsProp(id);
		} catch (Exception ex) {
			logger.error("[GoodsPropServiceImpl][deleteGoodsProp] id: "+id+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result>0?true:false;
	}

	@Override
	public boolean checkGoodPropName(String name) {
		long result=0;
		try 
		{
			result =goodsPropDao.getPropIdByName(name);
		} catch (Exception ex) {
			logger.error("[GoodsPropServiceImpl][getPropIdByName] name: "+name+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result>0?true:false;
	}

	@Override
	public long getPropIdByName(String name) {
		long result=0;
		try 
		{
			result =goodsPropDao.getPropIdByName(name);
		} catch (Exception ex) {
			logger.error("[GoodsPropServiceImpl][getPropIdByName] name: "+name+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result;
	}

	@Override
	public boolean addGoodsPropItem(List<GoodsPropItem> listGoodsPropItem) {
		boolean result=true;
		try 
		{
			if(listGoodsPropItem!=null)
			{
				for(GoodsPropItem item:listGoodsPropItem)
				{
					this.goodsPropItemDao.addGoodsPropItem(item);	
				}
			}
		} catch (Exception ex) {
			logger.error("[GoodsPropServiceImpl][addGoodsPropItem] listGoodsPropItem: "+listGoodsPropItem+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result;
	}

	@Override
	public List<GoodsPropItem> getPropItemById(Long propId) {
		List<GoodsPropItem> list=new ArrayList<GoodsPropItem>();
		try 
		{
			list =goodsPropItemDao.getPropItemById(propId);
			
		} catch (Exception ex) 
		{
			logger.error("[GoodsPropServiceImpl][getPropItemById] propId: " + propId + "-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return list;
	}

	@Override
	public GoodsProp getPropById(Long propId) {
		GoodsProp goodProp=null;
		try 
		{
			goodProp =goodsPropDao.getPropById(propId);
			
		} catch (Exception ex) 
		{
			logger.error("[GoodsPropServiceImpl][getPropById] propId: " + propId + "-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return goodProp;
	}

	@Override
	public boolean deleteGoodsPropItem(Long propId) {
		boolean result = true;
		try {
			result = this.goodsPropItemDao.deleteGoodsPropItem(propId);
		} catch (Exception ex) {
			logger.error("[GoodsPropServiceImpl][addGoodsPropItem] propId: " + propId + "-" + ex.getLocalizedMessage()
					+ ":" + ex.getMessage(), ex.getCause());
		}
		return result;
	}

	@Override
	public boolean updateGoodsProp(GoodsProp goodsProp) {
		boolean result = true;
		try {
			result = this.goodsPropDao.updateGoodsProp(goodsProp);
		} catch (Exception ex) {
			logger.error("[GoodsPropServiceImpl][updateGoodsProp] goodsProp: " + goodsProp + "-" + ex.getLocalizedMessage()
					+ ":" + ex.getMessage(), ex.getCause());
		}
		return result;
	}



}
