<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户设置</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.8.0.js"></script>
</head>
<body>
	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/css/images/title_arrow.gif" />
				用户信息
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id=MainArea>
		<div class="ItemBlock_Title1"></div>

		<!-- 表单内容显示 -->
		<form:form commandName="user" action="addUser" name="userForm">
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table cellpadding="0" cellspacing="0" class="mainForm">
						<tr>
							<td width="100">所属部门</td>
							<td><select name="did" class="SelectStyle">
									<c:forEach items="${departments}" var="department">
										<option value="${department.did}">${department.name}</option>
									</c:forEach>
							</select></td>
						</tr>

						<tr>
							<td>姓名</td>
							<td><input type="text" name="name" class="InputStyle">
							</td>
						</tr>

						<tr>
							<td>登录名</td>
							<td><form:input path="username" cssClass="InputStyle" />*（登录名要唯一）
							</td>
						</tr>
						<tr>
							<td>密码</td>
							<td><form:password path="password" /> *</td>
						</tr>
						<tr>
							<td>性别</td>
							<td><form:radiobuttons items="${sexList}" path="sex"
									id="male" /></td>
						</tr>
						<tr>
							<td>联系电话</td>
							<td><form:input path="phone" cssClass="InputStyle" /></td>
						</tr>
						<tr>
							<td>E-mail</td>
							<td><form:input path="email" cssClass="InputStyle" /></td>
						</tr>
					</table>
				</div>
			</div>

			<div class="ItemBlock_Title1">
				<!-- 信息说明 -->
				<div class="ItemBlock_Title1">
					<img border="0" width="4" height="7"
						src="${pageContext.request.contextPath}/css/images/item_point.gif" />
					岗位设置
				</div>
			</div>

			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table cellpadding="0" cellspacing="0" class="mainForm">
						<tr>
							<td width="100">岗位</td>
							<td><select multiple="true" id="role_" name="rid">
									<c:forEach items="${roles}" var="role">
										<option value="${role.rid}">${role.name}</option>
									</c:forEach>
							</select></td>
						</tr>
					</table>
				</div>
			</div>
		</form:form>
		<!-- 表单操作 -->
		<div id="InputDetailBar">
			<input type="button"
				src="${pageContext.request.contextPath}/css/images/save.png"
				value="保存" id="submitButton"> <a href="goBackUser"> <img
				src="${pageContext.request.contextPath}/css/images/goBack.png"
				alt="图片崩溃" /></a>
		</div>
	</div>
	<script type="text/javascript">
		window.onload = function() {
			/*AJAX传递数据*/
			var submitButton = document.getElementById('submitButton');
			submitButton.onclick = function() {
				var role = document.getElementById('role_');
				var optionElement = role.options;
				var xxx = "";
				for (var i = 0; i < optionElement.length; i++) {
					if (optionElement[i].selected) {
						xxx += optionElement[i].value + ",";
					}
				}
				console.log("reds:" + xxx);
				xxx = xxx.substr(0, xxx.length - 1); /*自动截取最后一个,*/
				var did = document.userForm.did.value;
				var username = document.userForm.username.value;
				var password = document.userForm.password.value;
				var sex = encodeURIComponent(document.userForm.sex.value);
				var name = encodeURIComponent(document.userForm.name.value);
				var phone = document.userForm.phone.value;
				var email = document.userForm.email.value;
				var url = "${pageContext.request.contextPath}/addUser?"
						+ "username=" + username + "&password=" + password
						+ "&sex=" + sex + "&rids=" + xxx + "&phone=" + phone
						+ "&email=" + email + "&did=" + did + "&name=" + name;
				window.location.href = url;
			};
		};
	</script>
	<div class="Description">
		说明：<br /> 1，用户的登录名要唯一，在填写时要同时检测是否可用。<br /> 2，新建用户后，密码被初始化为"1234"。<br />
		3，密码在数据库中存储的是MD5摘要（不是存储明文密码）。<br /> 4，用户登录系统后可以使用“个人设置→修改密码”功能修改密码。<br />
		5，新建用户后，会自动指定默认的头像。用户可以使用“个人设置→个人信息”功能修改自已的头像<br />
		6，修改用户信息时，登录名不可修改。
	</div>
</body>
</html>