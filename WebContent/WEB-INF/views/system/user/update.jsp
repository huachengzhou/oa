<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	line-height: 22px;
}
</style>
<title>用户信息</title>
</head>
<body>
	<div id=Title_bar>
		<div id=Title_bar_Head>
			<div id=Title_Head></div>
			<div id=Title>
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/css/images/title_arrow.gif" />
				用户信息显示
			</div>
			<div id=Title_End></div>
		</div>
		<div id=Title_bar_bg_up>
			<div id=Title_bar_bg></div>
		</div>
	</div>
	<!--显示表单内容-->
	<div id=MainArea>
		<div class=ItemBlock_Title1></div>
		<div class=ItemBlockBorder style="margin: 0 auto; width: 1000px;">

			<table>
				<tbody>
					<form:form action="updateUser" name="userForm">

						<tr>
							<td width="100">所属部门</td>
							<td><select name="did" class="SelectStyle">
									<!-- 默认选择这个 -->
									<option value="${user.department.did}" selected="selected">${user.department.name}</option>
									<c:forEach items="${departments}" var="department">
										<option value="${department.did}">${department.name}</option>
									</c:forEach>
							</select></td>
						</tr>

						<tr>
							<td>登录名 <input type="text" value="${user.name}" name="name"
								class="InputStyle"> <input type="hidden" name="uid"
								value="${user.uid}">
							</td>
							<td><input type="text" value="${user.username}"
								name="username" class="InputStyle">*（登录名要唯一）</td>
						</tr>
						<tr>
							<td>密码</td>
							<td><input type="password" value="${user.password}"
								name="password" class="InputStyle"> *</td>
						</tr>
						<tr>
							<td>性别</td>
							<td>${user.sex=='男'?'男':'女'}<input type="radio" name="sex"
								value="${user.sex}" checked="checked">
								${user.sex=='男'?'女':'男'}<input type="radio" name="sex"
								value="${user.sex=='男'?'女':'男'}">
							</td>
						</tr>
						<tr>
							<td>联系电话</td>
							<td><input type="text" value="${user.phone}" name="phone"
								class="InputStyle"></td>
						</tr>
						<tr>
							<td>E-mail</td>
							<td><input type="text" value="${user.email}" name="email"
								class="InputStyle"></td>
						</tr>
						<tr>
							<td><select name="rid" multiple="true" id="role_">
									<c:forEach items="${user.roles}" var="role">
										<!-- 预先选中,因为是修改,所以有可能不会改变,因此必须预先选中 -->
										<option value="${role.rid}" selected="selected">${role.name}</option>
									</c:forEach>
									<c:forEach items="${roles}" var="role">
										<option value="${role.rid}">${role.name}</option>
									</c:forEach>
							</select></td>
						</tr>
					</form:form>
					<tr>
						<td><input type="button"
							src="${pageContext.request.contextPath}/css/images/save.png"
							value="保存" id="submitButton"></td>
						<td><a href="goBackUser"> <img
								src="${pageContext.request.contextPath}/css/images/goBack.png"
								alt="图片崩溃" /></a></td>
					</tr>
				</tbody>
			</table>
			<script type="text/javascript">
				window.onload = function() {
					var xxPassword = document.userForm.password.value;
					/*捕获焦点并且,清空value*/
					document.userForm.password.onfocus = function() {
						document.userForm.password.value = "";
					};
					/*防止点击一下之后,又不输入值了的情况*/
					document.userForm.password.onblur = function() {
						if (document.userForm.password.value = "") {
							document.userForm.password.value = xxPassword;
						}
					};
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
						var uid = document.userForm.uid.value;
						var username = document.userForm.username.value;
						var password = document.userForm.password.value;
						var sex = encodeURIComponent(document.userForm.sex.value);
						var phone = document.userForm.phone.value;
						var email = document.userForm.email.value;
						var name = encodeURIComponent(document.userForm.name.value);
						var url = "${pageContext.request.contextPath}/updateUser?"
								+ "username="
								+ username
								+ "&password="
								+ password
								+ "&sex="
								+ sex
								+ "&rids="
								+ xxx
								+ "&phone="
								+ phone
								+ "&email="
								+ email
								+ "&did="
								+ did
								+ "&uid="
								+ uid
								+ "&name="
								+ name;
						window.location.href = url;
					};
				};
			</script>
		</div>
	</div>
</body>
</html>