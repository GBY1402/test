<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/company">
	<input type="hidden" name="search_LIKE_name" value="${param.search_LIKE_name}"/>
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="hidden" name="search_LIKE_organization.name" value="${param['search_LIKE_organization.name']}">
	<input type="hidden" name="search_EQ_stateType" value="${param.search_EQ_stateType}">
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
</form>

<form id="searchForm" method="post" action="${ctx}/company" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>企业名称：</label>
					<input type="text" name="search_LIKE_enterName" value="${param.search_LIKE_enterName }"/>
				</li>
				<li>
					<label>认证状态：</label>
					<select name="search_EQ_enterCondition" class="combox">
						<option value="">请选择</option>
						<option ${param.search_EQ_enterCondition=='0' ? 'selected' : ''} value="0">未认证</option>
						<option ${param.search_EQ_enterCondition=='1' ? 'selected' : ''} value="1">已认证</option>
						<option ${param.search_EQ_enterCondition=='2' ? 'selected' : ''} value="2">认证未通过</option>
					</select>
				</li>
				<li>
					<label>删除状态：</label>
					<select name="search_EQ_enterDelete" class="combox">
						<option value="">请选择</option>
						<option ${param.search_EQ_enterDelete=='0' ? 'selected' : ''} value="0">未删除</option>
						<option ${param.search_EQ_enterDelete=='1' ? 'selected' : ''} value="1">已删除</option>
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
		<shiro:hasPermission name="Resume:save">
			<li><a  width="600" height="600" rel="companyback" class="add" href="${ctx}/company/create" target="dialog" mask="true"><span>添加</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="Resume:edit">
			<li><a  width="600" height="600" class="edit" href="${ctx}/company/${emp.enterId}/{sid_user}/update" target="dialog" mask="true"><span>修改</span></a></li>
		</shiro:hasPermission>
		<li class="line">line</li>
		<shiro:hasPermission name="Resume:view">
			<li><a class="icon" width="850" height="600" href="${ctx}/company/${emp.enterId}/{sid_user}/view" target="dialog" mask="true"><span>详细</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="Resume:delete">
		<li><a class="delete" rel="companyback" href="${ctx}/company/${emp.enterId}/{sid_user}/delete" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</shiro:hasPermission>
		</ul>
	</div>
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="137">
    <thead>
        <tr >
            <th width="300px" align="center">企业全称</th>
            <th width="200px" align="center">企业简称</th>
            <th width="200px" align="center">企业性质</th>
            <th width="200px" align="center">融资轮数</th>
            <th width="200px" align="center">人数</th>
            <th width="200px" align="center">法人代表</th>
           	<th width="200px" align="center">企业邮箱</th>
           	<th width="200px" align="center">企业电话</th>
           	<th width="200px" align="center">行业</th>
       		<th width="200px" align="center">公司LOGO</th>
   			<th width="200px" align="center">营业执照</th>
   			<th width="200px" align="center">企业官网</th>
   			<th width="100px" align="center">认证状态</th>
   			<th width="100px" align="center">删除状态</th>
   			<th width="100px" align="center">修改人</th>
   			<th width="200px" align="center">修改时间</th>
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
				<td>${emp.enterEmail}</td>
                 <td>${emp.enterTelephone }</td>
                 <td>${emp.enterIndustry.name }</td>
				 <td>
					<c:if test="${emp.enterLogo != null}">
						<a href="${emp.enterLogo }" target="_href">${emp.enterLogo }</a>
					</c:if>
				</td>
				<td>
					<c:if test="${emp.enterBusimes != null}">
						<a href="${emp.enterBusimes }" target="_href">${emp.enterBusimes }</a>
					</c:if>
				</td>
                <td>
                	<c:if test="${emp.enterUrl != null}">
						<a href="${emp.enterUrl }" target="_href">${emp.enterUrl }</a>
					</c:if>
                </td>
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
                <c:if test="${emp.enterDelete == 0 }">
                 		未删除
                 	</c:if>
                 	<c:if test="${emp.enterDelete == 1 }">
                 		<b style="color:red">已删除</b>
                 	</c:if>
                 </td>
				 <td>${emp.createUser }</td>
                 <td><fmt:formatDate value="${emp.createTime}" type="date" dateStyle="long"/></td>
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