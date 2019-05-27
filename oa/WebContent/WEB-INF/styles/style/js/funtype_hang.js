var fun_flag_arr = new Array();		//	已选中数组
//var fun_flag_arr = new Array('0100','2400','2402');
var Funtype = {
	
	Show : function(){
		var output='',flag,output2='';
		for(var i in fun_flag_arr){
			output2+='<li class="Funtype'+fun_flag_arr[i]+' chkON" onclick="Funtype.Chk(\''+fun_flag_arr[i]+'\')">'+fun_a[fun_flag_arr[i]].name+'</li>';
		}
		$('#FuntypeSelected dd').html(output2);
		for (var i in fun_a){
			if(fun_a[i].pid=="1"){
				output+='<li onclick="Funtype.Showsoon(\''+fun_a[i].id+'\')">'+fun_a[i].name+'</li>';
			}
		}
		$('#drag').width('670px');
		$('#FuntypeList').html('<ul>'+output+'</ul>');
		// 鼠标悬停变色
		$('#FuntypeAlpha li').hover(function(){$(this).addClass('over')},function(){$(this).removeClass('over')});
		
	},
	
	Showsoon : function(id){
		var output='',flag,output2='';
		for(var i in fun_flag_arr){
			output2+='<li class="Funtype'+fun_flag_arr[i]+' chkON" onclick="Funtype.Chk(\''+fun_flag_arr[i]+'\')">'+fun_a[fun_flag_arr[i]].name+'</li>';
		}
		$('#FuntypeSelected dd').html(output2);
		for (var i in fun_a){
			if(fun_a[i].pid==id){
				output+='<li onclick="Funtype.Chk(\''+i+'\')">'+fun_a[i].name+'</li>';
			}
		}
		$('#FuntypeList1').html('<ul>'+output+'</ul>');
		// 鼠标悬停变色
		$('#FuntypeAlpha li').hover(function(){$(this).addClass('over')},function(){$(this).removeClass('over')});
		
	},
	Chk : function(id){
		if(!in_array(id,fun_flag_arr)){
			if(id.substr(2)=='00'){	// 选中父类清除子类
				for (var i in fun_a){
					if(i.substr(0,2)==id.substr(0,2)){
						if(in_array(i,fun_flag_arr)) this.del(i);
					}
				}
			}else{	// 选中子类清除父类
				var myid;
				myid=id.substr(0,2)+'00';
				if(in_array(myid,fun_flag_arr)) this.del(myid);
			};
			if(fun_flag_arr.length<1){
				fun_flag_arr[fun_flag_arr.length]=id;
				var html='<li class="Funtype'+id+'" onclick="Funtype.Chk(\''+id+'\')">'+fun_a[id].name+'</li>';
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
		for (var i in fun_flag_arr){
			if(fun_flag_arr[i]==id) fun_flag_arr.splice(i,1);;
		}
		$('#FuntypeSelected .Funtype'+id).remove();
		$('.Funtype'+id).removeClass('chkON');
	},
	// 确定
	confirm : function(){
		var funStr='',fun_Id='';
		for(var i in fun_flag_arr){
			funStr+=','+fun_a[fun_flag_arr[i]].name;
			fun_Id+=fun_a[fun_flag_arr[i]].id;
		}
		funStr=funStr.substring(1)?funStr.substring(1):'请选行业类别'; 
		$('#btn_FuntypeID').val(funStr);
		$('#FuntypeID').val(fun_flag_arr);
		$('#industryCategory').val(fun_Id);
		boxAlpha();
	},

}

// 多选
function funtypeHang(){
	var dragHtml ='<div id="FuntypeAlpha">';			//行业类别
		dragHtml+='		<dl id="FuntypeSelected"><dt>已选行业类别：</dt><dd></dd></dl>';
		dragHtml+='		<div id="FuntypeList"></div>';	//行业类别列表
		dragHtml+='		<div id="FuntypeList1"></div>';
		dragHtml+='</div>';
	$('#drag_h').html('<b>请选择行业类别（您只能选择1项）</b><span onclick="Funtype.confirm()">确定</span>');
	$('#drag_con').html(dragHtml);
	Funtype.Show();
	boxAlpha();
	draglayer();
}
