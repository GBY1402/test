<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/recruit/hrLookup">
	<input type="hidden" name="search_LIKE_humanBasicInfo.humanName" value="${param['search_LIKE_humanBasicInfo.humanName'] }"/>
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
</form>

<form id="searchForm" method="post" action="${ctx}/recruit/hrLookup" onsubmit="return dialogSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>账号：</label>
					<input type="text" name="search_LIKE_humanBasicInfo.humanName" value="${param['search_LIKE_humanBasicInfo.humanName'] }" />
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
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="137">
    <thead>
        <tr >
            <th width="100px" align="center">账号</th>
            <th width="100px" align="center">职位</th>
            <th width="200px" align="center">所属公司</th>
   			<th width="200px" align="center">请选择</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.content}" var="hr">
            <tr target="sid_user" rel="${hr.enterPerId}">
                 <td>${hr.humanBasicInfo.humanName }</td>
                <td>${hr.enterPosition }</td>
                <td>${hr.personAndbasicInfo.enterBasicInfo.enterName }</td>
                <td>
                     <a class="btnSelect" href="javascript:$.bringBack({'enterPerId':'${hr.enterPerId }','humanBasicInfo.humanName':'${hr.humanBasicInfo.humanName }'})" title="用户信息">选择</a>
                 </td>
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
		<div class="pagination" targetType="dialog" totalCount="${page.totalElements }" numPerPage="${page.size }" pageNumShown="8" currentPage="${page.number+1 }"></div>
	</div>
</div>