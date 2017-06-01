<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="<%=request.getContextPath()%>/resources/style/system/manage/blue/template.css"  rel="stylesheet" type="text/css"/>
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.shop.base.js"></script>
<script>
$(function(){
	$(".webmap a").click(function(){
	    $(".webmap_box").fadeIn('normal');
	 });
	$(".close_map").click(function(){
	    $(".webmap_box").fadeOut('normal');
	});
	$("a[id^=complex_]").click(function(){
	  var suffix=jQuery(this).attr("suffix");
	  if($("#"+suffix+"info").css("display")=="block"){
	      $("#"+suffix+"info").hide();
		  $("#"+suffix+"img").attr("src","<%=request.getContextPath()%>/resources/style/system/manage/blue/images/spread.jpg");
	   }else{
	      $("#"+suffix+"info").show();
		  $("#"+suffix+"img").attr("src","<%=request.getContextPath()%>/resources/style/system/manage/blue/images/contract.jpg");	  
	   }
	});
});	
</script>
</head>
<body scroll="yes">
<div class="main">
  <div class="top">
    <div class="login">您登录的身份是：${login_session_admin.cnname} &nbsp;&nbsp;| <a href="<%=request.getContextPath()%>/sys/logout" target="_self">安全退出</a>|<a href="<%=request.getContextPath()%>/sys/modifyPassword" target="main_workspace">修改密码</a>| <a href="<%=request.getContextPath()%>/manage" target="_blank">后台首页</a></div>
    <div class="logo"></div>
    <div class="nav">
      <ul>
        <li><a href="javascript:void(0);" class="home" id="common_operation_menu" onclick="openURL('show','common_operation')">系统首页</a></li>
        <li><a href="javascript:void(0);" class="active" id="base_set_menu" onclick="openURL('show','base_set')" >系统设置</a></li>
        <li><a href="javascript:void(0);" class="active" id="about_goods_menu" onclick="openURL('show','about_goods')">商品管理</a></li>
        <li><a href="javascript:void(0);" class="active" id="about_member_menu" onclick="openURL('show','about_member')">会员管理</a></li>
        <li><a href="javascript:void(0);" class="active" id="about_trade_menu" onclick="openURL('show','about_trade')">交易管理</a></li>
        <li><a href="javascript:void(0);" class="active" id="about_withdrawal_menu" onclick="openURL('show','about_withdrawal')">提现管理</a></li>
      </ul>
    </div>
  </div>
  <div class="index" id="workspace">
    <div class="left">
      <div class="lefttop"></div>
      <div class="left_ul">
        <ul class="ulleft" id="common_operation">
        <div class="leftone">常用操作</div>
          <li><a class="this" id="welcome_op" href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/welcome','main_workspace','welcome_op')">欢迎页面</a></li>         
          <li><a href="javascript:void(0);" id="set_site_op_q" onclick="openURL('url','<%=request.getContextPath()%>/admin/set_site.htm','main_workspace','set_site_op_q')">买家地址管理</a></li>
          <li><a href="javascript:void(0);" id="user_list_op_q" onclick="openURL('url','<%=request.getContextPath()%>/admin/user_list.htm','main_workspace','user_list_op_q')">会员管理</a></li>
          <li><a href="javascript:void(0);" id="goods_manage_op_q" onclick="openURL('url','<%=request.getContextPath()%>/admin/goods/goodsClassList','main_workspace','goods_manage_op_q')">商品管理</a></li>
          <li><a href="javascript:void(0);" id="order_list_op_q" onclick="openURL('url','<%=request.getContextPath()%>/admin/order_list.htm','main_workspace','order_list_op_q')">订单管理</a></li>
        </ul>
        <ul class="ulleft" id="base_set" style="display:none;">
          <div class="leftone">基本设置</div>
          <li><a href="javascript:void(0);" id="set_system_op" class="this" onclick="openURL('url','<%=request.getContextPath()%>/admin/systemConfig/List','main_workspace','set_system_op')">系统参数设置</a></li>
          <li><a href="javascript:void(0);" id="set_site_op" class="this" onclick="openURL('url','<%=request.getContextPath()%>/admin/address/list','main_workspace','set_site_op')">买家地址管理</a></li>
          <li><a href="javascript:void(0);" id="admin_list_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/admin_list.htm','main_workspace','admin_list_op')">管理员管理</a></li>
        </ul>
        <ul class="ulleft" style="display:none;" id="about_goods">
          <div class="leftone">商品相关</div>
          <li><a href="javascript:void(0);" class="this" id="goods_class_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/goods/goodsClassList','main_workspace','goods_class_op')">分类管理</a> </li>
          <li><a href="javascript:void(0);" id="goods_brand_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/goods/goodsBrandList','main_workspace','goods_brand_op')">品牌管理</a></li>
          <li><a href="javascript:void(0);" id="goods_type_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/goods_type_list.htm','main_workspace','goods_type_op')">类型管理</a></li>
          <li><a href="javascript:void(0);" id="goods_spec_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/goods/goodsSpecList','main_workspace','goods_spec_op')">规格管理</a></li>
          <li><a href="javascript:void(0);" id="goods_releases_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/add_goods_first.htm','main_workspace','goods_releases_op')">商品发布</a></li>
          <li><a href="javascript:void(0);" id="goods_manage_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/goods_list.htm','main_workspace','goods_manage_op')">商品管理</a></li>
        </ul>
        <ul class="ulleft" style="display:none;" id="about_member">
          <div class="leftone">会员相关</div>
          <li><a href="javascript:void(0);" class="this" id="member_manage_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/user_list.htm','main_workspace','member_manage_op')">会员管理</a> </li>
          <li><a href="javascript:void(0);" class="this" id="user_creditrule_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/user_creditrule.htm','main_workspace','user_creditrule_op')">会员信用</a> </li>
          <li><a href="javascript:void(0);" id="user_msg_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/user_msg.htm','main_workspace','user_msg_op')">会员通知</a></li>
          <li><a href="javascript:void(0);" id="user_integral_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/user_integral.htm','main_workspace','user_integral_op')">积分管理</a></li>
          <li><a href="javascript:void(0);" id="integrallog_list_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/integrallog_list.htm','main_workspace','integrallog_list_op')">积分明细</a></li>
          <li><a href="javascript:void(0);" id="img_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/user_photo_list.htm','main_workspace','img_op')">图片管理</a></li> 
          <li><a id="user_sns_op" href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/sns_user.htm','main_workspace','user_sns_op')">会员动态</a></li>
          </li>
        </ul>
        <!-- 交易管理-->
        <ul class="ulleft" style="display:none;" id="about_trade">
          <div class="leftone">交易管理</div>
          <li><a href="javascript:void(0);" id="order_manage_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/order_list.htm','main_workspace','order_manage_op')">订单管理</a> </li>
          <li><a href="javascript:void(0);" id="set_order_confirm_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/set_order_confirm.htm','main_workspace','set_order_confirm_op')">订单设置</a> </li>
          <li><a href="javascript:void(0);" id="consult_manage_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/consult_list.htm','main_workspace','consult_manage_op')">咨询管理</a></li>
          <li><a href="javascript:void(0);" id="report_manage_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/report_list.htm','main_workspace','report_manage_op')">举报管理</a></li>
          <li><a href="javascript:void(0);"  id="evaluate_manage_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/evaluate_list.htm','main_workspace','evaluate_manage_op')">商品评价</a></li>
          <li><a href="javascript:void(0);" id="complaint_manage_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/complaint_list.htm','main_workspace','complaint_manage_op')">投诉管理</a></li>
        </ul>
        
        <!-- 提现管理-->
        <ul class="ulleft" style="display:none;" id="about_withdrawal">
          <div class="leftone">提现管理</div>
          <li>
	          <ul id="withdrawal_center_info">
	              <li><a href="javascript:void(0);" id="integral_rule_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/withdrawal/list','main_workspace','integral_rule_op')">待审核提现</a></li>
	              <li><a href="javascript:void(0);" id="integral_pass_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/withdrawal/passList','main_workspace','integral_pass_op')">已审核提现</a></li>
	              <li><a href="javascript:void(0);" id="integral_finish_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/withdrawal/finishList','main_workspace','integral_finish_op')">交易完成提现</a></li>
	              <li><a href="javascript:void(0);" id="integral_reject_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/withdrawal/rejectList','main_workspace','integral_reject_op')">拒绝提现</a></li>
	              <li><a href="javascript:void(0);" id="integral_password_op" onclick="openURL('url','<%=request.getContextPath()%>/admin/withdrawal/passwordList','main_workspace','integral_password_op')">提现密码管理</a></li>
	          </ul>
          </li>
        </ul>
        <ul class="ulleft" style="display:none;" id="sys_manage">
          <div class="leftone">系统管理</div>
          <li><a href="javascript:void(0);" id="password_modify_op" onclick="openURL('url','<%=request.getContextPath()%>/sysUsers/showModifyPassword','main_workspace','password_modify_op')">密码修改</a></li>
          <li><a href="javascript:void(0);" id="database_add_op" onclick="openURL('url','<%=request.getContextPath()%>/sysUsers/listSysUsers','main_workspace','database_add_op')">系统账号管理</a></li>
          <li><a href="javascript:void(0);" id="login_manage_op" onclick="openURL('url','<%=request.getContextPath()%>/loginLog/listSysUsersLogin','main_workspace','login_manage_op')">日志管理</a></li>
        </ul>
      </div>
    </div>
    <div class="content">
   	  <div class="navbar"><span class="webmap"><a href="javascript:void(0);">管理地图</a></span>
     		 <div style="line-height:36px;">您的位置：控制台><span id="top_nav_info">站点设置</span></div>
      </div>
      <iframe id="main_workspace" name="main_workspace" src="<%=request.getContextPath()%>/welcome" style="overflow:auto;height:550px" frameborder="0" width="100%" height="100%" scrolling="yes" onload="window.parent"></iframe>
    </div>
  </div>
