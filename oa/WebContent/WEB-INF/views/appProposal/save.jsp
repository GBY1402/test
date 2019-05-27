<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="pageContent">
	<form method="post" action="${ctx }/appProposal/save" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,dialogReloadNavTab)">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>名称：</label>
				<input name="mobileName" class="validate[required,maxSize[30]] required" type="text" size="30" />
			</p>
			<p>
				<label>APPID：</label>
				<input name="appId" class="validate[required,maxSize[30]] required" type="text" size="30" />
			</p>
			<p>
				<label>APP版本号：</label>
				<input name="appVersion" class="validate[required,maxSize[30]] required" type="text" size="30" />
			</p>
			<p>
				<label>反馈和意见：</label>
				<input name="mobileDescribe" class="validate[required,maxSize[30]] required" type="text" size="30" />
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
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