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
  <h1 class="seth1">增加系统参数</h1>
  <form name="theForm" id="theForm" action="<%=request.getContextPath()%>/admin/systemConfig/save" method="post">
    <div class="setcont">
      <ul class="set1">
        <li><strong class="orange fontsize20">*</strong>参数编码</li>
        <li><span class="webname">
          <input name="paramCode" type="text" id="paramCode" size="40" />
          </span></li>
      </ul>
      <ul class="set1">
        <li><strong class="orange fontsize20">*</strong>参数名称</li>
        <li><span class="webname">
         	  <input name="paramName" type="text" id="paramName"  size="40" />
            </span>
        </li>
      </ul>
      <ul class="set1">
        <li><strong class="orange fontsize20">*</strong>参数值</li>
        <li><span class="webname">
         	 <input name="paramValue" type="text" id="paramValue" size="40" />
            </span>
        </li>
      </ul>
      <ul class="set1">
        <li><strong class="orange fontsize20">*</strong>参数描述</li>
        <li><span class="webname">
            	 <input name="paramDesc" type="text" id="paramDesc" size="100" />
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
	   		paramCode:{required :true},
	   		paramName:{required:true},
	   		paramValue:{required:true},
	   		paramDesc:{required:true}
		  },
	messages:{
		paramCode:{required:"参数编码不能为空"},
		paramName:{required:"参数名称不能为空"},
		paramValue:{required:"参数值不能为空"},
		paramDesc:{required:"参数描述不能为空"},
	}
 });
 
$(function()
{
   ajaxSubmit("#theForm",1500);
});  
</script>
</html>