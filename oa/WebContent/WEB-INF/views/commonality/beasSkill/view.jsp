<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
		<div class="pageFormContent" layoutH="58">
	        
	         <div class="unit">
				<label>父节点：</label>
				<input type="text" size="30" name="parent.name" disabled="disabled" value="${industrySkillsInfo.parent.name}" />
			</div>
	        
			<div class="unit">
				<label>名称：</label>
				<input type="text" name="name" size="30" disabled="disabled" maxlength="20" class="required" value="${industrySkillsInfo.name}"/>
			</div>
			<div class="unit">
				<label >描述：</label>
				<textarea rows="3" cols="40" disabled="disabled"  maxlength="200" id="description" name="description"  class="textInput" >${industrySkillsInfo.description }</textarea>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
</div>
