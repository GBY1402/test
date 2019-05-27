<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	<form method="post" action="${ctx }/account/update" class="required-validate pageForm" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input type="hidden" name="userPassword" value="${userAddInfo.userPassword}"/>
		<input type="hidden" name="userSalt" value="${userAddInfo.userSalt}"/>
		<input type="hidden" name="userId" value="${userAddInfo.userId}"/>
		<input type="hidden" name="createUser" value="${userAddInfo.createUser}"/>
		<input type="hidden" name="createTime" value="${userAddInfo.createTime}"/>
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>账号：</label>
				<input name="userName" class="validate[required,maxSize[30]] required" type="text" size="30" value="${userAddInfo.userName }"/>
			</p>
			<p>
				<label>密码：</label>
				<input name="plainPassword" class="validate[required,maxSize[32]] required" size="30" />
			</p>
			<p>
				<label>个人账号：</label>
				<select name="userPerson" class="validate[required]">
					<option value="0" selected>请选择</option>
					<option value="1"${userAddInfo.userPerson==1?'selected':''}>开通</option>
					<option value="0"${userAddInfo.userPerson==0?'selected':''}>未开通</option>
				</select>
				<span><font color="red">*</font></span>
			</p>
			<p>
				<label>企业账号：</label>
				<select name="userCompany" class="validate[required]">
					<option value="0" selected>请选择</option>
					<option value="1"${userAddInfo.userCompany==1?'selected':''}>开通</option>
					<option value="0"${userAddInfo.userCompany==0?'selected':''}>未开通</option>
				</select>
				<span><font color="red">*</font></span>
			</p>
			<p>
				<label>归属状态：</label>
				<select name="userState" class="validate[required]">
					<option value="0" selected>请选择</option>
					<option value="1"${userAddInfo.userState==1?'selected':''}>开启状态</option>
					<option value="2"${userAddInfo.userState==2?'selected':''}>冻结状态</option>
					<option value="3"${userAddInfo.userState==3?'selected':''}>个人冻结</option>
					<option value="4"${userAddInfo.userState==4?'selected':''}>企业冻结</option>
				</select>
				<span><font color="red">*</font></span>
			</p>
			<p>
				<label>删除状态：</label>
				<select name="userDelete" class="validate[required]">
					<option value="0" selected>请选择</option>
					<option value="1" ${userAddInfo.userDelete==1?'selected':''}>删除</option>
					<option value="0"${userAddInfo.userDelete==0?'selected':''}>未删除</option>
				</select>
				<span><font color="red">*</font></span>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>

<script type="text/javascript">
	function hideCalendar(){	
		$("#calendar").hide();
	}
</script>