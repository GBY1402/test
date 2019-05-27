<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="pageContent">
	<form method="post" action="${ctx }/basics/edit" class="pageForm required-validate" onsubmit="return iframeCallback(this, dialogReloadNavTab)">
		<div class="pageFormContent" layoutH="58">
			<input type="hidden" name="id" value="${basicsData.id }"/>
			<input type="hidden" name="cGrade" value="${basicsData.cGrade }"/>
	        <div class="unit">
				<label>父节点：</label>
				<input type="text" size="30" name="parent.name" disabled="disabled" value="${basicsData.parent.name}" />
				<input type="hidden" name="parent.id" value="${basicsData.parent.id}">
			</div>
			<div class="unit">
				<label>名称：</label>
				<input type="text" name="name" maxlength="20" size="30" class="validate[required,maxSize[20]] required" value="${basicsData.name }" />
			</div>
			<div class="unit">
				<label >所属名称：</label>
				<input type="text" name="sn" maxlength="20" size="30" class="validate[required,maxSize[20]] required" value="${basicsData.sn }" />
			</div>
			<div class="unit">
				<label >顺序等级：</label>
				<input type="text" name="grade" maxlength="20" size="30" min="1" class="validate[required,maxSize[20]] required" value="${basicsData.grade }" />
			</div>		
			<div class="unit">
				<label >描述：</label>
				<textarea rows="3" cols="40" maxlength="200" id="description" name="description"  class="textInput" >${basicsData.description }</textarea>
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