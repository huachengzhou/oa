<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>岗位列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/role_privilege.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-ztree-2.5.js"></script>
</head>
<body>

	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/css/images/title_arrow.gif" />
				岗位管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">

			<!-- 表头-->
			<thead>
				<tr align=center valign=middle id=TableTitle>
					<td width="150px">岗位名称</td>
					<td width="200px">岗位说明</td>
					<td>相关操作</td>
				</tr>
			</thead>

			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer">
				<c:forEach items="${roles}" var="role">
					<tr>
						<td>${role.name}</td>
						<input type="hidden" name="rid" value="${role.rid}">
						<td>${role.description}</td>
						<td><a href="removeRole?rid=${role.rid}">删除</a> <a
							href="updateRole_?rid=${role.rid}">修改</a> <a href="#" title="N_QUAN">设置权限</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<a href="addRole_"><img alt="图片崩溃"
					src="${pageContext.request.contextPath}/css/images/createNew.png"></a>
			</div>
		</div>
		<!-- ..........................................分隔符...................................................... -->
		<!-- 用户名: -->
		<div class="ItemBlock_Title1"
			style="display: none;width:100%;margin-top:20px;">
			<img style="border:0px;width:11px;height: 15px;padding-top:10px;"
				src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" />
			<label id="roleNameImage"
				style="padding-top:0px;padding-bottom:12px;">_</label>
		</div>
		<div id="Title" style="width:100%;display: none;">
			<!--配置权限标题-->
			<img border="0" width="13" height="13"
				src="${pageContext.request.contextPath}/css/images/title_arrow.gif" />
			配置权限
		</div>
		<!-- 表单内容显示 -->
		<div class="ItemBlockBorder" style="display: none;">


			<div class="ItemBlock">
				<table cellpadding="0" cellspacing="0" class="mainForm">
					<!--表头-->
					<thead>
						<tr align="LEFT" valign="MIDDLE" id="TableTitle">
							<td width="300px" style="padding-left: 7px;border:0px;"><input
								type="CHECKBOX" id="cbSelectAll" disabled="false" /> <label
								for="cbSelectAll">全选</label></td>
						</tr>
					</thead>

					<!--显示数据列表-->
					<tbody id="TableData">
						<tr class="TableDetail1">
							<!-- 显示权限树 -->
							<td>
								<ul id="privilegeTree" class="tree"></ul> 
								<!-- 没有加载出来旋转 --> 
								<img id="loading" src="css/images/loading.gif" />
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- ..........................................分隔符...................................................... -->
        <!-- 表单操作 -->
		<div id="InputDetailBar" style="display: none;">
			<input type="image"
				src="${pageContext.request.contextPath}/css/images/save.png"
				id="savePrivilege" /> <a href="javascript:history.go(-1);"><img
				src="${pageContext.request.contextPath}/css/images/goBack.png" /></a>
		</div>
	</div>
	<div class="Description">
		说明：<br /> 1，选中一个权限时：<br /> &nbsp;&nbsp;&nbsp;&nbsp; a，应该选中 他的所有直系上级。<br />
		&nbsp;&nbsp;&nbsp;&nbsp; b，应该选中他的所有直系下级。<br /> 2，取消选择一个权限时：<br />
		&nbsp;&nbsp;&nbsp;&nbsp; a，应该取消选择 他的所有直系下级。<br />
		&nbsp;&nbsp;&nbsp;&nbsp; b，如果同级的权限都是未选择状态，就应该取消选中他的直接上级，并递归向上做这个操作。<br />

		3，全选/取消全选。<br /> 4，默认选中当前岗位已有的权限。<br />
	</div>
</body>
</html>
