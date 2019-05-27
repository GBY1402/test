<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<form id="pagerForm" method="post" action="${ctx }/recruit/hunting">
	<input type="hidden" name="numPerPage" value="${page.size}" />
	<input type="hidden" name="pageNum" value="${page.number+1 }" />
</form>

<form id="searchForm" method="post" action="${ctx}/recruit/hunting" onsubmit="return navTabSearch(this)">
	<input type="hidden" name="search_EQ_jobAttribute" value="2" />
	<div class="pageHeader">
		<div class="searchBar">
			 <ul class="searchContent">
				<li>
					<label>HR：</label>
					<input type="text" name="search_LIKE_enterPersonInfo.humanBasicInfo.humanName" value="${param['search_LIKE_enterPersonInfo.humanBasicInfo.humanName']}"/>
				</li>
				<li>
					<label>公司名称：</label>
					<input type="text" name="search_LIKE_enterBasicInfo.enterName" value="${param['search_LIKE_enterBasicInfo.enterName']}"/>
				</li>
				<li>
					<label>求职状态：</label>
					<select name="search_EQ_jobCondition" class="combox">
					<option value="">请选择</option>
					<option value="0" ${param.search_EQ_jobCondition == '0' ? 'selected' : ''}>停止招聘</option>
					<option value="1" ${param.search_EQ_jobCondition == '1' ? 'selected' : ''}>招聘中</option>
					<option value="2" ${param.search_EQ_jobCondition == '2' ? 'selected' : ''}>保存</option>
					</select>
				</li> 
				 <li>
					<label>删除状态：</label>
					<select name="search_EQ_jobDelete" class="combox">
					<option value="">请选择</option>
					<option value="0" ${param.search_EQ_jobDelete == '0' ? 'selected' : ''}>未删除</option>
					<option value="1" ${param.search_EQ_jobDelete == '1' ? 'selected' : ''}>已删除</option>
					</select>
				</li> 
			</ul> 
			<div class="subBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
				</ul>
			</div>
		</div>
	</div>
</form>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		<shiro:hasPermission name="RecruitL:save">
			<li><a  width="550" height="600" rel="companyback" class="add" href="${ctx}/recruit/hunting/save" target="dialog" mask="true"><span>添加</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="RecruitL:edit">
			<li><a  width="550" height="600" rel="resume_edit" class="edit" href="${ctx}/recruit/hunting/${emp.jobWanfedId}/{sid_user}/update" target="dialog" ><span>修改</span></a></li>
		</shiro:hasPermission>
		<li class="line">line</li>
		<shiro:hasPermission name="RecruitL:view">
			<li><a class="icon" width="850" height="450" href="${ctx}/recruit/hunting/${emp.jobWanfedId}/{sid_user}/view" target="dialog" mask="true"><span>详细</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="RecruitL:delete">
			<li><a class="delete" href="${ctx}/recruit/hunting/${emp.jobWanfedId}/{sid_user}/delete" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</shiro:hasPermission>
		</ul>
	</div>
	<c:if test="${not empty msg}">
    	<div class="message">${msg}</div>
	</c:if>

<table class="table" layoutH="137">
    <thead>
        <tr >
            <th width="100px" align="center">薪资起</th>
            <th width="100px" align="center">薪资结</th>
            <th width="100px" align="center">学历</th>
            <th width="100px" align="center">年限要求</th>
            <th width="100px" align="center">人数</th>
            <!-- <th width="100px" align="center">工作地址</th> -->
            <th width="400px" align="center">详细地址</th>
            <th width="150px" align="center">行业</th>
            <th width="150px" align="center">职能</th>
            <th width="150px" align="center">佣金</th>
            <th width="100px" align="center">HR</th>
            <th width="150px" align="center">HR所属公司</th>
            <th width="150px" align="center">求职状态</th>
            <th width="150px" align="center">删除状态</th>
            <th width="150px" align="center">创建人</th>
            <th width="150px" align="center">创建时间</th>
            
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.content}" var="emp">
            <tr target="sid_user" rel="${emp.jobWanfedId}">
                  <td>${emp.fullPayStart.name }</td>
                  <td>${emp.fullPayEnd.name }</td>
                  <td>${emp.educationJob.name }</td>
                  <td>${emp.workJobLife.name }</td>
                  <td>${emp.numberJob }</td>
                  <%-- <td>${emp.workArdess.regionName }</td> --%>
                  <td>${emp.workArdessDe }</td>
                  <td>${emp.workIndustry.name }</td>
                  <td>${emp.workFunction.name }</td>
                  <td>${emp.commission }</td>
                  <td>${emp.enterPersonInfo.humanBasicInfo.humanName }</td>
                  <td>${emp.enterBasicInfo.enterName }</td>
                  <td>
                    <c:if test="${emp.jobCondition == 0 }">
	                	停止招聘
	                </c:if>
	                <c:if test="${emp.jobCondition == 1 }">
	                	招聘中
	                </c:if>
	                <c:if test="${emp.jobCondition == 2 }">
	                	保存
	                </c:if>
                  </td>
                  <td>
                  	<c:if test="${emp.jobDelete == 0 }">
	                	未删除
	                </c:if>
	                <c:if test="${emp.jobDelete == 1 }">
	                	<b style="color:red;">已删除</b>
	                </c:if>
                  </td>
				 <td>${emp.createUser }</td>
                 <td><fmt:formatDate value="${emp.createTime}" type="date" dateStyle="long"/></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20"  <c:if test="${page.size==20}">selected="selected"</c:if>>20</option>
				<option value="50"  <c:if test="${page.size==50}">selected="selected"</c:if>>50</option>
				<option value="100" <c:if test="${page.size==100}">selected="selected"</c:if>>100</option>
				<option value="200" <c:if test="${page.size==200}">selected="selected"</c:if>>200</option>
			</select>
			<span>条，共${page.totalElements}条</span>
		</div>
		<div class="pagination" targetType="navTab" totalCount="${page.totalElements }" numPerPage="${page.size }" pageNumShown="8" currentPage="${page.number+1 }"></div>
	</div>
</div>