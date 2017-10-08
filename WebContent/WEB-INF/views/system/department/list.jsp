<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>部门列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/css/images/title_arrow.gif" />
				部门管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">

			<!-- 表头-->
			<thead>
				<tr align=center valign=middle id=TableTitle>
					<td width="150px">部门名称</td>
					<td width="200px">职能说明</td>
					<td>相关操作</td>
				</tr>
			</thead>

			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer">
				<c:forEach items="${departments}" var="department">
					<tr>
						<td>${department.name}</td>
						<td>${department.description}</td>
						<td><a href="removeDepartment?did=${department.did}">删除</a> <a
							href="updateDepartment_?did=${department.did}">修改</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<a href="add_"><img
					src="${pageContext.request.contextPath}/css/images/createNew.png" /></a>
			</div>
		</div>
	</div>

	<!--说明-->
	<div id="Description">
		说明：<br /> 1，列表页面只显示一层的（同级的）部门数据，默认显示最顶级的部门列表。<br />
		2，点击部门名称，可以查看此部门相应的下级部门列表。<br /> 3，删除部门时，同时删除此部门的所有下级部门。
	</div>

</body>
</html>
