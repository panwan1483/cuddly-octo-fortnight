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
  <div class="orderdetail">
    <div class="orderh">提现订单详细</div>
    <div class="orderul">
      <ul>
        <li><span class="ordertitle">申请人:</span><span>${withdrawal.applyer}</span></li>
        <li><span class="ordertitle">订单号:</span><span>${withdrawal.applyOrder}</span></li>
        <li><span class="ordertitle"> 订单状态:</span>
            <span style="color:blue">
	        	 <c:if test="${withdrawal.status==0}">申请提现</c:if>
	        	 <c:if test="${withdrawal.status==1}">审批通过,提现进行中</c:if>
	        	 <c:if test="${withdrawal.status==2}">交易完成</c:if>
	        	 <c:if test="${withdrawal.status==-1}">审批不通过</c:if>
            </span>
         </li>
        <li><span class="ordertitle">银行卡信息:</span><span>${withdrawal.applyBankName}(${withdrawal.applyBankCode})</span></li>
        <li><span class="ordertitle">银行卡号码:</span><span>${withdrawal.applyBankNumber}</span></li>
        <li><span class="ordertitle">订单总额:</span><span><strong class="orange" style="padding-right:10px;">¥${withdrawal.applyRmb}</strong></span></li>
        <li><span class="ordertitle">申请提现时间:</span>
            <span><fmt:formatDate value="${withdrawal.applyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
        </li>
	    <c:if test="${withdrawal.status==-1}">
	        <li><span class="ordertitle">拒绝提现的原因:</span><span>${withdrawal.remark}</span></li>
	     </c:if>  
      </ul>
    </div>
    <div id="writeForm" class="ordetable">
      <form method="post" name="statusform">
       <span>拒绝提现的原因：</span><br/><textarea id="withdrawal.remark" name="withdrawal.remark" rows="5" cols="50"></textarea>
        <br/>  
       <input type="button" type="submit" name="reject" value="拒绝提现" onclick="statusform.action='<%=request.getContextPath()%>/admin/withdrawal/reject?uid=${withdrawal.uid}';statusform.submit()"/>&nbsp;&nbsp;&nbsp;
       <input type="button" type="submit" name="pass" value="提现审核通过" onclick="statusform.action='<%=request.getContextPath()%>/admin/withdrawal/pass?uid=${withdrawal.uid}';statusform.submit()"/>
      </form>
    </div>
</div>
</body>
</html>