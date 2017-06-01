package com.sps.ecommerce.admin.controller.goods.classes;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sps.ecommerce.admin.constants.JsonResult;
import com.sps.ecommerce.admin.constants.JsonResultCode;
import com.sps.ecommerce.admin.controller.BaseController;
import com.sps.ecommerce.admin.entity.GoodsClass;
import com.sps.ecommerce.admin.entity.SystemConfig;
import com.sps.ecommerce.admin.service.GoodsClassService;
import com.sps.ecommerce.admin.utils.PageUtil;

/**
 * 商品分类管理
 * @author wangfucai
 */
@Controller
@RequestMapping("/admin")
public class GoodsClassController extends BaseController{

	@Autowired
	private GoodsClassService goodsClassService;
	/**
	 * 商品分类
	 * 
	 * */
	
	@RequestMapping(value = "/goods/goodsClassList", method = { RequestMethod.GET, RequestMethod.POST })
	public String goodsClassList(HttpServletRequest request, HttpServletResponse response, Model model)
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

		List<GoodsClass> list =this.goodsClassService.listGoodsClass(currentPageNum, currentPageSize);
		
		int total =this.goodsClassService.PageCount();
		
		PageUtil paging_vo = new PageUtil(currentPageSize, total, currentPageNum);
		
		paging_vo.setObject(list);
		
		model.addAttribute("paging_vo",paging_vo);
		
