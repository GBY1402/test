<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/wallet">
	<input type="hidden" name="search_LIKE_organization.name" value="${param['search_LIKE_organization.name']}">
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
</form>

<form id="searchForm" method="post" action="${ctx}/wallet" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>用户：</label>
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
	<div class="panelBar">
		<ul class="toolBar">
		<shiro:hasPermission name="Wallet:save">
			<li><a  width="600" height="200" rel="lookup2organization_add" class="add" href="${ctx}/wallet/create" target="dialog" mask="true"><span>添加</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="Wallet:edit">
			<li><a  width="600" height="200" rel="wallet_edit" class="edit" href="${ctx}/wallet/${emp.walletId}/{sid_user}/update" target="dialog" mask="true"><span>修改</span></a></li>
		</shiro:hasPermission>
		<li class="line">line</li>
		<%-- <shiro:hasPermission name="Wallet:view">
			<li><a  width="850" height="450"  class="icon" href="${ctx}/wallet/${emp.walletId}/{sid_user}/view" target="dialog" mask="true"><span>详细</span></a></li>
		</shiro:hasPermission> --%>
		<shiro:hasPermission name="Wallet:delete">
		<li><a class="delete" href="${ctx}/wallet/${emp.walletId}/{sid_user}/delete" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</shiro:hasPermission>
		<li class="line">line</li>
		</ul>
	</div>
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="137">
    <thead>
        <tr>
        	<th width="150px" align="center">用户</th>
            <th width="150px" align="center">余额</th>
            <th width="150px" align="center">账户状态</th>
            <th width="150px" align="center">绑定状态</th>
            <th width="150px" align="center">删除状态</th>
            <th width="150px" align="center">微信账号</th>
            <th width="150px" align="center">微信昵称</th>
            <th width="150px" align="center">微信头像</th>
            <th width="150px" align="center">支付宝账号</th>
            <th width="150px" align="center">创建人</th>
   			<th width="150px" align="center">创建时间</th>
   			<th width="150px" align="center">修改人</th>
   			<th width="150px" align="center">修改时间</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.content}" var="emp">
            <tr target="sid_user" rel="${emp.walletId}">
            	<td>${emp.humanBasicInfo.humanName }</td>
                <td>${emp.balance }</td> 
                <td>
					<c:if test="${emp.state==0 }">
	                	正常
	                </c:if>
	                <c:if test="${emp.state==1 }">
	                	冻结
	                </c:if>
	                <c:if test="${emp.state==2 }">
	                	结算中
	                </c:if>
				</td>
				<td>
					<c:if test="${emp.binding==0 }">
	                	未绑定
	                </c:if>
	                <c:if test="${emp.binding==1 }">
	                	微信
	                </c:if>
	                <c:if test="${emp.binding==2 }">
	                	支付宝
	                </c:if>
	                <c:if test="${emp.binding==3 }">
	                	微信/支付宝
	                </c:if>
				</td>
				<td>
					<c:if test="${emp.walletDelete == 0 }">
						未删除
					</c:if>
					<c:if test="${emp.walletDelete == 1 }">
						<b style="color:red">已删除</b>
					</c:if>
				</td>
				<td>${emp.weChat }</td>
				<td>${emp.weChatName }</td>
				<td><a href="${emp.headimgurl }" target="_href"><img src="${emp.headimgurl }" /></a></td>
				<td>${emp.aliPay }</td>
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