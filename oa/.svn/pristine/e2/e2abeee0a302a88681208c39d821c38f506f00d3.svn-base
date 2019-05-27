<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
		<div class="pageFormContent" layoutH="56">
		<fieldset style="width:95%; margin: 0px auto;">
			<%-- <legend>${boleGradeData.gradeName }</legend> --%>
			<table class="gridtable" >
				<tr>
				    <td align="right">职位类型：</td>
				    <td>
						<c:if test="${huntingWorryData.hunWorAttr == 0}">普通</c:if>
						<c:if test="${huntingWorryData.hunWorAttr == 1}">急聘</c:if>
						<c:if test="${huntingWorryData.hunWorAttr == 2}">猎聘</c:if>
				    </td>
				</tr>
				<tr>
				    <td align="right">首笔支付天数：</td><td>${huntingWorryData.startDay }</td>
				</tr>
				<tr>
				    <td align="right">首笔支付百分比：</td><td><fmt:formatNumber type="number" pattern="0.00" value="${huntingWorryData.startPay}" /> %</td>
				</tr>
				<tr>
				    <td align="right">尾笔支付天数：</td><td>${huntingWorryData.endDay }</td>
				</tr>
				<tr>
				    <td align="right">尾笔支付百分比：</td><td><fmt:formatNumber type="number" pattern="0.00" value="${huntingWorryData.endPay }" /> %</td>
				</tr>
			</table>
		</fieldset>
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>维护信息</legend>
			<table class="gridtable">
				<tr>
				    <td align="right" >创建人：</td><td colspan="3">${huntingWorryData.createUser }</td>
				</tr>
				<tr>
					<td align="right">创建时间：</td><td><fmt:formatDate value="${huntingWorryData.createTime}" pattern="yyyy-MM-dd"/></td>
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
