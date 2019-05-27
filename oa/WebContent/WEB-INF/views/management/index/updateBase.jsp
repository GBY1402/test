<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="${ctx }/management/index/updateBase" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogAjaxDone);">
	<div class="pageFormContent" layoutH="58">
		<p>
			<label>登录账号：</label>
			<input type="text" name="username" size="30" class="readonly" readonly="readonly" value="${login_user.username }"/>
		</p>
		<p>
			<label>员工姓名：</label>
			<input type="text" name="realname" size="30" class="readonly" readonly="readonly" value="${login_user.employee.name }"/>
		</p>
		<p>
			<label>电话：</label>
			<input type="text" name="phone" class="validate[custom[phone],maxSize[32]]" size="30" maxlength="32" value="${login_user.phone }"/>
		</p>
		<p>
			<label>用户邮箱：</label>
			<input type="text" name="email" class="validate[custom[email],maxSize[128]]" size="30" maxlength="128" value="${login_user.email }"/>
		</p>	
	</div>
			
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>