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

<title>赛事添加</title>

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
	<form method="post" action="servlet/MatchManage?action=add"
		name="course_modify_form">
		主场球队ID: <input type="text" name="home_id"> <br />
		客场球队ID: <input type="text" name="away_id"> <br /> 
		比赛轮次: <input type="text" name="turn"> <br /> 
		比赛日期: <input type="text" name="date"> <br /> 
		主队比分: <input type="text" name="home_score"> <br /> 
		客队比分: <input type="text" name="away_score"> <br /> 
		<input type="submit" name="submit" value="添加"> 
		<input type="reset" name="reset" value="重置"> 
		<input type="button" value="返回" onclick="javascript:window.history.back();">
	</form>

</body>
</html>
