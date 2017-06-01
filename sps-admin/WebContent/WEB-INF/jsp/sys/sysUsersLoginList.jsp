<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>日志管理</title>
<link href="<%=request.getContextPath()%>/resources/style/system/manage/blue/template.css"  rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/resources/style/common/css/jquery-ui-1.8.22.custom.css"  rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/style/common/css/overlay.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/layer/skin/layer.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.shop.base.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.shop.common.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.21.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.zh.cn.js"></script>
<script src="<%=request.getContextPath()%>/resources/layer/layer.js"></script>
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
<div class="cont" style="height:550px;overflow:auto">
  <div class="settab"><span class="tab-one"></span> <span class="tabs">
  <a href="javascript:void(0);" class="this">日志管理</a></span> <span class="tab-two"></span></div>
  <form id="queryForm" action="<%=request.getContextPath()%>/loginLog/listSysUsersLogin" method="post" >
  <div class="orders">
    <ul>
      <li>
       <span>用户名</span>
         <span class="order_input size1">
          <input name="username" type="text" id="username" value="${username}" style="width:160px;"/>
        </span>
        <span class="btn_search">
          <input name="" type="submit"  value="搜索" style="cursor:pointer;"/>
        </span>
       </li>
    </ul>
  </div>
  </form>
  <form action="<%=request.getContextPath()%>/loginLog/listSysUsersLogin" method="post" id="ListForm" >
    <div class="allshop_table">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="content">
      <tr style="background:#2A7AD2;height:30px; color:#FFF">
        <td width="15%">系统用户编号</td>
        <td width="10%">用户名</td>
        <td width="15%">IP地址</td>
        <td width="10%">浏览器</td>
        <td width="15%">操作系统</td>
        <td width="15%">登录状态</td>
        <td width="20%">登录时间</td>
      </tr>
      <c:forEach items="${paging_vo.object}" var="r"> 
      <tr>
	        <td>${r.sysId}</td>
	        <td>${r.username}</td>
	        <td>${r.ip}</td>
	        <td>${r.browser }</td>
	        <td>${r.os}</td>
	        <td>
	        <c:if test="${r.status==1}"><span style="color: green">登录成功</span></c:if>
	        <c:if test="${r.status==-1}"><span style="color: red">登录失败</span></c:if>
	        </td>
            <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	   </tr>     
       </c:forEach>
    </table>
    <c:choose>
     <c:when test="${paging_vo.totalRecord==0}">
                <span>无相关记录</span>
 	</c:when>
<c:otherwise>
<!--分页-->
<div class="fenye">
  共${paging_vo.totalRecord} 条记录,当前页 ${paging_vo.currentPage}, 总页数：${paging_vo.totalPage}
  <a href="<%=request.getContextPath()%>/loginLog/listSysUsersLogin?username=${username}">首页</a>
  <a href="<%=request.getContextPath()%>/loginLog/listSysUsersLogin?page_num=${paging_vo.prePage}&username=${username}">上一页</a>
  <c:forEach begin="${paging_vo.pageNumStart }" end="${paging_vo.pageNumEnd }" var="pageIndex">
  <c:if test="${paging_vo.currentPage==pageIndex }">
                <a style="background-color:#3b9acb;color:#fff" href="<%=request.getContextPath()%>/loginLog/listSysUsersLogin?page_num=${paging_vo.prePage}&username=${username}">
                    <span>${pageIndex}</span>
               </a>
  </c:if>
  <c:if test="${paging_vo.currentPage!=pageIndex }">        
  <a href="<%=request.getContextPath()%>/loginLog/listSysUsersLogin?page_num=${pageIndex}&username=${username}">
         <span>${pageIndex}</span>
         </a>
  </c:if>
  </c:forEach>
  <a href="<%=request.getContextPath()%>/loginLog/listSysUsersLogin?page_num=${paging_vo.nextPage}&username=${username}">下一页</a>
  <a href="<%=request.getContextPath()%>/loginLog/listSysUsersLogin?page_num=${paging_vo.totalPage}&username=${username}">尾页</a>
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