<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
		<div class="pageFormContent" layoutH="56">
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>简历投递详情</legend>
			<table class="gridtable" >
				<tr>
				    <td align="right">简历名称：</td><td>${jobper.personJobInfo.personJobName }</td><td  align="right">所属用户：</td><td>${jobper.personJobInfo.humanBasicInfo.humanName }</td>
				</tr>
				<tr>
				    <td align="right">投递类型：</td>
				    <td>
					    <c:if test="${jobper.jobWanfedInfo.jobAttribute==0}">全职</c:if>
						<c:if test="${jobper.jobWanfedInfo.jobAttribute==1}">急聘</c:if>
						<c:if test="${jobper.jobWanfedInfo.jobAttribute==2}">猎聘</c:if>
					</td>
					<td align="right">属性：</td>
				    <td>
					    <c:if test="${jobper.centerAudition == 0 }">已投递</c:if>
	                 	<c:if test="${jobper.centerAudition == 1 }">已查看</c:if>
	                 	<c:if test="${jobper.centerAudition == 2 }">邀请面试</c:if>
	                 	<c:if test="${jobper.centerAudition == 3 }">同意面试</c:if>
	                 	<c:if test="${jobper.centerAudition == 4 }">拒绝面试</c:if>
	                 	<c:if test="${jobper.centerAudition == 5 }">不合适</c:if>
	                 	<c:if test="${jobper.centerAudition == 6 }">已成功</c:if>
					</td>
					</tr>
					<tr>
					<td align="right">行业：</td><td>${jobper.jobWanfedInfo.workIndustry.name }</td>
					<td align="right">职位：</td><td>${jobper.jobWanfedInfo.workFunction.name }</td>
					</tr>
					<tr>
					<td align="right">接收HR：</td><td>${jobper.jobWanfedInfo.enterPersonInfo.humanBasicInfo.humanName }</td>
					<td align="right">HR所属公司：</td><td>${jobper.jobWanfedInfo.enterPersonInfo.personAndbasicInfo.enterBasicInfo.enterName }</td>
					</tr>
					<tr>
					<td align="right">个人删除：</td>
				    <td>
					    <c:if test="${jobper.deletePerson == 0 }">未删除</c:if>
                 		<c:if test="${jobper.deletePerson == 1 }"><b style="color:red;">已删除</b></c:if>
					</td>
					<td align="right">企业删除：</td>
				    <td>
					    <c:if test="${jobper.deleteEnter == 0 }">未删除</c:if>
                 		<c:if test="${jobper.deleteEnter == 1 }"><b style="color:red;">已删除</b></c:if>
					</td>
					</tr>
					<tr>
					<td align="right">后台删除：</td>
				    <td>
					    <c:if test="${jobper.deleteCentre == 0 }">未删除</c:if>
                 		<c:if test="${jobper.deleteCentre == 1 }"><b style="color:red;">已删除</b></c:if>
					</td>
					</tr>
				</tr>
				
			</table>
		</fieldset>
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>维护信息</legend>
			<table class="gridtable">
				<tr>
				    <td align="right" >创建人：</td><td >${jobper.createUser }</td>
				      <td align="right">创建时间：</td><td><fmt:formatDate value="${jobper.createTime}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
				    <td align="right">修改人：</td><td >${jobper.updateUser }</td>
					<td align="right">修改时间：</td><td><fmt:formatDate value="${jobper.updateTime}" pattern="yyyy-MM-dd"/></td>
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
