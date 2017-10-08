<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>岗位设置</title>
</head>
<body>
	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/css/images/title_arrow.gif" />
				岗位信息
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id=MainArea>
			<div class="ItemBlock_Title1">
			</div>

			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<form:form commandName="role" action="addRole">
					<div class="ItemBlock">
						<table cellpadding="0" cellspacing="0" class="mainForm">
							<tr>
								<td>岗位名称</td>
								<td><form:input path="name" cssClass="InputStyle" /> *</td>
							</tr>
							<tr>
								<td>岗位说明</td>
								<td><textarea name="description" class="TextareaStyle"></textarea></td>
							</tr>
						</table>
					</div>
			</div>

			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="submit"
					src="${pageContext.request.contextPath}/css/images/save.png"
					value="保存" /> <a href="goBackRole"> <img
					src="${pageContext.request.contextPath}/css/images/goBack.png"
					alt="图片崩溃" /></a>
			</div>
			</form:form>
	</div>


</body>
</html>