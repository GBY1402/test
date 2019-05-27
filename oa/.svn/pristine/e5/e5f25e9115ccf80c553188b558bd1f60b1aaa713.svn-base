<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="pageContent">
	<form method="post" action="${ctx }/huntingWorryData/edit" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,dialogReloadNavTab)">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="hunWorId" value="${huntingWorryData.hunWorId }" />
			<input type="hidden" name="createUser" value="${huntingWorryData.createUser }" />
			<input type="hidden" name="createTime" value="${huntingWorryData.createTime }" />
			<p>
				<label>职位类型：</label>
				<select name="hunWorAttr" class="validate[required]">
					<option value="0" ${huntingWorryData.hunWorAttr==0?'selected':''}>普通</option>
					<option value="1" ${huntingWorryData.hunWorAttr==1?'selected':''}>急聘</option>
					<option value="2" ${huntingWorryData.hunWorAttr==2?'selected':''}>猎聘</option>
				</select>
			</p>
			<p>
				<label>首笔支付天数：</label>
				<input name="startDay" class="validate[required,maxSize[30]] required" type="text" size="30" value="${huntingWorryData.startDay }" />
			</p>
			<p>
				<label>首笔支付百分比：</label>
				<input name="startPay" class="validate[required,maxSize[30]] required" type="text" size="30" value="${huntingWorryData.startPay }" />
			</p>
			<p>
				<label>尾笔支付天数：</label>
				<input name="endDay" class="validate[required,maxSize[30]] required" type="text" size="30" value="${huntingWorryData.endDay }" />
			</p>
			<p>
				<label>尾笔支付百分比：</label>
				<input name="endPay" class="validate[required,maxSize[30]] required" type="text" size="30" value="${huntingWorryData.endPay }" />
			</p>
			<p>
				<label>状态：</label>
				<select name="deleteData" class="validate[required]">
					<option value="0"${huntingWorryData.deleteData==0?'selected':''}>未删除</option>
					<option value="1"${huntingWorryData.deleteData==1?'selected':''}>已删除</option>
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