<%@ page language="java"
	import="java.util.*, com.LFMMS.library.Hibernate.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>
<jsp:useBean id="teams" class="java.util.ArrayList" scope="session"></jsp:useBean>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>球队管理</title>

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
				<td>名称</td>
				<td>主场</td>
				<td>主教练</td>
				<td>操作</td>
			</tr>
			<%
				Iterator<Team> it = teams.iterator();
				while (it.hasNext()) {
					Team team = it.next();
			%>
			<tr>
				<td><%=team.getId()%></td>
				<td><%=team.getName()%></td>
				<td><%=team.getHome()%></td>
				<td><%=team.getCoach()%></td>
				<td><a href="servlet/TeamManage?action=modify_show&team_id=<%=team.getId()%>">修改</a>&nbsp;<a
					href="servlet/TeamManage?action=delete&team_id=<%=team.getId()%>">删除</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<a href="/LFMMS/team_add.jsp">添加</a>
	<a href="./">返回</a>
</body>
</html>
