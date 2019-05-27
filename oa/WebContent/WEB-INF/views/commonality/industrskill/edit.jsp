<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx }/industry/update" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogReloadNavTab)">
		<div class="pageFormContent" layoutH="58">
	        <input type="hidden" name="id" value="${representativeInfo.id }">
	        <input type="hidden" name="level" value="${representativeInfo.level }">
	         <div class="unit">
				<label>父节点：</label>
				<input type="text" size="30" name="parent.name" disabled="disabled" value="${representativeInfo.parent.name}" />
				<input type="hidden" name="parent.id" value="${representativeInfo.parent.id }">
			</div>
			<div class="unit">
				<label>行业名称：</label>
				<input type="text" name="name" size="30" maxlength="20" class="validate[required,maxSize[20]] required" value="${representativeInfo.name}"/>
			</div>
			<div class="unit">
				<label >描述：</label>
				<textarea rows="3" cols="40" maxlength="200" id="description" name="description"  class="textInput" >${representativeInfo.description }</textarea>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
