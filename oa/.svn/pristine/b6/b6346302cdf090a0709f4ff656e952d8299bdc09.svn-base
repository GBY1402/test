<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/companyAgreement">
	<input type="hidden" name="search_LIKE_name" value="${param.search_LIKE_name}"/>
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="hidden" name="search_LIKE_organization.name" value="${param['search_LIKE_organization.name']}">
	<input type="hidden" name="search_EQ_stateType" value="${param.search_EQ_stateType}">
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
</form>

<form id="searchForm" method="post" action="${ctx}/companyAgreement" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>急聘签约状态：</label>
					<select name="search_EQ_wantedState" class="combox">
						<option value="">请选择</option>
						<option ${param.search_EQ_wantedState=='0' ? 'selected' : ''} value="0">未签约</option>
						<option ${param.search_EQ_wantedState=='1' ? 'selected' : ''} value="1">签约中</option>
						<option ${param.search_EQ_wantedState=='2' ? 'selected' : ''} value="2">已签约</option>
					</select>
				</li>
				<li>
					<label>猎聘签约状态：</label>
					<select name="search_EQ_huntingState" class="combox">
						<option value="">请选择</option>
						<option ${param.search_EQ_huntingState=='0' ? 'selected' : ''} value="0">未签约</option>
						<option ${param.search_EQ_huntingState=='1' ? 'selected' : ''} value="1">签约中</option>
						<option ${param.search_EQ_huntingState=='2' ? 'selected' : ''} value="2">已签约</option>
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
		<shiro:hasPermission name="CompanyAgreement:save">
			<li><a  width="700" height="250" rel="companyback" class="add" href="${ctx}/companyAgreement/save" target="dialog" mask="true"><span>添加</span></a></li>
		</shiro:hasPermission>
		<li class="line">line</li>
		<shiro:hasPermission name="CompanyAgreement:edit">
			<li><a  width="700" height="250" class="edit" href="${ctx}/companyAgreement/${emp.agreementId}/{sid_user}/edit" target="dialog" mask="true"><span>修改</span></a></li>
		</shiro:hasPermission>
		<li class="line">line</li>
		<shiro:hasPermission name="CompanyAgreement:view">
			<li><a class="icon" width="850" height="320" href="${ctx}/companyAgreement/${emp.agreementId}/{sid_user}/view" target="dialog" mask="true"><span>详细</span></a></li>
		</shiro:hasPermission>
		</ul>
	</div>
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="137">
    <thead>
        <tr >
            <th width="300px" align="center">关联企业名称</th>
            <th width="200px" align="center">急聘签约状态</th>
            <th width="200px" align="center">急聘签约文件地址</th>
            <th width="300px" align="center">猎聘签约状态</th>
            <th width="300px" align="center">猎聘文件编号</th>
            <th width="200px" align="center">创建人</th>
   			<th width="200px" align="center">创建时间</th>
   			<th width="200px" align="center">修改人</th>
   			<th width="200px" align="center">修改时间</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.content}" var="emp">
            <tr target="sid_user" rel="${emp.agreementId}">
            	<td>${emp.enterBasicInfo.enterName}</td>
                 <td>
                 	<c:choose>
                 		<c:when test="${emp.wantedState == 0}">未签约</c:when>
                 		<c:when test="${emp.wantedState == 1}">签约中</c:when>
                 		<c:when test="${emp.wantedState == 2}">已签约</c:when>
                 		<c:otherwise></c:otherwise>
                 	</c:choose>
                 </td>
                 <td><a href="${emp.wantedURL }" target="_href">${emp.wantedURL }</a></td>
                 <td>
                 	<c:choose>
                 		<c:when test="${emp.huntingState == 0}">未签约</c:when>
                 		<c:when test="${emp.huntingState == 1}">签约中</c:when>
                 		<c:when test="${emp.huntingState == 2}">已签约</c:when>
                 		<c:otherwise></c:otherwise>
                 	</c:choose>
                 </td> 
                 <td>${emp.number }</td>
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