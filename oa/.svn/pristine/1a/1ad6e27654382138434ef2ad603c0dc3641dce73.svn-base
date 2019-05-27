<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>陇浩IT资源管理平台</title>
<link href="${ctx}/styles/dwz/themes/default/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/dwz/themes/css/core.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/dwz/themes/css/login.css" rel="stylesheet" type="text/css" />

<!-- form验证 -->
<link rel="stylesheet" href="${ctx}/styles/validationEngine/css/validationEngine.jquery.css" type="text/css"/>
<script src="${ctx}/styles/jquery/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="${ctx}/styles/validationEngine/js/languages/jquery.validationEngine-zh_CN.js" type="text/javascript" charset="utf-8"></script>
<script src="${ctx}/styles/validationEngine/js/jquery.validationEngine-2.6.4.js" type="text/javascript" charset="utf-8"></script>
<script>
    jQuery(document).ready(function(){
        jQuery("#formID").validationEngine();
    });
</script>
</head>

<body>
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<img src="${ctx}/styles/dwz/themes/default/images/logo_title.png" />
			</h1>

			<div class="login_headerContent">
				<div class="navList">
					<ul>
<%-- 						<li><a href="${ctx}/management/index">后台主页</a></li> --%>
<!-- 						<li><a href="https://github.com/ketayao/keta-custom" target="_blank">k-custom主页</a></li> -->
<!-- 						<li><a href="#">设为首页</a></li> -->
<!-- 						<li><a href="http://bbs.dwzjs.com">反馈</a></li> -->
<!-- 						<li><a href="doc/dwz-user-guide.pdf" target="_blank">帮助</a></li> -->
					</ul>
				</div>
				<h2 class="login_title"><img src="${ctx }/styles/dwz/themes/default/images/login_title.png" /></h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
				<form method="post" action="${ctx}/login" id="formID" >
			<%-- 		<c:if test="${msg!=null }">
						<p style="color: red; margin-left: 10px;">${msg }</p>
					</c:if> --%>
					<p>
						<label>用户名:</label>
						<input type="text" name="username" style="width: 150px;" id="username" value="${username }"/>
					</p>
					<p>
						<label>密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
						<input type="password" name="password" style="width: 150px;" id="password"/>
					</p>
					<!-- <p>
						<label>记住我:</label>
						<input type="checkbox" id="rememberMe" name="rememberMe"/>
					</p>		 -->			
					<div class="login_bar" style="disply:block;float:left;">
						<input class="sub" type="submit" value=""/>
					</div>
				</form>
			</div>
			<div class="login_banner"><img src="${ctx}/styles/dwz/themes/default/images/login_banner.jpg" /></div>
			<div class="login_main">
<!-- 				<ul class="helpList"> -->
<!-- 					<li><a href="javascript:toggleBox('forgotPwd')">忘记密码?</a></li> -->
<!-- 				</ul> -->

				<div class="login_inner">
					<!-- <p>测试用户名: admin</p>
					<p>测试密码: 123456</p> -->
					<p>此版本只做为试运行版本。</p>
				</div>
			</div>
		</div>
		<div id="login_footer">
			Copyright &copy; 2017, 西安陇浩网络科技有限公司 Inc. All Rights Reserve.
		</div>
	</div>
</body>
</html>