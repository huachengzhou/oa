<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>表单模板列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 模板管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
             <tr align=center valign=middle id=TableTitle>
            	<td width="250px">模板名称</td>
				<td width="250px">所用流程</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="documentTemplateList">
        	<c:forEach items="${formTemplates}" var="formTemplate">
        		<tr>
        			<td> ${formTemplate.name}</td>
        			<td> ${formTemplate.processKey}</td>
        			<td> <a href="removeDocument?ftid=${formTemplate.ftid}">删除</a> &nbsp; <a href="#">修改</a> &nbsp;
        				<a href="downloadFormTemplate?ftid=${formTemplate.ftid}">下载</a> &nbsp;
        			</td>
        		</tr>
        	</c:forEach>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
			<a href="formTemplateAddUI"><img src="${pageContext.request.contextPath}/css/blue/images/button/addNew.PNG" /></a>
        </div>
    </div>

	<div class="description">
		说明：<br />
		1，删除时，相应的文件也被删除。<br />
		2，下载时，文件名默认为：{表单模板名称}.doc<br />
	</div>

</div>
</body>
</html>
