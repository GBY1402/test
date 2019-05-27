<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/boleGradeData">
	<input type="hidden" name="search_LIKE_name" value="${param.search_LIKE_name}"/>
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="hidden" name="search_LIKE_organization.name" value="${param['search_LIKE_organization.name']}">
	<input type="hidden" name="search_EQ_stateType" value="${param.search_EQ_stateType}">
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
</form>

<form id="searchForm" method="post" action="${ctx}/boleGradeData" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>名称：</label>
					<input type="text" name="search_LIKE_gradeName" value="${param.search_LIKE_gradeName }"/>
				</li>
				<li>
					<label>删除状态：</label>
					<select name="search_EQ_deleteData" class="combox">
					<option value="">请选择</option>
						<option ${param.search_EQ_deleteData== '0' ? 'selected' : ''} value="0">未删除</option>
						<option ${param.search_EQ_deleteData== '1' ? 'selected' : ''} value="1">已删除</option>
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
		<shiro:hasPermission name="BoleGradeData:save">
			<li><a  width="500" height="220" rel="companyback" class="add" href="${ctx}/boleGradeData/save" target="dialog" mask="true"><span>添加</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="BoleGradeData:edit">
			<li><a  width="500" height="250" class="edit" href="${ctx}/boleGradeData/${emp.boleDataId}/{sid_user}/edit" target="dialog" mask="true"><span>修改</span></a></li>
		</shiro:hasPermission>
		<li class="line">line</li>
		<shiro:hasPermission name="BoleGradeData:view">
			<li><a class="icon" width="360" height="370" href="${ctx}/boleGradeData/${emp.boleDataId}/{sid_user}/view" target="dialog" mask="true"><span>详细</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="BoleGradeData:delete">
		<li><a class="delete" rel="bolegradedataback" href="${ctx}/boleGradeData/${emp.boleDataId}/{sid_user}/delete" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</shiro:hasPermission>
		</ul>
	</div>
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="137">
    <thead>
        <tr >
            <th width="100px" align="center">等级</th>
            <th width="100px" align="center">经验</th>
            <th width="200px" align="center">名称</th>
            <th width="200px" align="center">佣金限制</th>
            <th width="200px" align="center">状态</th>
            <th width="200px" align="center">创建人</th>
   			<th width="200px" align="center">创建时间</th>
   			<th width="200px" align="center">修改人</th>
   			<th width="200px" align="center">修改时间</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.content}" var="emp">
            <tr target="sid_user" rel="${emp.boleDataId}">
                 <td>${emp.boleGrade }</td> 
                 <td>${emp.boleExperience }</td>
                 <td>${emp.gradeName}</td>
                 <td>${emp.boleMoney}</td>
                 <td>
                 	<c:if test="${emp.deleteData == 0 }">
                 		未删除
                 	</c:if>
                 	<c:if test="${emp.deleteData == 1 }">
                 		<b style="color:red">已删除</b>
                 	</c:if>
                 </td>
                 <td>${emp.createUser}</td>
				 <td><fmt:formatDate value="${emp.createTime}" type="date" dateStyle="long"/></td>
				 <td>${emp.updateUser}</td>
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