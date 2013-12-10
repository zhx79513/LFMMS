<%@ page language="java"
	import="java.util.*, com.LFMMS.library.Hibernate.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>
<jsp:useBean id="players" class="java.util.ArrayList" scope="session"></jsp:useBean>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>球员管理</title>

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
				<td>姓名</td>
				<td>球队ID</td>
				<td>球衣号码</td>
				<td>场上位置</td>
				<td>身高</td>
				<td>体重</td>
				<td>生日</td>
				<td>操作</td>
			</tr>
			<%
				Iterator<Player> it = players.iterator();
				while (it.hasNext()) {
					Player player = it.next();
			%>
			<tr>

				<td><%=player.getId()%></td>
				<td><%=player.getName()%></td>
				<td><%=player.getTeam().getId()%></td>
				<td><%=player.getNumber()%></td>
				<td><%=player.getPosition()%></td>
				<td><%=player.getHeight()%></td>
				<td><%=player.getWeight()%></td>
				<td><%=player.getBirthday()%></td>
				<td><a
					href="servlet/PlayerModify?player_id=<%=player.getId()%>">修改</a>&nbsp;<a
					href="servlet/PlayerDelete?player_id=<%=player.getId()%>">删除</a></td>

			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<a href="/LFMMS/player_add.jsp">添加</a>
	<a href="/LFMMS/admin.jsp">返回</a>
</body>
</html>
