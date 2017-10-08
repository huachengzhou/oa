<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<html>
<head>
<title>ItcastOA</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<frameset rows="100,*,25" framespacing="0" border="0" frameborder="0">
    <frame src="forward_top" name="TopMenu"  scrolling="no" noresize />
    <frameset cols="180,*" id="resize">
        <frame noresize name="menu" src="forward_left" scrolling="yes" />
        <frame noresize name="right" src="forward_right" scrolling="yes" />
    </frameset>
    <frame noresize name="status_bar" scrolling="no" src="forward_bottom" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
