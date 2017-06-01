<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商城系统后台管理</title>
<link href="<%=request.getContextPath()%>/resources/style/system/manage/blue/template.css"  rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/resources/style/system/manage/blue/login.css"  rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/resources/style/common/css/jquery-ui-1.8.22.custom.css"  rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/style/common/css/overlay.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/layer/skin/layer.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.shop.base.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.shop.common.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.21.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.zh.cn.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.form.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.formPlugin.js"></script>
<script src="<%=request.getContextPath()%>/resources/layer/layer.js"></script>
<script type="text/javascript">
function changeCode()
{
   $("#codeImg").attr("src","<%=request.getContextPath()%>/code/getVerificationCode?time="+new Date().getTime());
}
$(function()
{
	var validator = $("#loginForm").validate({
		rules: {
			username: {
				required: true,
				maxlength:16,
			},
			password: {
				required: true,
				maxlength:16,
			},
			code: {
				required: true,
				maxlength:4,
			}
		},
		messages: {
			
			username: {
				required: "请输入用户名",
				maxlength: jQuery.validator.format("您输入的用户名超过了16位")
			},
			password: {
				required: "请输入密码",
				maxlength: jQuery.validator.format("您输入的密码超过了16位")
			},
			code: {
				required: "请输入验证码",
				maxlength: jQuery.validator.format("您输入的密码超过了4位")
			},
		},
	});
  	ajaxSubmit("#loginForm",1000);
  	
	$("#codeImg").bind("click",changeCode);
});
</script>
</head>
	<body style="padding-top:29.5px">
		<div class="header">
			<div class="logo-login">
				<img height="32" src="images/logo.png" alt="武汉尚品说网络科技有限公司">
			</div>
			<div class="slogan-company">
				<b class="angle">&nbsp;</b>
				"十年专注，值得信赖"
			</div>
		</div>
		<div class="container">
			<div class="background-identity">
				<div class="user-login">
					<div class="head">
						<strong>后台管理登录</strong>
					</div>
					<div class="body login-form">
						<form id="loginForm" action="<%=request.getContextPath() %>/sys/login" method="post" autocomplete="off">
							<div class="verify-message"></div>
							<div class="form-item">
								<span class="think-placeholder" style="position: relative; display: inline-block;">
								<input id="username" class="text account" type="text" name="username" placeholder="用户名" style="vertical-align: top;" maxlength="16"></span>
							</div>
							<div class="form-item">
								<input id="password" class="text password" type="password" name="password" placeholder="密码" style="vertical-align: top;" maxlength="16">
							</div>
							
							<div class="form-item">
								<input id="code" class="text account" type="text" name="code" placeholder="验证码" style="vertical-align: top;width:100px" maxlength="4" size="4">
								<img id="codeImg" alt="点击更换" title="点击更换" src="<%=request.getContextPath() %>/code/getVerificationCode"/>
							</div>
							<div class="form-item">
								<input class="submit" type="submit" value="登录">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="footer">
			<div class="copyright">
				武汉尚品说网络科技有限公司所有 Copyright © 2016 - 2017 www.91sps.com All Rights Reserved.
			</div>
		</div>
	</body>
	</html>