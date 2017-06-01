package com.sps.ecommerce.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sps.ecommerce.admin.entity.GoodsProp;

public interface GoodsPropDao {

	public List<GoodsProp> selectGoodsPropByPage(@Param("pageNum")int pageNum, @Param("pageSize")int pageSize);
	
	public int selectPageCount();

	public int deleteGoodsProp(Long id);

	public int insertGoodsProp(GoodsProp goodsProp);

	public int getPropIdByName(String name);

	public GoodsProp getPropById(Long propId);

	public boolean updateGoodsProp(GoodsProp goodsProp);

}
