var data1 = "";
	//[{"id":110000,"pid":1,"name":"北京市","isParent":true},{"id":120000,"pid":1,"name":"天津市","isParent":true},{"id":130000,"pid":1,"name":"河北省","isParent":true},{"id":140000,"pid":1,"name":"山西省","isParent":true},{"id":150000,"pid":1,"name":"内蒙古自治区","isParent":true},{"id":210000,"pid":1,"name":"辽宁省","isParent":true},{"id":220000,"pid":1,"name":"吉林省","isParent":true},{"id":230000,"pid":1,"name":"黑龙江省","isParent":true},{"id":310000,"pid":1,"name":"上海市","isParent":true},{"id":320000,"pid":1,"name":"江苏省","isParent":true},{"id":330000,"pid":1,"name":"浙江省","isParent":true},{"id":340000,"pid":1,"name":"安徽省","isParent":true},{"id":350000,"pid":1,"name":"福建省","isParent":true},{"id":360000,"pid":1,"name":"江西省","isParent":true},{"id":370000,"pid":1,"name":"山东省","isParent":true},{"id":410000,"pid":1,"name":"河南省","isParent":true},{"id":420000,"pid":1,"name":"湖北省","isParent":true},{"id":430000,"pid":1,"name":"湖南省","isParent":true},{"id":440000,"pid":1,"name":"广东省","isParent":true},{"id":450000,"pid":1,"name":"广西壮族自治区","isParent":true},{"id":460000,"pid":1,"name":"海南省","isParent":true},{"id":500000,"pid":1,"name":"重庆市","isParent":true},{"id":510000,"pid":1,"name":"四川省","isParent":true},{"id":520000,"pid":1,"name":"贵州省","isParent":true},{"id":530000,"pid":1,"name":"云南省","isParent":true},{"id":540000,"pid":1,"name":"西藏自治区","isParent":true},{"id":610000,"pid":1,"name":"陕西省","isParent":true},{"id":620000,"pid":1,"name":"甘肃省","isParent":true},{"id":630000,"pid":1,"name":"青海省","isParent":true},{"id":640000,"pid":1,"name":"宁夏回族自治区","isParent":true},{"id":650000,"pid":1,"name":"新疆维吾尔自治区","isParent":true}];

