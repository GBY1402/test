<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="pageContent">
    <form method="post" action="${ctx}/companyAgreement/save" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,dialogReloadNavTab)">
        <div class="pageFormContent" layoutH="50">
        	<div class="unit">
                <label>选择企业：</label>
				<input name="enterBasicInfo.enterId" type="hidden" readonly="readonly" />
				<input name="enterBasicInfo.enterName" class="validate[required,maxSize[30]] required" size="30" readonly="readonly" />
				<a class="btnLook" href="${ctx }/company/lookup" lookupGroup="enterBasicInfo" rel="lookup2organization_add" title="选择企业" width="600">查找带回</a>
           </div>
           <div class="unit">
                <label>急聘签约状态：</label>
                <select name="wantedState">
                <option value="" >请选择</option>
                <option value="0" >未签约</option>
                <option value="1" >签约中</option>
                <option value="2" >已签约</option>
                </select>
           </div>
           <div class="unit">
                <label>急聘文件地址：</label>
				<input name="wantedURL" class="validate[maxSize[200]] " size="60" />
           </div>
           <div class="unit">
                <label>猎聘签约状态：</label>
                <select name="huntingState">
                <option value="" >请选择</option>
                <option value="0" >未签约</option>
                <option value="1" >签约中</option>
                <option value="2" >已签约</option>
                </select>
           </div>
           <div class="unit">
                <label>猎聘文件地址：</label>
				<input name="number" class="validate[maxSize[200]] " size="60" />
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
