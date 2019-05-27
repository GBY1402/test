var fun_flag_soonarr = new Array();		//	已选中数组
//var fun_flag_arr = new Array('0100','2400','2402');

var Funtypesoon = {
	Show1 : function(FuntypeID){
		var output='',flag,output2='';
		
		for(var i in fun_flag_soonarr){
			output2+='<li class="Funtype'+fun_flag_soonarr[i]+' chkON" onclick="Funtypesoon.Chk(\''+fun_flag_soonarr[i]+'\')">'+fun_a[fun_flag_soonarr[i]].name+'</li>';
		}
		$('#FuntypeSelected dd').html(output2);
		for (var i in fun_a){
			if(fun_a[i].pid==fun_a[FuntypeID].id){
				output+='<li onclick="Funtypesoon.Chk(\''+i+'\')">'+fun_a[i].name+'</li>';
			
			}
		}
		$('#drag').width('670px');
		$('#FuntypeList2').html('<ul>'+output+'</ul>');
		// 鼠标悬停变色
		$('#FuntypeAlpha li').hover(function(){$(this).addClass('over')},function(){$(this).removeClass('over')});
		
	},
	Chk : function(id){
		if(!in_array(id,fun_flag_soonarr)){
			if(id.substr(2)=='00'){	// 选中父类清除子类
				for (var i in fun_a){
					if(i.substr(0,2)==id.substr(0,2)){
						if(in_array(i,fun_flag_soonarr)) this.del(i);
					}
				}
			}else{	// 选中子类清除父类
				var myid;
				myid=id.substr(0,2)+'00';
				if(in_array(myid,fun_flag_soonarr)) this.del(myid);
			};
			if(fun_flag_soonarr.length<1){
				fun_flag_soonarr[fun_flag_soonarr.length]=id;
				var html='<li class="Funtype'+id+'" onclick="Funtypesoon.Chk(\''+id+'\')">'+fun_a[id].name+'</li>';
				$('#FuntypeSelected dd').append(html);
				$('.Funtype'+id).addClass('chkON');
				$('#FuntypeSelected li').hover(function(){$(this).addClass('over')},function(){$(this).removeClass('over')});
			}else{
				alert('您只能选择1项');
				return false;
			}
		}else{
			this.del(id)
		}
	},
	del : function(id){
		for (var i in fun_flag_soonarr){
			if(fun_flag_soonarr[i]==id) fun_flag_soonarr.splice(i,1);;
		}
		$('#FuntypeSelected .Funtype'+id).remove();
		$('.Funtype'+id).removeClass('chkON');
	},
	// 确定
	confirm : function(){
		var funStr='',fun_Id='';
		for(var i in fun_flag_soonarr){
			funStr+=','+fun_a[fun_flag_soonarr[i]].name;
			fun_Id+=fun_a[fun_flag_soonarr[i]].id;
		}
		funStr=funStr.substring(1)?funStr.substring(1):'请选择职能类别'; 
		$('#btn_FuntypeID1').val(funStr);
		$('#FuntypeID1').val(fun_flag_soonarr);
		$('#functionCaeyorey').val(fun_Id);
		boxAlpha();
	},
	
}
//单选
function funtypeZhi(){
	var  FuntypeID = document.getElementById("FuntypeID").value;
 	if(FuntypeID==null || FuntypeID==""){
 		alert("请选择行业！");
 	}else{
	var dragHtml ='<div id="FuntypeAlpha">';			//职能类别
		dragHtml+='		<dl id="FuntypeSelected"><dt>已选行业类别：';
		dragHtml+=fun_a[FuntypeID].name;
		dragHtml+='		</dt><dd></dd></dl>';
		dragHtml+='		<div id="FuntypeList2"></div>';	//职能类别列表
		dragHtml+='</div>';
	$('#drag_h').html('<b>请选择职能类别（您只能选择1项）</b><span onclick="Funtypesoon.confirm()">确定</span>');
	$('#drag_con').html(dragHtml);
	Funtypesoon.Show1(FuntypeID);
	boxAlpha();
	draglayer();
	}
}