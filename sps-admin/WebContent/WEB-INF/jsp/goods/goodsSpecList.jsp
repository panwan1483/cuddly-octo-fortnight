<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>规格管理</title>
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
<script>
function addorsubtract(obj,id){
 var cls=jQuery(obj).attr("cls");
 var level=jQuery(obj).attr("level");
  if(cls=="jian"){
  jQuery.ajax({type:'POST',
		       url:'<%=request.getContextPath()%>/admin/goods_class_data.htm',
		        data:{"pid":id,"currentPage":"${currentPage}"},
				success:function(data){
	                jQuery("#"+id).after(data);
					jQuery(obj).attr("src","<%=request.getContextPath()%>/resources/style/system/manage/blue/images/add.jpg");
					jQuery(obj).attr("cls","add");
					tipStyle();
              }
  });
  }else{
       if(level=="0_"+id){
	    jQuery("tr[level=child_"+id+"]").remove();
	   }else
	   jQuery("tr[parent="+id+"]").remove();
	   jQuery(obj).attr("src","<%=request.getContextPath()%>/resources/style/system/manage/blue/images/jian.jpg");
	   jQuery(obj).attr("cls","jian");
  }
  //
}
function ajax_update(id,fieldName,obj){
   var val=jQuery(obj).val();
    jQuery.ajax({type:'POST',
	              url:'<%=request.getContextPath()%>/admin/goods/goodsSpecUpdate',
				  data:{"id":id,"fieldName":fieldName,"value":val},
				beforeSend:function(){
				  
				},
			   success:function(data){
	             if(val==""){
				   jQuery(obj).attr("src","<%=request.getContextPath()%>/resources/style/system/manage/blue/images/"+data+".png");
				 }else{
				   jQuery(obj).val(val);
				 }      
              }
	    });
}
jQuery(document).ready(function(){
 
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

 
<body>
<div class="cont">
  <h1 class="seth1">商品分类</h1>
  <div class="settab"><span class="tab-one"></span> <span class="tabs"> <a href="<%=request.getContextPath()%>/admin/goods/goodsSpecList"  class="this">管理</a> | <a href="<%=request.getContextPath()%>/admin/goods/goodsSpecAdd">新增</a></span> <span class="tab-two"></span></div>
   <div class="operation">
    <h3>友情提示</h3>
    <ul>
      <li>通过商品规格管理，你可以进行查看、编辑、删除系统商品规格</li>
      <li>你可以根据需要控制商品规格是否显示</li>
    </ul>
  </div>   
  <div class="classtable">
  <FORM name="ListForm" id="ListForm"  action="<%=request.getContextPath()%>/admin/goods/goodsSpecList" method="post">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="class_table">
       <tr style="background:#2A7AD2;height:30px; color:#FFF">
        <td width="5%">&nbsp;</td>
        <td width="10%">排序</td>
        <td width="20%" align="left">规格名称</td>
        <td width="40%" align="center">规格值</td>
        <td width="center" align="left">操作</td>
      </tr>
    
      <c:forEach items="${paging_vo.object}" var="r"> 
      <tr id="${obj.id }">
	    <td align="center"><input name="ids" id="ids" type="checkbox" value="${r.id }" /></td>
        <td colspan="2" align="center"><ul class="addclass">
          <li class="ac1">
            <input name="${r.id }" id="${r.id }" type="hidden" value="true" />
            <img src="<%=request.getContextPath()%>/resources/style/system/manage/blue/images/jian.jpg" cls="jian" level="0_${r.id }" width="14" height="14" id="jian_${r.id }" onclick="addorsubtract(this,${r.id});" style="cursor:pointer;"/> </li>
          <li class="ac2"><span class="num">
            <input type="text" name="${r.sequence }" id="${r.sequence }"  value="${r.sequence }"   title="可编辑"/>
          </span></li>
          <li class="ac3"><span class="classies">
            <input type="text" name="${r.name }" id="${r.name }" value="${r.name }"  title="可编辑"/></li>
        </ul></td>
        <td align="left" class="ac8"><a href="<%=request.getContextPath()%>/admin/goods/goodsSpecEdit?id=${r.id }&currentPage=${currentPage }">编辑</a>|<a href="javascript:void(0);" onclick="if(confirm('删除后不可恢复，是否继续?'))window.location.href='<%=request.getContextPath()%>/admin/goods/goodsSpecDel?id=${r.id }&currentPage=${currentPage }'">删除</a></td>
      </tr>
      </c:forEach>
      <tr style="background:#F2F2F2; height:30px;">
		<td align="center"><input type="checkbox" name="all" id="all" value="" onclick="selectAll(this)"/></td>
        <td colspan="2" align="center" class="sall"><span class="classall">全部</span><span class="shop_btn_del" id="alldel">
          <input name="input" type="button" value="删除" style="cursor:pointer;" onclick="cmd('<%=request.getContextPath()%>/admin/goods/goodsSpecDel')"/>
          </span></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>   
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
  <a href="<%=request.getContextPath()%>/admin/goods/goodsSpecList">首页</a>
  <a href="<%=request.getContextPath()%>/admin/goods/goodsSpecList?page_num=${paging_vo.prePage}">上一页</a>
  <c:forEach begin="${paging_vo.pageNumStart }" end="${paging_vo.pageNumEnd }" var="pageIndex">
  <c:if test="${paging_vo.currentPage==pageIndex }">
                <a style="background-color:#3b9acb;color:#fff" href="<%=request.getContextPath()%>/admin/goods/goodsSpecList?page_num=${paging_vo.prePage}">
                    <span>${pageIndex}</span>
               </a>
  </c:if>
  <c:if test="${paging_vo.currentPage!=pageIndex }">        
  <a href="<%=request.getContextPath()%>/admin/goods/goodsSpecList?page_num=${pageIndex}">
         <span>${pageIndex}</span>
         </a>
  </c:if>
  </c:forEach>
  <a href="<%=request.getContextPath()%>/admin/goods/goodsSpecList?page_num=${paging_vo.nextPage}">下一页</a>
  <a href="<%=request.getContextPath()%>/admin/goods/goodsSpecList?page_num=${paging_vo.totalPage}">尾页</a>
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