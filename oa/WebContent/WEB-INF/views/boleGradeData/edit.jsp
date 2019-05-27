<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="pageContent">
	<form method="post" action="${ctx }/boleGradeData/edit" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,dialogReloadNavTab)">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="boleDataId" value="${boleGradeData.boleDataId }" />
			<input type="hidden" name="createUser" value="${boleGradeData.createUser }" />
			<input type="hidden" name="createTime" value="${boleGradeData.createTime }" />
			<p>
				<label>等级：</label>
				<input name="boleGrade" class="validate[required,maxSize[30]] required" type="text" size="30" value="${boleGradeData.boleGrade }" />
			</p>
			<p>
				<label>经验：</label>
				<input name="boleExperience" class="validate[required,maxSize[30]] required" type="text" size="30" value="${boleGradeData.boleExperience }" />
			</p>
			<p>
				<label>名称：</label>
				<input name="gradeName" class="validate[required,maxSize[30]] required" type="text" size="30" value="${boleGradeData.gradeName }" />
			</p>
			<p>
				<label>佣金限制：</label>
				<input name="boleMoney" class="validate[required,maxSize[30]] required" type="text" size="30" value="${boleGradeData.boleMoney }" />
			</p>
			<p>
				<label>状态：</label>
				<select name="deleteData" class="validate[required]">
					<option value="1"${boleGradeData.deleteData==1?'selected':''}>已删除</option>
					<option value="0"${boleGradeData.deleteData==0?'selected':''}>未删除</option>
				</select>
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