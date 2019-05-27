<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/person">
	<input type="hidden" name="search_LIKE_name" value="${param.search_LIKE_name}"/>
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="hidden" name="search_LIKE_organization.name" value="${param['search_LIKE_organization.name']}">
	<input type="hidden" name="search_EQ_stateType" value="${param.search_EQ_stateType}">
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
</form>

<form id="searchForm" method="post" action="${ctx}/person" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>账号：</label>
					<input type="text" name="search_LIKE_userAddInfo.userName" value="${param.search_LIKE_userAddInfo.userName }" />
				</li>
				<li>
					<label>姓名：</label>
					<input type="text" name="search_LIKE_humanName" value="${param.search_LIKE_humanName }" />
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
	<div class="panelBar">
		<ul class="toolBar">
		<shiro:hasPermission name="Resume:save">
			<li><a  width="500" height="220" rel="lookup2organization_add" class="add" href="${ctx}/person/create" target="dialog" mask="true"><span>添加</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="Resume:edit">
			<li><a  width="850" height="600" class="edit" href="${ctx}/person/${emp.humanId}/{sid_user}/update" target="dialog" mask="true"><span>修改</span></a></li>
		</shiro:hasPermission>
		<li class="line">line</li>
		<%-- <shiro:hasPermission name="Resume:view">
			<li><a  width="850" height="500"  class="icon" href="${ctx}/person/${emp.humanId}/{sid_user}/view" target="dialog" mask="true"><span>详细</span></a></li>
		</shiro:hasPermission> --%>
		<shiro:hasPermission name="Resume:delete">
		<li><a class="delete" href="${ctx}/person/${emp.humanId}/{sid_user}/delete" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</shiro:hasPermission>
		</ul>
	</div>
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="137">
    <thead>
        <tr >
			<th width="100px" align="center">账号</th>
			<th width="100px" align="center">属性</th>
			<th width="100px" align="center">姓名</th>
			<th width="200px" align="center">性别</th>        
            <th width="100px" align="center">头像路径</th>
            <th width="100px" align="center">身份证号</th>
            <th width="100px" align="center">实名认证</th>
            <th width="200px" align="center">身份</th>
           	<th width="200px" align="center">学历</th>
           	<th width="200px" align="center">出生日期</th>
       		<th width="200px" align="center">微信</th>
       		<th width="200px" align="center">QQ</th>
   			<th width="200px" align="center">邮箱</th>
   			<th width="100px" align="center">删除状态</th>
   			<th width="200px" align="center">创建人</th>
   			<th width="200px" align="center">创建时间</th>
   			<th width="200px" align="center">修改人</th>
   			<th width="200px" align="center">修改时间</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.content}" var="emp">
            <tr target="sid_user" rel="${emp.humanId}">
            	 <td>${emp.userAddInfo.userName }</td>
            	 <td>
            	 	<c:choose>
            	 		<c:when test="${emp.userAddInfo.userPerson == 1 && emp.userAddInfo.userCompany == 1}">个人 / 企业</c:when>
            	 		<c:when test="${emp.userAddInfo.userPerson == 1 && emp.userAddInfo.userCompany == 0}">个人</c:when>
            	 		<c:when test="${emp.userAddInfo.userPerson == 0 && emp.userAddInfo.userCompany == 1}">企业</c:when>
            	 	</c:choose>
            	 </td>
                 <td>${emp.humanName }</td>
                 <td>
					<c:if test="${emp.humanSex==1 }">
		                	女
		                </c:if>
		                <c:if test="${emp.humanSex==0 }">
		                	男
		                </c:if>
				 </td>
				 <td><a href="${emp.humanImage }" target="_href">${emp.humanImage }</a></td> 
                 <td>${emp.humanCard}</td>
                <td>
				<c:if test="${emp.nameAuthent==1 }">
	                	已认证
	                </c:if>
	                <c:if test="${emp.nameAuthent==0 }">
	                	<b style="color:red;">未认证</b>
	                </c:if>
				</td>
				<td>
				<c:if test="${emp.humanIdentity==1 }">
	                	蒸蒸日上
	                </c:if>
	                <c:if test="${emp.humanIdentity==0 }">
	                	莘莘学子
	                </c:if>
				</td>
                 <td>${emp.humanDiploma.name }</td>
                 <td><fmt:formatDate value="${emp.humanBirthday}" type="date" dateStyle="long"/></td>
                 <td>${emp.humanWechat }</td>
                 <td>${emp.humanQQ }</td>
                 <td>${emp.humanEmail }</td>
                  <td>${emp.userAddInfo.userDelete == 0 ? '未删除' : '<b style="color:red;">已删除</b>' }</td>
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