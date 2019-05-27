<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@page import="java.util.Date"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<dwz:paginationForm action="${ctx }/management/security/logEntity/list" page="${page }">
	<input type="hidden" name="search_LIKE_username" value="${param.search_LIKE_username }"/>
	<input type="hidden" name="search_EQ_ipAddress" value="${param.search_EQ_ipAddress }"/>
	<input type="hidden" name="search_EQ_logLevel" value="${param.search_EQ_logLevel }"/>
	<input type="hidden" name="search_GTE_createTime" value="${param.search_GTE_createDate}"/>
	<input type="hidden" name="search_LTE_createTime" value="${param.search_LTE_createDate}"/>
</dwz:paginationForm>

<form method="post" action="${ctx}/management/security/logEntity/list" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label style="width: 100px;">登录名称：</label>
					<input type="text" name="search_LIKE_username" value="${param.search_LIKE_username }"/>
				</li>	
				<li>
					<label style="width: 100px;">登录IP：</label>
					<input type="text" name="search_LIKE_ipAddress" value="${param.search_LIKE_ipAddress }"/>
				</li>
				<li>
					<label style="width: 100px;">日志等级：</label>
					<select name="search_EQ_logLevel">
						<option value="">所有</option>
						<c:forEach var="logLevel" items="${logLevels }"> 
							<option value="${logLevel}" ${param.search_EQ_logLevel == logLevel ? 'selected="selected"':'' }>${logLevel}</option>
						</c:forEach>
					</select>
				</li>																
			</ul>
			<ul class="searchContent">	
				<li>
					<label style="width: 100px;">日志开始时间：</label>
					<input type="text" name="search_GTE_createDate" class="date" readonly="readonly" style="float:left;" value="${param.search_GTE_createDate}"/>
					<a class="inputDateButton" href="javascript:;" style="float:left;">选择</a>
				</li>			
				<li>
					<label style="width: 100px;">日志结束时间：</label>
					<input type="text" name="search_LTE_createDate" class="date" readonly="readonly" style="float:left;" value="${param.search_LTE_createDate}"/>
					<a class="inputDateButton" href="javascript:;" style="float:left;">选择</a>
				</li>							
			</ul>			
			<div class="subBar">
				<ul>						
					<li><div class="button"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
				</ul>
			</div>
		</div>
	</div>
</form>

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<shiro:hasPermission name="LogEntity:delete">
				<li><a class="delete" target="selectedTodo" rel="ids" href="${ctx}/management/security/logEntity/delete" title="确认要删除?"><span>删除日志</span></a></li>
			</shiro:hasPermission>
		</ul>
	</div>
	
	<table class="table" layoutH="162" width="100%">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th width="100">登录名称</th>
				<th width="100">登录IP</th>
				<th width="100" orderField="logLevel" class="${page.orderField eq 'logLevel' ? page.orderDirection : ''}">日志等级</th>
				<th >日志内容</th>
				<th width="130" orderField="createTime" class="${page.orderField eq 'createTime' ? page.orderDirection : ''}">创建时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${logEntities}">
			<tr target="slt_uid" rel="${item.id}">
				<td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.username}</td>
				<td>${item.ipAddress}</td>
				<td>${item.logLevel}</td>
				<td>${item.message}</td>
				<td><fmt:formatDate value="${item.createTime}" type="both"/></td>
			</tr>			
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<dwz:pagination page="${page }"/>
</div>