package com.sps.ecommerce.admin.dao;

import java.util.List;

import com.sps.ecommerce.admin.entity.GoodsPropItem;

public interface GoodsPropItemDao {

	public void addGoodsPropItem(GoodsPropItem item);

	public List<GoodsPropItem> getPropItemById(Long propId);

	public boolean deleteGoodsPropItem(Long propId);

}
