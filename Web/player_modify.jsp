<%@ page language="java"
	import="java.util.*, com.LFMMS.library.Hibernate.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>
<jsp:useBean id="player" class="com.LFMMS.library.Hibernate.Player"
	scope="session"></jsp:useBean>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>球员修改</title>

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
	<form method="post" action="servlet/PlayerManage?action=modify_commit"
		name="course_modify_form">
		ID: <input type="text" name="id" value="<%=player.getId()%>" readonly="readonly"> <br /> 
		姓名: <input type="text" name="name" value="<%=player.getName()%>"> <br /> 
		球队ID: <input type="text" name="team_id" value="<%=player.getTeam().getId()%>"> <br /> 
		球衣号码: <input type="text" name="number" value="<%=player.getNumber()%>"> <br /> 
		场上位置: <input type="text" name="position" value="<%=player.getPosition()%>"> <br /> 
		身高: <input type="text" name="height" value="<%=player.getHeight()%>"> <br /> 
		体重: <input type="text" name="weight" value="<%=player.getWeight()%>"> <br />
		生日: <input type="text" name="birthday" value="<%=player.getBirthday()%>"> <br /> 
		<input type="submit" name="submit" value="修改"> 
		<input type="reset" name="reset" value="重置"> 
		<input type="button" value="返回" onclick="javascript:window.location.href='./';">
	</form>


</body>
</html>
