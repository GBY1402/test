<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx }/skills/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogReloadNavTab)">
		<div class="pageFormContent" layoutH="58">
	        <div class="unit">
				<label>职位：</label>
				<input type="text" size="30" name="functionInfo.name" disabled="disabled" value="${parent.name}" />
				<input type="hidden" name="functionInfo.id" value="${parent.id}">
			</div>
			<div class="unit">
				<label>技能名称：</label>
				<input type="text" name="sName" maxlength="20" size="30" class="validate[required,maxSize[20]] required" />
			</div>
			<div class="unit">
				<label >技能值：</label>
				<textarea rows="3" cols="40" maxlength="200" id="description" name="sValue"  class="textInput" ></textarea>
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