var fun_flag_skills = new Array();		//	已选中数组
/*var fun = new Array('0100','2400','2402');
alert(fun[0]);*/
var Funtypeskill = {
	Showskill : function(id){
		var output='',flag,output2='';
		for (var i in fun_a){
			if(fun_a[i].pid==fun_a[id].id){
				output+='<tr> <td>'+fun_a[i].name+': </td><td>';
				for (var j in fun_ason){
					if(fun_ason[j].pid==fun_a[i].id){
						output+='<input type="radio" name="radio'+fun_a[i].id+'" value="'+fun_ason[j].id+'" onclick="return Funtypeskill.Chk(\''+i+'\')"/>'+fun_ason[j].name;
					}
				}
				output+='<input type="radio" name="radio'+fun_a[i].id+'" value="" checked="checked" onclick="Funtypeskill.del(\''+i+'\')"/>'+'不掌握' ;
				output+='</td></tr>';
			}
		}
		$('#drag').width('670px');
		$('#FuntypeList2').html('<table>'+output+'</table>');
	},
	Chk : function(id){
		if(!in_array(id,fun_flag_skills)){
			if(fun_flag_skills.length<5){
				fun_flag_skills[fun_flag_skills.length]=id;
			}else{
				alert('您最多能选择5项');
				return false;
			}
		}
	},
	del : function(id){
		if(in_array(id,fun_flag_skills)){
		for (var i in fun_flag_skills){
			if(fun_flag_skills[i]==id) fun_flag_skills.splice(i,1);;
		}
		}
	},
	// 确定
	confirm : function(){
		var funStr='',value='',num=0;
		var skillpid=new Array();
		var skillname=new Array();
		for (var j in fun_a){
			var radio=document.getElementsByName("radio"+fun_a[j].id);
			  for(var i=0;i<radio.length;i++){
				if(radio[i].checked==true && radio[i].value!=""){
				  value+=radio[i].value+';';
				  num++;
				}
			}
		}
		if(num>5){
			alert("只能选择5个技能");
			return false;
		}
		skillpid = value.split(";");
		for (var i in fun_ason){
			for (var j in skillpid){
				if(fun_ason[i].id==skillpid[j]){
					skillname.push(i);
				}
			}
		}
		for (var i in fun_a){
			for (var j in skillname){
				if(fun_a[i].id==fun_ason[skillname[j]].pid){
					funStr+='<li>'+fun_a[i].name+":"+fun_ason[skillname[j]].name+'</li>';
					}
		}
		}
		$('#divskill').html('<ul>'+funStr+'</ul>');
		$('#valuetree').val(value);
		boxAlpha();
	},
	
}
// 多选
function funtypeskills(){
	var id = document.getElementById("FuntypeID1").value;
	if(id==null || id==""){
 		alert("请选择职位类别！");
 	}else{
	var dragHtml ='<div id="FuntypeAlpha">';			//职能类别
		dragHtml+='		<dl id="FuntypeSelected"><dt>已选职职位类别：';
		dragHtml+=fun_a[id].name;
		dragHtml+='		</dt><dd></dd></dl>';
		dragHtml+='		<div id="FuntypeList2"></div>';	//技能类别列表
		dragHtml+='</div>';
	$('#drag_h').html('<b>请选择职能类别（您最多能选择5项）</b><span onclick="Funtypeskill.confirm()">确定</span>');
	$('#drag_con').html(dragHtml);

	Funtypeskill.Showskill(id);
	boxAlpha();
	draglayer();
	}
}