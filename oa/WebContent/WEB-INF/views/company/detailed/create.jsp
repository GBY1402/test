<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="pageContent">
	<form method="post" action="${ctx }/hrWalletDetail/create" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,dialogReloadNavTab)">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>金额：</label>
				<input name="money" class="validate[required,maxSize[30]] required" type="text" size="30" />
			</p>
			<p>
				<label>订单号：</label>
				<input name="orderNumber" class="validate[required,maxSize[30]] required" type="text" size="30" />
			</p>
			<p>
				<label>状态：</label>
				<select name="state" class="validate[required]">
					<option value="">请选择</option>
					<option value="0">收入</option>
					<option value="1">提现</option>
				</select>
				<span><font color="red">*</font></span>
			</p>
			<p>
				<label>类型：</label>
				<select name="type" class="validate[required]">
					<option value="">请选择</option>
					<option value="0">微信 </option>
					<option value="1">支付宝</option>
					<option value="2">平台钱包</option>
				</select>
				<span><font color="red">*</font></span>
			</p>
			<p>
				<label>进度：</label>
				<select name="progress" class="validate[required]">
					<option value="">请选择</option>
					<option value="0">结算成功 </option>
					<option value="1">结算中</option>
					<option value="2">结算失败</option>
				</select>
				<span><font color="red">*</font></span>
			</p>
			<p>
			<label>所属HR：</label>	
			<input name="enterHRWalletInfo.walletID" type="hidden" />
			<input class="validate[required] required" name="enterHRWalletInfo.enterPersonInfo.humanBasicInfo.humanName" type="text" readonly="readonly" />
			<a class="btnLook" href="${ctx }/hrWallet/hrLookupByWallet" lookupGroup="enterHRWalletInfo" rel="lookup2organization_add" title="选择HR" width="600">查找带回</a>	
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