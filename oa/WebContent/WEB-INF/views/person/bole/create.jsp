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
	<form method="post" action="${ctx }/bole/create" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,dialogReloadNavTab)">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>伯乐昵称：</label>
				<input name="boleName" class="validate[required,maxSize[30]] required" type="text" size="30" />
			</p>
			<div class="unit">
				<label>伯乐头像：</label>
				<div class="upload-wrap">
					<input id="inputimg" type="file" name="image" accept="image/*" onchange="myFunction()"/>
					<div class="thumbnail">
							<img id="myimg" style="max-width: 80px; max-height: 80px">
					</div> 
				</div>
			</div>
			<p>
			<label>所属用户：</label>	
			<input name="humanBasicInfo.humanId" value="${humanBasicInfo.humanId}" type="hidden" />
			<input class="validate[required] required" name="humanBasicInfo.humanName" type="text" readonly="readonly" value="${humanBasicInfo.humanName }"/>
			<a class="btnLook" href="${ctx }/person/personlookup?deleteBasic=0" lookupGroup="humanBasicInfo" rel="lookup2organization_add" title="选择企业名称" width="600">查找带回</a>	
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