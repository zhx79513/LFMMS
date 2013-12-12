<%@ page language="java"
	import="java.util.*, com.LFMMS.library.Hibernate.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>
<jsp:useBean id="team" class="com.LFMMS.library.Hibernate.Team"
	scope="session"></jsp:useBean>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>球队修改</title>

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
	<form method="post" action="servlet/TeamModifyConfirm"
		name="course_modify_form">
		ID:
	<input type="text" name="id" value="<%=team.getId()%>" readonly="readonly">
	<br /> 名称:
	<input type="text" name="name"
		value="<%=team.getName()%>">
	<br /> 主场:
	<input type="text" name="home"
		value="<%=team.getHome()%>">
	<br /> 主教练:
	<input type="text" name="coach" value="<%=team.getCoach()%>">
	<br />
	<input type="submit" name="submit" value="修改">
	<input type="reset" name="reset" value="重置">
	<input type="button" value="返回" onclick="javascript:window.location.href='./';">
	</form>
	

</body>
</html>
