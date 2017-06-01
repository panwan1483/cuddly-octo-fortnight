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
  <h1 class="seth1">增加管理员</h1>
  <form name="theForm" id="theForm" action="<%=request.getContextPath()%>/sysUsers/save" method="post">
    <div class="specification" style="padding-top:0px;overflow-y:scroll">
      <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>账号
	        <span class="span1">
	          	<input name="username" type="text" id="username" size="40" />
	        </span>
          </li>
      </ul>
      <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>密码
        <span class="span1">
         	  <input name="password" type="password" id="password" size="40" />
         </span>
        </li>
      </ul>
      <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>确认密码
        <span class="span1">
         	  <input name="confirmpassword" type="password" id="confirmpassword" size="40" />
            </span>
        </li>
      </ul>
      <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>姓名
        <span class="span1">
         	 <input name="cnname" type="text" id="cnname" size="40" />
        </span>
        </li>
      </ul>
      <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>手机号
        <span class="span1">
             <input name="phone" type="text" id="phone" size="40" />
         </span>
        </li>
      </ul>
      <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>性别
        <span class="span1">
           	 <input name="gender" type="radio" id="gender" value="1" />男
           	 <input name="gender" type="radio" id="gender" value="0" />女
         </span>
        </li>
      </ul>
       <ul class="spec_sports">
        <li><strong class="orange fontsize20">*</strong>状态
        <span class="span1">
            	 <input name="status" type="radio" id="status" value="0" />启用
            	 <input name="status" type="radio" id="status" value="-1"/>不启用
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
	   		username:{required :true},
	   		password:{required:true},
	   		confirmpassword:{required:true},
	   		cnname:{required:true},
	   		phone:{required:true},
	   		gender:{required:true},
	   		status:{required:true},
		  },
	messages:{
		username:{required:"账号不能为空"},
		password:{required:"密码不能为空"},
		confirmpassword:{required:"密码不能为空"},
		cnname:{required:"姓名不能为空"},
		phone:{required:"手机号不能为空"},
		gender:{required:"性别不能为空"},
		status:{required:"状态不能为空"}
	}
 });
 
$(function()
{
   ajaxSubmit("#theForm",1500);
});  
</script>
</html>