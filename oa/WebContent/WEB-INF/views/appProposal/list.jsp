<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/appProposal">
	<input type="hidden" name="search_LIKE_name" value="${param.search_LIKE_name}"/>
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="hidden" name="search_LIKE_organization.name" value="${param['search_LIKE_organization.name']}">
	<input type="hidden" name="search_EQ_stateType" value="${param.search_EQ_stateType}">
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
</form>

<form id="searchForm" method="post" action="${ctx}/appProposal" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>名称：</label>
					<input type="text" name="search_LIKE_mobileName" value="${param.search_LIKE_mobileName }"/>
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
		<shiro:hasPermission name="AppProposal:save">
			<li><a  width="500" height="250" rel="companyback" class="add" href="${ctx}/appProposal/save" target="dialog" mask="true"><span>添加</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="AppProposal:edit">
			<li><a  width="500" height="300" class="edit" href="${ctx}/appProposal/${emp.hunWorId}/{sid_user}/edit" target="dialog" mask="true"><span>修改</span></a></li>
		</shiro:hasPermission>
		<li class="line">line</li>
		<shiro:hasPermission name="AppProposal:view">
			<li><a class="icon" width="600" height="400" href="${ctx}/appProposal/${emp.hunWorId}/{sid_user}/view" target="dialog" mask="true"><span>详细</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="AppProposal:delete">
		<li><a class="delete" rel="appProposal" href="${ctx}/appProposal/${emp.hunWorId}/{sid_user}/delete" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</shiro:hasPermission>
		</ul>
	</div>
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="137">
    <thead>
        <tr >
            <th width="200px" align="center">名称</th>
            <th width="200px" align="center">APPID</th>
            <th width="200px" align="center">APP版本号</th>
            <th width="200px" align="center">时间</th>
            <th width="1000px" align="center">反馈和意见</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.content}" var="emp">
            <tr target="sid_user" rel="${emp.mobileId}">
                 <td>${emp.mobileName }</td>
                 <td>${emp.appId}</td>
                 <td>${emp.appVersion}</td>
				 <td><fmt:formatDate value="${emp.mobileTime}" type="date" dateStyle="long"/></td>
				 <td>${emp.mobileDescribe}</td>
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