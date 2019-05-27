<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<style type="text/css">
	ul.rightTools {float:right; display:block;}
	ul.rightTools li{float:left; display:block; margin-left:5px}
</style>
<div class="pageContent" style="padding:5px">
	<div>
		<div id="_equipmentSupp_tree_region" layoutH="15" style="float:left; display:block; overflow:auto; width:240px; border:solid 1px #CCC; line-height:21px; background:#fff">
		</div>
		<div id="representative_region" class="unitBox" style="margin-left:246px;">
			<jsp:include page="/WEB-INF/views/region/childlist.jsp"/>
		</div>
	</div>
</div>


<script>

function getTree(data,pId){ 
    var tree; 
    if(pId==0){ 
        tree = '<ul class="tree treeFolder ">'; 
    }else{ 
        tree = '<ul>'; 
    } 
    for(var i in data){ 
        if(data[i].pid == pId){ 
       		 tree += "<li><a href='${ctx}/region/findChild?eId="+data[i].id+"' target='ajax' rel='representative_region'>"+data[i].name+"</a>"; 
             tree += getTree(data,data[i].id); 
             tree += "</li>"; 
        }
    } 
    return tree+"</ul>"; 
} 
jQuery(function($) { 
    $("#_equipmentSupp_tree_region").html(getTree(${jsonTree},0).replaceAll("<ul></ul>","")); 
}); 
</script>

