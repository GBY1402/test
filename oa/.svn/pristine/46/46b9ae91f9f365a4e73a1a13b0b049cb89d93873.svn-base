<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx }/employee/${employee.pkid}/update" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input type="hidden" name="pkid" value="${employee.pkid}">
		<div class="pageFormContent" layoutH="56">
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>个人基本信息</legend>
			<table class="gridtable" >
				<tr>
				    <td align="right">工号：</td><td>${employee.jobnum }</td><td  align="right">姓名：</td><td>${employee.name }</td>
				</tr>
				<tr>
				    <td align="right">性别：</td>
				    <td>
					    <c:if test="${employee.sex==1}">男</c:if>
						<c:if test="${employee.sex==2}">女</c:if>
					</td>
					<td  align="right">年龄：</td><td>${employee.age }</td>
				</tr>
				<tr>
				    <td align="right">身份证号：</td><td>${employee.cardid }</td>
				    <td align="right">毕业院校：</td><td>${employee.toschool }</td>
				</tr>
				<tr>
				    <td align="right">出生年月：</td><td><fmt:formatDate value="${employee.birthday}" pattern="yyyy-MM-dd"/></td>
				    <td align="right">联系电话：</td><td>${employee.phone }</td>
				</tr>
				<tr>
				    <td align="right">专业：</td><td>${employee.major }</td>
				    <td align="right">学历：</td>
				    <td>
				    	<c:forEach items="${edtypes}" var="type" >
							<c:if test="${employee.educationColl==type}">
								${type.info}
							</c:if>
						</c:forEach>
				    </td>
				</tr>
				<tr>
				    <td align="right">婚姻状况：</td>
				    <td>
				    	<c:if test="${employee.maritalstatus==1}">未婚</c:if>
						<c:if test="${employee.maritalstatus==2}">已婚</c:if>
				    </td>
				    <td align="right">户口所在地：</td><td>${employee.domicileplace }</td>
				</tr>
				<tr>
				    <td align="right">家庭地址：</td><td colspan="3">${employee.homeaddress }</td>
				</tr>
				<tr>
				    <td align="right">是否转正：</td>
				    <td>
				    	<c:if test="${employee.isorregular==1}">已转正</c:if>
						<c:if test="${employee.isorregular==2}">未转正</c:if>
				    </td>
				    <td align="right">转正时间：</td><td><fmt:formatDate value='${employee.regulartime}' pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
				    <td align="right">年假：</td>
				    <td>
					    <c:if test="${employee.isyearleave==1}">有</c:if>
						<c:if test="${employee.isyearleave==2}">无</c:if>
				    </td>
				    <td align="right">状态：</td>
				    <td>
				    	<c:forEach items="${stateTypes}" var="type" >
							<c:if test="${employee.stateType==type}">
								${type.info}
							</c:if>
						</c:forEach>
				    </td>
				</tr>
			</table>
		</fieldset>
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>合同信息</legend>
			<table class="gridtable">
				<tr>
				    <td align="right" >合同编号：</td><td colspan="3">${employee.contractid }</td>
				</tr>
				<tr>
				    <td align="right">合同开始时间：</td><td><fmt:formatDate value="${employee.contractstarttime}" pattern="yyyy-MM-dd"/></td>
					<td align="right">合同终止时间：</td><td><fmt:formatDate value="${employee.contractendtime}" pattern="yyyy-MM-dd"/></td>
				</tr>
			</table>
		</fieldset>
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>入职信息</legend>
			<table class="gridtable">
				<tr>
				    <td align="right">部门：</td><td>${employee.organization.name }</td>
				    <td align="right">岗位：</td><td>${employee.job }</td>
				</tr>
				<tr>
				    <td align="right">技能：</td><td>${employee.skill }</td>
					<td align="right">招聘渠道：</td>
					<td>
						<c:forEach items="${types}" var="type" >
							<c:if test="${employee.recruitmentChannel==type}">
								${type.info}
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<tr>
				    <td align="right" >紧急联络人：</td><td>${employee.emergencyContact }</td>
				    <td align="right" >紧急联络人电话：</td><td>${employee.emergencyContactphone }</td>
				</tr>
				<tr>
				    <td align="right" >入职时间：</td><td colspan="3"><fmt:formatDate value="${employee.entrytime}" pattern="yyyy-MM-dd"/></td>
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
