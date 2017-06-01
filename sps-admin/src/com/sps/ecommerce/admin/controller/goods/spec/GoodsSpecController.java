package com.sps.ecommerce.admin.controller.goods.spec;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sps.ecommerce.admin.constants.JsonResult;
import com.sps.ecommerce.admin.constants.JsonResultCode;
import com.sps.ecommerce.admin.controller.BaseController;
import com.sps.ecommerce.admin.entity.GoodsSpec;
import com.sps.ecommerce.admin.entity.GoodsSpecItem;
import com.sps.ecommerce.admin.service.GoodsSpecService;
import com.sps.ecommerce.admin.utils.PageUtil;

/**
 * 商品规格管理
 * @author 张振焕
 */
@Controller
@RequestMapping("/admin")
public class GoodsSpecController extends BaseController{

	@Autowired
	private GoodsSpecService goodsSpecService;
	
	//去修改页面
	@RequestMapping(value="/goods/goodsSpecShow",method={RequestMethod.GET,RequestMethod.POST})
	public String goodsSpecShow(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		Long id=NumberUtils.toLong(request.getParameter("id"));
		
		GoodsSpec goodsSpec=this.goodsSpecService.getGoodsSpecById(id);
		
		model.addAttribute("goodsSpec",goodsSpec);
		
		return "goods/goodsSpecShow";
	}
	
	
	//列表
	@RequestMapping(value = "/goods/goodsSpecList", method = { RequestMethod.GET, RequestMethod.POST })
	public String goodsSpecList(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		GoodsSpec goodsSpec = null;
		GoodsSpecItem goodsSpecItem = null;
		int currentPageNum = 0;
		int currentPageSize = 10;

		String pageNum = request.getParameter("page_num");
		String pageSize = request.getParameter("page_size");

		if (StringUtils.isNotBlank(pageNum)) {
			currentPageNum = NumberUtils.toInt(pageNum);
		}

		if (StringUtils.isNotBlank(pageSize)) {
			currentPageSize = NumberUtils.toInt(pageSize);
		}

		List<GoodsSpec> listSpec =this.goodsSpecService.listGoodsSpec(currentPageNum, currentPageSize);
		
		int total =this.goodsSpecService.PageCount();
		
		java.util.Iterator<GoodsSpec> itSpec = listSpec.iterator();
		while (itSpec.hasNext()) {
			String valueGroup = "";
			goodsSpec = (GoodsSpec)itSpec.next();
			long specId = goodsSpec.getId();
			List<GoodsSpecItem> listSpecItem = this.goodsSpecService.getSpecItemById(specId);
			java.util.Iterator<GoodsSpecItem> itSpecItem = listSpecItem.iterator();
			while (itSpecItem.hasNext()) {
				goodsSpecItem = (GoodsSpecItem)itSpecItem.next();
				valueGroup = goodsSpecItem.getValue() + ",";
	       }
			valueGroup = valueGroup.substring(0, valueGroup.length()-1);
			goodsSpec.setValueGroup(valueGroup);
       }
		
		PageUtil paging_vo = new PageUtil(currentPageSize, total, currentPageNum);
		
		paging_vo.setObject(listSpec);
		
		model.addAttribute("paging_vo",paging_vo);
		
		return "goods/goodsSpecList";
	}
	
    //删除
	@ResponseBody
	@RequestMapping(value = "/goods/goodsSpecDel", method ={ RequestMethod.GET, RequestMethod.POST })
	public Object delGoodsSpec(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		try
		{
			Long id= NumberUtils.toLong(request.getParameter("id"));
			
			boolean result=this.goodsSpecService.deleteGoodsSpec(id);
			
			if(result)
			{
				Map<String,String> paramMap=new HashMap<String,String>();
				
				paramMap.put("url",request.getContextPath()+"/admin/goods/goodsSpecList");
				
				return new JsonResult(JsonResultCode.SUCCESS,"删除成功",paramMap);
			}else
			{
				return new JsonResult(JsonResultCode.FAILURE,"删除失败","");
			}
		}catch(Exception ex)
		{
			return new JsonResult(JsonResultCode.FAILURE,"系统错误，请联系管理员","");
		}
	}
	
