<%@ page language="java"
	import="java.util.*, com.LFMMS.library.Hibernate.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>
<%@ include file="title_bar.jsp" %>
<jsp:useBean id="players" class="java.util.ArrayList" scope="session">
</jsp:useBean>


<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<title>球员管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Loading Bootstrap -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Loading Flat UI -->
<link href="css/flat-ui.css" rel="stylesheet">

<!-- Loading LFMMS css -->
<link href="css/LFMMS.css" rel="stylesheet">
<link rel="shortcut icon" href="images/favicon.ico">
<style type="text/css">
.container {
	width: 970px;
}
</style>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
    <![endif]-->
</head>
<body>
<div class="container" > 
 <table border="2" align="center" width="95%">
		<tbody>
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>球队ID</th>
				<th>球衣号码</th>
				<th>场上位置</th>
				<th>身高</th>
				<th>体重</th>
				<th>生日</th>
				<th>操作</th>
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
					href="servlet/PlayerManage?action=modify_show&player_id=<%=player.getId()%>">修改</a>&nbsp;<a
					href="servlet/PlayerManage?action=delete&player_id=<%=player.getId()%>">删除</a></td>

			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<a href="/LFMMS/player_add.jsp">添加</a>
	<a href="./">返回</a>
</div>
<!-- /.container --> 

<!-- Load JS here for greater good =============================--> 
<script src="js/jquery-1.8.3.min.js"></script> 
<script src="js/jquery-ui-1.10.3.custom.min.js"></script> 
<script src="js/jquery.ui.touch-punch.min.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/bootstrap-select.js"></script> 
<script src="js/bootstrap-switch.js"></script> 
<script src="js/flatui-checkbox.js"></script> 
<script src="js/flatui-radio.js"></script> 
<script src="js/jquery.tagsinput.js"></script> 
<script src="js/jquery.placeholder.js"></script>
</body>
</html>
