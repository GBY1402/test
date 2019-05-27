<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="pageContent">
	<form method="post" action="${ctx }/company/update" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,dialogReloadNavTab)">
		<input type="hidden" name="enterId" value="${enterBasicInfo.enterId}"/>
		<input type="hidden" name="createUser" value="${enterBasicInfo.createUser}"/>
		<input type="hidden" name="createTime" value="${enterBasicInfo.createTime}"/>
		<input type="hidden" name="enterLogo" value="${enterBasicInfo.enterLogo}"/>
		<input type="hidden" name="enterBusimes" value="${enterBasicInfo.enterBusimes}"/>
		<c:if test="${enterArdess.regionId != null }">
		<input type="hidden" name="enterArdess.regionId" value="${enterBasicInfo.enterArdess.regionId }"/>
		</c:if>
		<input type="hidden" name="enterArdessX" value="${enterBasicInfo.enterArdessX }"/>
		<input type="hidden" name="enterArdessY" value="${enterBasicInfo.enterArdessY }"/>
		<input type="hidden" name="enterDelete" value="${enterBasicInfo.enterDelete }"/>
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>企业全称：</label>
				<input name="enterName" class="validate[required,maxSize[30]] required" type="text" size="30" value="${enterBasicInfo.enterName }"/>
			</p>
			<p>
				<label>企业简称：</label>
				<input name="enterShortName" class="validate[required,maxSize[30]] required" type="text" size="30" value="${enterBasicInfo.enterShortName }"/>
			</p>
			<p>
				<label>企业性质：</label>
				<select name="enterNature.id" class="validate[required]">
				<c:forEach items="${basicsEnterNature}" var="dopName">
					<option value="${dopName.id }"${enterBasicInfo.enterNature.id==dopName.id?'selected':''}>${dopName.name}</option>
				</c:forEach>
				</select>
				<span><font color="red">*</font></span>
			</p>
			<p>
				<label>融资轮数：</label>
				<select name="enterFinanc.id" class="validate[required]">
				<c:forEach items="${basicsEnterFinanc}" var="dopName">
					<option value="${dopName.id }"${enterBasicInfo.enterFinanc.id==dopName.id?'selected':''}>${dopName.name}</option>
				</c:forEach>
				</select>
				<span><font color="red">*</font></span>
			</p>
			<p>
				<label>企业人数：</label>
				<select name="enterNumber.id" class="validate[required]">
				<c:forEach items="${basicsEnterNumber}" var="dopName">
					<option value="${dopName.id }"${enterBasicInfo.enterNumber.id==dopName.id?'selected':''}>${dopName.name}</option>
				</c:forEach>
				</select>
				<span><font color="red">*</font></span>
			</p>
			<p>
				<label>法人代表：</label>
				<input name="enterLegalPerson" class="validate[required,maxSize[30]] required" type="text" size="30" value="${enterBasicInfo.enterLegalPerson }"/>
			</p>
			<p>
				<label>企业邮箱：</label>
				<input name="enterEmail" class="validate[maxSize[30]] " type="text" size="30" value="${enterBasicInfo.enterEmail }"/>
			</p>
			<p>
				<label>企业电话：</label>
				<input name="enterTelephone" class="validate[maxSize[30]] " type="text" size="30" value="${enterBasicInfo.enterTelephone }"/>
			</p>
			<p>
				<label>行业：</label>
				<select name="enterIndustry.id" class="validate[required]">
				<c:forEach items="${industrylist}" var="dopName">
					<option value="${dopName.id }"${enterBasicInfo.enterIndustry.id==dopName.id?'selected':''}>${dopName.name}</option>
				</c:forEach>
				</select>
				<span><font color="red">*</font></span>
			</p>
			<div class="unit">
				<label>公司LOGO：</label>
				<div class="upload-wrap">
					<input type="file" name="image" accept="image/*">
					<c:if test="${!empty enterBasicInfo.enterLogo}">
						<div class="thumbnail">
							<img src="${enterBasicInfo.enterLogo}" style="max-width: 80px; max-height: 80px">
						<a class="del-icon" href="${ctx}/person/${enterBasicInfo.enterId}/deleteimage" onclick="impage()"></a>
					</div> 
					</c:if>
			</div>
			</div>
			<div class="unit">
				<label>营业执照：</label>
				<div class="upload-wrap">
					<input type="file" name="image" accept="image/*">
					<c:if test="${!empty enterBasicInfo.enterBusimes}">
						<div class="thumbnail">
							<img src="${enterBasicInfo.enterBusimes}" style="max-width: 80px; max-height: 80px">
						<a class="del-icon" href="${ctx}/person/${enterBasicInfo.enterId}/deleteimage" onclick="impage()"></a>
					</div> 
					</c:if>
			</div>
			</div>
			<p>
				<label>企业官网：</label>
				<input name="enterUrl" class="validate[maxSize[30]] " type="text" size="30" value="${enterBasicInfo.enterUrl }"/>
			</p>
			<%-- <p>
				<label>地       区：</label>
				<input name="enterArdess.regionId" class="validate[required,maxSize[30]] required" type="text" size="30" value="${enterBasicInfo.enterArdess.regionName }"/>
			</p> --%>
			<p>
				<label>详细地址：</label>
				<input name="enterArdessDe" class="validate[maxSize[30]] " type="text" size="30" value="${enterBasicInfo.enterArdessDe }"/>
			</p>
			<p>
				<label>企业认证：</label>
				<select name="enterCondition" class="validate[required]">
				<option value="0"${enterBasicInfo.enterCondition==0?'selected':''}>认证中</option>
				<option value="1"${enterBasicInfo.enterCondition==1?'selected':''}>已认证</option>
				<option value="2"${enterBasicInfo.enterCondition==2?'selected':''}>认证未通过</option>
				</select>
				<span><font color="red">*</font></span>
			</p>
			<p>
				<label> 自我描述：</label>
			 <textarea name="enterDescride" cols="30" rows="12" align="center">${enterBasicInfo.enterDescride }</textarea>
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