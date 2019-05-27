<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/company/lookup">
	<input type="hidden" name="search_LIKE_name" value="${param.search_LIKE_name}"/>
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="hidden" name="search_LIKE_organization.name" value="${param['search_LIKE_organization.name']}">
	<input type="hidden" name="search_EQ_stateType" value="${param.search_EQ_stateType}">
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
</form>

<form id="searchForm" method="post" action="${ctx}/company/lookup" onsubmit="return dialogSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>企业名称：</label>
					<input type="text" name="search_LIKE_enterName" value="${param.search_LIKE_enterName }"/>
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

<table class="table" layoutH="137">
    <thead>
        <tr >
            <th width="300px" align="center">企业全称</th>
            <th width="200px" align="center">企业简称</th>
            <th width="200px" align="center">企业性质</th>
            <th width="200px" align="center">融资轮数</th>
            <th width="200px" align="center">人数</th>
            <th width="200px" align="center">法人代表</th>
   			<th width="100px" align="center">认证状态</th>
   			<th width="100px" align="center">请选择</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.content}" var="emp">
            <tr target="sid_user" rel="${emp.enterId}">
                 <td>${emp.enterName }</td> 
                 <td>${emp.enterShortName }</td>
                 <td>${emp.enterNature.name}</td>
                 <td>${emp.enterFinanc.name}</td>
                 <td>${emp.enterNumber.name}</td>
				<td>${emp.enterLegalPerson}</td>
                <td>
                	<c:if test="${emp.enterCondition==2 }">
	                	认证未通过
	                </c:if>
                	<c:if test="${emp.enterCondition==1 }">
	                	已认证
	                </c:if>
	                <c:if test="${emp.enterCondition==0 }">
	                	未认证
	                </c:if>
                </td>
                <td>
                     <a class="btnSelect" href="javascript:$.bringBack({'enterId':'${emp.enterId }','enterName':'${emp.enterName }'})" title="企业名称">选择</a>
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