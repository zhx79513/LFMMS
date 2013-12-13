<%@ page language="java"
	import="java.util.*, com.LFMMS.library.Hibernate.*"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>
<%@ include file="title_bar.jsp" %>
<jsp:useBean id="teams" class="java.util.ArrayList" scope="session"></jsp:useBean>


<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<title>球队管理</title>
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
				<th>名称</th>
				<th>主场</th>
				<th>主教练</th>
				<th>操作</th>
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
</div>
<p>
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
</p>
</body>
</html>
