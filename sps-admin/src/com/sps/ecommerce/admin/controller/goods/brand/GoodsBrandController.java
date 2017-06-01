package com.sps.ecommerce.admin.controller.goods.brand;

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
import com.sps.ecommerce.admin.entity.GoodsBrand;
import com.sps.ecommerce.admin.service.GoodsBrandService;
import com.sps.ecommerce.admin.utils.PageUtil;

/**
 * 商品品牌管理
 * 
 * @author wangfucai
 */
@Controller
@RequestMapping("/admin")
public class GoodsBrandController extends BaseController {

	@Autowired

	private GoodsBrandService goodsBrandService; 

	// 分页
	@RequestMapping(value = "/goods/goodsBrandList", method = { RequestMethod.GET, RequestMethod.POST })
	public String goodsBrandList(HttpServletRequest request, HttpServletResponse response, Model model) {
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

		List<GoodsBrand> list = this.goodsBrandService.listGoodsBrand(currentPageNum, currentPageSize);

		int total = this.goodsBrandService.PageCount();

		PageUtil paging_vo = new PageUtil(currentPageSize, total, currentPageNum);

		paging_vo.setObject(list);

		model.addAttribute("paging_vo", paging_vo);

		return "goods/goodsBrandList";
	}

	// 删除
	@ResponseBody
	@RequestMapping(value = "/goods/goodsBrandDel", method = { RequestMethod.GET, RequestMethod.POST })
	public Object goodsBrandDel(HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			Long id = NumberUtils.toLong(request.getParameter("id"));

			int result = this.goodsBrandService.deleteGoodsBrand(id);

			if (result > 0) {
				Map<String, String> paramMap = new HashMap<String, String>();

				paramMap.put("url", request.getContextPath() + "/admin/goods/goodsBrandList");

				return new JsonResult(JsonResultCode.SUCCESS, "删除成功", paramMap);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "删除失败", "");
			}
		} catch (Exception ex) {
			return new JsonResult(JsonResultCode.FAILURE, "系统错误，请联系管理员", "");
		}
	}

	// 修改
	@ResponseBody
	@RequestMapping(value = "/goods/goodsBrandUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public Object goodsBrandUpdate(HttpServletRequest request, HttpServletResponse response, Model model,GoodsBrand goodsBrand) {
		try {
			int result = this.goodsBrandService.updateGoodsBrand(goodsBrand);

			if (result > 0) {
				Map<String, String> paramMap = new HashMap<String, String>();

				paramMap.put("url", request.getContextPath() + "/admin/goods/goodsBrandList");

				return new JsonResult(JsonResultCode.SUCCESS, "系统保存成功", paramMap);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "系统失败成功", "");
			}
		} catch (Exception ex) {
			return new JsonResult(JsonResultCode.FAILURE, "系统错误，请联系管理员", "");
		}
	}

	// 添加
	@RequestMapping(value = "goods/goodsBrandAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public String goodsBrandAdd(HttpServletRequest request, HttpServletResponse response, Model model,GoodsBrand goodsBrand) {
		return "goods/AddgoodsBrand";
	}

	// 添加保存
	@ResponseBody
	@RequestMapping(value = "goods/goodsBrandSave", method = { RequestMethod.GET, RequestMethod.POST })
	public Object goodsBrandSave(HttpServletRequest request, HttpServletResponse response, Model model,GoodsBrand goodsBrand) {
		try {
			goodsBrand.setCreateTime(new Date());

			int result = this.goodsBrandService.saveGoodsBrand(goodsBrand);

			if (result > 0) {
				Map<String, String> paramMap = new HashMap<String, String>();

				paramMap.put("url", request.getContextPath() + "/admin/goods/goodsBrandList");

				return new JsonResult(JsonResultCode.SUCCESS, "系统保存成功", paramMap);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "系统失败成功", "");
			}
		} catch (Exception ex) {
			return new JsonResult(JsonResultCode.FAILURE, "系统错误，请联系管理员", "");
		}

	}

}
