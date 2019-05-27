<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
		<div class="pageFormContent" layoutH="56">
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>个人基本信息</legend>
			<table class="gridtable" >
				<tr>
				    <td align="right">姓名：</td><td>${humanBasicInfo.humanName }</td><td  align="right">身份证：</td><td>${humanBasicInfo.humanCard }</td>
				</tr>
				<tr>
				    <td align="right">认证：</td>
				    <td>
					    <c:if test="${humanBasicInfo.nameAuthent==1}">已认证</c:if>
						<c:if test="${humanBasicInfo.nameAuthent==0}">未认证</c:if>
					</td>
					 <td align="right">认证：</td>
				    <td>
					    <c:if test="${humanBasicInfo.humanSex==1}">女</c:if>
						<c:if test="${humanBasicInfo.humanSex==0}">男</c:if>
					</td>
				</tr>
				<tr>
				    <td align="right">属性：</td>
				    <td>
					    <c:if test="${humanBasicInfo.nameAuthent==1}">已认证</c:if>
						<c:if test="${humanBasicInfo.nameAuthent==0}">未认证</c:if>
					</td>
					 <td align="right">删除状态：</td>
				    <td>
					    <c:if test="${humanBasicInfo.deleteBasic==1}"><b style="color:red;">已删除</b></c:if>
						<c:if test="${humanBasicInfo.deleteBasic==0}">未删除</c:if>
					</td>
				</tr>
				<tr>
				    <td align="right">身份：</td>
				    <td>
					    <c:if test="${humanBasicInfo.humanIdentity==1}">蒸蒸日上</c:if>
						<c:if test="${humanBasicInfo.humanIdentity==0}">莘莘学子</c:if>
					</td>
				    <td align="right">学历：</td><td>${humanBasicInfo.humanDiploma.name }</td>
				</tr>
				<tr>
				    <td align="right">出生年月：</td><td><fmt:formatDate value="${humanBasicInfo.humanBirthday}" pattern="yyyy-MM-dd"/></td>
				    <td align="right">联系电话：</td><td>${humanBasicInfo.humanPhone }</td>
				</tr>
				<tr>
				    <td align="right">微信：</td><td>${humanBasicInfo.humanWechat }</td>
				    <td align="right">QQ：</td>
				    <td>${humanBasicInfo.humanQQ }</td>
				</tr>
				<tr>
				    <td align="right">邮箱：</td>
				    <td>${humanBasicInfo.humanEmail}</td>
				    <td align="right">详细地址：</td><td>${humanBasicInfo.humanDetailed }</td>
				</tr>
				<tr>
				    <td align="right">身高：</td>
				    <td>${humanBasicInfo.humanHeight}</td>
				    <td align="right">体重：</td><td>${humanBasicInfo.humanWeight }</td>
				</tr>
				<tr>
				    <td align="right">自我描述：</td>
				    <td  colspan="3">${humanBasicInfo.humanDescription}</td>
				</tr>
			</table>
		</fieldset>
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>维护信息</legend>
			<table class="gridtable">
				<tr>
				    <td align="right" >创建人：</td><td >${humanBasicInfo.createUser }</td>
				      <td align="right">创建时间：</td><td><fmt:formatDate value="${humanBasicInfo.createTime}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
				    <td align="right">修改人：</td><td >${humanBasicInfo.updateUser }</td>
					<td align="right">修改时间：</td><td><fmt:formatDate value="${humanBasicInfo.updateTime}" pattern="yyyy-MM-dd"/></td>
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
