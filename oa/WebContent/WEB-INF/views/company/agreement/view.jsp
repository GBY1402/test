<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx }/" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>企业协议基本信息</legend>
			<table class="gridtable" >
					<tr>
						<td align="right">企业名称：</td>
						<td>${model.enterBasicInfo.enterName }</td>
					</tr>
					<tr>
					    <td align="right">急聘签约状态：</td>
					    <td>
					    	<c:if test="${model.wantedState == 0}">未签约</c:if>
					    	<c:if test="${model.wantedState == 1}">签约中</c:if>
					    	<c:if test="${model.wantedState == 2}">已签约</c:if>
					    </td>
					    <td align="right">急聘文件地址：</td><td><a href="${model.wantedURL }">${model.wantedURL }</a></td>
					</tr>				
					<tr>
					    <td align="right">猎聘签约状态：</td>
					    <td>
					    	<c:if test="${model.huntingState == 0}">未签约</c:if>
					    	<c:if test="${model.huntingState == 1}">签约中</c:if>
					    	<c:if test="${model.huntingState == 2}">已签约</c:if>
					    </td>
					    <td align="right">猎聘文件编号：</td><td>${model.number }</td>
					</tr>				
			</table>
		</fieldset>
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>维护信息</legend>
			<table class="gridtable">
				<tr>
				    <td align="right" >创建人：</td><td colspan="3">${model.createUser }</td>
				    <td align="right">创建时间：</td><td><fmt:formatDate value="${model.createTime}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<td align="right" >修改人：</td><td colspan="3">${model.updateUser }</td>
					<td align="right">修改时间：</td><td><fmt:formatDate value="${model.updateTime}" pattern="yyyy-MM-dd"/></td>
				</tr>
			</table>
		</fieldset>
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
