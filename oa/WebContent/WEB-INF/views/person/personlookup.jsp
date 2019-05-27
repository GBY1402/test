<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/person/personlookup">
	<input type="hidden" name="search_LIKE_name" value="${param.search_LIKE_name}"/>
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="hidden" name="search_LIKE_organization.name" value="${param['search_LIKE_organization.name']}">
	<input type="hidden" name="search_EQ_deleteBasic" value="0">
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
</form>

<form id="searchForm" method="post" action="${ctx}/person/personlookup" onsubmit="return dialogSearch(this)">
	<input type="hidden" name="search_EQ_deleteBasic" value="0">	
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>姓名：</label>
					<input type="text" name="search_LIKE_humanName" value="${param.search_LIKE_humanName }" />
				</li>
				<li>
					<label>账号：</label>
					<input type="text" name="search_LIKE_userAddInfo.userName" value="${param.search_LIKE_userAddInfo.userName }" />
				</li>
				<li>
					<label>实名认证：</label>
					<select name="search_EQ_nameAuthent" class="combox">
					<option value="" ${param.search_EQ_nameAuthent == '' ? 'selected' : ''}>请选择</option>
					<option value="0" ${param.search_EQ_nameAuthent == '0' ? 'selected' : ''}>未认证</option>
					<option value="1" ${param.search_EQ_nameAuthent == '1' ? 'selected' : ''}>已认证</option>
				
					</select>
				</li>
				<li>
					<label>学历：</label>
					<select name="search_EQ_humanDiploma.id" class="combox">
					<option value="">请选择</option>
						<c:forEach items="${humanDiploma}" var="type" >
							<option  value="${type.id}" ${param.search_EQ_humanDiploma.id == type.id ? 'selected' : ''}>${type.name }</option>
						</c:forEach>
					</select>
				</li>
				<li>
					<label>删除状态：</label>
					<select name="search_EQ_userAddInfo.userDelete" class="combox">
					<option value="">请选择</option>
							<option  value="0" ${param.search_EQ_userAddInfo.userDelete == 0 ? 'selected' : ''}>未删除</option>
							<option  value="1" ${param.search_EQ_userAddInfo.userDelete == 1 ? 'selected' : ''}>已删除</option>
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
        	<th width="200px" align="center">账号</th>
            <th width="100px" align="center">姓名</th>
            <th width="100px" align="center">实名认证</th>
            <th width="200px" align="center">性别</th>
            <th width="200px" align="center">身份</th>
           	<th width="200px" align="center">学历</th>
           	<th width="200px" align="center">出生日期</th>
           	<th width="200px" align="center">手机号</th>
   			<th width="200px" align="center">请选择</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.content}" var="humanBasicInfo">
            <tr target="sid_user" rel="${humanBasicInfo.humanId}">
            	<td>${humanBasicInfo.userAddInfo.userName }</td>
                <td>${humanBasicInfo.humanName }</td>
                <td>
				<c:if test="${humanBasicInfo.nameAuthent==1 }">
	                	已认证
	                </c:if>
	                <c:if test="${humanBasicInfo.nameAuthent==0 }">
	                	未认证
	                </c:if>
				</td>
				<td>
				<c:if test="${humanBasicInfo.humanSex==1 }">
	                	女
	                </c:if>
	                <c:if test="${humanBasicInfo.humanSex==0 }">
	                	男
	                </c:if>
				</td>
				<td>
				<c:if test="${humanBasicInfo.humanIdentity==1 }">
	                	蒸蒸日上
	                </c:if>
	                <c:if test="${humanBasicInfo.humanIdentity==0 }">
	                	莘莘学子
	                </c:if>
				</td>
                 <td>${humanBasicInfo.humanDiploma.name }</td>
                 <td><fmt:formatDate value="${humanBasicInfo.humanBirthday}" type="date" dateStyle="long"/></td>
                 <td>${humanBasicInfo.humanPhone }</td>
                <td>
                     <a class="btnSelect" href="javascript:$.bringBack({'humanId':'${humanBasicInfo.humanId }', 'humanName':'${humanBasicInfo.humanName }'})" title="用户信息">选择</a>
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