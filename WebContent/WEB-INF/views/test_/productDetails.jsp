<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件显示</title>
<style type="text/css">
#global {
	text-align: center;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<div id="global">
		<h4>The produce has bean</h4>
		<h5>Details</h5>
		<p>
			ProductName: ${product.name}<br> description:
			${product.description}<br> price: ${product.price}<br>
		</p>
		<h3>下载</h3>
		<p>
			<a href="download?fileName=${product.image.originalFilename}">${product.image.originalFilename}</a>
		</p>
	</div>
	<div id="global">
		<img alt="图片崩溃" src="image/${product.image.originalFilename}">

	</div>
</body>
</html>