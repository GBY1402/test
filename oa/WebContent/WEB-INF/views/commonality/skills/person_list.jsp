<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<style type="text/css">
	ul.rightTools {float:right; display:block;}
	ul.rightTools li{float:left; display:block; margin-left:5px}
</style>
<div class="pageContent" style="padding:5px">
<input type="hidden" id="recruitInfoid" name="id" value="${sid }">
	<div>
		<div id="_industryskillsEqui_tree" layoutH="15" style="float:left; display:block; overflow:auto; width:50%; border:solid 1px #CCC; line-height:21px; background:#fff">
		</div>
		<div id="jbsxBoxIskill" class="unitBox" style="margin-left:246px;">
			<jsp:include page="/WEB-INF/views/commonality/skills/skillsInfo_create_person.jsp"/>
		</div>
	</div>
</div>


<script>

function getTree(data,pId){ 
	var sid=document.getElementById("recruitInfoid");
    var tree; 
    if(pId==0){ 
        tree = '<ul class="tree treeFolder ">'; 
    }else{ 
        tree = '<ul>'; 
    } 
    for(var i  in data ){ 
        if(data[i].pid == pId){ 
            tree += "<li><a href='${ctx}/industrySkills/"+data[i].id+"/"+sid.value+"/skillpointperson' target='ajax' rel='jbsxBoxIskill'>"+data[i].name+"</a>"; 
            tree += getTree(data,data[i].id); 
            tree += "</li>"; 
        } 
    } 
    return tree+"</ul>"; 
} 
jQuery(function($) { 
    $("#_industryskillsEqui_tree").html(getTree(${jsonTree},0).replaceAll("<ul></ul>","")); 
}); 
</script>

