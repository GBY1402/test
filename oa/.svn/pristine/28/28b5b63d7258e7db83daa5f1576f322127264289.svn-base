function func( id,beas,tcx){
	var idnew = document.getElementById(id); 
	var beasnew = document.getElementById(beas).value; 
	$.ajax({
		url :tcx+beasnew,
		type : 'POST',
		async : true,
		cache : false,
		contentType : false,
		processData : false,
		success : function(result) {
			for(var i=0;i<result.length;i++){
	        	 var opt = document.createElement("option");
	        	   opt.value = result[i].id;
	        	   opt.innerText = result[i].name;  
	        	   idnew.appendChild(opt);  
	        }
		}
	});
}

function getCity(url){
	  var province = document.getElementById("province"); 
	 $.ajax({
		url : url,
		type : 'POST',
		async : true,
		cache : false,
		contentType : false,
		processData : false,
		success : function(result) {
			for(var i=0;i<result.length;i++){
	        	 var opt = document.createElement("option");
	        	   opt.value = result[i].regionId;  
	        	   opt.innerText = result[i].regionName;  
	        	   province.appendChild(opt);  
	        }
		}
	});
}

function getDistrict(){
	  var province = document.getElementById("city"); 
	  var options=$("#province option:selected");
	 $.ajax({
		url : '${ctx}/addresscity/findModel?id='+options.val(),
		type : 'POST',
		async : true,
		cache : false,
		contentType : false,
		processData : false,
		success : function(result) {
			for(var i=0;i<result.length;i++){
	        	 var opt = document.createElement("option");
	        	   opt.value = result[i].regionId;  
	        	   opt.innerText = result[i].regionName;  
	        	   province.appendChild(opt);  
	        }
		}
	});
}

function getCounty(url){
	  var province = document.getElementById("county"); 
	  var options=$("#city option:selected");
	 $.ajax({
		url : url+options.val(),
		type : 'POST',
		async : true,
		cache : false,
		contentType : false,
		processData : false,
		success : function(result) {
			for(var i=0;i<result.length;i++){
	        	 var opt = document.createElement("option");
	        	   opt.value = result[i].regionId;  
	        	   opt.innerText = result[i].regionName;  
	        	   province.appendChild(opt);  
	        }
		}
	});
}
function getArea(url){
	  var province = document.getElementById("area"); 
	  var options=$("#county option:selected");
	 $.ajax({
		url : url+options.val(),
		type : 'POST',
		async : true,
		cache : false,
		contentType : false,
		processData : false,
		success : function(result) {
			for(var i=0;i<result.length;i++){
	        	 var opt = document.createElement("option");
	        	   opt.value = result[i].regionId;  
	        	   opt.innerText = result[i].regionName;  
	        	   province.appendChild(opt);  
	        }
		}
	});
}

function getVillage(url){
	  var province = document.getElementById("village"); 
	  var options=$("#area option:selected");
	 $.ajax({
		url : url+options.val(),
		type : 'POST',
		async : true,
		cache : false,
		contentType : false,
		processData : false,
		success : function(result) {
			for(var i=0;i<result.length;i++){
	        	 var opt = document.createElement("option");
	        	   opt.value = result[i].regionId;  
	        	   opt.innerText = result[i].regionName;  
	        	   province.appendChild(opt);  
	        }
		}
	});
}