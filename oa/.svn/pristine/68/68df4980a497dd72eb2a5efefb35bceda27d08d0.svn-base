<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>    
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>陇浩IT资源管理平台</title>
<link href="${ctx}/styles/dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${ctx}/styles/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${ctx}/styles/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="${ctx}/styles/validationEngine/css/validationEngine.jquery.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${ctx}/styles/ztree/css/zTreeStyle.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${ctx}/styles/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${ctx}/styles/treeTable/themes/default/treeTable.css" rel="stylesheet" type="text/css" />
<!-- 详细页面表格的css -->
<link href="${ctx}/styles/tablecss/table.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/keta/css/keta.css" rel="stylesheet" type="text/css" />

<!--[if IE]>
<link href="${ctx}/styles/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->
<!--[if lte IE 9]>
<script src="${ctx}/styles/dwz/js/speedup.js" type="text/javascript"></script>
<![endif]-->
<script src="${ctx}/styles/jquery/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>

<script src="${ctx}/styles/treeTable/jquery.treeTable.min.js" type="text/javascript"></script>
<%-- form验证 --%>
<script src="${ctx}/styles/validationEngine/js/languages/jquery.validationEngine-zh_CN-ciaoca.js" type="text/javascript" charset="utf-8"></script>
<script src="${ctx}/styles/validationEngine/js/jquery.validationEngine-2.6.4.js" type="text/javascript" charset="utf-8"></script>

<%-- <script src="${ctx}/styles/dwz/js/dwz.min.js" type="text/javascript"></script> --%>

<script src="${ctx}/styles/dwz/js/dwz.core.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.util.date.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.drag.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.tree.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.accordion.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.ui.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.theme.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.navTab.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.tab.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.resize.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.dialog.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.stable.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.ajax.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.pagination.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.database.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.effects.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.panel.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.history.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.combox.js" type="text/javascript"></script>
<script src="${ctx}/styles/dwz/js/dwz.print.js" type="text/javascript"></script>

<!-- jquery - simplemodal-->
<script src="${ctx}/styles/simplemodal/js/ jquery.simplemodal-1.4.4.js" type="text/javascript"></script>

<script src="${ctx}/styles/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<%-- 自定义JS --%>
<script src="${ctx}/styles/dwz/js/customer.js" type="text/javascript"></script>
<script src="${ctx}/styles/keta/js/keta.js" type="text/javascript"></script>
<%-- upload --%>
<script src="${ctx}/styles/uploadify/scripts/jquery.uploadify.min.js" type="text/javascript"></script>
<%-- zTree --%>
<script src="${ctx}/styles/ztree/js/jquery.ztree.all-3.5.min.js" type="text/javascript"></script>

<!-- jquery - simplemodal用样式 -->
<link href="${ctx}/styles/simplemodal/css/box.css"  rel="stylesheet" type="text/css" />	

<style>
#basic-dialog-question,#basic-dialog-warn,#basic-dialog{
	display:none;
}
/* Overlay */
#simplemodal-overlay {background-color:#000;}
.simplemodal-wrap{background-color:#fff;}

/* Container */
#simplemodal-container {
	height:153px; 
	width:500px;
}
#ifr-dialog-content{
	height:300px; 
	width:700px;
}

</style>

