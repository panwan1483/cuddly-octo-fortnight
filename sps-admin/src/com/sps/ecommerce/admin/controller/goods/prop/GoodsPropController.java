package com.sps.ecommerce.admin.controller.goods.prop;

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
import com.sps.ecommerce.admin.entity.GoodsProp;
import com.sps.ecommerce.admin.entity.GoodsPropItem;
import com.sps.ecommerce.admin.service.GoodsPropService;
import com.sps.ecommerce.admin.utils.PageUtil;

/**
 * 商品属性管理
 * @author 金灿
 */
@Controller
@RequestMapping("/admin")
public class GoodsPropController extends BaseController{
	
	@Autowired
	private GoodsPropService goodsPropService;
	
	/**
	 * 属性列表
	 */
	@RequestMapping(value = "/goods/goodsPropList", method = { RequestMethod.GET, RequestMethod.POST })
	public String goodsPropList(HttpServletRequest request, HttpServletResponse response, Model model)
	{
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

		List<GoodsProp> list =this.goodsPropService.listGoodsProp(currentPageNum, currentPageSize);
		
		int total =this.goodsPropService.PageCount();
		
		PageUtil paging_vo = new PageUtil(currentPageSize, total, currentPageNum);
		
		paging_vo.setObject(list);
		
		model.addAttribute("paging_vo",paging_vo);
		
		return "goods/goodsPropList";
	}
	
	    //删除
		@ResponseBody
		@RequestMapping(value = "/goods/goodsPropDel", method ={ RequestMethod.GET, RequestMethod.POST })
		public Object delSystemConfig(HttpServletRequest request, HttpServletResponse response, Model model)
		{
			try
			{
				Long id= NumberUtils.toLong(request.getParameter("id"));
				
				boolean result=this.goodsPropService.deleteGoodsProp(id);
				
				if(result)
				{
					Map<String,String> paramMap=new HashMap<String,String>();
					
					paramMap.put("url",request.getContextPath()+"/admin/goods/goodsPropList");
					
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
		
		//按钮action页面跳转
		@RequestMapping(value="/goods/goodsPropAdd",method ={ RequestMethod.GET, RequestMethod.POST })
		public String addGoodsProp(HttpServletRequest request, HttpServletResponse response)
		{
			return "goods/addGoodsProp";
		}
		
		// 添加保存
		@ResponseBody
		@RequestMapping(value="/goods/goodsPropSave",method ={ RequestMethod.GET, RequestMethod.POST })
		public Object saveGoodsProp(HttpServletRequest request, HttpServletResponse response, GoodsPropItem goodsPropItem,GoodsProp goodsProp)
		{
			goodsProp.setCreateTime(new Date());
			goodsPropItem.setCreateTime(new Date());
			
			boolean check = this.goodsPropService.checkGoodPropName(goodsProp.getName());
			
			
			if(!check)
			{
				return new JsonResult(JsonResultCode.FAILURE, "属性名称已存在,请更换", "");
			}else
			{
				boolean result1 = this.goodsPropService.addGoodsProp(goodsProp);
				
				long propId = this.goodsPropService.getPropIdByName(goodsProp.getName());
				goodsPropItem.setPropId(propId);
				
				List<GoodsPropItem> listGoodsPropItem = null;
				
				boolean result2 = this.goodsPropService.addGoodsPropItem(listGoodsPropItem);
		
				if (result1&&result2) 
				{
					Map<String, String> paramMap = new HashMap<String, String>();
		
					paramMap.put("url", request.getContextPath() + "/admin/goods/goodsPropList");
		
					return new JsonResult(JsonResultCode.SUCCESS,"新增属性成功",paramMap);
				}else
				{
					return new JsonResult(JsonResultCode.FAILURE,"新增属性失败","");
				}
			}
		}
		
		//编辑按钮 跳转后回显。
		@RequestMapping(value = "/goods/showEditProp/{id}", method = { RequestMethod.GET,RequestMethod.POST })
		public String showEditExperiment(@PathVariable String id,HttpServletRequest request, Model model) 
		{
			Long propId= NumberUtils.toLong(id);
			List<GoodsPropItem> listGoodsPropItem = this.goodsPropService.getPropItemById(propId);
			GoodsProp goodsProp = this.goodsPropService.getPropById(propId);
			
			model.addAttribute("propId", propId);
			model.addAttribute("goodsProp", goodsProp);
			model.addAttribute("listGoodsPropItem", listGoodsPropItem);
			
			return "goods/editGoodsProp";
		}
		
		//修改
		@ResponseBody
		@RequestMapping(value = "/goods/goodsPropUpdate/{id}", method = { RequestMethod.GET, RequestMethod.POST })
		public Object updateGoodsProp(@PathVariable String id,HttpServletRequest request, HttpServletResponse response, Model model,GoodsProp goodsProp,GoodsPropItem goodsPropItem) 
		{
			Long propId= NumberUtils.toLong(id);
			boolean delete = this.goodsPropService.deleteGoodsPropItem(propId);
			goodsPropItem.setCreateTime(new Date());
			
			if(!delete)
			{
				return new JsonResult(JsonResultCode.FAILURE, "修改失败,请重试", "");
			}else
			{
				boolean result1 = this.goodsPropService.updateGoodsProp(goodsProp);
				
				goodsPropItem.setPropId(propId);
				
				List<GoodsPropItem> listGoodsPropItem = null;
				
				boolean result2 = this.goodsPropService.addGoodsPropItem(listGoodsPropItem);
		
				if (result1&&result2) 
				{
					Map<String, String> paramMap = new HashMap<String, String>();
		
					paramMap.put("url", request.getContextPath() + "/admin/goods/goodsPropList");
		
					return new JsonResult(JsonResultCode.SUCCESS,"修改属性成功",paramMap);
				}else
				{
					return new JsonResult(JsonResultCode.FAILURE,"修改属性失败","");
				}
			}
		}
}