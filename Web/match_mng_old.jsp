<%@ page language="java"
	import="java.util.*, com.LFMMS.library.Hibernate.*"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>
<jsp:useBean id="courses" class="java.util.ArrayList" scope="session"></jsp:useBean>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>赛事管理</title>

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
	<table border="1" align="center" width="95%">
		<tbody>
			<tr>
				<td>ID</td>
				<td>主场球队ID</td>
				<td>客场球队ID</td>
				<td>比赛轮次</td>
				<td>比赛日期</td>
				<td>主队比分</td>
				<td>客队比分</td>
				<td>操作</td>
			</tr>
			<%
				Iterator it = courses.iterator();
				while (it.hasNext()) {
					Course course = (Course) it.next();
			%>
			<tr>

				<td><%=course.getId()%></td>
				<td><%=course.getTeamByHomeId().getId()%></td>
				<td><%=course.getTeamByAwayId().getId()%></td>
				<td><%=course.getTurn()%></td>
				<td><%=course.getMatchDate()%></td>
				<td><%=course.getHomeScore()%></td>
				<td><%=course.getAwayScore()%></td>
				<td><a
					href="servlet/MatchModify?course_id=<%=course.getId()%>">修改</a>&nbsp;<a
					href="servlet/MatchDelete?course_id=<%=course.getId()%>">删除</a>
				</td>

			</tr>
			<%
				}
			%>
		</tbody>
	</table>

<a href="/LFMMS/match_add.jsp">添加</a>
<a href="/LFMMS/admin.jsp">返回</a>
</body>
</html>
