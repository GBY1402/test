<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="pageContent">
    <form method="post" action="${ctx}/companyAgreement/edit" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,dialogReloadNavTab)">
    	<input type="hidden" name="createTime" value="${model.createTime }" />
    	<input type="hidden" name="createUser" value="${model.createUser }" />
    	<input type="hidden" name="agreementId" value="${model.agreementId }" />
        <div class="pageFormContent" layoutH="50">
        	<div class="unit">
                <label>选择企业：</label>
				<input name="enterBasicInfo.enterId" value="${model.enterBasicInfo.enterId }" type="hidden" readonly="readonly" />
				<input name="enterBasicInfo.enterName" class="validate[required,maxSize[30]] required" size="30" value="${model.enterBasicInfo.enterName }" readonly="readonly" />
				<a class="btnLook" href="${ctx }/company/lookup" lookupGroup="enterBasicInfo" rel="lookup2organization_add" title="选择企业" width="600">查找带回</a>
           </div>
           <div class="unit">
                <label>急聘签约状态：</label>
                <select name="wantedState">
                <option value="" >请选择</option>
                <option value="0" ${model.wantedState == '0' ? 'selected' : ''}>未签约</option>
                <option value="1" ${model.wantedState == '1' ? 'selected' : ''}>签约中</option>
                <option value="2" ${model.wantedState == '2' ? 'selected' : ''}>已签约</option>
                </select>
           </div>
           <div class="unit">
                <label>急聘文件地址：</label>
				<input name="wantedURL" class="validate[maxSize[200]] " size="60" value="${model.wantedURL }" />
           </div>
           <div class="unit">
                <label>猎聘签约状态：</label>
                <select name="huntingState">
                <option value="" >请选择</option>
                <option value="0" ${model.huntingState == '0' ? 'selected' : ''}>未签约</option>
                <option value="1" ${model.huntingState == '1' ? 'selected' : ''}>签约中</option>
                <option value="2" ${model.huntingState == '2' ? 'selected' : ''}>已签约</option>
                </select>
           </div>
           <div class="unit">
                <label>猎聘文件地址：</label>
				<input name="number" class="validate[maxSize[200]] " size="60" value="${model.number }" />
           </div>
        </div> 
        <div class="formBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="submitForm();">提交</button></div></div></li>
                <li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
            </ul>
        </div>
    </form>
</div>
