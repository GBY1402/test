<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/management/security/user/lookup2empl">
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="text" name="search_LIKE_name" value="${param.search_LIKE_name }"/>
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="${ctx }/management/security/user/lookup2empl" onsubmit="return dwzSearch(this,'dialog');">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>姓名:</label>
				<input type="text" name="search_LIKE_name" value="${param.search_LIKE_name }"/>
			</li>	  
		</ul>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div> 

	<table class="table" layoutH="118" targetType="dialog" width="100%">
		<thead>
			<tr>
	            <th width="100px" align="center" orderfield = "orgName">姓名</th>
	            <th width="100px" align="center">性别</th>
	            <th width="200px" align="center">部门</th>
	            <th width="200px" align="center">联系方式</th>
	     		<th width="200px" align="center">是否转正</th>
	     		<th width="200px" align="center">状态</th>
				<th width="80">选择</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.content}" var="emp">
				<tr>
					<td>${emp.name }</td>
					<td>${emp.sex == 1?'男':'女'}</td>
					<td>${emp.organization.name}</td>
					<td>${emp.phone }</td>
					<td>${emp.isorregular == 1?'是':'否'}</td>
					<td>${emp.stateType.info}</td>
					<td>
						<a class="btnSelect" href="javascript:$.bringBack({pkid:'${emp.pkid }', name:'${emp.name }'})" title="员工信息">选择</a>
					</td>
				</tr>
			</c:forEach>	
		</tbody>
	</table>

	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="10"  <c:if test="${page.size==10}">selected="selected"</c:if>>10</option>
				<option value="20"  <c:if test="${page.size==20}">selected="selected"</c:if>>20</option>
				<option value="30" <c:if test="${page.size==30}">selected="selected"</c:if>>30</option>
				<option value="50" <c:if test="${page.size==50}">selected="selected"</c:if>>50</option>
			</select>
		<span>条，共${page.totalElements}条</span>
	</div>
	<div class="pagination" targetType="navTab" totalCount="${page.totalElements }" numPerPage="${page.size }" pageNumShown="8" currentPage="${page.number+1 }"></div>
</div>
