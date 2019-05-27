<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>办公系统-登录</title>
<style type="text/css">
html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, font, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td { padding:0; margin:0; font-size:12px; line-height:100%; font-family:Arial, sans-serif;}

ul, ol { list-style:none;}
img { border:0;}

body { margin:0; text-align:center; background:#FFF url(${ctx}/themes/default/images/login_bg.png) repeat-x top;}

#login { display:block; width:950px; margin:0 auto; text-align:left;}
#login_header { display:block; padding-top:40px; height:80px;}
.login_logo { float:left; margin-top:10px;}
.login_info { float:left; margin-left:10px; line-height:80px; font-size:18px; color:#0088cc; font-weight: bold;}
.login_headerContent { float:right; display:block; width:280px; height:80px; padding:0 40px; background:url(${ctx}/themes/default/images/login_header_bg.png) no-repeat top right;}
.navList { display:block; overflow:hidden; height:20px; padding-left:28px;}
.navList ul { float:left; display:block; overflow:hidden;}
.navList li { float:left; display:block; margin-left:-1px; padding:0 10px; background:url(${ctx}/themes/default/images/login_list.png) no-repeat 0 5px;}
.navList a { display:block; white-space:nowrap; line-height:21px; color:#000; text-decoration:none;}
.navList a:hover { text-decoration:underline;}

#login_content { display:block; position:relative;}
.login_title { display:block; padding:25px 0 0 38px;}
.loginForm { display:block; width:240px; padding:40px 20px 0 20px; position:absolute; right:40px;}
.loginForm p { margin:10px 0;}
.loginForm label { float:left; width:70px; padding:0 0 0 10px; line-height:25px; color:#4c4c4c; font-size:14px;}
.loginForm input { padding:3px 2px; border-style:solid; border-width:1px; border-color:#80a5c4;}
.loginForm .login_input {}
.loginForm .code { float:left; margin-right:5px;}
.login_bar { padding-left:70px;}
.login_bar .sub { display:block; width:75px; height:30px; border:none; background:url(${ctx}/themes/default/images/login_sub.png) no-repeat; cursor:pointer;}

.login_banner { display:block; height:270px;}
.login_main { display:block; height:200px; padding-right:40px; background:url(${ctx}/themes/default/images/login_content_bg.png) no-repeat top;}

.helpList { float:right; width:200px;}
.helpList li { display:block; padding-left:10px; background:url(${ctx}/themes/default/images/login_list.png) no-repeat 0 -40px;}
.helpList a { line-height:21px; color:#333; text-decoration:none; }
.helpList a:hover { text-decoration:underline;}

.login_inner { display:block; width:560px; padding:30px 20px 0 20px;}
.login_inner p { margin:10px 0; line-height:150%; font-size:14px; color:#666;}

#login_footer { clear:both; display:block; margin-bottom:20px; padding:10px; border-top:solid 1px #e2e5e8; color:#666; text-align:center;}
.login-error{text-align: center;color: red;}
.button{width:38px;height:18px;line-height:18px;border:0;margin:4px 0 0 10px;} 
</style>
</head>

<body>
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<a href="${ctx }"><img src="${ctx }/themes/default/images/login_logo.png" /></a>
			</h1>
			<div class="login_headerContent">
				<div class="navList">
<!-- 					<ul> -->
<!-- 						<li><a href="#">设为首页</a></li> -->
<!-- 						<li><a href="http://bbs.dwzjs.com">反馈</a></li> -->
<!-- 						<li><a href="doc/dwz-user-guide.pdf" target="_blank">帮助</a></li> -->
<!-- 					</ul> -->
				</div>
				<h2 class="login_title"><img src="${ctx }/themes/default/images/login_title.png" /></h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
				<div class="login-error">${error}</div>
				账号：admin &nbsp; 密码：123456 
				<form method="post" action="">
					<p>
						<label>用户名：</label>
						<input type="text" name="username" size="20" class="login_input" />
					</p>
					<p>
						<label>密码：</label>
						<input type="password" name="password" size="20" class="login_input" />
					</p>
					<p>
						<label>记住密码：</label>
						<input type="checkbox" name="rememberMe" value="true"/>
						<span >&nbsp;<br/></span>
					</p>
					<div class="login_bar">
						<input class="sub" type="submit" value=" " />
					</div>
				</form>
			</div>
			<div class="login_banner"><img src="${ctx }/themes/default/images/login_banner.jpg" /></div>
			<div class="login_main">
				<ul class="helpList">
				<!-- 用户使用帮助
				<li><a href="#">下载驱动程序</a></li> -->
				</ul>
				<div class="login_inner">
					<p>您可以使用办公系统 ，随时随地办公</p>
					<p>系统处于试运行状态，欢迎大家使用、吐槽……</p>
				</div>
			</div>
		</div>
		<div id="login_footer">
			Copyright &copy; 2009 西安鼎蓝通信科技有限公司 Inc. All Rights Reserved.
		</div>
	</div>
</body>
</html>
