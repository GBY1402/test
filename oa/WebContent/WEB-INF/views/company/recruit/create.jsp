<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="pageContent">
    <form method="post" action="${ctx}/recruit/save" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,dialogReloadNavTab)">
    	<input type="hidden" name="jobAttribute" value="0" />
    	<input type="hidden" name="jobType" value="0" />
    	<input type="hidden" name="workArdessX" value="0" />
    	<input type="hidden" name="workArdessY" value="0" />
        <div class="pageFormContent" layoutH="50">
        	<div class="unit">
				<label>行业：</label>
				<input class="validate[required] required" name="workFunction.parent.id" value="" type="hidden" readonly="readonly"/>
				<input class="validate[required] required" name="workFunction.parent.name" value="" type="text" readonly="readonly"/>
            </div>
			<div class="unit">
				<label>职能：</label>
				<input class="validate[required] required" name="workFunction.id" value="" type="hidden" readonly="readonly"/>
				<input class="validate[required] required" name="workFunction.name" value="" type="text" readonly="readonly"/>
                <a class="btnLook" rel="addskill" width="850" height="700" href="${ctx }/industryskills/2/lookup" lookupGroup="workFunction" title="选择职能" >查找带回</a>
            </div>
           <div class="unit">
                <label>全职薪资起：</label>
                <select name="fullPayStart.id" class="validate[required]">
                <option value="" selected>请选择</option>
                	<c:forEach items="${fullPay }" var="pay">
                		<option value="${pay.id }">${pay.name }</option>
                	</c:forEach>                    
                </select>
                <span><font color="red">*</font></span>
           </div>
           <div class="unit">
                <label>全职薪资结：</label>
                <select name="fullPayEnd.id" class="validate[required]">
                <option value="" selected>请选择</option>
                	<c:forEach items="${fullPay }" var="pay">
                		<option value="${pay.id }">${pay.name }</option>
                	</c:forEach>                    
                </select>
                <span><font color="red">*</font></span>
           </div>
           <div class="unit">
                <label>职位年限：</label>
                <select name="workJobLife.id" class="validate[required]">
                <option value="" selected>请选择</option>
                	<c:forEach items="${workLifeData }" var="w">
                		<option value="${w.id }">${w.name }</option>
                	</c:forEach>                    
                </select>
                <span><font color="red">*</font></span>
           </div>
           <div class="unit">
                <label>学历：</label>
                <select name="educationJob.id" class="validate[required]">
                <option value="" selected>请选择</option>
                	<c:forEach items="${diploma }" var="d">
                		<option value="${d.id }">${d.name }</option>
                	</c:forEach>                    
                </select>
                <span><font color="red">*</font></span>
           </div>
           <div class="unit">
                <label>详细地址：</label>
                <textarea name="workArdessDe" cols="30" rows="4" align="center" ></textarea>
           </div>
           
           <div class="unit">
                <label>职位描述：</label>
                <textarea name="jobDescribe" cols="30" rows="4" align="center" ></textarea>
           </div>
           <div class="unit">
                <label>求职状态：</label>
                <select name="jobCondition" class="validate[required]">
                <option value="" selected>请选择</option>
                <option value="0">停止招聘</option>
                <option value="1">招聘中</option>
                <option value="2">保存</option>
                </select>
                <span><font color="red">*</font></span>
           </div>
			
			<div class="unit">
                <label>删除状态：</label>
                <select name="jobDelete" class="validate[required]">
                <option value="" selected>请选择</option>
                <option value="0">未删除</option>
                <option value="1">已删除</option>
                </select>
                <span><font color="red">*</font></span>
           </div>
           <div class="unit">
				<label>对应HR：</label>
				<input class="validate[required] required" name="enterPersonInfo.enterPerId" value="" type="hidden" readonly="readonly"/>
				<input class="validate[required] required" name="enterPersonInfo.humanBasicInfo.humanName" value="" type="text" readonly="readonly"/>
                <a class="btnLook" rel="addskill" width="500" height="500" href="${ctx }/recruit/hrLookup?enterDelete=0" lookupGroup="enterPersonInfo" title="选择HR" >查找带回</a>
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