</div>
<div class="webmap_box" style="display:none;">
  <h4><a href="javascript:void(0);" class="close_map"></a>管理中心导航</h4>
  <div class="webmap_list"> 
    <span class="weblist_sp">
    <h5>系统设置</h5>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/set_site.htm','main_workspace','set_site_op','base_set')">站点设置</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/set_image.htm','main_workspace','set_image_op','base_set')">上传设置</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/admin_list.htm','main_workspace','admin_list_op','base_set')">管理员管理</a>
    </span> 
    <span class="weblist_sp">
    <h5>商品管理</h5>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/goods_class_list.htm','main_workspace','goods_class_op','about_goods')">分类管理</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/goods_brand_list.htm','main_workspace','goods_brand_op','about_goods')">品牌管理</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/goods_type_list.htm','main_workspace','goods_type_op','about_goods')">类型管理</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/goods_spec_list.htm','main_workspace','goods_spec_op','about_goods')">规格管理</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/seller/add_goods_first.htm','main_workspace','goods_floor_op','about_goods')">商品发布</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/goods_list.htm','main_workspace','goods_manage_op','about_goods')">商品管理</a>
    </span> 
    <span class="weblist_sp">
    <h5>会员管理</h5>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/user_list.htm','main_workspace','member_manage_op','about_member')">会员管理</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/user_creditrule.htm','main_workspace','user_creditrule_op','about_member')">会员信用</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/user_msg.htm','main_workspace','user_msg_op','about_member')">会员通知</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/user_integral.htm','main_workspace','user_integral_op','about_member')">积分管理</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/integrallog_list.htm','main_workspace','integrallog_list_op','about_member')">积分明细</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/user_photo_list.htm','main_workspace','img_op','about_member')">图片管理</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/sns_user.htm','main_workspace','user_sns_op','about_member')">会员动态</a>
    </span> 
    <span class="weblist_sp">
    <h5>交易管理</h5>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/order_list.htm','main_workspace','order_manage_op','about_trade')">订单管理</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/set_order_confirm.htm','main_workspace','set_order_confirm_op','about_trade')">订单设置</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/consult_list.htm','main_workspace','consult_manage_op','about_trade')">咨询管理</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/report_list.htm','main_workspace','report_manage_op','about_trade')">举报管理</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/evaluate_list.htm','main_workspace','evaluate_manage_op','about_trade')">商品评价</a>
    <a href="javascript:void(0);" onclick="openURL('url','<%=request.getContextPath()%>/admin/complaint_list.htm','main_workspace','complaint_manage_op','about_trade')">投诉管理</a>
    </span>
  </div>
</div>
</body>
</html>