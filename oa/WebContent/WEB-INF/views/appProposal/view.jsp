<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
		<div class="pageFormContent" layoutH="56">
		<fieldset style="width:95%; margin: 0px auto;">
			<table class="gridtable" >
				<tr>
				    <td align="right">名称：</td>
				    <td>${appProposal.mobileName}</td>
				</tr>
				<tr>
				    <td align="right">APPID：</td><td>${appProposal.appId}</td>
				</tr>
				<tr>
				    <td align="right">APP版本号：</td><td>${appProposal.appVersion}</td>
				</tr>
				<tr>
				    <td align="right">时间：</td><td><fmt:formatDate value="${appProposal.mobileTime}" type="date" dateStyle="long"/></td>
				</tr>
				<tr>
				    <td align="right">反馈和意见：</td><td>${appProposal.mobileDescribe}</td>
				</tr>
			</table>
		</fieldset>
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>图片反馈</legend>
			<table class="gridtable">
				<c:forEach items="${appProposal.pictureList }" var="pic" varStatus="status">
				<tr>
				    <td align="right" >图片${status.index + 1}：</td><td colspan="3"><a href="${pic.picturePath }" target="_href">${pic.picturePath }</a></td>
				</tr>				
				</c:forEach>
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
