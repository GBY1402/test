<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="pageContent">
    <form method="post" action="${ctx}/resume/resumeBasicUpdate"  enctype="multipart/form-data" name="resumeBasic" class="pageForm required-validate" onsubmit="return iframeCallback(this, dialogReloadNavTab)">
        <div class="pageFormContent" layoutH="50">
            <input name="personJobId" type="hidden" value="${personJobInfo.personJobId}">
            <input name="createUser" type="hidden" value="${personJobInfo.createUser}">
            <input name="createTime" type="hidden" value="${personJobInfo.createTime}">
            <input name="humanBasicInfo.humanId" type="hidden" value="${personJobInfo.humanBasicInfo.humanId}">
            <c:if test="${personJobInfo.personWorkArdess.regionId != null}">
            	<input name="personWorkArdess.regionId" type="hidden" value="${personJobInfo.personWorkArdess.regionId}">
            </c:if>
            <input name="personDeleteStatus" type="hidden" value="${personJobInfo.personDeleteStatus}">
            <fieldset style="width:95%; margin: 0px auto;">
               <legend>基本信息</legend>
               <p>
                    <label>简历名称：</label>
                    <input name="personJobName" class="validate[required,maxSize[30]] required" size="30" value="${personJobInfo.personJobName}" />
               </p>
                <p>
		            <label>期望薪资：</label>
                   <select name="personPayStart.id" class="validate[required]">
				<c:forEach items="${basicsDataInfo}" var="dopName">
					<option value="${dopName.id }"${personJobInfo.personPayStart.name==dopName.name?'selected':''}>${dopName.name}</option>
				</c:forEach>
				</select>
                    <span><font color="red">*</font></span>
		       </p>
               <p>
				<label>开始工作时间：</label>
				  <input name="personJobWork" type="text" class="validate[required,custom[date],past[#regulartime]] text-input date required" size="30" readonly="readonly" minDate="{%y-100}-%M-%d" maxDate="{%y}-%M-{%d}" value='<fmt:formatDate value="${personJobInfo.personJobWork }" pattern="yyyy-MM-dd"/>'/><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
            <p>
                    <label>工作年数：</label>
                    <input name="jobWorkYear" class="validate[required,maxSize[30]] required" size="30" value="${personJobInfo.jobWorkYear}" />
               </p>
              <p>
		            <label>简历开关：</label>
                   <select name="personToggle" class="validate[required]">
					<option value="0"${personJobInfo.personToggle==0?'selected':''}>开启求职</option>
					<option value="1"${personJobInfo.personToggle==1?'selected':''}>关闭求职</option>
				</select>
                    <span><font color="red">*</font></span>
		       </p>
              
               <p class="nowrap">
                    <label>行业：</label>  
                    <input class="validate[required] required" name="personFunction.parent.id" value="${personJobInfo.personIndustry.id }" type="hidden" readonly="readonly"/>
                    <input class="validate[required] required" name="personFunction.parent.name" value="${personJobInfo.personIndustry.name }" type="text" readonly="readonly"/>
               </p> 
               
               <p class="nowrap">
                    <label>职位：</label>  
                    <input class="validate[required] required" name="personFunction.id" value="${personJobInfo.personFunction.id }" type="hidden" readonly="readonly"/>
                    <input class="validate[required] required" name="personFunction.name" value="${personJobInfo.personFunction.name }" type="text" readonly="readonly"/>
                    <a class="btnLook" rel="addskill" width="850" height="700" href="${ctx }/industryskills/2/lookup" lookupGroup="personFunction" title="选择用户" >查找带回</a>  
               </p>
           </fieldset>
        </div>
        <div class="formBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="submitForm();">提交</button></div></div></li>
                <li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
            </ul>
        </div>
    </form>
</div>