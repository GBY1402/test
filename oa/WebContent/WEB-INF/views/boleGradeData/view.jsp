<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
		<div class="pageFormContent" layoutH="56">
		<fieldset style="width:95%; margin: 0px auto;">
			<%-- <legend>${boleGradeData.gradeName }</legend> --%>
			<table class="gridtable" >
				<tr>
				    <td align="right">等级：</td><td>${boleGradeData.boleGrade }</td>
				</tr>
				<tr>
				    <td align="right">经验：</td><td>${boleGradeData.boleExperience }</td>
				</tr>
				<tr>
				    <td align="right">名称：</td><td>${boleGradeData.gradeName }</td>
				</tr>
				<tr>
				    <td align="right">佣金限制：</td><td>${boleGradeData.boleMoney }</td>
				</tr>
			</table>
		</fieldset>
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>维护信息</legend>
			<table class="gridtable">
				<tr>
				    <td align="right" >创建人：</td><td colspan="3">${boleGradeData.createUser }</td>
				</tr>
				<tr>
					<td align="right">创建时间：</td><td><fmt:formatDate value="${boleGradeData.createTime}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<td align="right" >修改人：</td><td colspan="3">${boleGradeData.updateUser }</td>
				</tr>
				<tr>
					<td align="right">修改时间：</td><td><fmt:formatDate value="${boleGradeData.updateTime}" pattern="yyyy-MM-dd"/></td>
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
