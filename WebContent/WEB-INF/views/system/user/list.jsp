<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ page language="java" import="cn.blake.shoa.domain.Role"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>用户列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/user_role_.js"></script>
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
				用户管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">

			<!-- 表头-->
			<thead>
				<tr align=center valign=middle id=TableTitle>
					<td width="100">姓名</td>
					<td width="100">登录名</td>
					<td width="100">密码</td>
					<td width="100">所属部门</td>
					<td width="200">岗位</td>
					<td width="50">性别</td>
					<td width="200">电话</td>
					<td width="100">邮箱</td>
					<td>备注</td>
					<td>相关操作</td>
				</tr>
			</thead>

			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer" datakey="userList">
				<c:forEach items="${users}" var="user">
					<tr class="TableDetail1 template">
						<td>${user.name}&nbsp;</td>
						<input type="hidden" name="uid" value="${user.uid}">
						<td>${user.username}&nbsp;</td>
						<!-- <td>${user.password}&nbsp;</td> -->
						<td>${user.department.name}&nbsp;</td>
						<td><c:forEach items="${user.roles}" var="role">
								<font color="green">${role.name}</font>
							</c:forEach></td>
						<td>${user.sex}&nbsp;</td>
						<td>${user.phone}&nbsp;</td>
						<td>${user.email}&nbsp;</td>
						<td>xxxxxxxx</td>
						<td><a href="removeUser?uid=${user.uid}">删除</a> <a
							href="updateUser_?uid=${user.uid}">修改</a> <a href="#"
							onClick="return window.confirm('您确定要初始化密码为1234吗？')">初始化密码</a> <a
							href="#" title="N_QUAN">设置角色</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<a href="addUser_"><img
					src="${pageContext.request.contextPath}/css/images/createNew.png" /></a>
			</div>
		</div>
		<!-- ..........................................分隔符...................................................... -->
		<!-- 用户名: -->
		<div class="ItemBlock_Title1"
			style="display: none;width:100%;margin-top:20px;">
			<img style="border:0px;width:11px;height: 15px;padding-top:10px;"
				src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" />
			<label id="userNameImage"
				style="padding-top:0px;padding-bottom:12px;">dsgs</label>
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
								<ul id="roleTree" class="tree"></ul> 
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
</body>
</html>
