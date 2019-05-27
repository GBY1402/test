<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	 <form method="post" action="${ctx }/resume/skillpoint" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogReloadNavTab)">
		<div class="pageFormContent" layoutH="56">
			<c:forEach items="${info }" var="var">
			<p>
			<label>
			 ${var.name }
           </label>
			<a class="btnSelect" href="javascript:$.bringBack({id:'${var.id }', name:'${var.name }', 'parent.id':'${var.parent.id }', 'parent.name':'${var.parent.name }'})" title="用户信息">选择</a>
			</p>			
			</c:forEach>
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