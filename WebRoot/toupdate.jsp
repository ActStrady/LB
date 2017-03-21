<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri='/struts-tags' prefix='s'%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'toupdate.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form action="updateBook" method="post">
		<s:hidden name="resouce.resid" value="%{#request.resouce.resid}"></s:hidden>
		<p>
            <s:textfield label="id" name="resouce.resid"
                value="%{#request.resouce.resid }" />
        </p>
		<p>
			<s:textfield label="书名" name="resouce.bname"
				value="%{#request.resouce.bname }" />
		</p>
		<p>
			<s:textfield label="日期" name="resouce.bdate"
				value="%{#request.resouce.bdate }" />
		</p>
		<p>
			<s:textfield label="书名" name="resouce.price"
				value="%{#request.resouce.price }" />
		</p>
		<br>
		<p>
			<s:submit value="提交" align="center" />
		</p>
	</form>
</body>
</html>
