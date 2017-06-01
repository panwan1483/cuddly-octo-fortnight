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
  <h1 class="seth1">密码修改管理</h1>
  <form name="theForm" id="theForm" action="<%=request.getContextPath()%>/sysUsers/modifyPassword" method="post">
    <div class="setcont">
      <ul class="set1">
        <li><strong class="orange fontsize20">*</strong>原密码</li>
        <li><span class="webname">
          <input name="oldPassword" type="password" id="oldPassword" size="40" />
          </span></li>
      </ul>
      <ul class="set1">
        <li><strong class="orange fontsize20">*</strong>新密码</li>
        <li><span class="webname">
         	  <input name="newPassword" type="password" id="newPassword"  size="40" />
            </span>
        </li>
      </ul>
      <ul class="set1">
        <li><strong class="orange fontsize20">*</strong>确认密码</li>
        <li><span class="webname">
         	 <input name="confirmPassword" type="password" id="confirmPassword" size="40" />
            </span>
        </li>
      </ul>
    </div>
    <div class="submit">
    	<input name="update" type="submit" value="提交"/>
 	 </div>
  </form>
</div>
</body>
<script>
$("#theForm").validate({
	ignore: "",						  
	   rules:{
		   oldPassword:{required :true},
		   newPassword:{required:true},
		   confirmPassword:{required:true},
		  },
	messages:{
		oldPassword:{required:"原密码不能为空"},
		newPassword:{required:"新密码不能为空"},
		confirmPassword:{required:"确认密码不能为空"},
	}
 });
 
$(function()
{
   ajaxSubmit("#theForm",1500);
});  
</script>
</html>