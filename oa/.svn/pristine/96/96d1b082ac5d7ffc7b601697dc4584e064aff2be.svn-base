<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="pageContent">
	<form method="post" action="${ctx }/resume/showResumeWorkAdd"  class="required-validate pageForm" onsubmit="return iframeCallback(this,dialogReloadNavTab)">
		<input type="hidden" name="personJobInfo.personJobId" value="${personJobId}"/>
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>公司名称：</label>
				<input name="resumeName" class="validate[required,maxSize[30]] required" type="text" size="30" />
			</p>
			
			<p>
				<label>公司电话：</label>
				<input name="resumePhone" class="validate[required,maxSize[32]] required" size="30" />
			</p>
			<p>
				<label>工作职位：</label>
				<input name="resumePosition" class="validate[required,maxSize[32]] required" size="30" />
			</p>
			<p>
				<label>所属部门：</label>
				<input name="resumeDepartment" class="validate[required,maxSize[32]] required" size="30" />
			</p>
			 <p>
				<label>开始工作时间：</label>
				  <input name="startDate" type="text" class="validate[required,custom[date],past[#regulartime]] text-input date required" size="30" readonly="readonly" minDate="{%y-100}-%M-%d" maxDate="{%y}-%M-{%d}" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>结束时间：</label>
				 <input name="endDate" type="text" class="validate[required,custom[date],past[#regulartime]] text-input date required" size="30" readonly="readonly" minDate="{%y-100}-%M-%d" maxDate="{%y}-%M-{%d}" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
		            <label>薪资：</label>
                   <select name="personPayStart.id" class="validate[required]">
				<c:forEach items="${basicsDataInfo}" var="dopName">
					<option value="${dopName.id }"${personJobInfo.personPayStart.id==dopName.id?'selected':''}>${dopName.name}</option>
				</c:forEach>
				</select>
                    <span><font color="red">*</font></span>
		       </p>
			<p>
				<label>职责描述：</label>
			 <textarea name="resumeDescribe" cols="30" rows="12" align="center" ></textarea>
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