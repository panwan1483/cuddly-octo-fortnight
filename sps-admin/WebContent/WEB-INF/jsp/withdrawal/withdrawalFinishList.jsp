<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>提现功能列表</title>
<link href="<%=request.getContextPath()%>/resources/style/system/manage/blue/template.css"  rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/resources/style/common/css/jquery-ui-1.8.22.custom.css"  rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/style/common/css/overlay.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.shop.base.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.shop.common.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.21.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.zh.cn.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-migrate-1.2.1.js"></script>
<script>
$(document).ready(function(){
  $('#beginTime').datepicker({
	  dateFormat:"yy-mm-dd",
	  changeMonth: true,
	  changeYear: true
  });
  $('#endTime').datepicker({
	  dateFormat:"yy-mm-dd",
	  changeMonth: true,
	  changeYear: true
  });
});
</script>
<style>
a.confirm {
  border: 1px solid #36c;
  background: #ddd;
  padding: 2px;
  border-radius: 3px;
  text-decoration: none;
}
</style>
</head>
<body>
<div class="cont">
  <h1 class="seth1">提现管理</h1>
  <div class="settab"><span class="tab-one"></span> <span class="tabs">
  <a href="javascript:void(0);" class="this">交易完成提现列表</a></span> <span class="tab-two"></span></div>
  <form id="queryForm" action="<%=request.getContextPath()%>/admin/order_list.htm" method="post" >
  <div class="orders">
    <ul>
      <li>
       <span>提现申请人</span>
         <span class="order_input size1">
          <input name="applyer" type="text" id="type_data" value="${applyer }" style="width:160px;"/>
        </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span>提现订单号</span>
         <span class="order_input size1">
          <input name="applyOrder" type="text" id="applyOrder" value="${applyOrder }" style="width:233px;"/>
        </span>
        <span>&nbsp;&nbsp;&nbsp;&nbsp;申请时间</span><span class="order_input size2">
        <input name="beginTime" type="text" id="beginTime"  readonly="readonly" value="${beginTime }"/>
        </span><span>—</span><span class="order_input size2">
        <input name="endTime" type="text" id="endTime" readonly="readonly" value="${endTime }"/>
        </span> <span class="order_input size2"></span> <span class="btn_search">
        <input name="" type="submit"  value="搜索" style="cursor:pointer;"/>
      </span> </li>
    </ul>
  </div>
  </form>
  <form action="<%=request.getContextPath()%>/admin/withdrawal/finishList" method="post" id="ListForm" >
    <div class="allshop_table">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr style="background:#2A7AD2;height:30px; color:#FFF">
        <td width="10%">申请人</td>
        <td width="15%">申请订单号</td>
        <td width="15%">申请银行</td>
        <td width="15%">银行卡号</td>
        <td width="10%">申请金额</td>
        <td width="15%">申请时间</td>
        <td align="center">操作</td>
      </tr>
      <tr>
      <c:forEach items="${paging_vo.object}" var="r"> 
	        <td>${r.applyer}</td>
	        <td>${r.applyOrder}</td>
	        <td>${r.applyBankName}</td>
	        <td>${r.applyBankNumber}</td>
	        <td>${r.applyRmb}</td>
            <td><fmt:formatDate value="${r.applyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	        <td align="center" class="blue xiahua">
	            <a href="<%=request.getContextPath()%>/admin/withdrawal/detail?withdrawalId=${r.id}">查看详细</a>
	        </td>
       </c:forEach>
      </tr>
    </table>
    
    <c:choose>
<c:when test="${paging_vo.totalRecord==0}">
  <span> 无相关记录</span>
</c:when>
<c:otherwise>
<!--分页-->
<div class="fenye">
  共${paging_vo.totalRecord} 条记录,当前页 ${paging_vo.currentPage}, 总页数：${paging_vo.totalPage}
  
  <a href="<%=request.getContextPath()%>/admin/withdrawal/finishList?applyer=${applyer}&applyOrder=${applyOrder}&beginTime=${beginTime}&endTime=${endTime}">首页</a>
  <a href="<%=request.getContextPath()%>/admin/withdrawal/finishList?applyer=${applyer}&applyOrder=${applyOrder}&beginTime=${beginTime}&endTime=${endTime}">上一页</a>
  <c:forEach begin="${paging_vo.pageNumStart }" end="${paging_vo.pageNumEnd }" var="pageIndex">
  <c:if test="${paging_vo.currentPage==pageIndex }">
                <a style="background-color:#3b9acb;color:#fff" href="<%=request.getContextPath()%>/admin/withdrawal/finishList?page_num=${paging_vo.prePage}&passport=${passport}&orderId=${orderId}&startTime=${startTime}&endTime=${endTime}&productName=${productName}">
                    <span>${pageIndex}</span>
               </a>
  </c:if>
  <c:if test="${paging_vo.currentPage!=pageIndex }">        
  <a href="<%=request.getContextPath()%>/admin/withdrawal/finishList?page_num=${pageIndex}applyer=${applyer}&applyOrder=${applyOrder}&beginTime=${beginTime}&endTime=${endTime}">
         <span>${pageIndex}</span>
         </a>
  </c:if>
  </c:forEach>
  <a href="<%=request.getContextPath()%>/admin/withdrawal/finishList?page_num=${paging_vo.nextPage}&passport=${passport}&orderId=${orderId}&startTime=${startTime}&endTime=${endTime}&productName=${productName}">下一页</a>
  <a href="<%=request.getContextPath()%>/admin/withdrawal/finishList?page_num=${paging_vo.totalPage}&passport=${passport}&orderId=${orderId}&startTime=${startTime}&endTime=${endTime}&productName=${productName}">尾页</a>

  当前显示  ${paging_vo.currentPage}/${paging_vo.totalPage}
 <br/>
</div>
</c:otherwise>
</c:choose>
    
  </div>
  </form>
</div>
</body>
</html>