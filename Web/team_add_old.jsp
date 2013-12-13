<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>球队添加</title>

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
	<form method="post" action="servlet/TeamManage?action=add"
		name="course_modify_form">
		名称: <input type="text" name="name"> <br />
		主场: <input type="text" name="home"> <br /> 
		主教练: <input type="text" name="coach"> <br /> 
		<input type="submit" name="submit" value="添加"> 
		<input type="reset" name="reset" value="重置"> 
		<input type="button" value="返回" onclick="javascript:window.location.href='./';">
	</form>

</body>
</html>
