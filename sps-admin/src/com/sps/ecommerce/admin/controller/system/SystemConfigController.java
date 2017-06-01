package com.sps.ecommerce.admin.controller.system;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sps.ecommerce.admin.constants.JsonResult;
import com.sps.ecommerce.admin.constants.JsonResultCode;
import com.sps.ecommerce.admin.controller.BaseController;
import com.sps.ecommerce.admin.entity.SystemConfig;
import com.sps.ecommerce.admin.service.SystemConfigService;
import com.sps.ecommerce.admin.utils.PageUtil;

/**
 * 系统配置信息
 * @author wangfucai
 */
@Controller
@RequestMapping(value = "/admin")
public class SystemConfigController extends BaseController
{
	@Autowired
	private SystemConfigService systemConfigService;
    /**
     * 系统配置列表
     * @param request
     * @param response
     * @param model
     * @return
     */
	@RequestMapping(value = "/systemConfig/List", method ={ RequestMethod.GET, RequestMethod.POST })
	public String systemConfigList(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		int currentPageNum = 0;
		int currentPageSize = 10;
		
		String pageNum = request.getParameter("page_num");
		String pageSize=request.getParameter("page_size");
		
		String paramName=request.getParameter("paramName");
		String paramCode=request.getParameter("paramCode");
		
		if (StringUtils.isNotBlank(pageNum)) {
			currentPageNum = NumberUtils.toInt(pageNum);
		}
		
		if (StringUtils.isNotBlank(pageSize)) {
			currentPageSize =NumberUtils.toInt(pageSize);
		}
		
		List<SystemConfig> list = this.systemConfigService.getAllSystemConfig(paramName,paramCode,currentPageNum, currentPageSize);
		
		int total = this.systemConfigService.getPageCount(paramName,paramCode);
		
		PageUtil paging_vo = new PageUtil(currentPageSize, total, currentPageNum);

		paging_vo.setObject(list);
		
		model.addAttribute("paging_vo", paging_vo);
		model.addAttribute("paramName", paramName);
		model.addAttribute("paramCode", paramCode);
		
		return "system_config/systemConfigList";
	}
	
	//去添加页面
	@RequestMapping(value = "/systemConfig/addSystemConfig", method ={ RequestMethod.GET, RequestMethod.POST })
	public String addSystemConfig(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		return "system_config/addsystemConfig";
	}
	
	//增加
	@ResponseBody
	@RequestMapping(value = "/systemConfig/save", method ={ RequestMethod.GET, RequestMethod.POST })
	public Object addSystemConfig(HttpServletRequest request, HttpServletResponse response,SystemConfig systemConfig)
	{
		try
		{
			//基础参数检查
			String paramCode=systemConfig.getParamCode();
			
			if(StringUtils.isBlank(paramCode))
			{
				return new JsonResult(JsonResultCode.FAILURE,"系统参数有误，请重试","");
			}
			
			SystemConfig querySystemConfig=this.systemConfigService.getSystemConfigByParamCode(paramCode);		
			
			if(querySystemConfig!=null)
			{
				return new JsonResult(JsonResultCode.FAILURE,"系统编码已经被占用，请更换","");
			}
			
			systemConfig.setCreateTime(new Date());
			int result=this.systemConfigService.saveSystemConfig(systemConfig);
			
			if(result>0)
			{
				Map<String,String> paramMap=new HashMap<String,String>();
				
				paramMap.put("url",request.getContextPath()+"/admin/systemConfig/List");
				
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
		
	//查看
	@RequestMapping(value = "/systemConfig/show", method ={ RequestMethod.GET, RequestMethod.POST })
	public String showSystemConfig(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		Long id= NumberUtils.toLong(request.getParameter("id"));
		
		SystemConfig systemConfig=this.systemConfigService.getSystemConfigById(id);
		
		model.addAttribute("systemConfig",systemConfig);
		
		return "system_config/modifySystemConfig";
	}
	
	//修改
	@ResponseBody
	@RequestMapping(value = "/systemConfig/modify", method ={ RequestMethod.GET, RequestMethod.POST })
	public Object modifySystemConfig(HttpServletRequest request, HttpServletResponse response,SystemConfig systemConfig)
	{
		
		try
		{
			int result=this.systemConfigService.modifySystemConfig(systemConfig);
			
			if(result>0)
			{
				Map<String,String> paramMap=new HashMap<String,String>();
				
				paramMap.put("url",request.getContextPath()+"/admin/systemConfig/List");
				
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
	
	//删除
	@ResponseBody
	@RequestMapping(value = "/systemConfig/delete", method ={ RequestMethod.GET, RequestMethod.POST })
	public Object delSystemConfig(HttpServletRequest request, HttpServletResponse response, Model model,SystemConfig systemConfig)
	{
		try
		{
			Long id= NumberUtils.toLong(request.getParameter("id"));
			
			int result=systemConfigService.deleteSystemConfig(id);
			
			if(result>0)
			{
				Map<String,String> paramMap=new HashMap<String,String>();
				
				paramMap.put("url",request.getContextPath()+"/admin/systemConfig/List");
				
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
}