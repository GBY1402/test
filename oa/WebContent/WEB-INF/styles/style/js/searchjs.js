
var province=document.getElementById("prov");
var province1=document.getElementById("prov1");
var province2=document.getElementById("prov2");
function showchangeContent()
{
	province.style.display="block";
}
function changeContent(index)
{
	
	
	if(index==0)
	{
		province.style.display="none";
	}
	else
	{
		document.getElementById("btnd").value=index;
		document.getElementById("btndd").value=index;
		province.style.display="none";
	}
	
}
function showchangeContent1()
{
	province1.style.display="block";
}
function changeContent1(index)
{
	
	
	if(index==0)
	{
		province1.style.display="none";
	}
	else
	{
		document.getElementById("btnd1").value=index;
		document.getElementById("btndd1").value=index;
		province1.style.display="none";
	}
	
}
function showchangeContent2()
{
	province2.style.display="block";
}
function changeContent2(index)
{
	
	
	if(index==0)
	{
		province2.style.display="none";
	}
	else
	{
		document.getElementById("btnd2").value=index;
		document.getElementById("btndd2").value=index;
		province2.style.display="none";
	}
	
}