<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		 <shiro:hasPermission name="Industry:save">
			<li><a rel="industrySkills_add" width="550" height="230" class="add" href="${ctx}/industry/${parentId}/save" target="dialog"><span>添加</span></a></li>
		 </shiro:hasPermission>
		 <shiro:hasPermission name="Industry:delete">
		    <li class="line">line</li>
			<li><a width="550" height="230" class="delete" href="${ctx}/industry/{sid_orga}/delete" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		 </shiro:hasPermission>
		 <shiro:hasPermission name="Industry:edit">
		    <li class="line">line</li>
			<li><a width="550" height="230" class="edit" href="${ctx}/industry/{sid_orga}/update" target="dialog"><span>修改</span></a></li>
		 </shiro:hasPermission>
		</ul>
	</div>
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="90" width= "102%">
    <thead>
        <tr >
          	<th width="120">节点技能分类名称</th>
          	<th width="120">上级节点技能分类</th>
			<th width="400">描述</th>
        </tr>
    </thead>
    <tbody>
		<c:forEach items="${nodeList}" var="node">
			<tr target="sid_orga" rel="${node.id}" >
				<td><a width='500' height='230' rel='area_view' href='${ctx}/industry/${node.id}/view' target='dialog'>${node.name}</a></td>
				<td>${node.parent.name}</td>
				<td>${node.description}</td>
			</tr>
		</c:forEach>
    </tbody>
</table>
	<div class="panelBar"></div>
</div>
