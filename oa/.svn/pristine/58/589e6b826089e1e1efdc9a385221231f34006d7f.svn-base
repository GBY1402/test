<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/resume">
	<input type="hidden" name="search_LIKE_personJobName" value="${param.search_LIKE_personJobName}"/>
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="hidden" name="search_LIKE_humanBasicInfo.humanName" value="${param['search_LIKE_humanBasicInfo.humanName']}">
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
</form>

<form id="searchForm" method="post" action="${ctx}/resume" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>简历名称：</label>
					<input type="text" name="search_LIKE_personJobName" value="${param.search_LIKE_personJobName }"/>
				</li>
				<li>
					<label>所属用户：${param }</label>
					<input type="text" name="search_LIKE_humanBasicInfo.humanName" value="${param['search_LIKE_humanBasicInfo.humanName']}"/>
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
			<li><a  width="600" height="500"  class="add" href="${ctx}/resume/create" target="dialog" rel="add_resume"><span>添加</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="Resume:edit">
			<li><a  width="1200" height="800" class="edit" href="${ctx}/resume/{sid_user}/update" target="navTab"><span>修改</span></a></li>
		</shiro:hasPermission>
		<li class="line">line</li>
		<shiro:hasPermission name="Resume:view">
			<li><a class="icon" href="${ctx}/resume/${emp.humanId}/{sid_user}/view" target="navTab"><span>详细</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="Resume:delete">
		<li><a class="delete" href="${ctx}/resume/${emp.humanId}/{sid_user}/delete" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</shiro:hasPermission><%--  --%>
		</ul>
	</div>
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="137">
    <thead>
        <tr >
            <th width="100px" align="center">简历名称</th>
            <th width="100px" align="center">所属用户</th>
            <th width="100px" align="center">求职区域</th>
            <th width="100px" align="center">期望薪资</th>
            <th width="100px" align="center">行业</th>
            <th width="200px" align="center">职能</th>
            <th width="200px" align="center">开始工作时间</th>
           	<th width="200px" align="center">工作年数</th>
       		<th width="200px" align="center">求职状态</th>
       		<th width="200px" align="center">删除状态</th>
   			<th width="200px" align="center">账号</th>
   			<th width="200px" align="center">修改人</th>
   			<th width="200px" align="center">修改时间</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.content}" var="emp">
            <tr target="sid_user" rel="${emp.personJobId}">
                 <td>${emp.personJobName }</td>
                 <td>${emp.humanBasicInfo.humanName }</td>  
                  <td>${emp.personWorkArdess.regionName }</td>
                 <td>${emp.personPayStart.name }</td>
                 <td>${emp.personIndustry.name}</td>
                 <td>${emp.personFunction.name}</td>
                  <td><fmt:formatDate value="${emp.personJobWork}" type="date" dateStyle="long"/></td>
                  <td>${emp.jobWorkYear}</td>
                <td>
                	<c:if test="${emp.personToggle == 0 }">
                	开启求职
                	</c:if>
                	<c:if test="${emp.personToggle == 1 }">
                	关闭求职
                	</c:if>
                 </td>
                 <td>
                 	<c:if test="${emp.personDeleteStatus == 0 }">
                	未删除
                	</c:if>
                	<c:if test="${emp.personDeleteStatus == 1 }">
                	<b style="color:red;">已删除</b>
                	</c:if>
                 </td>
                 <td>${emp.humanBasicInfo.userAddInfo.userName}</td>
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