var fun_flag_soonarr = new Array();		//	已选中数组
//var fun_flag_arr = new Array('0100','2400','2402');
var Funtypesoon = {
	Show1 : function(){
		var output='',flag,output2='';
		for(var i in fun_flag_soonarr){
			output2+='<li class="Funtype'+fun_flag_soonarr[i]+' chkON" onclick="Funtypesoon.Chk(\''+fun_flag_soonarr[i]+'\')">'+fun_a[fun_flag_soonarr[i]].name+'</li>';
		}
		$('#FuntypeSelected dd').html(output2);
		for (var i in fun_a){
			if(fun_a[i].pid=="1"){
				output+='<li onclick="Funtypesoon.Showsoon1(\''+fun_a[i].id+'\')">'+fun_a[i].name+'</li>';
			}
		}
		$('#drag').width('670px');
		$('#FuntypeList').html('<ul>'+output+'</ul>');
		// 鼠标悬停变色
		$('#FuntypeAlpha li').hover(function(){$(this).addClass('over')},function(){$(this).removeClass('over')});
		
	},
	
	Showsoon1 : function(id){
		var output='',flag,output2='';
		for(var i in fun_flag_soonarr){
			output2+='<li class="Funtype'+fun_flag_soonarr[i]+' chkON" onclick="Funtypesoon.Chk(\''+fun_flag_soonarr[i]+'\')">'+fun_a[fun_flag_soonarr[i]].name+'</li>';
		}
		$('#FuntypeSelected dd').html(output2);
		for (var i in fun_a){
			if(fun_a[i].pid==id){
				output+='<li onclick="Funtypesoon.SubLayer(\''+fun_a[i].id+'\')">'+fun_a[i].name+'</li>';
			}
		}
		$('#FuntypeList1').html('<ul>'+output+'</ul>');
		// 鼠标悬停变色
		$('#FuntypeAlpha li').hover(function(){$(this).addClass('over')},function(){$(this).removeClass('over')});
		// 点击弹出子菜单
		$('#FuntypeList1 li').click(function(e){$("#sublist").css({top:e.pageY-4,left:e.pageX-4}).hover(function(){$(this).show()},function(){$(this).hide()})})
	},
	// 子职位 悬浮菜单
	SubLayer : function(id){
		var output='',width,flag;
		var myid=id;
		var len=0;
		for (var i in fun_a){
			if(fun_a[i].pid==myid){
				flag=in_array(i,fun_flag_soonarr)?' chkON':'';
				if(i.substr(2)=='00'){
					output+='<h4 onclick="Funtypesoon.Chk(\''+i+'\')"><a href="javascript:" class="Funtype' + i + flag +'">'+fun_a[id].name+'</a></h4>';
				}else{
					output+='<li><a href="javascript:" class="Funtype' + i + flag +'" onclick="Funtypesoon.Chk(\''+i+'\')">'+fun_a[i].name+'</a></li>';
					len++;
				}
			}
		}
		width=len>10?440:220;
		output='<div id="sub_funtype"><ul style="width:'+width+'px">'+output+'</ul></div>';
		$("#sublist").html(output).show();
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
			if(fun_flag_soonarr.length<5){
				fun_flag_soonarr[fun_flag_soonarr.length]=id;
				var html='<li class="Funtype'+id+'" onclick="Funtypesoon.Chk(\''+id+'\')">'+fun_a[id].name+'</li>';
				$('#FuntypeSelected dd').append(html);
				$('.Funtype'+id).addClass('chkON');
				$('#FuntypeSelected li').hover(function(){$(this).addClass('over')},function(){$(this).removeClass('over')});
			}else{
				alert('您最多能选择5项');
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
		}
		funStr=funStr.substring(1)?funStr.substring(1):''; 
		$('#btn_FuntypeID1').val(funStr);
		$('#FuntypeID1').val(fun_flag_soonarr);
		$('#functionCategory').val(funStr);
		boxAlpha();
	},
	
}
// 多选
function funtypeSelect1(){
	var dragHtml ='<div id="FuntypeAlpha">';			//职能类别
		dragHtml+='		<dl id="FuntypeSelected"><dt>已选职能类别：</dt><dd></dd></dl>';
		dragHtml+='		<div id="FuntypeList"></div>';	//职能类别列表
		dragHtml+='		<div id="FuntypeList1"></div>';
		dragHtml+='</div>';
	$('#drag_h').html('<b>请选择职能类别（您最多能选择5项）</b><span onclick="Funtypesoon.confirm()">确定</span>');
	$('#drag_con').html(dragHtml);

	Funtypesoon.Show1();
	boxAlpha();
	draglayer();
}