<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="admin" class="com.LFMMS.library.Hibernate.Admin" scope="session">
</jsp:useBean>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>管理页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Loading Bootstrap -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Loading Flat UI -->
<link href="css/flat-ui.css" rel="stylesheet">
<link rel="shortcut icon" href="images/favicon.ico">

<style type="text/css">
li {
	list-style: none;
}

.text-white {
	color: white;
}

.text-white-bold {
	color: white;
	font-weight: bold;
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
      <li> <a href="index.html"> 英超首页 </a> </li>
      <li class="active"> <a href="#fakelink"> 英超球队 <span class="navbar-unread">1</span> </a>
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
      <li class="active"> <a href="#fakelink"> 赛事信息 <span class="navbar-unread">1</span> </a>
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
        	<li><a href="servlet/PlayerManage">球员信息管理</a> </li>
            <li><a href="servlet/TeamManage">球队信息管理</a> </li>
            <li><a href="servlet/MatchManage">赛事管理</a> </li>
        </ul>
        </li>
      <% } %>
    </ul>
  </div>
</div>
<div class="container">
  <% if (admin == null || admin.getUsername() == null || admin.getUsername().isEmpty()) {%>
  登陆失败
  <%} else {%>
  <h4> 
  <li><button class="btn btn-info mbm"> <a class="text-white-bold" href="servlet/PlayerManage">球员信息管理</a> </button> </li>
  <li><button class="btn btn-info mbm"><a class="text-white-bold" href="servlet/TeamManage">球队信息管理</a></button></li>
  <li><button class="btn btn-info mbm"><a class="text-white-bold" href="servlet/MatchManage">赛事管理</a></button></li>
  </h4>
  <%} %>
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
