<%@page import="java.util.Map"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		<shiro:hasPermission name="empl:save">
			<li><a class="add" href="${ctx}/apk/create" target="dialog"><span>添加</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="empl:edit">
			<li><a class="edit" href="${ctx}/apk/${emp.id}/{sid_user}/update" target="dialog"><span>修改</span></a></li>
		</shiro:hasPermission>
		<li class="line">line</li>
		<shiro:hasPermission name="empl:view">
			<li><a class="icon" href="${ctx}/apk/${emp.id}/{sid_user}/view" target="dialog"><span>详细</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="empl:delete">
			<li><a class="delete" rel="apk" href="${ctx}/apk/${emp.apkId}/{sid_user}/delete" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</shiro:hasPermission>
		</ul>
	</div>
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="137">
    <thead>
        <tr >
            <th width="100px" align="center">类型</th>
            <th width="100px" align="center">描述</th>
            <th width="100px" align="center">版本号</th>
            <th width="100px" align="center">下载路径</th>
            <th width="100px" align="center">创建人</th>
            <th width="100px" align="center">创建时间</th>
            <th width="100px" align="center">修改人</th>
            <th width="100px" align="center">修改时间</th>
     		<th width="200px" align="center">状态</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listApk.content}" var="emp">
            <tr target="sid_user" rel="${emp.apkId}">
            	<td>
	                <c:if test="${emp.apkType==0 }">
	                	个人安卓
	                </c:if>
	                <c:if test="${emp.apkType==1 }">
	                	个人IOS
	                </c:if>
	                <c:if test="${emp.apkType==2 }">
	                	企业安卓
	                </c:if>
	                <c:if test="${emp.apkType==3 }">
	                	企业IOS
	                </c:if>
                </td>
                 <td>${emp.name }</td>
                 <td>${emp.version }</td>
                 <td>
                 	<c:if test="${emp.path != ''}">
                 		<a href="${emp.path }" target="_href">${emp.path }</a>
                 	</c:if>
                 </td>
                 <td>${emp.createName }</td>
                 <td>
                	<fmt:formatDate value="${emp.createTime}" type="date" dateStyle="long"/>
                 </td>
                 <td>${emp.updateName }</td>
                 <td>
                	<fmt:formatDate value="${emp.updateTime}" type="date" dateStyle="long"/>
                 </td>
                 <td>
                 <c:if test="${emp.state==1 }">
	                	发布
	                </c:if>
	                <c:if test="${emp.state==2 }">
	                	停止
	                </c:if>
                </td>
            </tr> 
        </c:forEach>
    </tbody>
</table>
</div>