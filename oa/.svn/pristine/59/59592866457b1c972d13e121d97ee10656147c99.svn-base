<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
function myFunction(){
	var reads = new FileReader();
    var x=document.getElementById("inputimg").files[0];
    reads.readAsDataURL(x);
    reads.onload = function(e) {
    document.getElementById('myimg').src = this.result;
    }
 }
</script>
<div class="pageContent">
	<form method="post" action="${ctx }/person/update" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,dialogReloadNavTab)">
		<input type="hidden" name="humanId" value="${humanBasicInfo.humanId}"/>
		<input type="hidden" name="createUser" value="${humanBasicInfo.createUser}"/>
		<input type="hidden" name="createTime" value="${humanBasicInfo.createTime}"/>
		<input type="hidden" name="deleteBasic" value="${humanBasicInfo.deleteBasic}"/>
		<input name="humanImage" type="hidden" value="${humanBasicInfo.humanImage}">
		<input name="userAddInfo.userId" type="hidden" value="${humanBasicInfo.userAddInfo.userId}">
		<input name="enterPersonInfo.enterPerId" type="hidden" value="${humanBasicInfo.enterPersonInfo.enterPerId}">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>姓名：</label>
				<input name="humanName" class="validate[required,maxSize[30]] required" type="text" size="30" value="${humanBasicInfo.humanName }"/>
			</p>
			<div class="unit">
				<label>上传头像：</label>
				<div class="upload-wrap">
					<input id="inputimg" type="file" name="image" accept="image/*" onchange="myFunction()">
					 <c:if test="${!empty humanBasicInfo.humanImage}">
						<div class="thumbnail">
							<img  src="${humanBasicInfo.humanImage}" style="max-width: 80px; max-height: 80px">
						<a class="del-icon" href="${ctx}/person/${humanBasicInfo.humanId}/deleteimage" onclick="impage()"></a>
					</div> 
					</c:if>
					<div class="thumbnail">
							<img id="myimg" style="max-width: 80px; max-height: 80px">
					</div> 
			</div>
			</div>
			<p>
				<label>身份证：</label>
				<input name="humanCard" class="validate[maxSize[32]] " value="${humanBasicInfo.humanCard }"/>
			</p>
			<p>
				<label>实名认证：</label>
				<select name="nameAuthent">
					<option value="1"${humanBasicInfo.nameAuthent==1?'selected':''}>已认证</option>
					<option value="0"${humanBasicInfo.nameAuthent==0?'selected':''}>未认证</option>
				</select>
			</p>
			<p>
				<label>性别：</label>
				<select name="humanSex">
					<option value="">请选择</option>
					<option value="1"${humanBasicInfo.humanSex== '0' ? 'selected' : ''}>女</option>
					<option value="0"${humanBasicInfo.humanSex== '1' ? 'selected' : ''}>男</option>
				</select>
			</p>
			<p>
				<label>身份：</label>
				<select name="humanIdentity">
					<option value="">请选择</option>
					<option value="1"${humanBasicInfo.humanIdentity==1?'selected':''}>蒸蒸日上</option>
					<option value="0"${humanBasicInfo.humanIdentity==0?'selected':''}>莘莘学子</option>
				</select>
			</p>
			<p>
				<label>学历：</label>
				<select name="humanDiploma.id" >
				<option value="">请选择</option>
				<c:forEach items="${basicsDataInfo}" var="dopName">
					<option value="${dopName.id }"${humanBasicInfo.humanDiploma.id==dopName.id?'selected':''}>${dopName.name}</option>
				</c:forEach>
				</select>
			</p>
			<p>
				<label> 出生日期：</label>
				  <input name="humanBirthday" type="text" class="validate[custom[date],past[#regulartime]] text-input date " size="30" readonly="readonly" minDate="{%y-100}-%M-%d" maxDate="{%y}-%M-{%d}" value='<fmt:formatDate value='${humanBasicInfo.humanBirthday }' pattern="yyyy-MM-dd"/>'/><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label> 手机号：</label>
				<input name="humanPhone" class="validate[maxSize[32]] " value="${humanBasicInfo.humanPhone }"/>
			</p>
			<p>
				<label> 微信：</label>
				<input name="humanWechat" class="validate[maxSize[32]] " value="${humanBasicInfo.humanWechat }"/>
			</p>
			<p>
				<label> QQ：</label>
				<input name="humanQQ" class="validate[maxSize[32]] " value="${humanBasicInfo.humanQQ }"/>
			</p>
			<p>
				<label> 邮箱：</label>
				<input name="humanEmail" class="validate[maxSize[32]]" value="${humanBasicInfo.humanEmail }"/>
			</p>
			<p>
				<label>详细地址：</label>
				<input name="humanDetailed" class="validate[maxSize[32]] " value="${humanBasicInfo.humanDetailed }"/>
			</p>
			<p>
				<label>身高：</label>
				<input name="humanHeight" class="validate[maxSize[32]] " value="${humanBasicInfo.humanHeight }"/>
			</p>
			<p>
				<label>体重：</label>
				<input name="humanWeight" class="validate[maxSize[32]] " value="${humanBasicInfo.humanWeight }"/>
			</p>
			<p>
				<label> 自我描述：</label>
			 <textarea name="humanDescription" cols="30" rows="12" align="center">${humanBasicInfo.humanDescription }</textarea>
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