<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<script type="text/javascript">
<!--
jQuery(document).ready(function(){
	$("#captcha").click(function(){
		$(this).attr("src", "${contextPath }/Captcha.jpg?time=" + new Date());
		return false;
	});
});
//-->
</script>
<div class="pageContent">
	<form method="post" action="${ctx }/login" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<%-- 指定为ajax请求 --%>
		<input type="hidden" name="ajax" value="true"/>
		<div class="pageFormContent" layoutH="58">
			<p>
				<label>用户名:</label>
				<input type="text" name="username" id="username" maxlength="32" class="validate[required] required"/>
			</p>
			<p>
				<label>密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
				<input type="password" name="password" id="password" maxlength="32" class="validate[required] required"/>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="button"><div class="buttonContent"><button type="submit">登录</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
