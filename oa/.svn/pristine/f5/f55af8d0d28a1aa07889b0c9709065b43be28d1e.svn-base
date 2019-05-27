<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<a id="refreshJbsxBox2organizationTree" rel="jbsxBox2organizationTree" target="ajax" href="${request.contextPath}/management/security/organization/tree" style="display:none;"></a>
<div class="pageContent">
<form method="post" action="${ctx }/management/security/organization/create" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadRel2Org);">
	<input type="hidden" name="parent.id" value="${parentOrganizationId }"/>
	<div class="pageFormContent" layoutH="58">
		<dl>
			<dt>名称：</dt>
			<dd>
				<input type="text" name="name" class="validate[required,maxSize[64]] required" size="32" maxlength="64" alt="请输入组织名称"/>
			</dd>
		</dl>		
		<dl>
			<dt>描述：</dt>
			<dd>
				<textarea name="description" cols="28" rows="3" maxlength="255"></textarea>
			</dd>
		</dl>	
	</div>
			
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>

<h2 class="contentTitle">tree查找带回</h2>

<div class="pageContent">
<form action="demo/common/ajaxDone.html" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">

	<div class="pageFormContent" layoutH="97">
		<dl class="nowrap">
			<dt>城市：</dt>
			<dd>
				<input class="required" name="district.cityName" type="text" readonly/>
			</dd>
		</dl>
		
		<dl class="nowrap">
			<dt>区县：</dt>
			<dd>
				<input name="district.id" value="" type="hidden"/>
				<input class="required" name="district.districtName" type="text" readonly/>
				<a class="btnLook" href="demo/database/treeLookup.html" lookupGroup="district">查找带回</a>	
			</dd>
		</dl>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>