var city = {
	chkcity1 : function(id){
		document.getElementById('countctiy1').innerText=data1[id].name;
		document.getElementById("ctiy1").value = data1[id].id;
		document.getElementById("select_option").style.display = "none";
		document.getElementById('countctiy2').innerText="请选择";
		document.getElementById("ctiy2").value = "";
		document.getElementById('countctiy3').innerText="请选择";
		document.getElementById("ctiy3").value = "";
		document.getElementById('countctiy4').innerText="请选择";
		document.getElementById("ctiy4").value = "";
		document.getElementById('countctiy5').innerText="请选择";
		document.getElementById("ctiy5").value = "";
		$('#select_option').html("");
	},
	showCity1: function(id) {
		var getUrl = document.getElementById("select_city1").getAttribute('getUrl');
		var cityhtml="";
		getUrl+="?id="+id;
		$.get(getUrl,function(data){
			data1 = data;
			cityhtml += "<ul>";
			for (var i in data1 ) {
				cityhtml += '<li onclick="city.chkcity1(\''+i+'\')">'+data1[i].name+'</li>';
			}
			cityhtml += "</ul>";
			$('#select_option').html(cityhtml);
		});
		document.getElementById("select_option").style.display = "block";
	},
	chkcity2 : function(id){
		document.getElementById('countctiy2').innerText=data1[id].name;
		document.getElementById("ctiy2").value = data1[id].id;
		document.getElementById("select_option").style.display = "none";
		document.getElementById('countctiy3').innerText="请选择";
		document.getElementById("ctiy3").value = "";
		document.getElementById('countctiy4').innerText="请选择";
		document.getElementById("ctiy4").value = "";
		document.getElementById('countctiy5').innerText="请选择";
		document.getElementById("ctiy5").value = "";
		$('#select_option').html("");
	},
	showCity2: function() {
		var getUrl = document.getElementById("select_city2").getAttribute('getUrl');
		var ctiy1 = document.getElementById("ctiy1").value;
		getUrl+="?id="+ctiy1;
		if(ctiy1==""){
			alert("请选择上一级，");
			document.getElementById("select_option").style.display = "none";
		}else{
		var cityhtml="";
		$.get(getUrl,function(data){
			data1 = data;
			cityhtml += "<ul>";
			for (var i in data1 ) {
				cityhtml += '<li onclick="city.chkcity2(\''+i+'\')">'+data1[i].name+'</li>';
			}
			cityhtml += "</ul>";
			$('#select_option').html(cityhtml);
		});
		document.getElementById("select_option").style.display = "block";
	}
	},
	chkcity3 : function(id){
		document.getElementById('countctiy3').innerText=data1[id].name;
		document.getElementById("ctiy3").value = data1[id].id;
		document.getElementById("select_option").style.display = "none";
		document.getElementById('countctiy4').innerText="请选择";
		document.getElementById("ctiy4").value = "";
		document.getElementById('countctiy5').innerText="请选择";
		document.getElementById("ctiy5").value = "";
		$('#select_option').html("");
	},
	showCity3: function() {
		var getUrl = document.getElementById("select_city3").getAttribute('getUrl');
		var ctiy2 = document.getElementById("ctiy2").value;
		getUrl+="?id="+ctiy2;
		if(ctiy2==""){
			alert("请选择上一级，");
			document.getElementById("select_option").style.display = "none";
		}else{
		var cityhtml="";
		$.get(getUrl,function(data){
			data1 = data;
			cityhtml += "<ul>";
			for (var i in data1 ) {
				cityhtml += '<li onclick="city.chkcity3(\''+i+'\')">'+data1[i].name+'</li>';
			}
			cityhtml += "</ul>";
			$('#select_option').html(cityhtml);
		});
		document.getElementById("select_option").style.display = "block";
	}
	},
	chkcity4 : function(id){
		document.getElementById('countctiy4').innerText=data1[id].name;
		document.getElementById("ctiy4").value = data1[id].id;
		document.getElementById("select_option").style.display = "none";
		document.getElementById('countctiy5').innerText="请选择";
		document.getElementById("ctiy5").value = "";
		$('#select_option').html("");
	},
	showCity4: function() {
		var getUrl = document.getElementById("select_city4").getAttribute('getUrl');
		var ctiy3 = document.getElementById("ctiy3").value;
		getUrl+="?id="+ctiy3;
		if(ctiy3==""){
			alert("请选择上一级，");
			document.getElementById("select_option").style.display = "none";
		}else{
		var cityhtml="";
		$.get(getUrl,function(data){
			data1 = data;
			cityhtml += "<ul>";
			for (var i in data1 ) {
				cityhtml += '<li onclick="city.chkcity4(\''+i+'\')">'+data1[i].name+'</li>';
			}
			cityhtml += "</ul>";
			$('#select_option').html(cityhtml);
		});
		document.getElementById("select_option").style.display = "block";
	}
	},
	chkcity5 : function(id){
		document.getElementById('countctiy5').innerText=data1[id].name;
		document.getElementById("ctiy5").value = data1[id].id;
		document.getElementById("select_option").style.display = "none";
		$('#select_option').html("");
	},
	showCity5: function() {
		var getUrl = document.getElementById("select_city5").getAttribute('getUrl');
		var ctiy4 = document.getElementById("ctiy4").value;
		getUrl+="?id="+ctiy4;
		if(ctiy4==""){
			alert("请选择上一级，");
			document.getElementById("select_option").style.display = "none";
		}else{
		var cityhtml="";
		$.get(getUrl,function(data){
			data1 = data;
			cityhtml += "<ul>";
			for (var i in data1 ) {
				cityhtml += '<li onclick="city.chkcity5(\''+i+'\')">'+data1[i].name+'</li>';
			}
			cityhtml += "</ul>";
			$('#select_option').html(cityhtml);
		});
		document.getElementById("select_option").style.display = "block";
	}
	},
	
	
	
}