<script type="text/javascript">
$(function(){	
	DWZ.init("${ctx}/styles/dwz/dwz.frag.xml", {
		loginUrl:"${ctx}/login/timeout", 
		loginTitle:"登录",	// 弹出登录对话框
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"${ctx}/styles/dwz/themes"});
		}
	});
});
</script>
</head>
<body scroll="no">
<div id="layout">
	<div id="header">
		<div class="headerNav">
			<a class="logo" href="${ctx}/management/index">Logo</a>
			<ul class="nav">
				<li><a href="${ctx}/management/index">主页</a></li>
				<li><a href="${ctx}/management/index/updateBase" target="dialog" mask="true" width="550" height="250">修改用户信息</a></li>
				<li><a href="${ctx}/management/index/updatePwd" target="dialog" mask="true" width="500" height="200">修改密码</a></li>
				<li><a href="${ctx}/logout">退出</a></li>
			</ul>
			<%-- 
			<ul class="themeList" id="themeList">
				<li theme="default"><div class="selected">blue</div></li>
				<li theme="green"><div>green</div></li>
				<li theme="purple"><div>purple</div></li>
				<li theme="silver"><div>silver</div></li>
				<li theme="azure"><div>天蓝</div></li>
			</ul>
			--%>
		</div>
	</div>
	<div id="leftside">
		<div id="sidebar_s">
			<div class="collapse">
				<div class="toggleCollapse"><div></div></div>
			</div>
		</div>
		<div id="sidebar">
			<div class="toggleCollapse"><h2>菜单</h2><div>collapse</div></div>
			<div class="accordion" fillSpace="sideBar">
				<c:forEach var="level1" items="${menuModule.children }">
					<div class="accordionHeader">
						<h2><span>Folder</span>${level1.name }</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder expand">
						<c:forEach var="level2" items="${level1.children }">
							<li>
								<dwz:menuAccordion child="${level2 }" urlPrefix="${ctx }"/>
							</li>
						</c:forEach>
						</ul>
					</div>												
				</c:forEach>				
			</div>
		</div>
	</div>
	<div id="container">
		<div id="navTab" class="tabsPage">
			<div class="tabsPageHeader">
				<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
					<ul class="navTab-tab">
						<li tabid="main" class="main"><a href="javascript:void(0)"><span><span class="home_icon">主页</span></span></a></li>
					</ul>
				</div>
				<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
				<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
				<div class="tabsMore">more</div>
			</div>
			<ul class="tabsMoreList">
				<li><a href="javascript:void(0)">主页</a></li>
			</ul>
			<div class="navTab-panel tabsPageContent layoutBox">
				<div class="page unitBox">
					<div class="accountInfo">
						<div class="right">
							<p><fmt:formatDate value="<%=new Date() %>" dateStyle="full"/></p>
						</div>
						<p><span>欢迎, ${login_user.employee.name } .</span></p>
					</div>
					<div class="pageFormContent" layouth="80">
					<fieldset>
						<legend>基本信息</legend>
						<dl>
							<dt style="width: 60px;">登录名称：</dt>
							<dd><span class="unit">${login_user.username }</span></dd>
						</dl>
						<dl>
							<dt style="width: 60px;">员工名字：</dt>
							<dd><span class="unit">${login_user.employee.name }</span></dd>
						</dl>
						<dl>
							<dt style="width: 60px;">电话：</dt>
							<dd><span class="unit">${login_user.phone }</span></dd>
						</dl>
						<dl>
							<dt style="width: 60px;">E-Mail：</dt>
							<dd><span class="unit">${login_user.email }</span></dd>
						</dl>
						<dl>
							<dt style="width: 60px;">创建时间：</dt>
							<dd><span class="unit"><fmt:formatDate value="${login_user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span></dd>
						</dl>
						<dl>
							<dt style="width: 60px;">可用状态：</dt>
							<dd><span class="unit">${(login_user.status == "enabled")? "可用":"不可用"}</span></dd>
						</dl>
						<dl>
							<dt style="width: 60px;">所属机构：</dt>
							<dd><span class="unit">${login_user.organization.name }</span></dd>
						</dl>
					</fieldset>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<div id="basic-dialog-warn">
		<!-- 普通弹出层 [[ -->  
		<div class="box-title show"><h2>提示</h2></div>  
		<div class="box-main">
			<div class="tips">      
				<span class="tips-ico">
					<span id="ico-type" class="ico-warn"><!-- 图标 --></span>
				</span>      
				<div class="tips-content">        
					<div id="message" class="tips-title">系统繁忙，请稍候重试</div>        
					<div class="tips-line"></div>     
				</div>    
			</div>
			<div class="box-buttons"><button type="button" class="simplemodal-close">关 闭</button></div>
		</div>  
		<!-- 普通弹出层 ]] -->
</div>
	
<div id="basic-dialog-question">
		<!-- 普通弹出层 [[ -->  
		<div class="box-title show"><h2>提示</h2></div>  
		<div class="box-main">
			<div class="tips">      
				<span class="tips-ico">
					<span id="ico-type" class="ico-question"><!-- 图标 --></span>
				</span>      
				<div class="tips-content">        
					<div id="message" class="tips-title">系统繁忙，请稍候重试</div>        
					<div class="tips-line"></div>     
				</div>    
			</div>
			<div class="box-buttons">
				<button id="ok-button" type="button" onclick="ok();" class="simplemodal-close">确 认</button>
				<button type="button" class="simplemodal-close">关 闭</button>
			</div>
			<div class="box-buttons"></div>
		</div>  
		<!-- 普通弹出层 ]] -->
</div>	

<div id="basic-dialog">
		<!-- 普通弹出层 [[ -->  
		<div class="box-title show"><h2  id="box-title">提示</h2></div>  
		<div class="box-main">
			<div class="tips">      
				<span class="tips-ico">
					<span id="ico-type" class=""><!-- 图标 --></span>
				</span>      
				<div class="tips-content">        
					<div id="message" class="tips-title"></div>        
					<div class="tips-line"></div>     
				</div>    
			</div>
			<div class="box-buttons">
				<button type="button" class="simplemodal-close">关 闭</button>
			</div>
			<div class="box-buttons"></div>
		</div>  
		<!-- 普通弹出层 ]] -->
</div>	
	
</div>
<div id="footer">Copyright &copy; 2016, 西安陇浩网络科技有限公司 Inc. All Rights Reserve.</div>
</body>
</html>