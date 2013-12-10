<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="admin" class="com.LFMMS.library.Hibernate.Admin" scope="session"></jsp:useBean>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登陆</title>
    
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
  <% if (admin == null || admin.getUsername() == null || admin.getUsername().isEmpty()) {%>
  	登陆失败
  <%} else {%>
  用户：<%=admin.getUsername() %> <br/>
   <a href="servlet/PlayerManage">球员信息管理</a>
   <a href="servlet/TeamManage">球队信息管理</a>
   <a href="servlet/MatchManage">赛事管理</a>
   <%} %>
  </body>
</html>
