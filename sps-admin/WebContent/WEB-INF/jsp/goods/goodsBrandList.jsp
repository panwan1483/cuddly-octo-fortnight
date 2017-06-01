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
<script src="<%=request.getContextPath()%>/resources/js/jquery.poshytip.min.js"></script>
<script>
/* jQuery(document).ready(function(){
  	tipStyle();
	//设置推荐的默认装态
	function recommendState(){
	var state = jQuery("#recommend").val();
	if(state=="true"){
		jQuery("#recommend").val("false");
		 jQuery("#").show();
		jQuery("#").hide(); 
	}else{
		jQuery("#recommend").val("true");
		jQuery("#").hide();
		jQuery("#").show(); 
	}
}
}); */

//网站logo file样式
jQuery(function(){
    var textButton="<input type='text' name='textfield' id='textfield1' class='size13' /><input type='button' name='button' id='button1' value='' class='filebtn' />"
	jQuery(textButton).insertBefore("#brandLogo");
	jQuery("#brandLogo").change(function(){
	jQuery("#textfield1").val(jQuery("#brandLogo").val());
	})
});	
//
function ajax_update(id,fieldName,obj){
   var val=jQuery(obj).val();
   jQuery.ajax({type:'POST',
	            url:'<%=request.getContextPath()%>/admin/goods_brand_ajax.htm',
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
</script>
<body>
<div class="cont">
  <h1 class="seth1">品牌管理</h1>
  <div class="settab"> 
	<span class="tab-one"></span> <span class="tabs"> 
	<a href="<%=request.getContextPath()%>/admin/goods/goodsBrandList" class="this">管理</a> | 
	<a href="<%=request.getContextPath()%>/admin/goods/goodsBrandAdd">新增</a> | 
    <%-- <a href="<%=request.getContextPath()%>/admin/goods/goodsBrandAudit">申请列表</a> --%>
	</span> 
	<span class="tab-two"></span>	</div>
	<form name="queryForm" id="queryForm" action="" method="post">
    <div class="allmem_search">
      <ul>
        <li> <span>品牌名称</span> <span class="allmen size4">
          <input name="name" type="text" id="name" />
          </span> <span>根据字母查询</span> <span class="allmen size4">
          <input name="firstWord" type="text" id="firstWord" />
          </span> <span class="btn_search">
          <input name="" type="submit"  value="搜索" style="cursor:pointer;"/>
          </span> </li>
      </ul>
    </div>
  </form>
  <div class="operation">
    <h3>友情提示</h3>
    <ul>
      <li> 通过商品品牌管理，你可以进行查看、编辑、删除系统商品品牌</li>
      <li>设置推荐的品牌会在商城首页根据序号从小到大的顺利轮换显示</li>
      <li>设置品牌首字母，在品牌列表页通过首字母搜索品牌</li>
    </ul>
  </div>
  <form name="ListForm" id="ListForm" action="<%=request.getContextPath()%>/admin/goods/goodsBrandList" method="post">
    <div class="brandtable">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="brand_table">
         <tr style="background:#2A7AD2;height:30px; color:#FFF">
          <td width="45">&nbsp;</td>
          <td width="183">品牌ID</td>
          <td width="183">品牌名称</td>
          <td width="183">根据字母查询</td>
          <td width="183">序列</td>
          <td width="183">商品Logo</td>
          <td width="183">品牌分类ID</td>
          <td width="183">备注</td>
          <td width="183">创建时间</td>
          <td width="183">操作</td>
        </tr>
        <c:forEach items="${paging_vo.object}" var="r"> 
        <tr>
          	<td align="center"><input name="checkbox" type="checkbox" id="checkbox" value="${r.id }" /></td>
          	<td><span class="pxnum size5"> <input type="text" name="goodsBrand.id" id="goodsBrand.id"  value="${r.id }"  onblur="ajax_update('${goodsBrand.id}','id',this)" title="可编辑"/></span></td>
          	<td><span class="pxnum size5"> <input name="goodsBrand.name" type="text" id="goodsBrand.name"  onblur="ajax_update('${r.name}','name',this)"  value="${r.name }" title="可编辑"/></span></td>
          	<td><span class="pxnum size5"> <input type="text" name="goodsBrand.firstWord" id="goodsBrand.firstWord"  value="${r.firstWord }"  onblur="ajax_update('${goodsBrand.firstWord}','firstWord',this)" title="可编辑"/></span></td>
          	<td><span class="pxnum size5"> <input type="text" name="goodsBrand.sequence" id="goodsBrand.sequence"  value="${r.sequence }"  onblur="ajax_update('${goodsBrand.sequence}','sequence',this)" title="可编辑"/></span></td>
          	<td><span class="pxnum size5"> <input type="text" name="goodsBrand.logo" id="goodsBrand.logo"  value="${r.logo }"  onblur="ajax_update('${goodsBrand.logo}','logo',this)" title="可编辑"/></span></td>
         	<td><span class="pxnum size5">  <input type="text" name="goodsBrand.goodsClassId" id="goodsBrand.goodsClassId"  value="${r.goodsClassId }"  onblur="ajax_update('${goodsBrand.goodsClassId}','goodsClassId',this)" title="可编辑"/></span></td>
         	<td><span class="pxnum size8"> <input name="goodsBrand.remark" type="text" id="goodsBrand.remark"  onblur="ajax_update('${r.remark}','remark',this)"  value="${r.remark }" title="可编辑"/> </span></td>
			<td><span class="pxnum size5">   <input type="text" name="goodsBrand.createTime" id="goodsBrand.createTime"  value="${r.createTime }"  onblur="ajax_update('${goodsBrand.createTime}','createTime',this)" title="可编辑"/></span></td>
          	<%-- <td><span>${r.id}</span></td> --%>
          <%-- <td><img src="<%=request.getContextPath()%>/$!obj.brandLogo.path/$!obj.brandLogo.name" width="88px" height="44px" /></td>
          <td align="center"><img onclick="ajax_update('${r.id}','recommend',this)" src="<%=request.getContextPath()%>/resources/style/system/manage/blue/images/$!{obj.recommend}.png" width="25" height="21" border="0" style="cursor:pointer;" title="可编辑"/> </td> --%>
          <td class="ac8" align="left"><a href="<%=request.getContextPath()%>/admin/goods/goodsBrandUpdate?id=${r.id}">编辑</a>|<a href="<%=request.getContextPath()%>/admin/goods/goodsBrandDel?id=${r.id}&currentPage=${currentPage }">删除</a></td>
        </tr>
        </c:forEach>
		<tr>
        <td align="center"><input type="checkbox" name="all" id="all" value="" onclick="selectAll(this)"/></td>
        <td colspan="2" class="bdel">
		<span class="sp1">全部</span><span class="sp2">
          <div class="shop_btn_del shopbtn">
            <input name="" type="button" style="cursor:pointer;" value="删除" onclick="cmd('<%=request.getContextPath()%>/admin/goods/goodsBrandDel?currentPage=${currentPage }');"/>
          </div>
          </span>
		  </td>
        <td colspan="4"></td>
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
  <a href="<%=request.getContextPath()%>/admin/goods/goodsBrandList">首页</a>
  <a href="<%=request.getContextPath()%>/admin/goods/goodsBrandList?page_num=${paging_vo.prePage}">上一页</a>
  <c:forEach begin="${paging_vo.pageNumStart }" end="${paging_vo.pageNumEnd }" var="pageIndex">
  <c:if test="${paging_vo.currentPage==pageIndex }">
                <a style="background-color:#3b9acb;color:#fff" href="<%=request.getContextPath()%>/admin/goods/goodsBrandList?page_num=${paging_vo.prePage}">
                    <span>${pageIndex}</span>
               </a>
  </c:if>
  <c:if test="${paging_vo.currentPage!=pageIndex }">        
  <a href="<%=request.getContextPath()%>/admin/goods/goodsBrandList?page_num=${pageIndex}">
         <span>${pageIndex}</span>
         </a>
  </c:if>
  </c:forEach>
  <a href="<%=request.getContextPath()%>/admin/goods/goodsBrandList?page_num=${paging_vo.nextPage}">下一页</a>
  <a href="<%=request.getContextPath()%>/admin/goods/goodsBrandList?page_num=${paging_vo.totalPage}">尾页</a>
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
