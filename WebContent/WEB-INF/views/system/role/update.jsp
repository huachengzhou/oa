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
<title>岗位信息</title>
</head>
<body>
	<div id=Title_bar>
		<div id=Title_bar_Head>
			<div id=Title_Head></div>
			<div id=Title>
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/css/images/title_arrow.gif" />
				岗位信息显示
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
					<form:form action="updateRole">
						<tr>
							<td style="margin-right: 100px; display: inline-block;"><font
								color="blue">岗位名称</font></td>
							<td style="margin-bottom: 50px;"><input type="text"
								name="name" class="InputStyle" value="${role.name}" /></td>
						</tr>
						<tr>
							<td><font color="blue">岗位说明</font></td>
							<td><textarea class="TextareaStyle" name="description">${role.description}</textarea>
								<input type="hidden" name="rid" value="${role.rid}">
							</td>
						</tr>
						<tr>
							<td><input type="submit" value="submit"></td>
							<td><a href="goBackRole"> <img
									src="${pageContext.request.contextPath}/css/images/goBack.png"
									alt="图片崩溃" /></a></td>
						</tr>
					</form:form>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>