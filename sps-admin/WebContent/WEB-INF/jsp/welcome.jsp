<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商城系统后台管理</title>
</head>
<link href="<%=request.getContextPath()%>/resources/style/system/manage/blue/template.css"  rel="stylesheet" type="text/css"/>
<style>
.shopping_evaluate
{
  color:#fff; 
  background-color:#FF6600; 
  padding:2px 4px; 
  border-radius:4px 4px 4px 4px;
}
</style>
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<body>
      <div class="cont">
        <h1 class="seth1">欢迎页面</h1>
        <div class="welcome"><strong>您好,<span style="color:#06F">${login_session_admin.username}</span>,欢迎使用商城系统. 您上次登录的时间：$!CommUtil.formatLongDate($!user.lastLoginDate),登录IP:$!user.lastLoginIp</strong></div>

          <div class="wela">
            <h2>一周动态[本次统计时间：$!CommUtil.formatLongDate($!stat.addTime),下次统计时间：$!CommUtil.formatLongDate($!stat.next_time)]</h2>
            <ul>
              <li>新增会员数：    $!{stat.week_user}个</li>
              <li>新增商品数：    $!{stat.week_goods}件</li>
              <li>新增订单数：    $!{stat.week_order}单</li>
              <li>待处理投诉： <a href="javascript:void(0);" onclick="window.parent.openURL('url','<%=request.getContextPath()%>/admin/complaint_list.htm?status=new','main_workspace','complaint_manage_op')" class="shopping_evaluate">$!{stat.week_complaint}起</a></li>
              <li>待处理举报：  <a href="javascript:void(0);" onclick="window.parent.openURL('url','<%=request.getContextPath()%>/admin/report_list.htm','main_workspace','report_manage_op')" class="shopping_evaluate">$!{stat.week_report}次</a></li>
            </ul>
          </div>
              <div class="wela">
            <h2>统计信息[本次统计时间：$!CommUtil.formatLongDate($!stat.addTime),下次统计时间：$!CommUtil.formatLongDate($!stat.next_time)]</h2>
            <ul>
              <li>会员总数： $!{stat.all_user}个</li>
              <li>商品总数：$!{stat.all_goods}件</li>
              <li>订单总金额：¥$!CommUtil.null2Double($!{stat.order_amount})</li>
              <li>商品好评: <a href="javascript:void(0);" onclick="window.parent.openURL('url','<%=request.getContextPath()%>/admin/evaluate_list.htm?evaluate_buyer_val=1','main_workspace','report_manage_op')" class="shopping_evaluate">$!favorableEvaluate件</a></li>
              <li>商品中评:  <a href="javascript:void(0);" onclick="window.parent.openURL('url','<%=request.getContextPath()%>/admin/evaluate_list.htm?evaluate_buyer_val=0','main_workspace','report_manage_op')" class="shopping_evaluate">$!middleEvaluate件</a></li>
              <li>商品差评:  <a href="javascript:void(0);" onclick="window.parent.openURL('url','<%=request.getContextPath()%>/admin/evaluate_list.htm?evaluate_buyer_val=-1','main_workspace','report_manage_op')" class="shopping_evaluate">$!unfavorableEvaluate件</a></li>
              <li>总咨询数:  <a href="javascript:void(0);" onclick="window.parent.openURL('url','<%=request.getContextPath()%>/admin/consult_list.htm','main_workspace','report_manage_op')" class="shopping_evaluate">$!consultCount条</a></li>
              <li>已回复咨询:  <a href="javascript:void(0);" onclick="window.parent.openURL('url','<%=request.getContextPath()%>/admin/consult_list.htm','main_workspace','report_manage_op')" class="shopping_evaluate">$!consultYetReply条</a></li>
              <li>未回复咨询:  <a href="javascript:void(0);" onclick="window.parent.openURL('url','<%=request.getContextPath()%>/admin/consult_list.htm','main_workspace','report_manage_op')" class="shopping_evaluate">$!consultNoYetReply</a></li>
            </ul>
          </div>
          <div class="wela">
            <h2>系统信息</h2>
            <ul>
              <li>服务器操作系统：$!os</li>
              <li>JAVA版本：$!java_version</li>
              <li>数据库版本信息：$!database_version</li>
              <li>应用服务器：$!web_server_version</li>
            </ul>
          </div>
      </div>
</body>
</html>