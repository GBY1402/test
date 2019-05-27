<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>办公系统</title>
<link href="${ctx }/static/dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${ctx }/static/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${ctx }/static/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="${ctx }/static/dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lte IE 9]>
<script src="js/speedup.js" type="text/javascript"></script>
<![endif]-->

<script src="${ctx }/static/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
<script type="text/javascript" src="${ctx }/static/dwz/chart/raphael.js"></script>
<script type="text/javascript" src="${ctx }/static/dwz/chart/g.raphael.js"></script>
<script type="text/javascript" src="${ctx }/static/dwz/chart/g.bar.js"></script>
<script type="text/javascript" src="${ctx }/static/dwz/chart/g.line.js"></script>
<script type="text/javascript" src="${ctx }/static/dwz/chart/g.pie.js"></script>
<script type="text/javascript" src="${ctx }/static/dwz/chart/g.dot.js"></script>
<!-- 
<script src="${ctx }/static/dwz/js/dwz.core.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.util.date.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.drag.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.tree.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.accordion.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.ui.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.theme.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.navTab.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.tab.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.resize.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.dialog.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.stable.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.ajax.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.pagination.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.database.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.effects.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.panel.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.history.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.combox.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.print.js" type="text/javascript"></script>
 -->
<!-- 自定义脚本 -->
<%-- <script src="${ctx }/static/js/jquery.dlsw.js" type="text/javascript"></script> --%>

<!-- 可以用dwz.min.js替换前面全部dwz.*.js (注意：替换是下面dwz.regional.zh.js还需要引入)-->
<script src="${ctx }/static/dwz/js/dwz.min.js" type="text/javascript"></script>
<script src="${ctx }/static/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("${ctx }/static/dwz/dwz.frag.xml", {
		loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		keys: {statusCode:"statusCode", message:"message"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});

</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="#">标志</a>
				<ul class="nav">
					<li><a href="${ctx }/user/1/changePassword" target="dialog" width="600">设置</a></li>
					<li><a href="${ctx }/logout">退出</a></li>
				</ul>
			</div>
			<!-- navMenu -->
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>
				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2><span>Folder</span>系统菜单</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a>系统安全</a>
								<ul>
									<li><a target="navTab" href="${ctx }/organization" rel="page1">组织结构</a></li>
									<li><a target="navTab" href="${ctx }/user" rel="page2" >用户管理</a></li>
									<li><a target="navTab" href="${ctx }/resource" rel="page3" >资源管理</a></li>
									<li><a target="navTab" href="${ctx }/role" rel="page4">角色管理</a></li>
									<li><a target="navTab" href="${ctx }/employee" rel="page5">员工信息</a></li>
									<li><a target="navTab" href="${ctx }/dailywk" rel="page6">日报周报</a></li>
									<li><a target="navTab" href="${ctx }/dailywk/inspect"  rel="page7">日报周报督查</a></li>
									<li><a target="navTab" href="${ctx }/notice" rel="page8">通知公告</a></li>
									<li><a target="navTab" href="${ctx }/rules" rel="page9">规章制度</a></li>
									<li><a target="navTab" href="${ctx }/stimulate" rel="page10">员工激励</a></li>
									<li><a target="navTab" href="${ctx }/customer" rel="page11">客户管理</a></li>
									<li><a target="navTab" href="${ctx }/project" rel="page12">项目管理</a></li>
									<li><a target="navTab" href="${ctx }/area" rel="page13">区域管理</a></li>
									<li><a target="navTab" href="${ctx }/rewardsCount" rel="page14">奖惩统计</a></li>
									<li><a target="navTab" href="${ctx }/personCount/list" rel="page15">人力统计</a></li>
									<li><a target="navTab" href="${ctx }/attachfile" rel="page16">附件管理</a></li>
									<li><a target="navTab" href="${ctx }/caseinfo" rel="page17">案例维护</a></li>
									<li><a target="navTab" href="${ctx }/caseinfo/list" rel="page18">案例库</a></li>
									<li><a target="navTab" href="${ctx }/singleProcure" rel="page19">单采</a></li>
									<li><a target="navTab" href="${ctx }/projectProcure" rel="page20">项目采购</a></li>
									<li><a target="navTab" href="${ctx }/supplier" rel="page21">供应商</a></li>
								</ul>
							</li>
						</ul>
					</div>
					
					
<%-- 				<c:forEach items="${menus }" var="munu2"> --%>
<!-- 					<div class="accordionHeader"> -->
<%-- 						<h2><span>${munu2.name }</span>${munu2.name }</h2> --%>
<!-- 					</div> -->
<!-- 					<div class="accordionContent"> -->
<!-- 						<ul class="tree"> -->
<!-- 							<li><a href="newPage1.html" target="dialog" rel="dlg_page">列表</a></li> -->
<!-- 							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">列表</a></li> -->
<!-- 						</ul> -->
<!-- 					</div> -->
<%-- 					</c:forEach> --%>
					
				</div>
				
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<!-- start -->
						<div class="accountInfo">
							<div class="alertInfo">
								<p><span>重大事件</span></p>
								<p>鼎蓝通信科技有限公司</p>
							</div>
							<div class="right">
								<p style="color:red">重大事件 <a href="#" target="_blank">鼎蓝通信科技有限公司</a></p>
							</div>
						</div>
						<!-- end -->
						
						<!--start  -->
						<div class="pageContent sortDrag" selector="h1" style="width: 50%">
							<div class="panel collapse" minH="100" defH="150">
								<h1>公告<span style="margin-left: 80%">更多</span></h1>
								<div>
									<p>
										<table class="list" width="98%">
											<tbody>
												<c:forEach items="${notice }" var="notice" varStatus="sta" begin="0" end="5" step="1">
													<tr>
														<td>${sta.index+1}</td>
														<td><a target="dialog" href="${ctx }/notice/${notice.id}/view" mask="true" width="800" height="480"><p>${notice.title}</p></a></td>
														<td align="center">
															${notice.noticeType.info}
														</td>
														<td align="center">${notice.publishDateTime}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</p>
								</div>
							</div>
						</div>
						<!-- end -->
	
					</div>
				</div>
				<br/>
			</div>
		</div>

	</div>
	<div id="footer">Copyright &copy; 2014 <a href="demo_page2.html" target="dialog">西安鼎蓝通信科技有限公司</a></div>
</body>
</html>
