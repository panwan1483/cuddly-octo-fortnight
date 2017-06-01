<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="<%=request.getContextPath()%>/resources/style/system/manage/blue/template.css"  rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/resources/style/common/css/jquery-ui-1.8.22.custom.css"  rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/style/common/css/overlay.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.shop.base.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.shop.common.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.21.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.zh.cn.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.form.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.formPlugin.js"></script>
<script src="<%=request.getContextPath()%>/resources/layer/layer.js"></script>
</head>
<body>
<div class="cont">
  <h1 class="seth1">添加分类</h1>
  <form name="theForm" id="theForm" action="<%=request.getContextPath()%>/admin/goods/goodsClassSave" method="post">
    <div class="specification" style="padding-top:0px;">
      <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>分类名称
	        <span class="span1">
	          	<input name="className" type="text" id="className" size="40" />
	        </span>
          </li>
      </ul>
     <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>是否显示
        <span class="span1">
           	 <input name="display" type="radio" id="display" value="1" />显示
           	 <input name="display" type="radio" id="display" value="0" />不显示
         </span>
        </li>
      </ul>
      <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>层级别
        <span class="span1">
         	  <select name="level" id="level" onchange="">
         	  	<option value="1" selected="selected">一级分类</option>
         	  </select>
            </span>
        </li>
      </ul>
      <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>是否推荐
        <span class="span1">
           	 <input name="recommend" type="radio" id="recommend" value="1" />推荐
           	 <input name="recommend" type="radio" id="recommend" value="0" />不推荐
         </span>
        </li>
      </ul>
      <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>序列号
        <span class="span1">
             <input name="sequence" type="text" id="sequence" size="40" />
         </span>
        </li>
      </ul>
      <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>SEO描述
        <span class="span1">
             <textarea id="seoDescription" name="seoDescription" rows="5" cols="50"></textarea>
         </span>
        </li>
      </ul>
       <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>SEO关键字
        <span class="span1">
             <input name="seoKeywords" type="text" id="seoKeywords" size="40" />
         </span>
        </li>
      </ul>
    </div>
    <div class="submit">
    	<input name="save" type="submit" value="提交"/>
 	 </div>
  </form>
</div>
</body>
<script>
$("#theForm").validate({
	ignore: "",						  
	   rules:{
		   className:{required :true},
		   display:{required:true},
		   level:{required:true},
		   recommend:{required:true},
		   sequence:{required:true},
		   seoDescription:{required:true},
		   seoKeywords:{required:true},
		  },
	messages:{
		className:{required:"分类名称不能为空"},
		display:{required:"展示不能为空"},
		level:{required:"层级不能为空"},
		recommend:{required:"推荐不能为空"},
		sequence:{required:"序列号不能为空"},
		seoDescription:{required:"SEO描述不能为空"},
		seoKeywords:{required:"SEO关键字不能为空"},
	}
 });
 
$(function()
{
   ajaxSubmit("#theForm",1500);
});  
</script>
</html>