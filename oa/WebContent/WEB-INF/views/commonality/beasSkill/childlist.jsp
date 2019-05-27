<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		 <shiro:hasPermission name="Industry:save">
			<li><a rel="industrySkills_add" width="500" height="230" class="add" href="${ctx}/skills/${id}/save" target="dialog" mask="true" ><span>添加</span></a></li>
		 </shiro:hasPermission>
		 <shiro:hasPermission name="Industry:delete">
		    <li class="line">line</li>
			<li><a width="550" height="500" class="delete" href="${ctx}/skills/{sid_orga}/delete" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		 </shiro:hasPermission>
		 <shiro:hasPermission name="Industry:edit">
		    <li class="line">line</li>
			<li><a width="550" height="500" rel="industrySkills_edit" class="edit" href="${ctx}/skills/{sid_orga}/update" target="dialog"><span>修改</span></a></li>
		 </shiro:hasPermission>
		  <shiro:hasPermission name="Industry:delete">
		    <li class="line">line</li>
			<li><a width="550" height="500" class="delete" href="${ctx}/industry/generator" target="ajaxTodo" title="确定要生成所有技能吗?"><span>生成所有技能</span></a></li>
		 </shiro:hasPermission>
		</ul>
	</div>
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="90" width= "102%">
    <thead>
        <tr >
          	<th width="120">技能名称</th>
          	<th width="120">行业方向</th>
			<th width="400">技能指数</th>
        </tr>
    </thead>
    <tbody>
		<c:forEach items="${nodeList}" var="node">
			<tr target="sid_orga" rel="${node.sId}" >
				<td><a width='500' height='230' rel='area_view' href='${ctx}/skills/${node.sId}/view' target='dialog'>${node.sName}</a></td>
				<td>${node.functionInfo.name}</td>
				<td>${node.sValue}</td>
			</tr>
		</c:forEach>
    </tbody>
</table>
	<div class="panelBar"></div>
</div>
