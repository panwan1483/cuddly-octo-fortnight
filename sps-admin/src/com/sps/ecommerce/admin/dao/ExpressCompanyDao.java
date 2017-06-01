package com.sps.ecommerce.admin.dao;

import java.util.List;

import com.sps.ecommerce.admin.entity.ExpressCompany;

public interface ExpressCompanyDao {

	public int saveExpressCompany(ExpressCompany expressCompany);
	
	public int deleteExpressCompany(Long id);
	
	public int updateExpressCompany(ExpressCompany expressCompany);
	
	public ExpressCompany getExpressCompanyById(Long id);
	
	public List<ExpressCompany> listExpressCompany();
}
