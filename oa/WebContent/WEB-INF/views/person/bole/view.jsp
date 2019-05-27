<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
		<div class="pageFormContent" layoutH="56">
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>伯乐基本信息</legend>
			<table class="gridtable" >
				<tr>
				    <td align="right">昵称：</td><td>${personBoleInfo.boleName }</td>
				    <td  align="right">头像：</td><td>${personBoleInfo.boleImage }</td>
				</tr>
				<tr>
				    <td align="right">等级：</td>
				    <td>${personBoleInfo.boleGrade }</td>
					 <td align="right">经验：</td>
				    <td>${personBoleInfo.boleExperience }</td>
				</tr>
				<tr>
				    <td align="right">评分：</td>
				    <td>${personBoleInfo.boleScore }</td>
					 <td align="right">二维码图片路径：</td>
				    <td><a href="${personBoleInfo.boleQRImage }">${personBoleInfo.boleQRImage }</a></td>
				</tr>
				<tr>
				    <td align="right">行业：</td>
				    <td>${personBoleInfo.boleIndustry.name }</td>
					 <td align="right">推介人数：</td>
				    <td>${personBoleInfo.boleRecomNum }</td>
				</tr>
				<tr>
				    <td align="right">免费推介卡：</td>
				    <td>${personBoleInfo.boleRecomCard }</td>
					 <td align="right">点赞数：</td>
				    <td>${personBoleInfo.boleFabulous }</td>
				</tr>
				
			</table>
		</fieldset>
		<fieldset style="width:95%; margin: 0px auto;">
			<legend>维护信息</legend>
			<table class="gridtable">
				<tr>
				    <td align="right" >创建人：</td><td >${personBoleInfo.createUser }</td>
				      <td align="right">创建时间：</td><td><fmt:formatDate value="${personBoleInfo.createTime}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
				    <td align="right">修改人：</td><td >${personBoleInfo.updateUser }</td>
					<td align="right">修改时间：</td><td><fmt:formatDate value="${personBoleInfo.updateTime}" pattern="yyyy-MM-dd"/></td>
				</tr>
			</table>
		</fieldset>
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
</div>
