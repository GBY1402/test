<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<%@page import="com.lh.it.resource.common.entity.FunctionInfo"%>
<%@page import="java.util.List"%>
<%!
	public String tree(FunctionInfo industrySkillsInfo) {
		if (industrySkillsInfo.getChildInSk().isEmpty()) {
			return "";
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append("<ul>" + "\n");
		for(FunctionInfo $industrySkillsInfo : industrySkillsInfo.getChildInSk()) {
			buffer.append("<li><a href=\"javascript:\" onclick=\"$.bringBack({id:'" + $industrySkillsInfo.getId() + "', name:'" + $industrySkillsInfo.getName() + "'})\">" + $industrySkillsInfo.getName() + "</a>" + "\n");
			buffer.append(tree($industrySkillsInfo));
			buffer.append("</li>" + "\n");
		}
		buffer.append("</ul>" + "\n");
		return buffer.toString();
	}
%>
<%
FunctionInfo industrySkillsInfo = (FunctionInfo)request.getAttribute("rootNode");
%>
<div class="pageContent">
	<div class="pageFormContent" layoutH="58">
		<ul class="tree expand">
			<li><a href="javascript:" onclick="$.bringBack({id:'<%=industrySkillsInfo.getId() %>', name:'<%=industrySkillsInfo.getName() %>'})" ><%=industrySkillsInfo.getName()  %></a>
				<%=tree(industrySkillsInfo) %>
			</li>
		</ul>
	</div>
	
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
		</ul>
	</div>
</div>




