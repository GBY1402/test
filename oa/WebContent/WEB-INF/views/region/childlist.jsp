<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		 <shiro:hasPermission name="Region:save">
			<li><a rel="industry_add" width="550" height="360" class="add" href="${ctx}/region/${parentId}/save" target="dialog" mask="true" ><span>添加</span></a></li>
		 </shiro:hasPermission>
		 <shiro:hasPermission name="Region:delete">
		    <li class="line">line</li>
			<li><a width="550" height="230" class="delete" href="${ctx}/region/{sid_orga}/delete" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		 </shiro:hasPermission>
		 <shiro:hasPermission name="Region:edit">
		    <li class="line">line</li>
			<li><a width="550" height="360" class="edit" href="${ctx}/region/{sid_orga}/edit" target="dialog"><span>修改</span></a></li>
		 </shiro:hasPermission>
		</ul>
	</div>
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="90" width= "102%">
    <thead>
        <tr >
          	<th width="120">区域名称</th>
          	<th width="120">短名称</th>
          	<th width="120">邮政编码</th>
			<th width="400">上级名称</th>
        </tr>
    </thead>
    <tbody>
		<c:forEach items="${nodeList}" var="node">
			<tr target="sid_orga" rel="${node.regionId}" >
				<td><a width='400' height='300' rel='area_view' href='${ctx}/region/${node.regionId}/view' target='dialog'>${node.regionName}</a></td>
				<td>${node.shortName}</td>
				<td>${node.zipcode}</td>
				<td>${node.parentId.regionName}</td>
			</tr>
		</c:forEach>
    </tbody>
</table>
	<div class="panelBar"></div>
</div>
