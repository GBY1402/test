<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<form method="post" action="${ctx }/person/save" class="pageForm required-validate" onsubmit="return iframeCallback(this,dialogReloadNavTab)">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>账号：</label>
				<input name="userName" class="validate[required,maxSize[30]] required" type="text" size="30" />
			</p>
			<p>
				<label>密码：</label>
				<input name="password" class="validate[required,maxSize[30]] required" type="text" size="30" />
			</p>
			<p>
				<label>账号属性：</label>
				<select name="userType" class="validate[required]">
					<option value="">请选择</option>
					<option value="0">个人</option>
					<option value="1">企业</option>
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