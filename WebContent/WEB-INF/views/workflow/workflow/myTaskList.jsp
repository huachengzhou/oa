<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>待我审批</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/blue/pageCommon.css" />

</head>

<body>
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/css/images/title_arrow.gif" /> 待我审批
			</div>
			<div id="Title_End"></div>
		</div>
	</div>
	
	<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
				<td width="250">标题</td>
				<td width="115">申请人</td>
				<td width="115">申请日期</td>
				<td>相关操作</td>
			</tr>
		</thead>		
		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer">
        	<c:forEach items="${taskViews}" var="taskView">
				<tr class="TableDetail1 template">
					<td><a href="approveUI?taskId=${taskView.task.id}&fid=${taskView.form.fid}"> ${taskView.form.title} </a></td>
					<td>${taskView.form.formTemplate.name}&nbsp;</td>
					<td>${taskView.form.applictetime}&nbsp;</td>
					<td><a href="approveUI?taskId=${taskView.task.id}&fid=${taskView.form.fid}">审批处理</a></td>
				</tr>
        	</c:forEach>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail"><div id="TableTail_inside"></div></div>
</div>


</body>
</html>
