<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="pageContent">
    <form method="post" action="${ctx}/resume/create"  enctype="multipart/form-data" name="resumeBasic" class="pageForm required-validate" onsubmit="return iframeCallback(this, dialogReloadNavTab)">
        <div class="pageFormContent" layoutH="50">
            <fieldset style="width:95%; margin: 0px auto;">
               <legend>基本信息</legend>
               <p>
                    <label>简历名称：</label>
                    <input name="personJobName" class="validate[required,maxSize[30]] required" size="30" />
               </p>
               <p>
			<label>所属用户：</label>	
			<input class="validate[required] required" name="humanBasicInfo.humanId" type="hidden" readonly="readonly" />
			<input class="validate[required] required" name="humanBasicInfo.humanName" type="text" readonly="readonly" />
			<a class="btnLook" href="${ctx }/person/personlookup?deleteBasic=0" lookupGroup="humanBasicInfo" rel="lookup2organization_add" title="选择企业名称" width="600">查找带回</a>	
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