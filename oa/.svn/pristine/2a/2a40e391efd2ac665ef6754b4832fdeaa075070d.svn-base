<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/bole">
	<input type="hidden" name="search_LIKE_name" value="${param.search_LIKE_name}"/>
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="hidden" name="search_LIKE_organization.name" value="${param['search_LIKE_organization.name']}">
	<input type="hidden" name="search_EQ_stateType" value="${param.search_EQ_stateType}">
	<input type="hidden" name="search_EQ_deleteBasic" value="0">
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
</form>

<form id="searchForm" method="post" action="${ctx}/bole" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>伯乐昵称：</label>
					<input type="text" name="search_LIKE_boleName" value="${param.search_LIKE_boleName }" />
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
		<shiro:hasPermission name="Bole:save">
			<li><a  width="850" height="250" rel="bole" class="add" href="${ctx}/bole/create" target="dialog" mask="true"><span>添加</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="Bole:edit">
			<li><a  width="850" height="250" class="edit" href="${ctx}/bole/${emp.boleId}/{sid_user}/update" target="dialog" mask="true"><span>修改</span></a></li>
		</shiro:hasPermission>
		<li class="line">line</li>
		<shiro:hasPermission name="Bole:view">
			<li><a  width="850" height="450"  class="icon" href="${ctx}/bole/${emp.boleId}/{sid_user}/view" target="dialog" mask="true"><span>详细</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="Bole:delete">
		<li><a class="delete" href="${ctx}/bole/${emp.boleId}/{sid_user}/delete" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</shiro:hasPermission>
		</ul>
	</div>
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="137">
    <thead>
        <tr >
            <th width="100px" align="center">伯乐头像</th>
            <th width="100px" align="center">伯乐昵称</th>
            <th width="100px" align="center">伯乐等级</th>
            <th width="100px" align="center">伯乐经验</th>
            <th width="200px" align="center">二维码路径</th>
            <th width="200px" align="center">伯乐评分</th>
           	<th width="200px" align="center">行业</th>
           	<th width="200px" align="center">推介人数</th>
           	<th width="200px" align="center">免费推介卡</th>
       		<th width="200px" align="center">伯乐点赞数</th>
   			<th width="200px" align="center">个人信息</th>
   			<th width="200px" align="center">修改人</th>
   			<th width="200px" align="center">修改时间</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.content}" var="emp">
            <tr target="sid_user" rel="${emp.boleId}">
                 <td>${emp.boleImage }</td> 
                 <td>${emp.boleName }</td>
                 <td>${emp.boleGrade}</td>
                <td>${emp.boleExperience}
				</td>
				<td>${emp.boleQRImage}</td>
				<td>${emp.boleScore}</td>
                 <td>${emp.boleIndustry.name }</td>
                  <td>${emp.boleRecomNum }</td>
                 <td>${emp.boleRecomCard }</td>
                 <td>${emp.boleFabulous }</td>
                 <td>${emp.humanBasicInfo.humanName }</td>
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