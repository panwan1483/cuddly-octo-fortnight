package com.sps.ecommerce.admin.dao;

import java.util.List;

import com.sps.ecommerce.admin.entity.BrandCategory;

public interface BrandCategoryDao {

	public int saveBrandCategory(BrandCategory brandCategory);
	
	public int deleteBrandCategory(Long id);
	
	public int updateBrandCategory(BrandCategory brandCategory);
	
	public BrandCategory getBrandCategoryById(Long id);
	
	public List<BrandCategory> listBrandCategory();
}
