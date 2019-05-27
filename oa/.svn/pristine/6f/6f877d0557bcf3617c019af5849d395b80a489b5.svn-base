<%@page import="java.util.Map"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/employee">
	<input type="hidden" name="search_LIKE_name" value="${param.search_LIKE_name}"/>
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="hidden" name="search_LIKE_organization.name" value="${param['search_LIKE_organization.name']}">
	<input type="hidden" name="search_EQ_stateType" value="${param.search_EQ_stateType}">
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
</form>

<form id="searchForm" method="post" action="${ctx}/employee" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>员工姓名：</label>
					<input type="text" name="search_LIKE_name" value="${param.search_LIKE_name }"/>
				</li>
				<%-- <li>
					<label>所属部门：</label>
					<input type="text" name="search_LIKE_organization.name" value="${param['search_LIKE_organization.name']}">
				</li> --%>
				<li>
					<label>岗位状态：</label>
					<select name="search_EQ_stateType" class="combox">
					<option value="">请选择</option>
						<c:forEach items="${stateTypes}" var="type" >
							<option <c:if test="${param.search_EQ_stateType==type}">selected</c:if> value="${type}">${type.info }</option>
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
	<div class="panelBar">
		<ul class="toolBar">
		<shiro:hasPermission name="empl:save">
			<li><a class="add" href="${ctx}/employee/create" target="navTab"><span>添加</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="empl:edit">
			<li><a class="edit" href="${ctx}/employee/${emp.pkid}/{sid_user}/update" target="navTab"><span>修改</span></a></li>
		</shiro:hasPermission>
		<li class="line">line</li>
		<shiro:hasPermission name="empl:view">
			<li><a class="icon" href="${ctx}/employee/${emp.pkid}/{sid_user}/view" target="navTab"><span>详细</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="empl:download">
			<li><a class="icon" href="${ctx}/employee/download?name=${param.search_LIKE_name }&&stateType=${param.search_EQ_stateType}" target="dwzExport" targetType="dialog" title="确定要导出这些记录吗?"><span>导出EXCEL</span></a></li>
			
		</shiro:hasPermission><%--  --%>
		</ul>
	</div>
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="137">
    <thead>
        <tr >
            <th width="100px" align="center">工号</th>
            <th width="100px" align="center">合同编号</th>
            <th width="100px" align="center">姓名</th>
            <th width="100px" align="center">性别</th>
            <th width="200px" align="center">部门</th>
            <th width="200px" align="center">联系方式</th>
           	<th width="200px" align="center">身份证号</th>
           	<th width="200px" align="center">入职时间</th>
     		<th width="200px" align="center">是否转正</th>
    		<th width="200px" align="center">工作岗位</th>
     		<th width="200px" align="center">招聘渠道</th>
     		<th width="200px" align="center">状态</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.content}" var="emp">
            <tr target="sid_user" rel="${emp.pkid}">
                <td>${emp.jobnum }</td>
                <td>
                	<c:choose>
                		<c:when test="${!(emp.contractid=='')}">${emp.contractid }</c:when>
                		<c:otherwise>暂 无</c:otherwise>
                	</c:choose>
               	</td>
                <td>${emp.name }</td>
                <td>
	                <c:if test="${emp.sex==1 }">
	                	男
	                </c:if>
	                <c:if test="${emp.sex==2 }">
	                	女
	                </c:if>
                </td>
                <td>
                	${emp.organization.name}
                	<%-- <c:choose>
                		<c:when test="${emp.dept==1 }">总经办</c:when>
                		<c:when test="${emp.dept==2 }">总务部</c:when>
                		<c:when test="${emp.dept==3 }">市场部</c:when>
                		<c:when test="${emp.dept==4 }">产品研发部</c:when>
                		<c:when test="${emp.dept==5 }">运营部</c:when>
                		<c:otherwise>--</c:otherwise>
                	</c:choose> --%>
                </td>
                <td>${emp.phone }</td>
                <td>${emp.cardid }</td>
                <td>
                	<fmt:formatDate value="${emp.entrytime}" type="date" dateStyle="long"/>
                </td>
                <td>
                	<c:if test="${emp.isorregular==1 }">
	                	是
	                </c:if>
	                <c:if test="${emp.isorregular==2 }">
	                	否
	                </c:if>
                </td>
                <td>${emp.job }</td>
                <td>${emp.recruitmentChannel.info } </td>
                <td>${emp.stateType.info}</td>
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