<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	<form method="post" action="${ctx }/employee/${employee.pkid}/update" class="required-validate pageForm" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input type="hidden" name="pkid" value="${employee.pkid}">
		
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>工号：</label>
				<input name="jobnum" class="validate[required,maxSize[30]] required" type="text" size="30"  value="${employee.jobnum }" readonly="readonly"/>
			</p>
			<p>
				<label>姓名：</label>
				<input name="name" class="validate[required,maxSize[32]] required" size="30"  value="${employee.name }"/>
			</p>
			<p>
				<label>性别：</label>
				<select name="sex" class="validate[required]">
					<option value="1" ${employee.sex==1?'selected':''}>男</option>
					<option value="2" ${employee.sex==2?'selected':''}>女</option>
				</select>
				<span><font color="red">*</font></span>
			</p>
			<p>
				<label>合同编号：</label>
				<input name="contractid" class="validate[required,maxSize[32]] required" size="30"  value="${employee.contractid }"/>
			</p>
			<p>
				<label>合同开始时间：</label>
				<input name="contractstarttime" type="text" class="validate[required,custom[date],past[#contractendtime]] text-input date required" size="30" readonly="readonly" value="<fmt:formatDate value='${employee.contractstarttime}' pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>合同终止时间：</label>
				<input name="contractendtime" type="text" class="validate[required,custom[date],future[#contractstarttime]] text-input date required" size="30" readonly="readonly" value="<fmt:formatDate value='${employee.contractendtime}' pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>年龄：</label>
				<input name="age" class="validate[required,custom[integer],min[18],max[70]] required" type="text" size="30" value="${employee.age }"/>
			</p>
			<p>
				<label>部门：</label>
				<input type="text" class="validate[required] required" size="30" name="organization.name" disabled="disabled" value="${employee.organization.name }" />
				<input type="hidden" name="organization.id" value="${employee.organization.id }">
				<a width="240" height="360" class="btnLook"  lookupGroup="organization" href="${ctx}/employee/lookupOrga/0" onclick ="hideCalendar()">组织结构</a>
			</p>
			<p>
				<label>身份证号：</label>
				<input name="cardid" class="text-input validate[required,custom[chinaId]] required" type="text" size="30" value="${employee.cardid }"/>
			</p>
			<p>
				<label>岗位：</label>
				<input name="job" class="validate[required,maxSize[32]] required" type="text" size="30"  value="${employee.job }"/>
			</p>
			<p>
				<label>技能：</label>
				<input name="skill" class="validate[required,maxSize[32]] required" type="text" size="30"  value="${employee.skill }"/>
			</p>
			<p>
				<label>毕业院校：</label>
				<input name="toschool" class="validate[maxSize[32]]" type="text" size="30"  value="${employee.toschool }"/>
			</p>
			<p>
				<label>专业：</label>
				<input name="major" class="validate[maxSize[32]]" type="text" size="30"  value="${employee.major }"/>
			</p>
			<p>
				<label>学历：</label>
				<select name="educationColl" class="validate[required]">
					<c:forEach items="${edtypes}" var="type" >
						<option <c:if test="${employee.educationColl==type}">selected</c:if> value="${type}">${type.info }</option>
					</c:forEach>
				</select>
				<span><font color="red">*</font></span>
				
			</p>
			<p>
				<label>联系电话：</label>
				<input name="phone" class="validate[custom[phone]] text-input" type="text" size="30"  value="${employee.phone }"/>
			</p>
			<p>
				<label>出生年月：</label>
				<input name="birthday" type="text" class="validate[required,custom[date]] text-input date required" dateFmt="yyyy-MM-dd"  size="30" minDate="{%y-100}-%M-%d" maxDate="{%y}-%M-{%d}" readonly="readonly" value="<fmt:formatDate value='${employee.birthday}' pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>婚姻状况：</label>
				<select name="maritalstatus" class="validate[required]">
					<option value="1" ${employee.maritalstatus==1?'selected':''}>未婚</option>
					<option value="2" ${employee.maritalstatus==2?'selected':''}>已婚</option>
				</select>
				<span><font color="red">*</font></span>
			</p>
			<p>
				<label>户口所在地：</label>
				<input name="domicileplace" class="validate[maxSize[50]]" type="text" size="30" value="${employee.domicileplace }"/>
			</p>
			<p>
				<label>家庭地址：</label>
				<input name="homeaddress" class="validate[required,maxSize[50]] required" type="text" size="30" value="${employee.homeaddress }"/>
			</p>
			<p>
				<label>紧急联络人：</label>
				<input name="emergencyContact" class="validate[maxSize[20]] " type="text" size="30" value="${employee.emergencyContact }"/>
			</p>
			<p>
				<label>紧急联络人电话：</label>
				<input name="emergencyContactphone" class="validate[custom[phone]] text-input" type="text" size="30" value="${employee.emergencyContactphone }"/>
			</p>
			<p>
				<label>招聘渠道：</label>
				<select name="recruitmentChannel" class="validate[required]">
					<c:forEach items="${types}" var="type" >
						<option <c:if test="${employee.recruitmentChannel==type}">selected</c:if> value="${type}">${type.info }</option>
					</c:forEach>
				</select>
				<span><font color="red">*</font></span>
				
			</p>
			<p>
				<label>年假：</label>
				<select name="isyearleave" class="validate[required]">
					<option value="1" ${employee.isyearleave==1?'selected':''}>有</option>
					<option value="2" ${employee.isyearleave==2?'selected':''}>无</option>
				</select>
				<span><font color="red">*</font></span>
			</p>
			<p>
				<label>入职时间：</label>
				<input name="entrytime" type="text" class="validate[required,custom[date],past[#regulartime]] text-input date required" size="30" readonly="readonly" minDate="{%y-100}-%M-%d" maxDate="{%y}-%M-{%d}" value="<fmt:formatDate value='${employee.entrytime}' pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>是否转正：</label>
				<select name="isorregular" class="validate[required]">
					<option value="1" ${employee.isorregular==1?'selected':''}>是</option>
					<option value="2" ${employee.isorregular==2?'selected':''}>否</option>
				</select>
				<span><font color="red">*</font></span>
			</p>
			<p>
				<label>转正时间：</label>
				<input name="regulartime" type="text" class="validate[custom[date],future[#entrytime]] text-input date" size="30" readonly="readonly" value="<fmt:formatDate value='${employee.regulartime}' pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>岗位状态：</label>
				<select name="stateType" class="validate[required]">
					<c:forEach items="${stateTypes}" var="type" >
						<option <c:if test="${employee.stateType==type}">selected</c:if> value="${type}">${type.info }</option>
					</c:forEach>
				</select>
				<span><font color="red">*</font></span>
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