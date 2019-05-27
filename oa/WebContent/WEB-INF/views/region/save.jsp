<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx }/region/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogReloadNavTab)">
		<div class="pageFormContent" layoutH="58">
			<input type="hidden" name="cGrade" value="${parent.level + 1 }"/>
	        <div class="unit">
				<label>父节点：</label>
				<input type="text" size="30" disabled="disabled" value="${parent.regionName}" />
				<input type="hidden" name="parentId.regionId" value="${parent.regionId}">
				<input type="hidden" name="level" value="${parent.level + 1}">
			</div>
			<div class="unit">
				<label>区域编号：</label>
				<input type="text" name="regionId" maxlength="20" size="30" class="validate[required,maxSize[20]] required" />
			</div>
			<div class="unit">
				<label>区域名称：</label>
				<input type="text" name="regionName" maxlength="20" size="30" class="validate[required,maxSize[20]] required" />
			</div>
			<div class="unit">
				<label>短名称：</label>
				<input type="text" name="shortName" maxlength="20" size="30" class="validate[required,maxSize[20]] required" />
			</div>
			<div class="unit">
				<label>邮政编码：</label>
				<input type="text" name="zipcode" maxlength="20" size="30" class="validate[required,maxSize[20]] required" />
			</div>
			<div class="unit">
				<label>区域拼音：</label>
				<input type="text" name="pinyin" maxlength="20" size="30" class="validate[required,maxSize[20]] required" />
			</div>
			<div class="unit">
				<label>长：</label>
				<input type="text" name="lng" maxlength="20" size="30" class="validate[required,maxSize[20]] required" />
			</div>
			<div class="unit">
				<label>短：</label>
				<input type="text" name="lat" maxlength="20" size="30" class="validate[required,maxSize[20]] required" />
			</div>
			<div class="unit">
				<label>父类字符串全称：</label>
				<input type="text" name="position" maxlength="20" size="30" class="validate[required,maxSize[20]] required" />
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>