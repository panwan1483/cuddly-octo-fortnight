<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>买家地址管理</title>
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
<div class="cont">
  <div class="settab"><span class="tab-one"></span> <span class="tabs">
  <a href="javascript:void(0);" class="this">买家地址管理</a></span> <span class="tab-two"></span></div>
  <form id="queryForm" action="<%=request.getContextPath()%>/admin/address/list" method="post" >
  <div class="orders">
    <ul>
      <li>
       <span>买家手机号</span>
         <span class="order_input size1">
          <input name="telephone" type="text" id="telephone" value="${telephone}" style="width:160px;"/>
        </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <span>买家姓名</span>
         <span class="order_input size1">
          <input name="trueName" type="text" id="trueName" value="${trueName}" style="width:160px;"/>
        </span>
        <span class="btn_search">
           <input name="" type="submit" value="搜索" style="cursor:pointer;"/>
      	</span>
       </li>
    </ul>
  </div>
  </form>
  <form action="<%=request.getContextPath()%>/admin/address/list" method="post" id="ListForm" >
    <div class="allshop_table">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="content">
      <tr style="background:#2A7AD2;height:30px; color:#FFF">
        <td width="10%">用户编号</td>
        <td width="15%">详细地址信息</td>
        <td width="10%">电话号码</td>
        <td width="10%">手机号码</td>
        <td width="10%">真实姓名</td>
        <td width="10%">邮编</td>
        <td width="10%">所属地区</td>
        <td width="15%">创建时间</td>
        <td align="center">操作</td>
      </tr>
      <c:forEach items="${paging_vo.object}" var="r"> 
      <tr>
	        <td>${r.uid}</td>
	        <td>${r.areaInfo}</td>
	        <td>${r.mobile}</td>
	        <td>${r.telephone}</td>
	        <td>${r.trueName}</td>
	        <td>${r.zip}</td>
	        <td>${r.areaId}</td>
            <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	        <td align="center" class="blue xiahua">
	           <a href="#" name="del" id="${r.id}">删除</a>&nbsp;&nbsp;
	        </td>
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
  <a href="<%=request.getContextPath()%>/admin/address/list">首页</a>
  <a href="<%=request.getContextPath()%>/admin/address/list?page_num=${paging_vo.prePage}telephone=${telephone}&trueName=${trueName}">上一页</a>
  <c:forEach begin="${paging_vo.pageNumStart }" end="${paging_vo.pageNumEnd }" var="pageIndex">
  <c:if test="${paging_vo.currentPage==pageIndex }">
        <a style="background-color:#3b9acb;color:#fff" href="<%=request.getContextPath()%>/admin/address/list?page_num=${paging_vo.prePage}&telephone=${telephone}&trueName=${trueName}">
            <span>${pageIndex}</span>
       </a>
  </c:if>
  <c:if test="${paging_vo.currentPage!=pageIndex }">        
  <a href="<%=request.getContextPath()%>/admin/address/list?page_num=${pageIndex}&telephone=${telephone}&trueName=${trueName}">
         <span>${pageIndex}</span>
         </a>
  </c:if>
  </c:forEach>
  <a href="<%=request.getContextPath()%>/admin/address/list?page_num=${paging_vo.nextPage}&telephone=${telephone}&trueName=${trueName}">下一页</a>
  <a href="<%=request.getContextPath()%>/admin/address/list?page_num=${paging_vo.totalPage}&telephone=${telephone}&trueName=${trueName}">尾页</a>
  		当前显示  ${paging_vo.currentPage}/${paging_vo.totalPage}
 <br/>
</div>
</c:otherwise>
</c:choose>
</div>
 </form>
</div>
<script type="text/javascript">
$(function()
{
	$("#content a[name='del']").click(function()
	{
		var id=this.id;
		//询问框
		layer.confirm('您是确定要删除这条记录吗？', {
		  btn: ['是','否'] //按钮
		}, function()
		{
			$.ajax({
        		type: "post",
        		url: "<%=request.getContextPath()%>/admin/address/delete?id="+id,
        		cache:false,
        		success: function(result) 
        		{
        			var code=result.code;
        			var msg=result.msg;
        			var url=result.object.url;
        			if(code=="200")
        			{
        				layer.msg(msg);
        				window.location.href=url;
        			}else
        			{
        				layer.msg(msg);
        			}
        		}
        	});
		}, function(){
	 });
   });
});
</script>
</body>
</html>