	//添加
	@RequestMapping(value="/goods/goodsSpecAdd",method ={ RequestMethod.GET, RequestMethod.POST })
	public String addGoodsSpec(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		return "goods/addGoodsSpec";
	}
	
	// 添加保存
	@ResponseBody
	@RequestMapping(value="/goods/goodsSpecSave",method ={ RequestMethod.GET, RequestMethod.POST })
	public Object saveGoodsSpec(HttpServletRequest request, HttpServletResponse response, Model model,GoodsSpec goodsSpec,GoodsSpecItem goodsSpecItem)
	{
		try {
			goodsSpecItem.setCreateTime(new Date());
			goodsSpec.setCreateTime(new Date());
			
			boolean check = this.goodsSpecService.checkGoodSpecName(goodsSpec.getName());
			
			if (!check) {
				return new JsonResult(JsonResultCode.FAILURE, "规格名称已存在,请更换", "");
			}else{
				boolean result1= this.goodsSpecService.saveGoodsSpec(goodsSpec);
				
				long SpecId = this.goodsSpecService.getSpecIdByName(goodsSpec.getName());
				goodsSpecItem.setId(SpecId);
				
				List<GoodsSpecItem> listGoodsPropItem = null;
				
				boolean result2 = this.goodsSpecService.addGoodsSpecItem(listGoodsPropItem);
				
				if(result1 && result2)
				{
					Map<String,String> paramMap=new HashMap<String,String>();
					
					paramMap.put("url",request.getContextPath()+"/admin/goods/goodsSpecList");
					
					return new JsonResult(JsonResultCode.SUCCESS,"规格新增保存成功",paramMap);
				}else
				{
					return new JsonResult(JsonResultCode.FAILURE,"规格新增保存失败","");
				}
			}
		} catch (Exception e) {
			return new JsonResult(JsonResultCode.FAILURE,"系统错误，请联系管理员","");
		}
		
	}
	
	//编辑
	@RequestMapping(value="/goods/goodsSpecEdit{id}",method ={ RequestMethod.GET, RequestMethod.POST })
	public String editGoodsSpec(@PathVariable String id, HttpServletRequest request, HttpServletResponse response, Model model)
	{
		Long specId= NumberUtils.toLong(id);
		List<GoodsSpecItem> listGoodsSpecItem = this.goodsSpecService.getSpecItemById(specId);
		GoodsSpec goodsSpec = this.goodsSpecService.getGoodsSpecById(specId);
		
		model.addAttribute("specId", specId);
		model.addAttribute("goodsSpec", goodsSpec);
		model.addAttribute("listGoodsSpecItem", listGoodsSpecItem);
		
		return "goods/editGoodsSpec";
	}
	
	//修改
	@ResponseBody
	@RequestMapping(value="/goods/goodsSpecUpdate/{id}",method ={ RequestMethod.GET, RequestMethod.POST })
	public Object updateGoodsSpec(@PathVariable String id,HttpServletRequest request, HttpServletResponse response, Model model,GoodsSpec goodsSpec,GoodsSpecItem goodsSpecItem)
	{
		try
		{
			Long specId= NumberUtils.toLong(id);
			boolean delete = this.goodsSpecService.deleteGoodsSpecItem(specId);
			goodsSpecItem.setCreateTime(new Date());
			
			if (!delete) {
				return new JsonResult(JsonResultCode.FAILURE, "规格修改失败,请重试", "");
			}else{
				
				boolean result1 = this.goodsSpecService.updateGoodsSpec(goodsSpec);
				
				goodsSpecItem.setId(specId);
				
				List<GoodsSpecItem> listGoodsSpecItem = null;
				
				boolean result2 = this.goodsSpecService.addGoodsSpecItem(listGoodsSpecItem);
				if(result1 && result2)
				{
					Map<String,String> paramMap=new HashMap<String,String>();
					
					paramMap.put("url",request.getContextPath()+"/admin/goods/goodsSpecList");
					
					return new JsonResult(JsonResultCode.SUCCESS,"规格编辑保存成功",paramMap);
				}else
				{
					return new JsonResult(JsonResultCode.FAILURE,"规格编辑保存失败","");
				}
			}
		}catch(Exception ex)
		{
			return new JsonResult(JsonResultCode.FAILURE,"系统错误，请联系管理员","");
		}
	}
}