<%@ page language="java"
	import="java.util.*, com.LFMMS.library.Hibernate.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>
<jsp:useBean id="course" class="com.LFMMS.library.Hibernate.Course"
	scope="session"></jsp:useBean>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>赛事修改</title>

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
	<form method="post" action="servlet/MatchManage?action=modify_commit"
		name="course_modify_form">
		ID:
	<input type="text" name="id" value="<%=course.getId()%>" readonly="readonly">
	<br /> 主场球队ID:
	<input type="text" name="home_id"
		value="<%=course.getTeamByHomeId().getId()%>">
	<br /> 客场球队ID:
	<input type="text" name="away_id"
		value="<%=course.getTeamByAwayId().getId()%>">
	<br /> 比赛轮次:
	<input type="text" name="turn" value="<%=course.getTurn()%>">
	<br /> 比赛日期:
	<input type="text" name="date" value="<%=course.getMatchDate()%>">
	<br /> 主队比分:
	<input type="text" name="home_score" value="<%=course.getHomeScore()%>">
	<br /> 客队比分:
	<input type="text" name="away_score" value="<%=course.getAwayScore()%>">
	<br />
	<input type="submit" name="submit" value="修改">
	<input type="reset" name="reset" value="重置">
	<input type="button" value="返回" onclick="javascript:window.location.href='./';">
	</form>
	

</body>
</html>
