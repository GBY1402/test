<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	<form method="post" action="${ctx }/apk/create" enctype="multipart/form-data" class="required-validate pageForm" onsubmit="return iframeCallback(this,dialogReloadNavTab)">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>描述：</label>
				<input name="name" class="validate[required,maxSize[30]] required" type="text" size="30" />
			</p>
			<p>
				<label>版本号：</label>
				<input name="version" class="validate[required,maxSize[30]] required" type="text" size="30" />
			</p>
			<p>
				<label>路径：</label>
				<input name="path" class="validate[required,maxSize[30]] required" type="text" size="30" />
			</p>
			<p>
				<label>类型：</label>
				<select name="apkType" class="validate[required]">
					<option value="" selected>请选择</option>
					<option value="0">个人安卓</option>
					<option value="1">个人IOS</option>
					<option value="2">企业安卓</option>
					<option value="3">企业IOS</option>
				</select>
				<span><font color="red">*</font></span>
			</p>
			<p>
				<label>状态：</label>
				<select name="state" class="validate[required]">
					<option value="" selected>请选择</option>
					<option value="1">发布</option>
					<option value="2">停止</option>
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