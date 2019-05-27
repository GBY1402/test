<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
		<div class="pageFormContent" layoutH="56">
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>企业基本信息</legend>
			<table class="gridtable" >
				<tr>
				    <td align="right">企业全称：</td><td>${enterBasicInfo.enterShortName }</td><td  align="right">企业简称：</td><td>${enterBasicInfo.enterShortName }</td>
				</tr>
				<tr>
				    <td align="right">企业性质：</td>
				    <td>${enterBasicInfo.enterNature.name }</td>
					<td  align="right">融资轮数：</td><td>${enterBasicInfo.enterFinanc.name }</td>
				</tr>
				<tr>
				    <td align="right">企业人数：</td><td>${enterBasicInfo.enterNumber.name }</td>
				    <td align="right">法人代表：</td><td>${enterBasicInfo.enterLegalPerson }</td>
				</tr>
				<tr>
				    <td align="right">企业邮箱：</td><td>${enterBasicInfo.enterEmail }</td>
				    <td align="right">企业电话：</td><td>${enterBasicInfo.enterTelephone }</td>
				</tr>
				<tr>
				    <td align="right">行业：</td><td>${enterBasicInfo.enterIndustry.name }</td>
				    <td align="right">详细地址：</td><td>${enterBasicInfo.enterArdessDe }</td>
				</tr>
				<tr>
				    <td align="right">公司LOGO：</td><td><img src="${enterBasicInfo.enterLogo}" style="max-width: 80px; max-height: 80px"></td>
				    <td align="right">营业执照：</td><td><img src="${enterBasicInfo.enterBusimes }" style="max-width: 80px; max-height: 80px"></td>
				</tr>
				<tr>
				    <td align="right">公司官网：</td><td>${enterBasicInfo.enterUrl }</td>
				    <td align="right">认证状态：</td><td>
				     <c:if test="${enterBasicInfo.enterCondition==0}">认证中</c:if>
				     <c:if test="${enterBasicInfo.enterCondition==1}">已认证</c:if>
				     <c:if test="${enterBasicInfo.enterCondition==2}">认证未通过</c:if>
				   </td>
				</tr>
			</table>
		</fieldset>
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>维护信息</legend>
			<table class="gridtable">
				<tr>
				    <td align="right" >创建人：</td><td colspan="3">${enterBasicInfo.createUser }</td>
				    <td align="right">创建时间：</td><td><fmt:formatDate value="${enterBasicInfo.createTime}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<td align="right" >修改人：</td><td colspan="3">${enterBasicInfo.updateUser }</td>
					<td align="right">修改时间：</td><td><fmt:formatDate value="${enterBasicInfo.updateTime}" pattern="yyyy-MM-dd"/></td>
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
