<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门设置</title>
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
				部门信息
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id=MainArea>
			<div class="ItemBlock_Title1">
				<!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="../style/blue/images/item_point.gif" /> 部门信息 </DIV>  -->
			</div>

			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<form:form commandName="dept" action="add">
					<div class="ItemBlock">
						<table cellpadding="0" cellspacing="0" class="mainForm">
							<tr>
								<td>部门名称</td>
								<td><form:input path="name" cssClass="InputStyle" /> *</td>
							</tr>
							<tr>
								<td>职能说明</td>
								<td><textarea name="description" class="TextareaStyle"></textarea></td>
							</tr>
						</table>
					</div>
			</div>

			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="submit"
					src="${pageContext.request.contextPath}/css/images/save.png"
					value="保存" /> <a href="goBack"> <img
					src="${pageContext.request.contextPath}/css/images/goBack.png"
					alt="图片崩溃" /></a>
			</div>
			</form:form>
	</div>

	<div class="Description">
		说明：<br /> 1，上级部门的列表是有层次结构的（树形）。<br />
		2，如果是修改：上级部门列表中不能显示当前修改的部门及其子孙部门。因为不能选择自已或自已的子部门作为上级部门。<br />
	</div>

</body>
</html>