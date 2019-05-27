<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="pageContent">
	<form method="post" action="${ctx }/hrWallet/create" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,dialogReloadNavTab)">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>余额：</label>
				<input name="balance" class="validate[required,maxSize[30]] required" type="text" size="30" />
			</p>
			<p>
				<label>账户状态：</label>
				<select name="state" class="validate[required]">
					<option value="">请选择</option>
					<option value="0">正常</option>
					<option value="1">冻结</option>
					<option value="2">结算中</option>
				</select>
				<span><font color="red">*</font></span>
			</p>
			<p>
			<label>所属HR：</label>	
			<input name="enterPersonInfo.enterPerId" type="hidden" />
			<input class="validate[required] required" name="enterPersonInfo.humanBasicInfo.humanName" type="text" readonly="readonly"/>
			<a class="btnLook" href="${ctx }/recruit/hrLookup" lookupGroup="enterPersonInfo" rel="lookup2organization_add" title="选择HR" width="600">查找带回</a>	
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