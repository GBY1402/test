<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/person">
	<input type="hidden" name="search_LIKE_name" value="${param.search_LIKE_name}"/>
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="hidden" name="search_LIKE_organization.name" value="${param['search_LIKE_organization.name']}">
	<input type="hidden" name="search_EQ_stateType" value="${param.search_EQ_stateType}">
	<input type="hidden" name="search_EQ_deleteBasic" value="0">
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
</form>

<form id="searchForm" method="post" action="${ctx}/person/personlookup" onsubmit="return navTabSearch(this)">
<input type="hidden" name="search_EQ_deleteBasic" value="0">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>认证状态：</label>
					<select name="search_EQ_nameAuthent" class="combox">
					<option value="">请选择</option>
					<option value="0">未认证</option>
					<option value="1">已认证</option>
				
					</select>
				</li>
				<li>
					<label>账号：</label>
					<input type="text" name="search_LIKE_userAddInfo.userName" />
				</li>
				<li>
					<label>学历：</label>
					<select name="search_EQ_humanDiploma.id" class="combox">
					<option value="">请选择</option>
						<c:forEach items="${humanDiploma}" var="type" >
							<option  value="${type.id}">${type.name }</option>
						</c:forEach>
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
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="137">
    <thead>
        <tr >
            <th width="100px" align="center">姓名</th>
            <th width="100px" align="center">实名认证</th>
            <th width="200px" align="center">性别</th>
            <th width="200px" align="center">余额</th>
           	<th width="200px" align="center">学历</th>
           	<th width="200px" align="center">手机号</th>
           	<th width="200px" align="center">账号</th>
   			<th width="200px" align="center">请选择</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.content}" var="walletInfo">
            <tr target="sid_user" rel="${walletInfo.walletId}">
                 <td>${walletInfo.humanBasicInfo.humanName }</td>
                <td>
				<c:if test="${walletInfo.humanBasicInfo.nameAuthent==1 }">
	                	已认证
	                </c:if>
	                <c:if test="${walletInfo.humanBasicInfo.nameAuthent==0 }">
	                	未认证
	                </c:if>
				</td>
				<td>
				<c:if test="${walletInfo.humanBasicInfo.humanSex==1 }">
	                	女
	                </c:if>
	                <c:if test="${walletInfo.humanBasicInfo.humanSex==0 }">
	                	男
	                </c:if>
				</td>
                 <td>${walletInfo.humanBasicInfo.humanDiploma.name }</td>
                 <td><fmt:formatDate value="${walletInfo.humanBasicInfo.humanBirthday}" type="date" dateStyle="long"/></td>
                 <td>${walletInfo.humanBasicInfo.humanPhone }</td>
                <td>${walletInfo.humanBasicInfo.userAddInfo.userName }</td>
                <td>
                     <a class="btnSelect" href="javascript:$.bringBack({walletId:'${walletInfo.walletId}', updateUser:'${walletInfo.humanBasicInfo.humanName }'})" title="用户信息">选择</a>
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
		<div class="pagination" targetType="navTab" totalCount="${page.totalElements }" numPerPage="${page.size }" pageNumShown="8" currentPage="${page.number+1 }"></div>
	</div>
</div>