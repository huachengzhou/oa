<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>提交申请</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
 
<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 提交申请
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
	<form:form commandName="formTemplate" method="post" action="workFlowAction_submit" enctype="multipart/form-data">
	    <input type="hidden" name="ftid" value="${formTemplate.ftid}">
	    <input type="hidden" name="processKey" value="${formTemplate.processKey}">
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" /> 下载文档模板 </div> 
        </div>
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<tr>
						<td><a href="downloadFormTemplate?ftid=${formTemplate.ftid}" style="text-decoration: underline">[点击下载文档模板文件]</a></td>
					</tr>
                </table>
            </div>
        </div>
		
		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" /> 申请信息 </div> 
        </div>
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td width="130">请选择填写好的文档</td>
                        <td><input type="file" name="file" class="InputStyle">  </td>
                    </tr>
                </table>
            </div>
        </div>
		
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="submit" src="${pageContext.request.contextPath}/css/blue/images/button/submit.PNG"/>
			<a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/css/images/goBack.png"/></a>
        </div>
    </form:form>
</div>

<div class="Description">
	使用说明：<br />
	1，下载模板文件。<br />
	2，填写文档中的表单。<br />
	3，选择这个填写好的文件进行提交。<br />
	<br />
	说明2：提交表单后，就会按照 模板对应的流程 开始流转。
</div>

</body>
</html>
