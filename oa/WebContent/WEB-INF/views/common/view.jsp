<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
	<form method="post"  class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		<fieldset style="width:100%; margin: 0px auto;">
			<legend>账号基本信息</legend>
			<table class="gridtable" >
				<tr>
				    <td align="right">账号：</td><td>${userAddInfo.userName }</td>
				    <td align="right">删除状态：</td>
				    <td>
				    <c:if test="${userAddInfo.userDelete==0}">删除</c:if>
					<c:if test="${userAddInfo.userDelete==1}">未删除</c:if>
				    </td>
				</tr>
				<tr>
				    <td align="right">个人账号：</td>
				    <td>
					    <c:if test="${userAddInfo.userPerson==1}">开通</c:if>
						<c:if test="${userAddInfo.userPerson==2}">未开通</c:if>
					</td>
					<td  align="right">企业账号：</td>
					<td>
					 <c:if test="${userAddInfo.userCompany==1}">开通</c:if>
					<c:if test="${userAddInfo.userCompany==2}">未开通</c:if>
					</td>
				</tr>
				<tr>
				    <td align="right">归属状态：</td>
				    <td>
					<c:if test="${userAddInfo.userState==1}">开启状态</c:if>
					<c:if test="${userAddInfo.userState==2}">冻结状态</c:if>
					<c:if test="${userAddInfo.userState==3}">个人冻结</c:if>
					<c:if test="${userAddInfo.userState==4}">企业冻结</c:if>
					</td>
				    
				</tr>
				
			</table>
		</fieldset>
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>维护信息</legend>
			<table class="gridtable">
				<tr>
				    <td align="right" >修改人：</td><td>${userAddInfo.createUser }</td>
				    <td align="right" >修改时间：</td><td colspan="3"><fmt:formatDate value="${userAddInfo.createTime}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
				    <td align="right" >创建人：</td><td>${userAddInfo.updateUser }</td>
				    <td align="right" >创建时间：</td><td colspan="3"><fmt:formatDate value="${userAddInfo.updateTime}" pattern="yyyy-MM-dd"/></td>
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
