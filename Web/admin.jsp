<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="title_bar.jsp" %>

<!DOCTYPE html>
<html lang="zh-cn">
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
<div class="container">
  <% if (admin == null || admin.getUsername() == null || admin.getUsername().isEmpty()) {%>
  登陆失败
  <%} else {%>
  <h4> 
  <li><button class="btn btn-info mbm"> <a class="text-white-bold" href="servlet/PlayerManage?action=show">球员信息管理</a> </button> </li>
  <li><button class="btn btn-info mbm"><a class="text-white-bold" href="servlet/TeamManage?action=show">球队信息管理</a></button></li>
  <li><button class="btn btn-info mbm"><a class="text-white-bold" href="servlet/MatchManage?action=show">赛事管理</a></button></li>
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
