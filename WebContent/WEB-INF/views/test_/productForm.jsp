<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
<style type="text/css">
</style>
</head>
<body>
	<div id="global">
		<form:form commandName="product" action="product_save" method="post"
			enctype="multipart/form-data">
			<fieldset>
				<legend>Add a product </legend>
				<p>
					<label for="name">Product Name:</label>
					<form:input path="name" id="name" cssErrorClass="error" />
				</p>
				<p>
					<label for="description">Description:</label>
					<form:input path="description" id="description" />
				</p>
				<p>
					<label for="price">Price:</label>
					<form:input path="price" id="price" cssErrorClass="error" />
				</p>
				<p>
					<label for="image">Product Image:</label> <input type="file"
						name="file">
				</p>
				<p id="button">
				<input id="reset" type="reset" tabindex="4">
				<input type="submit" tabindex="5" value="submit">
				</p>
			</fieldset>
		</form:form>
	</div>
</body>
</html>