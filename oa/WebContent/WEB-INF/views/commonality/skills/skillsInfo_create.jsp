<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	 <form method="post" action="${ctx }/resume/skillpoint" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogReloadNavTab)">
		<div class="pageFormContent" layoutH="56">
				<label>技能点选择：</label>
				<input type="hidden" name="id" value="${id }">
           <input type="hidden" name="ids" value="${sid }">
           <c:forEach items="${map }" var="skillsInfoslist" varStatus="findex">
			<p>
			<label>
           <c:forEach items="${skillsInfoslist.value }" var="skillsInfos" varStatus="st">
			 <c:if test="${st.index==1}">
			 ${skillsInfos.functionInfo.name }
			 </c:if>
			</c:forEach>
           </label>
			<c:forEach items="${skillsInfoslist.value }" var="skillsInfos"  >
			 <input type="radio" type="hidden" name="SkillsInfos[${findex.index }].sId" value="${skillsInfos.sId }"/>${skillsInfos.sName }
			</c:forEach>
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