function trim(str) { //删除左右两端的空格
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
//登录验证
function validateForm() {
	var userName = document.forms["loginForm"]["userName"].value;
	if (trim(userName) == null || trim(userName) == "") {
		alert("请填写手机号！");
		return false;
	}
	if (trim(userName).length != 11) {
		alert('请输入有效的手机号码，需是11位！');
		return false;
	}
	var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	if (!myreg.test(trim(userName))) {
		alert('请输入有效的手机号码！');
		return false;
	}
	var userPassword = document.forms["loginForm"]["userPassword"].value;
	if (trim(userPassword) == null || trim(userPassword) == "") {
		alert("请填密码！");
		return false;
	}
	if (trim(userPassword).length < 6) {
		alert("输入密码不能低于6位数！");
		return false;
	}
	if (trim(userPassword).length > 16) {
		alert("输入密码不能大于16位数！");
		return false;
	}

}
//修改密码验证
function validatePassForm() {
	var userPassword = document.forms["updatePswForm"]["userPassword"].value;
	if (trim(userPassword) == null || trim(userPassword) == "") {
		alert("请填密码！");
		return false;
	}
	if (trim(userPassword).length < 6) {
		alert("输入密码不能低于6位数！");
		return false;
	}
	if (trim(userPassword).length > 16) {
		alert("输入密码不能大于16位数！");
		return false;
	}
	var passWord = document.forms["updatePswForm"]["passWord"].value;
	if (trim(passWord) == null || trim(passWord) == "") {
		alert("请填写新密码！");
		return false;
	}
	if (trim(passWord).length < 6) {
		alert("输入新密码不能低于6位数！");
		return false;
	}
	if (trim(passWord).length > 16) {
		alert("输入新密码不能大于16位数！");
		return false;
	}
	var newPassword = document.forms["updatePswForm"]["newPassword"].value;
	if (trim(newPassword) == null || trim(newPassword) == "") {
		alert("请填确认密码");
		return false;
	}
	if (trim(newPassword).length < 6) {
		alert("输入确认密码不能低于6位数！");
		return false;
	}
	if (trim(newPassword).length > 16) {
		alert("输入确认密码不能大于16位数！");
		return false;
	}
	if (newPassword !== passWord) {
		alert("两次输入密码不正确！");
		return false;
	}
	var newEamil = document.forms["updatePswForm"]["newEamil"].value;
	if (trim(newEamil) == null || trim(newEamil) == "") {
		alert("请填写邮箱");
		return false;
	}
	 var atpos=newEamil.indexOf("@");
	 var dotpos=newEamil.lastIndexOf(".");
	 if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length){
	   alert("不是一个有效的 e-mail 地址");
	   return false;
	  }
}

