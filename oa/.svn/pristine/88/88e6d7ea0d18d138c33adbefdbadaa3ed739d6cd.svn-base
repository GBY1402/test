<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="${ctx}/styles/style/js/chart.min.js"></script>
<div class="pageContent sortDrag" selector="h1" layoutH="42">
	<div class="panel" defH="230">
		<h1>基本信息</h1>
		<div>
            <table class="gridtable" >
                <tr>
                    <td  align="right">简历名称：</td><td>${personJobInfo.personJobName}</td>
                  <td align="right">薪资：</td><td >${personJobInfo.personPayStart.name}</td>
                </tr>
                  <tr>
                    <td align="right">行业：</td>
                    <td>${personJobInfo.personIndustry.name}
                    </td>
                     <td align="right">职位：</td><td>${personJobInfo.personFunction.name}</td>
                </tr>
                <tr>
                    <td align="right">最高学历：</td>
						<td><fmt:formatDate value="${personJobInfo.personJobWork}" pattern="yyyy-MM-dd"/></td>
                    <td align="right">工作年数：</td><td>${resumeBasic.jobWorkYear}</td>
                </tr>
                <tr>
                    <td align="right">工作地点：</td><td><fmt:formatDate value="${personJobInfo.reportStart}" pattern="yyyy-MM-dd"/></td>
                    <td align="right">期望薪资：</td>
                    <td><fmt:formatDate value="${personJobInfo.reportEnd}" pattern="yyyy-MM-dd"/></td>
                </tr>
                <tr>
                    <td align="right">求职状态：</td>
                    <td>
                    <c:if test="${personJobInfo.personToggle==0}">
                  			  求职中
                    </c:if>
                     <c:if test="${personJobInfo.personToggle==1}">
                  			关闭求职
                    </c:if>
                    </td>
                </tr>
            </table>
		</div>
	</div>
	<div class="formBar">
        <ul>
            <li>
                <shiro:hasPermission name="Resume:edit">
                    <%-- <a width="700" height="450" class="edit" href="${ctx}/resume/${personJobInfo.personJobId}/showResumeBasicUpdate" rel="updateuserinfo" target="dialog" mask="true"><button>添加</button></a> --%>
                    <a width="700" height="450" class="edit" href="${ctx}/resume/${humanId}/showResumeBasicSave" rel="updateuserinfo" target="dialog" mask="true"><button>添加</button></a>
                </shiro:hasPermission>
            </li>
        </ul>
    </div>
	<div class="panel collapse" minH="100" defH="150">
		<h1>工作经验</h1>
		<div>
            <table class="gridtable" >
                <c:forEach items="${personJobInfo.resumeList}" var="resumeWork">
                    <tr>
                        <td  align="right">公司名称：</td><td>${resumeWork.resumeName}</td>
                        <td  align="right">职位名称：</td><td>${resumeWork.resumePosition}</td>
                    </tr>
                    <tr>
                        <td  align="right">部门：</td><td>${resumeWork.resumeDepartment}</td>
                        <td  align="right">薪资：</td><td>${resumeWork.resumePay}</td>
                    </tr>
                    <tr>
                        <td align="right">开始日期：</td><td><fmt:formatDate value="${resumeWork.startDate}" pattern="yyyy-MM-dd"/></td>
                        <td align="right">结束日期：</td><td><fmt:formatDate value="${resumeWork.endDate}" pattern="yyyy-MM-dd"/></td>
                    </tr>
                    <tr>
                        <td  align="right">工作内容：</td><td colspan="3">${resumeWork.resumeDescribe}</td>
                    </tr>
                    <tr>
                        <td align="right" colspan="4">
                            <shiro:hasPermission name="Resume:delete">
                                <a class="delete" href="${ctx}/resume/${resumeWork.resumeId}/resumeWorkDel" target="ajaxTodo" title="确定要删除吗?"><button>删除</button></a>
                            </shiro:hasPermission>
                            <shiro:hasPermission name="Resume:edit">
                                <a width="650" height="450" class="edit" href="${ctx}/resume/${resumeWork.resumeId}/showResumeWorkUpdate" target="dialog" mask="true"><button>修改</button></a>
                            </shiro:hasPermission>
                        </td>
                    </tr>
                </c:forEach>
            </table>
		</div>
	</div>
    <div class="formBar">
        <ul>
            <li>
                <shiro:hasPermission name="Resume:save">
                    <a width="700" height="450" class="add" target="dialog" href="${ctx }/resume/${personJobInfo.personJobId}/showResumeWorkAdd" mask="true"><button>添加</button></a>
                </shiro:hasPermission>
            </li>
        </ul>
    </div>
    <div class="panel collapse"  minH="100" defH="150">
        <h1>项目经验</h1>
        <div>
            <table class="gridtable" >
                <c:forEach items="${personJobInfo.projectList}" var="resumeProject">
                    <tr>
                        <td  align="right">项目名称：</td><td >${resumeProject.projectName}</td>
                          <td  align="right">职务：</td><td >${resumeProject.projectPost}</td>
                    </tr>
                    <tr>
                        <td align="right">开始日期：</td><td><fmt:formatDate value="${resumeProject.projectStart}" pattern="yyyy-MM-dd"/></td>
                        <td align="right">结束日期：</td><td><fmt:formatDate value="${resumeProject.projectEnd}" pattern="yyyy-MM-dd"/></td>
                    </tr>
                    <tr>
                        <td  align="right">项目描述：</td><td colspan="3">${resumeProject.projectDescribe}</td>
                    </tr>
                    <tr>
                        <td  align="right">项目职责：</td><td colspan="3">${resumeProject.projectAchieve}</td>
                    </tr>
                    <tr>
                        <td align="right" colspan="4">
                            <shiro:hasPermission name="Resume:delete">
                                <a class="delete" href="${ctx}/resume/${resumeProject.projectId}/resumeProjectDel" target="ajaxTodo" title="确定要删除吗?"><button>删除</button></a>
                            </shiro:hasPermission>
                            <shiro:hasPermission name="Resume:edit">
                                <a width="650" height="450" class="edit" href="${ctx}/resume/${resumeProject.projectId}/showResumeProjectUpdate" target="dialog" mask="true"><button>修改</button></a>
                            </shiro:hasPermission>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="formBar">
        <ul>
            <li>
                <shiro:hasPermission name="Resume:save">
                    <a width="650" height="450" class="add" target="dialog" href="${ctx }/resume/${personJobInfo.personJobId}/showResumeProjectAdd" mask="true"><button>添加</button></a>
                </shiro:hasPermission>
            </li>
        </ul>
    </div>
    <div class="panel collapse" minH="100" defH="150">
        <h1>教育经历</h1>
        <div>
            <table class="gridtable" >
                <c:forEach items="${personJobInfo.trainList}" var="resumeTraining">
                    <tr>
                        <td  align="right">学校名称：</td><td>${resumeTraining.trainName}</td>
                        <td  align="right">专业：</td><td>${resumeTraining.trainMajor}</td>
                    </tr>
                    <tr>
                        <td align="right">开始日期：</td><td><fmt:formatDate value="${resumeTraining.trainStart}" pattern="yyyy-MM-dd"/></td>
                        <td align="right">结束日期：</td><td><fmt:formatDate value="${resumeTraining.trainEnd}" pattern="yyyy-MM-dd"/></td>
                    </tr>
                    <tr>
                        <td  align="right">学历：</td><td>${resumeTraining.humanDiploma.name}</td>
                        <td  align="right">在校经历：</td><td>${resumeTraining.trainExper}</td>
                    </tr>
                    <tr>
                        <td align="right" colspan="4">
	                        <shiro:hasPermission name="Resume:delete">
	                            <a class="delete" href="${ctx}/resume/${resumeTraining.trainId}/resumeTrainingDel" target="ajaxTodo" title="确定要删除吗?"><button>删除</button></a>
	                        </shiro:hasPermission>
	                        <shiro:hasPermission name="Resume:edit">
	                            <a width="650" height="450" class="edit" href="${ctx}/resume/${resumeTraining.trainId}/showResumeTrainingUpdate" target="dialog" mask="true"><button>修改</button></a>
	                        </shiro:hasPermission>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="formBar">
        <ul>
            <li>
                <shiro:hasPermission name="Resume:save">
                    <a width="650" height="450" class="add" target="dialog" href="${ctx }/resume/${personJobInfo.personJobId}/showResumeTrainingAdd" mask="true"><button>添加</button></a>
                </shiro:hasPermission>
            </li>
        </ul>
    </div>
    <%-- <div class="panel collapse"  defH="250">
        <h1>个人技能</h1>
        <div>
            <table class="gridtable" >
             <div>
            <table class="gridtable" >
            <c:forEach items="${resumeBasic.personSkillInfos}" var="personSkillInfo" varStatus="st" >
              <c:if test="${st.index==1}">
             <tr>
               <td  align="right">行业：</td><td>${personSkillInfo.skillsInfo.industrySkillsInfo.parent.parent.name}</td>
               <td  align="right">职位：</td><td>${personSkillInfo.skillsInfo.industrySkillsInfo.parent.name}</td>
           	</tr>
           </c:if>
           </c:forEach>
        </table>
           <tr>
             <canvas id="radar-chart2"class="chart" height="200" width="300"style="width: 200px; height: 200px;"></canvas>
              </tr>
            </table>
        </div>
        </div>
            </div>
    <div class="formBar">
        <ul>
            <li>
                <shiro:hasPermission name="Resume:save">
                    <a width="650" height="450" class="add" target="dialog" href="${ctx }/industrySkills/${resumeBasic.resumeId }/personSkillsInfo" mask="true"><button>添加</button></a>
                </shiro:hasPermission>
            </li>
        </ul>
    </div>
    <input type="hidden" id="skillName" value="${skillName }"> 
	<input type="hidden" id="skillValue" value="${skillValue }"> 
 <script >
$(document).ready(function(){
		 var option_bars = {
			scaleBeginAtZero : true,
			scaleShowGridLines : true,
			scaleGridLineColor : "rgba(0,0,0,.05)",
			scaleGridLineWidth : 1,
			scaleShowHorizontalLines : true,
			scaleShowVerticalLines : false,
			barShowStroke : false,
			barStrokeWidth : 0,
			barValueSpacing : 5,
			barDatasetSpacing : 1,
		};
		 var nameList = document.getElementById("skillName").value;
		 var name = nameList.split(",");
		 var valuelist = document.getElementById("skillValue").value;
		 var values = valuelist.split(","); 
		 var data = {
			 labels :  name,
			datasets : [ {
				label : "My Second dataset",
				fillColor : "rgba(34, 167, 240,0.2)",
				strokeColor : "#22A7F0",
				pointColor : "#22A7F0",
				pointStrokeColor : "#fff",
				pointHighlightFill : "#fff",
				pointHighlightStroke : "#22A7F0",
				 data : values
			} ]
		};
			 var myBarChart= new Chart(document.getElementById("radar-chart2").getContext("2d")).Radar(data, option_bars);
	 });
</script>
 --%>