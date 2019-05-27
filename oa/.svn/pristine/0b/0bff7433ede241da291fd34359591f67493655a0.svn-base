<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
		<div class="pageFormContent" layoutH="56">
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>企业基本信息</legend>
			<table class="gridtable" >
				<tr>
				    <td align="right">描述：</td>
				    <td>${apkInfo.name }</td>
				</tr>
				<tr>
				    <td align="right">版本号：</td><td>${apkInfo.version }</td>
				</tr>
				<tr>
				    <td align="right">下载路径：</td><td><a href="${apkInfo.path}" target="_href">${apkInfo.path }</a></td>
				</tr>
				<tr>
				    <td align="right">类型：</td><td>
				     <c:if test="${apkInfo.apkType==0}">个人安卓</c:if>
				     <c:if test="${apkInfo.apkType==1}">个人IOS</c:if>
				     <c:if test="${apkInfo.apkType==2}">企业安卓</c:if>
				     <c:if test="${apkInfo.apkType==3}">企业IOS</c:if>
				   </td>
				</tr>
				<tr>
				    <td align="right">状态：</td><td>
				     <c:if test="${apkInfo.state==1}">发布</c:if>
				     <c:if test="${apkInfo.state==2}">停止</c:if>
				   </td>
				</tr>
			</table>
		</fieldset>
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>维护信息</legend>
			<table class="gridtable">
				<tr>
				    <td align="right" >创建人：</td><td colspan="3">${apkInfo.createName }</td>
				</tr>
				<tr>
					<td align="right">创建时间：</td><td><fmt:formatDate value="${apkInfo.createTime}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<td align="right" >修改人：</td><td colspan="3">${apkInfo.updateName }</td>
				</tr>
				<tr>
					<td align="right">修改时间：</td><td><fmt:formatDate value="${apkInfo.updateTime}" pattern="yyyy-MM-dd"/></td>
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
</div>
