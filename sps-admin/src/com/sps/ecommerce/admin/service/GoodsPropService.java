package com.sps.ecommerce.admin.service;

import java.util.List;

import com.sps.ecommerce.admin.entity.GoodsProp;
import com.sps.ecommerce.admin.entity.GoodsPropItem;

public interface GoodsPropService {

	public List<GoodsProp> listGoodsProp(int pageNum,int pageSize);

	public int PageCount();
	
	public boolean addGoodsProp(GoodsProp goodsProp);

	public boolean deleteGoodsProp(Long id);

	public boolean checkGoodPropName(String name);

	public long getPropIdByName(String name);

	public boolean addGoodsPropItem(List<GoodsPropItem> listGoodsPropItem);

	public List<GoodsPropItem> getPropItemById(Long propId);

	public GoodsProp getPropById(Long propId);

	public boolean deleteGoodsPropItem(Long propId);

	public boolean updateGoodsProp(GoodsProp goodsProp);
}
