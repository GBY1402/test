<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/persondetailed">
	<input type="hidden" name="search_LIKE_organization.name" value="${param['search_LIKE_organization.name']}">
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
</form>

<form id="searchForm" method="post" action="${ctx}/persondetailed" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<%-- <li>
					<label>用户：</label>
					<input type="text" name="search_LIKE_walletInfo.humanBasicInfo.humanName " value="${param['walletInfo.humanBasicInfo.humanName '] }" />
				</li> --%>
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
		<shiro:hasPermission name="Persondetailed:save">
			<li><a  width="600" height="300" rel="lookup2organization_add" class="add" href="${ctx}/persondetailed/create" target="dialog" mask="true"><span>添加</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="Persondetailed:edit">
			<li><a  width="600" height="300" class="edit" href="${ctx}/persondetailed/${emp.detailedId}/{sid_user}/update" target="dialog" mask="true"><span>修改</span></a></li>
		</shiro:hasPermission>
		<li class="line">line</li>
		<%-- <shiro:hasPermission name="Resume:view">
		<li><a  width="850" height="450"  class="icon" href="${ctx}/persondetailed/${emp.detailedId}/{sid_user}/view" target="dialog" mask="true"><span>详细</span></a></li>
		</shiro:hasPermission> --%>
		<shiro:hasPermission name="Persondetailed:delete">
		<li><a class="delete" href="${ctx}/persondetailed/${emp.detailedId}/{sid_user}/delete" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</shiro:hasPermission>
		<li class="line">line</li>
		<shiro:hasPermission name="Persondetailed:view">
			<li><a  width="850" height="450"  class="icon" href="${ctx}/persondetailed/${emp.detailedId}/{sid_user}/payment" target="ajaxTodo" title="确定要结算吗?"><span>结算</span></a></li>
		</shiro:hasPermission>
		</ul>
	</div>
	<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<table class="table" layoutH="137">
    <thead>
        <tr >
        	<th width="200px" align="center">用户</th>
            <th width="200px" align="center">状态</th>
            <th width="200px" align="center">类型</th>
            <th width="200px" align="center">交易金额</th>
            <th width="200px" align="center">进度</th>
            <th width="200px" align="center">订单号</th>
            <th width="200px" align="center">删除状态</th>
            <th width="200px" align="center">创建人</th>
   			<th width="200px" align="center">创建时间</th>
   			<th width="200px" align="center">修改人</th>
   			<th width="200px" align="center">修改时间</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.content}" var="emp">
            <tr target="sid_user" rel="${emp.detailedId}">
            	<td>${emp.walletInfo.humanBasicInfo.humanName }</td>
                <td>
				<c:if test="${emp.state==0 }">
	                	收入
	                </c:if>
	                <c:if test="${emp.state==1 }">
	                	提现
	                </c:if>
				</td>
				 <td>
				<c:if test="${emp.type==0 }">
	                	微信
	                </c:if>
	                <c:if test="${emp.type==1 }">
	                	支付宝
	                </c:if>
	                <c:if test="${emp.type==2 }">
	                	平台钱包
	                </c:if>
				</td>
				<td>${emp.money }</td>
				 <td>
				<c:if test="${emp.progress==0 }">
	                	结算成功
	                </c:if>
	                <c:if test="${emp.progress==1 }">
	                	结算中
	                </c:if>
	                <c:if test="${emp.progress==2 }">
	                	结算失败
	                </c:if>
				</td>
				<td>${emp.orderNumber }</td>
				<td>
					<c:if test="${emp.walletDelete == 0 }">
						未删除
					</c:if>
					<c:if test="${emp.walletDelete == 1 }">
						<b style="color:red;">已删除</b>
					</c:if>
				</td>
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