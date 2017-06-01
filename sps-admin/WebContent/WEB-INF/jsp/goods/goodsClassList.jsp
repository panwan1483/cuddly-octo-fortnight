<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>分类管理</title>
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
<script src="<%=request.getContextPath()%>/resources/js/jquery.poshytip.min.js"></script>

<style>
a.confirm {
  border: 1px solid #36c;
  background: #ddd;
  padding: 2px;
  border-radius: 3px;
  text-decoration: none;
}
</style>

<body>
<div class="cont">
  <h1 class="seth1">商品分类</h1>
  <div class="settab"><span class="tab-one"></span> <span class="tabs"> <a href="<%=request.getContextPath()%>/admin/goods/goodsClassList"  class="this">管理</a> | <a href="<%=request.getContextPath()%>/admin/goods/goodsClassAdd">新增</a></span> <span class="tab-two"></span></div>
   <div class="operation">
    <h3>友情提示</h3>
    <ul>
      <li>通过商品分类管理，你可以进行查看、编辑、删除系统商品分类</li>
      <li>你可以根据需要控制商品分类是否显示</li>
    </ul>
  </div>   
  <div class="classtable">
  <FORM name="ListForm" id="ListForm"  action="<%=request.getContextPath()%>/admin/goods/goodsClassList" method="post">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="class_table">
       <tr style="background:#2A7AD2;height:30px; color:#FFF">
        <td width="10%" align="center">排序</td>
        <td width="20%" align="center">分类名称</td>
        <td width="10%" align="center">分类级别</td>
        <td width="10%" align="center">点击量</td>
        <td width="20%" align="center">创建时间</td>
        <td width="10%" align="center">显示</td>
        <td width="10%" align="center">推荐</td>
        <td width="10%" align="center">操作</td>
      </tr>
    
      <c:forEach items="${paging_vo.object}" var="r"> 
      <tr>
        <td align="center">${r.id }</td>
        <td align="center">${r.className }<span class="newclass"><c:if test="${r.level<3}"><a href="<%=request.getContextPath()%>/admin/goods/addSecondPage?id=${r.id }">新增下级</a></c:if></span></td>
        <td align="center">${r.level }级分类</td>
        <td align="center">${r.clickNumber }</td>
        <td align="center"><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td align="center">
        	<img  src="<%=request.getContextPath()%>/resources/style/system/manage/blue/images/${r.display==1}.png" width="21" height="23"></img>
        </td>
        <td align="center">
        	<img  src="<%=request.getContextPath()%>/resources/style/system/manage/blue/images/${r.recommend==1}.png" width="21" height="23"></img>
        </td>
        <td align="left" class="ac8"><a href="<%=request.getContextPath()%>/admin/goods/goodsClassShow?id=${r.id }">编辑</a>|<a href="javascript:void(0);" onclick="if(confirm('删除分类会同时删除该分类的所有下级，是否继续?'))window.location.href='<%=request.getContextPath()%>/admin/goods/goodsClassDel?id=${r.id }'">删除</a></td>
      </tr>
      </c:forEach>
    </table>
    <c:choose>
    <c:when test="${paging_vo.totalRecord==0}">
                <span>无相关记录</span>
 	</c:when>
    <c:otherwise>
	  <input type="hidden" name="currentPage" id="currentPage" value="${paging_vo.currentPage }" />
	  <input name="mulitId" type="hidden" id="mulitId" />
	  <div class="fenye">
  共${paging_vo.totalRecord} 条记录,当前页 ${paging_vo.currentPage}, 总页数：${paging_vo.totalPage}
  <a href="<%=request.getContextPath()%>/admin/goods/goodsClassList">首页</a>
  <a href="<%=request.getContextPath()%>/admin/goods/goodsClassList?page_num=${paging_vo.prePage}">上一页</a>
  <c:forEach begin="${paging_vo.pageNumStart }" end="${paging_vo.pageNumEnd }" var="pageIndex">
  <c:if test="${paging_vo.currentPage==pageIndex }">
                <a style="background-color:#3b9acb;color:#fff" href="<%=request.getContextPath()%>/admin/goods/goodsClassList?page_num=${paging_vo.prePage}">
                    <span>${pageIndex}</span>
               </a>
  </c:if>
  <c:if test="${paging_vo.currentPage!=pageIndex }">        
  <a href="<%=request.getContextPath()%>/admin/goods/goodsClassList?page_num=${pageIndex}">
         <span>${pageIndex}</span>
         </a>
  </c:if>
  </c:forEach>
  <a href="<%=request.getContextPath()%>/admin/goods/goodsClassList?page_num=${paging_vo.nextPage}">下一页</a>
  <a href="<%=request.getContextPath()%>/admin/goods/goodsClassList?page_num=${paging_vo.totalPage}">尾页</a>
  当前显示  ${paging_vo.currentPage}/${paging_vo.totalPage}
 <br/>
</div>
</c:otherwise>
</c:choose> 
   </FORM>
  </div>  
</div>
</body>
</html>
