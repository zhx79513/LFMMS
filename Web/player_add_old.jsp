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

<title>球员添加</title>

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
	<form method="post" action="servlet/PlayerManage?action=add"
		name="course_modify_form">
		姓名: <input type="text" name="name"> <br />
		球队ID: <input type="text" name="team_id"> <br /> 
		球衣号码: <input type="text" name="number"> <br /> 
		场上位置: <input type="text" name="position"> <br /> 
		身高: <input type="text" name="height"> <br /> 
		体重: <input type="text" name="weight"> <br /> 
		生日: <input type="text" name="birthday"> <br />
		<input type="submit" name="submit" value="添加"> 
		<input type="reset" name="reset" value="重置"> 
		<input type="button" value="返回" onclick="javascript:window.location.href='./';">
	</form>

</body>
</html>
