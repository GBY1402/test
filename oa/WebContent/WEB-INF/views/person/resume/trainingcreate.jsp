<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="pageContent">
	<form method="post" action="${ctx }/resume/showResumeTrainingAdd"  class="required-validate pageForm" onsubmit="return iframeCallback(this,dialogReloadNavTab)">
		<input type="hidden" name="personJobInfo.personJobId" value="${personJobId}"/>
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>学校名称：</label>
				<input name="trainName" class="validate[required,maxSize[30]] required" type="text" size="30" />
			</p>
			
			<p>
				<label>专业名称：</label>
				<input name="trainMajor" class="validate[required,maxSize[32]] required" size="30" />
			</p>
			 <p>
				<label>开始时间：</label>
				  <input name="trainStart" type="text" class="validate[required,custom[date],past[#regulartime]] text-input date required" size="30" readonly="readonly" minDate="{%y-100}-%M-%d" maxDate="{%y}-%M-{%d}" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>结束时间：</label>
				 <input name="trainEnd" type="text" class="validate[required,custom[date],past[#regulartime]] text-input date required" size="30" readonly="readonly" minDate="{%y-100}-%M-%d" maxDate="{%y}-%M-{%d}" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label> 在校经历：</label>
			 <textarea name="trainExper" cols="30" rows="12" align="center" ></textarea>
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