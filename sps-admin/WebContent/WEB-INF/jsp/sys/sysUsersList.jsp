<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统设置</title>
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
  <a href="javascript:void(0);" class="this">管理员设置</a></span> <span class="tab-two"></span></div>
  <form id="queryForm" action="<%=request.getContextPath()%>/sysUsers/listSysUsers" method="post" >
  <div class="orders">
    <ul>
      <li>
       <span>姓名</span>
         <span class="order_input size1">
          <input name="cnname" type="text" id="cnname" value="${cnname}" style="width:160px;"/>
        </span>
       <span>状态</span>
         <span class="order_input size1">
          <select name="status" id="status">
          	<option value="" selected="selected">请选择</option>
          	<option value="0">启用</option>
          	<option value="-1">禁用</option>
          </select>
        </span>
        <span class="btn_search">
          <input name="" type="submit"  value="搜索" style="cursor:pointer;"/>
        </span>
        <span class="btn_search" style="margin-left:10px;">
      	   <a href="<%=request.getContextPath()%>/sysUsers/show">添加管理人员</a>
      	 </span>
       </li>
    </ul>
  </div>
  </form>
  <form action="<%=request.getContextPath()%>/sysUsers/listSysUsers" method="post" id="ListForm" >
    <div class="allshop_table">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="content">
      <tr style="background:#2A7AD2;height:30px; color:#FFF">
        <td width="15%">账号</td>
        <td width="10%">姓名</td>
        <td width="15%">手机号码</td>
        <td width="10%">性别</td>
        <td width="10%">状态</td>
        <td width="20%">创建时间</td>
        <td width="10%">操作</td>
      </tr>
      <c:forEach items="${paging_vo.object}" var="r"> 
      <tr>
	        <td>${r.username}</td>
	        <td>${r.cnname}</td>
	        <td>${r.phone}</td>
	        <td>
	        	<c:if test="${r.gender==0 }">女 </c:if>
	            <c:if test="${r.gender==1 }">男 </c:if>
	        </td>
	        <td>
		        <c:if test="${r.status==0 }">启用 </c:if>
		        <c:if test="${r.status==-1 }">禁用 </c:if>
	        </td>
            <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	        <td class="blue xiahua">
	        	<c:if test="${r.status==0 }">
	            	<a href="#" name="del" title="禁用账号" id="${r.id}"><span style="color:red">禁用账号</span></a>
	            </c:if>
	            <c:if test="${r.status==-1 }">
	                <a href="#" name="open" title="启用账号"  id="${r.id}"><span style="color:green">启用账号</span></a>
	            </c:if>
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
  <a href="<%=request.getContextPath()%>/sysUsers/listSysUsers?cnname=${cnname}&status=${status}">首页</a>
  <a href="<%=request.getContextPath()%>/sysUsers/listSysUsers?page_num=${paging_vo.prePage}&cnname=${cnname}&status=${status}">上一页</a>
  <c:forEach begin="${paging_vo.pageNumStart }" end="${paging_vo.pageNumEnd }" var="pageIndex">
  <c:if test="${paging_vo.currentPage==pageIndex }">
                <a style="background-color:#3b9acb;color:#fff" href="<%=request.getContextPath()%>/sysUsers/listSysUsers?page_num=${paging_vo.prePage}&cnname=${cname}&status=${status}">
                    <span>${pageIndex}</span>
               </a>
  </c:if>
  <c:if test="${paging_vo.currentPage!=pageIndex }">        
  <a href="<%=request.getContextPath()%>/sysUsers/listSysUsers?page_num=${pageIndex}&cnname=${cnname}&status=${status}">
         <span>${pageIndex}</span>
         </a>
  </c:if>
  </c:forEach>
  <a href="<%=request.getContextPath()%>/sysUsers/listSysUsers?page_num=${paging_vo.nextPage}&cnname=${cnname}&status=${status}">下一页</a>
  <a href="<%=request.getContextPath()%>/sysUsers/listSysUsers?page_num=${paging_vo.totalPage}&cnname=${cnname}&status=${status}">尾页</a>
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
		layer.confirm('您是确定要禁用该账号吗？', {
		  btn: ['是','否'] //按钮
		}, function()
		{
			$.ajax({
        		type: "post",
        		url: "<%=request.getContextPath()%>/sysUsers/delete?status=-1&id="+id,
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
	
	$("#content a[name='open']").click(function()
			{
				var id=this.id;
				//询问框
				layer.confirm('您是确定要启用该账号吗？', {
				  btn: ['是','否'] //按钮
				}, function()
				{
					$.ajax({
		        		type: "post",
		        		url: "<%=request.getContextPath()%>/sysUsers/delete?status=0&id="+id,
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
<script type="text/javascript">
var status="${status}";
if(status==1)
{
  status="";
}
$("#status").get(0).value=status;
</script>
</body>
</html>