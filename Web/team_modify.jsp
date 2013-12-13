<%@ page language="java"
	import="java.util.*, com.LFMMS.library.Hibernate.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>
<%@ include file="title_bar.jsp" %>
<jsp:useBean id="team" class="com.LFMMS.library.Hibernate.Team"
	scope="session">
</jsp:useBean>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<title>球队修改</title>
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
  <form method="post" action="servlet/TeamManage?action=modify_commit"
		name="course_modify_form">
    <table border="0">
      <tr>
        <td width="30%">ID:</td>
        <td width="70%"><input type="text" name="id" class="form-control" value="<%=team.getId()%>" readonly></td>
      </tr>
      <tr>
        <td>名称:</td>
        <td><input type="text" name="name" class="form-control"
		value="<%=team.getName()%>"></td>
      </tr>
      <tr>
        <td>主场:</td>
        <td><input type="text" name="home" class="form-control"
		value="<%=team.getHome()%>"></td>
      </tr>
      <tr>
        <td>主教练:</td>
        <td><input type="text" name="coach" class="form-control" value="<%=team.getCoach()%>"></td>
      </tr>
    </table>
    <input type="submit" name="submit" class="btn btn-primary" value="修改">
    <input type="reset" name="reset" class="btn btn-danger" value="重置">
    <input type="button" value="返回" class="btn btn-default" onclick="javascript:window.location.href='./';">
  </form>
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
