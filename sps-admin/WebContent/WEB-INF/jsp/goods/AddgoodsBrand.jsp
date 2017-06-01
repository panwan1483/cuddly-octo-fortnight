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
  <h1 class="seth1">添加品牌管理</h1>
  <form name="theForm" id="theForm" action="<%=request.getContextPath()%>/admin/goods/goodsBrandSave" method="post">
    <div class="specification" style="padding-top:0px;overflow-y:scroll">
      <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>品牌名称
	        <span class="span1">
	          	<input name="name" type="text" id="name" size="40" />
	        </span>
          </li>
      </ul>
     <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>根据字母查询
        <span class="span1">
           	 <input name="firstWord" type="text" id="firstWord" size="40"/>
         </span>
        </li>
      </ul>
      <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>序列
        <span class="span1">
         <input name="sequence" type="text" id="sequence" size="40"/>	  
            </span>
        </li>
      </ul>
      <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>商品Logo
        <span class="span1">
           <input name="logo" type="text" id="logo" size="40"/>
         </span>
        </li>
      </ul>
     
       <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>品牌分类ID
        <span class="span1">
           <input name="goodsClassId" type="text" id="goodsClassId" size="40"/>
            </span>
        </li>
      </ul>
      <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>备注
        <span class="span1">
             <textarea id="remark" name="remark" rows="5" cols="50"></textarea>
         </span>
        </li>
      </ul>
       <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>创建时间
        <span class="span1">
        <jsp:useBean id="dateObject" class="java.util.Date" scope="page"></jsp:useBean>
		<jsp:setProperty property="time" name="dateObject" value="${i.effectiveDate}"/>
		<fmt:formatDate value="${dateObject}" pattern="yyyy-MM-dd" /> 
        <%-- <input  id="createTime" name="createTime" value="<fmt:formatDate value='${paramMap.createTime}' type='date' pattern='yyyy-MM-dd'/>" >   --%>
        <!--  <input name="createTime" type="text" id="createTime" size="40" /> -->
    
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
		   name:{required :true},
		   firstWord:{required:true},
		   sequence:{required:true},
		   logo:{required:true},
		   goodsClassId:{required:true},
		   remark:{required:true},
		   createTime:{required:true},
		  },
	messages:{
		name:{required:"品牌名称不能为空"},
		firstWord:{required:"根据字母查询不能为空"},
		sequence:{required:"序列不能为空"},
		logo:{required:"商品logo不能为空"},
		goodsClassId:{required:"品牌分类ID不能为空"},
		remark:{required:"备注不能为空"},
		createTime:{required:"创建时间不能为空"},
	}
 });
 
$(function()
{
   ajaxSubmit("#theForm",1500);
});  
</script>
</html>