<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Itcast OA</title>
<link href="${pageContext.request.contextPath}/css/blue/login.css" type="text/css" rel="stylesheet">
</head>
<body LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0
	CLASS=PageBody>
	<form:form action="login" commandName="user">
		<div ID="CenterAreaBg">
			<DIV ID="CenterArea">
				<DIV ID="LogoImg">
					<IMG BORDER="0"
						SRC="${pageContext.request.contextPath}/css/blue/images/logo.png" />
				</DIV>
				<DIV ID="LoginInfo">
					<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>
						<TR>
							<TD width=45 CLASS="Subject"><IMG BORDER="0"
								SRC="${pageContext.request.contextPath}/css/blue/images/login/userId.gif" /></TD>
							<TD><form:input path="username" cssClass="TextField"
									size="20" /></TD>
							<TD ROWSPAN="2" STYLE="padding-left: 10px;"><INPUT
								TYPE="image"
								SRC="${pageContext.request.contextPath}/css/blue/images/login/userLogin_button.gif" /></TD>
						</TR>
						<TR>
							<TD CLASS="Subject"><IMG BORDER="0"
								SRC="${pageContext.request.contextPath}/css/blue/images/login/password.gif" /></TD>
							<TD><form:password path="password" cssClass="TextField"
									size="20" /></TD>
						</TR>
						<TR>
							<TD>${error}</TD>
						</TR>
					</TABLE>
				</DIV>
				<DIV ID="CopyRight">
					<A HREF="javascript:void(0)">&copy; 2010 版权所有 itcast</A>
				</DIV>
			</DIV>
		</div>
	</form:form>
</body>
</html>