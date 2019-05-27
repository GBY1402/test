<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/jobper">
	<input type="hidden" name="search_LIKE_personJobInfo.personJobName" value="${param['search_LIKE_personJobInfo.personJobName']}"/>
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="hidden" name="search_EQ_deletePerson" value="${param.search_EQ_deletePerson}">
	<input type="hidden" name="search_EQ_deleteEnter" value="${param.search_EQ_deleteEnter}">
	<input type="hidden" name="search_EQ_deleteCentre" value="${param.search_EQ_deleteCentre}">
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
</form>

<form id="searchForm" method="post" action="${ctx}/jobper" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>简历名称：</label>
					<input type="text" name="search_LIKE_personJobInfo.personJobName" value="${param['search_LIKE_personJobInfo.personJobName']}" />
				</li>
				<li>
					<label>个人删除：</label>
					<select name="search_EQ_deletePerson" class="combox">
						<option value="">请选择</option>
						<option value="0" ${param.search_EQ_deletePerson == '0' ? 'selected' : ''}>未删除</option>
						<option value="1" ${param.search_EQ_deletePerson == '1' ? 'selected' : ''}>已删除</option>
					</select>
				</li>
				<li>
					<label>企业删除：</label>
					<select name="search_EQ_deleteEnter" class="combox">
						<option value="">请选择</option>
						<option value="0" ${param.search_EQ_deleteEnter == '0' ? 'selected' : ''}>未删除</option>
						<option value="1" ${param.search_EQ_deleteEnter == '1' ? 'selected' : ''}>已删除</option>
					</select>
				</li>
				<li>
					<label>后台删除：</label>
					<select name="search_EQ_deleteCentre" class="combox">
						<option value="">请选择</option>
						<option value="0" ${param.search_EQ_deleteCentre == '0' ? 'selected' : ''}>未删除</option>
						<option value="1" ${param.search_EQ_deleteCentre == '1' ? 'selected' : ''}>已删除</option>
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
		<%-- <shiro:hasPermission name="Jobper:save">
			<li><a  width="850" height="600" rel="bole" class="add" href="${ctx}/jobper/create" target="dialog" mask="true"><span>添加</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="Jobper:edit">
			<li><a  width="850" height="600" class="edit" href="${ctx}/jobper/${emp.centreId}/{sid_user}/update" target="dialog" mask="true"><span>修改</span></a></li>
		</shiro:hasPermission> --%>
		<shiro:hasPermission name="Jobper:view">
			<li><a  width="850" height="450"  class="icon" href="${ctx}/jobper/${emp.centreId}/{sid_user}/view" target="dialog" mask="true"><span>详细</span></a></li>
		</shiro:hasPermission>
		<li class="line">line</li>
		<shiro:hasPermission name="Jobper:delete">
		<li><a class="delete" href="${ctx}/jobper/${emp.centreId}/{sid_user}/delete" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</shiro:hasPermission>
		</ul>
	</div>
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="137">
    <thead>
        <tr >
            <th width="200px" align="center">简历名称</th>
            <th width="200px" align="center">所属用户</th>
            <th width="200px" align="center">属性</th>
            <th width="200px" align="center">个人删除</th>
            <th width="200px" align="center">企业删除</th>
            <th width="200px" align="center">后台删除</th>
			<th width="200px" align="center">创建人</th>
   			<th width="200px" align="center">创建时间</th>
   			<th width="200px" align="center">修改人</th>
   			<th width="200px" align="center">修改时间</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.content}" var="emp">
            <tr target="sid_user" rel="${emp.centreId}">
                 <td>${emp.personJobInfo.personJobName }</td> 
                 <td>${emp.personJobInfo.humanBasicInfo.humanName }</td>
                 <td>
                 	<c:if test="${emp.centerAudition == 0 }">已投递</c:if>
                 	<c:if test="${emp.centerAudition == 1 }">已查看</c:if>
                 	<c:if test="${emp.centerAudition == 2 }">邀请面试</c:if>
                 	<c:if test="${emp.centerAudition == 3 }">同意面试</c:if>
                 	<c:if test="${emp.centerAudition == 4 }">拒绝面试</c:if>
                 	<c:if test="${emp.centerAudition == 5 }">不合适</c:if>
                 	<c:if test="${emp.centerAudition == 6 }">已成功</c:if>
                 </td>
                 <td>
                 	<c:if test="${emp.deletePerson == 0 }">未删除</c:if>
                 	<c:if test="${emp.deletePerson == 1 }"><b style="color:red;">已删除</b></c:if>
                 </td>
                 <td>
                 	<c:if test="${emp.deleteEnter == 0 }">未删除</c:if>
                 	<c:if test="${emp.deleteEnter == 1 }"><b style="color:red;">已删除</b></c:if>
                 </td>
                 <td>
                 	<c:if test="${emp.deleteCentre == 0 }">未删除</c:if>
                 	<c:if test="${emp.deleteCentre == 1 }"><b style="color:red;">已删除</b></c:if>
                 </td>
                 <td>${emp.createUser }</td>
                 <td><fmt:formatDate value="${emp.createTime}" type="date" dateStyle="long"/></td>
                 <td>${emp.updateUser }</td>
                 <td><fmt:formatDate value="${emp.updateTime}" type="date" dateStyle="long"/></td>
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