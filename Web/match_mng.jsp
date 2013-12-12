<%@ page language="java"
	import="java.util.*, com.LFMMS.library.Hibernate.*"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>
<jsp:useBean id="courses" class="java.util.ArrayList" scope="session"></jsp:useBean>
<jsp:useBean id="admin" class="com.LFMMS.library.Hibernate.Admin" scope="session">
</jsp:useBean>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>LFMMS template</title>
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
<div class="navbar navbar-inverse">
  <div class="navbar-header">
    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-collapse-01"></button>
  </div>
  <div class="navbar-collapse collapse navbar-collapse-01">
    <ul class="nav navbar-nav navbar-left">
      <li> <a href="./"> 英超首页 </a> </li>
      <li class="active"> <a href="#fakelink"> 英超球队 </a>
        <ul>
          <li><a href="#fakelink">阿森纳</a></li>
          <li><a href="#fakelink">曼联</a></li>
          <li> <a href="#fakelink">利物浦</a> </li>
          <li><a href="#fakelink">切尔西</a></li>
        </ul>
      </li>
      <li > <a href="#fakelink"> 赛场介绍</a>
        <ul>
          <li><a href="#fakelink">老特拉福德球场</a></li>
          <li><a href="#fakelink">酋长球场</a></li>
          <li> <a href="#fakelink">圣安菲尔德球场</a> </li>
          <li><a href="#fakelink">斯坦福桥球场</a></li>
        </ul>
      </li>
      <li class="active"> <a href="#fakelink"> 赛事信息 </a>
        <ul>
          <li><a href="#fakelink">当轮比分</a></li>
          <li><a href="#fakelink">当轮最佳</a></li>
          <li> <a href="#fakelink">当轮集锦</a>
            <ul>
              <li><a href="#fakelink">精彩图集</a></li>
              <li><a href="#fakelink">精彩视频</a></li>
              <li><a href="#fakelink">场外花边</a></li>
            </ul>
          </li>
        </ul>
      </li>
      <% if (admin == null || admin.getUsername() == null || admin.getUsername().isEmpty()) {%>
      <li> <a href="admin_login.html"> 用户：登陆失败 </a> </li>
      <%} else {%>
      <li> <a href="admin.jsp"> 用户： <%=admin.getUsername() %> <br/>
        </a> 
        <ul>
        	<li><a href="servlet/PlayerManage?action=show">球员信息管理</a> </li>
            <li><a href="servlet/TeamManage">球队信息管理</a> </li>
            <li><a href="servlet/MatchManage?action=show">赛事管理</a> </li>
            <li><a href="servlet/AdminManage?action=logout">退出登陆</a> </li>
        </ul>
        </li>
      <% } %>
    </ul>
  </div>
</div>


<div class="container" >
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
					href="servlet/MatchManage?action=modify_show&course_id=<%=course.getId()%>">修改</a>&nbsp;<a
					href="servlet/MatchManage?action=delete&course_id=<%=course.getId()%>">删除</a>
				</td>

			</tr>
			<%
				}
			%>
		</tbody>
	</table>

<a href="/LFMMS/match_add.jsp">添加</a>
<a href="javascript:void(0);" onClick="javascript:window.location.href='./'">返回</a>
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
