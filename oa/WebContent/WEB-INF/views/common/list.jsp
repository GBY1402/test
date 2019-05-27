<%@page import="java.util.Map"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/account">
	<input type="hidden" name="search_LIKE_userName" value="${param.search_LIKE_userName}"/>
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="hidden" name="search_EQ_userPerson" value="${param.search_EQ_userPerson}">
	<input type="hidden" name="search_EQ_userCompany" value="${param.search_EQ_userCompany}">
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
</form>

<form id="searchForm" method="post" action="${ctx}/account" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>账号：</label>
					<input type="text" name="search_LIKE_userName" value="${param.search_LIKE_userName }"/>
				</li>
				<li>
					<label>个人账号：</label>
					<select name="search_EQ_userPerson" class="combox">
						<option value="">请选择</option>
						<option value="1" ${param.search_EQ_userPerson == '1' ? 'selected' : ''}>个人</option>
						<option value="0" ${param.search_EQ_userPerson == '0' ? 'selected' : ''}>未开通</option>
					</select>
				</li>
				<li>
					<label>企业账号：</label>
					<select name="search_EQ_userCompany" class="combox">
						<option value="">请选择</option>
						<option value="1" ${param.search_EQ_userCompany == '1' ? 'selected' : ''}>企业</option>
						<option value="0" ${param.search_EQ_userCompany == '0' ? 'selected' : ''}>未开通</option>
					</select>
				</li>
			</ul>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
				</ul>
			</div>
		</div>
	</div>
</form>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		<shiro:hasPermission name="Account:save">
			<li><a class="add" href="${ctx}/account/create" target="dialog"><span>添加</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="Account:edit">
			<li><a class="edit" href="${ctx}/account/${emp.userId}/{sid_user}/update" target="dialog"><span>修改</span></a></li>
		</shiro:hasPermission>
		<li class="line">line</li>
		<shiro:hasPermission name="Account:view">
			<li><a class="icon" href="${ctx}/account/${emp.userId}/{sid_user}/view" target="dialog"><span>详细</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="Account:delete">
			<li><a class="icon" href="${ctx}/account/${emp.userId}/{sid_user}/delete" target="dwzExport" targetType="dialog" title="确定要导出这些记录吗?"><span>删除</span></a></li>
			
		</shiro:hasPermission><%--  --%>
		</ul>
	</div>
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="137">
    <thead>
        <tr >
            <th width="100px" align="center">账号</th>
            <th width="100px" align="center">个人账号</th>
            <th width="100px" align="center">企业账号</th>
            <th width="100px" align="center">归属状态 </th>
            <th width="200px" align="center">删除状态</th>
            <th width="200px" align="center">创建人</th>
           	<th width="200px" align="center">修改人</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.content}" var="emp">
            <tr target="sid_user" rel="${emp.userId}">
                <td>${emp.userName }</td>
                <td>
	                <c:if test="${emp.userPerson==1 }">
	                	个人
	                </c:if>
	                <c:if test="${emp.userPerson==0 }">
	                	未开通
	                </c:if>
                </td>
                 <td>
	                <c:if test="${emp.userCompany==1 }">
	                	企业
	                </c:if>
	                <c:if test="${emp.userCompany==0 }">
	                	未开通
	                </c:if>
                </td>
                <td>
	                <c:if test="${emp.userState==1 }">
	                	开启状态
	                </c:if>
	                <c:if test="${emp.userState==2 }">
	                	冻结状态
	                </c:if>
	                 <c:if test="${emp.userState==3 }">
	                	个人冻结
	                </c:if>
	                 <c:if test="${emp.userState==4 }">
	                	企业冻结
	                </c:if>
                </td>
                <td>
	                <c:if test="${emp.userDelete==1 }">
	                	已删除
	                </c:if>
	                <c:if test="${emp.userDelete==0 }">
	                	未删除
	                </c:if>
                </td>
                <td>${emp.createUser }</td>
                <td><fmt:formatDate value="${emp.createTime}" type="date" dateStyle="long"/></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20"  <c:if test="${page.size==20}">selected="selected"</c:if>>20</option>
				<option value="50"  <c:if test="${page.size==50}">selected="selected"</c:if>>50</option>
				<option value="100" <c:if test="${page.size==100}">selected="selected"</c:if>>100</option>
				<option value="200" <c:if test="${page.size==200}">selected="selected"</c:if>>200</option>
			</select>
			<span>条，共${page.totalElements}条</span>
		</div>
		<div class="pagination" targetType="navTab" totalCount="${page.totalElements }" numPerPage="${page.size }" pageNumShown="8" currentPage="${page.number+1 }"></div>
	</div>
</div>