<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx }/recruit/${employee.pkid}/update" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input type="hidden" name="pkid" value="${employee.pkid}">
		<div class="pageFormContent" layoutH="56">
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>个人基本信息</legend>
			<table class="gridtable" >
				<tr>
				    <td align="right">薪资起：</td><td>${job.fullPayStart.name }</td>
				    <td  align="right">薪资结：</td><td>${job.fullPayEnd.name }</td>
				</tr>
				<tr>
				    <td align="right">学历：</td>
				    <td>${job.educationJob.name }</td>
					<td  align="right">年限要求：</td><td>${job.workJobLife.name }</td>
				</tr>
				<tr>
				    <td align="right">行业：</td><td>${job.workIndustry.name }</td>
				    <td align="right">职能：</td><td>${job.workFunction.name }</td>
				</tr>
				<tr>
				    <td align="right">人数：</td><td>${job.numberJob }</td>
				    <td align="right">佣金：</td><td>${job.commission }</td>
				</tr>
				<tr>
				    <td align="right">到岗开始时间：</td><td><fmt:formatDate value="${job.workArrivalStart}" pattern="yyyy-MM-dd"/></td>
				    <td align="right">到岗结束时间：</td><td><fmt:formatDate value="${job.workArrivalEnd}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
				    <td align="right">HR：</td><td>${job.enterPersonInfo.humanBasicInfo.humanName }</td>
				    <td align="right">HR所属公司：</td><td>${job.enterBasicInfo.enterName }</td>
				</tr>
				<tr>
				    <td align="right">求职状态：</td>
				    <td>
				    	<c:if test="${job.jobCondition == 0 }">
	                		停止招聘
		                </c:if>
		                <c:if test="${job.jobCondition == 1 }">
		                	招聘中
		                </c:if>
		                <c:if test="${job.jobCondition == 2 }">
		                	保存
		                </c:if>
				    </td>
				    <td align="right">删除状态：</td>
				    <td>
				    	<c:if test="${job.jobDelete == 0 }">
	                		未删除
		                </c:if>
		                <c:if test="${job.jobDelete == 1 }">
		                	<b style="color:red;">已删除</b>
		                </c:if>
				    </td>
				</tr>
				<tr>
				    <td align="right">详细地址：</td><td>${job.workArdessDe }</td>
				</tr>
			</table>
		</fieldset>
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>维护信息</legend>
			<table class="gridtable">
				<tr>
				    <td align="right" >创建人：</td><td colspan="3">${job.createUser }</td>
				    <td align="right">创建时间：</td><td><fmt:formatDate value="${job.createTime}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<td align="right" >修改人：</td><td colspan="3">${job.updateUser }</td>
					<td align="right">修改时间：</td><td><fmt:formatDate value="${job.updateTime}" pattern="yyyy-MM-dd"/></td>
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