		return "goods/goodsClassList";
	}
	
	    //删除
		@ResponseBody
		@RequestMapping(value = "/goods/goodsClassDel", method ={ RequestMethod.GET, RequestMethod.POST })
		public Object delSystemConfig(HttpServletRequest request, HttpServletResponse response, Model model)
		{
			try
			{
				Long id= NumberUtils.toLong(request.getParameter("id"));
				
				int result=this.goodsClassService.deleteGoodsClass(id);
				
				if(result>0)
				{
					Map<String,String> paramMap=new HashMap<String,String>();
					
					paramMap.put("url",request.getContextPath()+"/admin/goods/goodsClassList");
					
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
		
		//去新增界面
		@RequestMapping(value="/goods/goodsClassAdd",method ={ RequestMethod.GET, RequestMethod.POST })
		public String addGoodsClass(HttpServletRequest request, HttpServletResponse response, Model model)
		{
			int level=NumberUtils.toInt(request.getParameter("level"));
			
			List<GoodsClass> list=this.goodsClassService.getGoodsClassByLevel(level);
			
			model.addAttribute("list", list);
			
			return "goods/addGoodsClass";
		}
		
		// 添加保存
		@ResponseBody
		@RequestMapping(value="/goods/goodsClassSave",method ={ RequestMethod.GET, RequestMethod.POST })
		public Object saveGoodsClass(HttpServletRequest request, HttpServletResponse response, Model model,GoodsClass goodsClass)
		{
			try
			{
				String className=goodsClass.getClassName();
				
				if(StringUtils.isBlank(className))
				{
					return new JsonResult(JsonResultCode.FAILURE,"分类名称有误，请重试","");
				}
				
				GoodsClass  goodsClass2=this.goodsClassService.getGoodsClassByName(className);
				
				if (goodsClass2!=null) {
					return new JsonResult(JsonResultCode.FAILURE,"该分类名已经存在，请更换","");
				}
				
				int sequence=goodsClass.getSequence();
				
				GoodsClass  goodsClass3=this.goodsClassService.getGoodsClassBySeq(sequence);
				
				if (goodsClass3!=null) {
					return new JsonResult(JsonResultCode.FAILURE,"该序列已经存在，请更换","");
				}
				
				goodsClass.setCreateTime(new Date());
				
				int result=this.goodsClassService.saveGoodsClass(goodsClass);
				
				if(result>0)
				{
					Map<String,String> paramMap=new HashMap<String,String>();
					
					paramMap.put("url",request.getContextPath()+"/admin/goods/goodsClassList");
					
					return new JsonResult(JsonResultCode.SUCCESS,"系统保存成功",paramMap);
				}else
				{
					return new JsonResult(JsonResultCode.FAILURE,"系统失败","");
				}
			}catch(Exception ex)
			{
				return new JsonResult(JsonResultCode.FAILURE,"系统错误，请联系管理员","");
			}
		}
		
		//去修改界面
		@RequestMapping(value="/goods/goodsClassShow",method={RequestMethod.GET,RequestMethod.POST})
		public String goodsClassShow(HttpServletRequest request, HttpServletResponse response, Model model)
		{
			Long id=NumberUtils.toLong(request.getParameter("id"));
			
			GoodsClass goodsClass=this.goodsClassService.getGoodsClassById(id); 
			
			model.addAttribute("goodsClass", goodsClass);
			
			return "goods/updateGoodsClass";
		}
		
		//修改
		@ResponseBody
		@RequestMapping(value="/goods/goodsClassUpdate",method ={ RequestMethod.GET, RequestMethod.POST })
		public Object updateGoodsClass(HttpServletRequest request, HttpServletResponse response, Model model,GoodsClass goodsClass)
		{
			try
			{
				goodsClass.setCreateTime(new Date());
				
				int result=this.goodsClassService.updateGoodsClass(goodsClass);
				
				if(result>0)
				{
					Map<String,String> paramMap=new HashMap<String,String>();
					
					paramMap.put("url",request.getContextPath()+"/admin/goods/goodsClassList");
					
					return new JsonResult(JsonResultCode.SUCCESS,"系统保存成功",paramMap);
				}else
				{
					return new JsonResult(JsonResultCode.FAILURE,"系统失败成功","");
				}
			}catch(Exception ex)
			{
				return new JsonResult(JsonResultCode.FAILURE,"系统错误，请联系管理员","");
			}
		}
		
		//去添加二级分类页面
		@RequestMapping(value="/goods/addSecondPage",method ={ RequestMethod.GET, RequestMethod.POST })
		public String addSecondGoodsClass(HttpServletRequest request, HttpServletResponse response, Model model)
		{
			Long id=NumberUtils.toLong(request.getParameter("id"));
			
			int level=NumberUtils.toInt(request.getParameter("level"));
			
			List<GoodsClass> list=this.goodsClassService.getGoodsClassByLevel(level);
			
			GoodsClass goodsClass=this.goodsClassService.getGoodsClassById(id);
			
			model.addAttribute("list",list);
			
			model.addAttribute("goodsClass",goodsClass);
			
			model.addAttribute("id",id);
			
			return "goods/addSecondPage";
		}
		
		//执行添加二级分类
		@ResponseBody
		@RequestMapping(value="/goods/secondGoodsClassSave",method ={ RequestMethod.GET, RequestMethod.POST })
		public Object saveSecondGoodsClass(HttpServletRequest request, HttpServletResponse response, Model model,GoodsClass goodsClass)
		{
			try
			{
				String className=goodsClass.getClassName();
				
				if(StringUtils.isBlank(className))
				{
					return new JsonResult(JsonResultCode.FAILURE,"分类名称有误，请重试","");
				}
				
				GoodsClass  goodsClass2=this.goodsClassService.getGoodsClassByName(className);
				
				if (goodsClass2!=null) {
					return new JsonResult(JsonResultCode.FAILURE,"该分类名已经存在，请更换","");
				}
				
				int sequence=goodsClass.getSequence();
				
				GoodsClass  goodsClass3=this.goodsClassService.getGoodsClassBySeq(sequence);
				
				if (goodsClass3!=null) {
					return new JsonResult(JsonResultCode.FAILURE,"该序列已经存在，请更换","");
				}
				
				goodsClass.setCreateTime(new Date());
				
				int result=this.goodsClassService.saveGoodsClass(goodsClass);
				
				if(result>0)
				{
					Map<String,String> paramMap=new HashMap<String,String>();
					
					paramMap.put("url",request.getContextPath()+"/admin/goods/goodsClassList");
					
					return new JsonResult(JsonResultCode.SUCCESS,"系统保存成功",paramMap);
				}else
				{
					return new JsonResult(JsonResultCode.FAILURE,"系统失败","");
				}
			}catch(Exception ex)
			{
				return new JsonResult(JsonResultCode.FAILURE,"系统错误，请联系管理员","");
			}
		}
}