<%@ page language="java"
	import="java.util.*, com.LFMMS.library.Hibernate.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>
<%@ include file="title_bar.jsp" %>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<title>球员添加</title>
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
  <form method="post" action="servlet/PlayerManage?action=<%=CONSTANT.ACTIONPARAM.ADD %>&redirect=PlayerManage?action=<%=CONSTANT.ACTIONPARAM.SHOWALL %>%26redirect=<%=path %>/player_mng.jsp"
		name="course_modify_form">
    <table border="0">
      <tr>
        <td width="30%">姓名:</td>
        <td width="70%"><input type="text" name="name" class="form-control"></td>
      </tr>
      <tr>
        <td>球队ID:</td>
        <td><input type="text" name="team_id" class="form-control"></td>
      </tr>
      <tr>
        <td>球衣号码:</td>
        <td><input type="text" name="number" class="form-control"></td>
      </tr>
      <tr>
        <td>场上位置:</td>
        <td><input type="text" name="position" class="form-control"></td>
      </tr>
      <tr>
        <td>身高:</td>
        <td><input type="text" name="height" class="form-control"></td>
      </tr>
      <tr>
        <td>体重:</td>
        <td><input type="text" name="weight" class="form-control"></td>
      </tr>
      <tr>
        <td>生日:</td>
        <td><input type="text" name="birthday" class="form-control"></td>
      </tr>
    </table>
    <input type="submit" name="submit" value="添加" class="btn btn-primary">
    <input type="reset" name="reset" value="重置" class="btn btn-danger">
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
