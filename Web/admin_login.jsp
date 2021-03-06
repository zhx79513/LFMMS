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
<title>管理员登陆</title>
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
table .login-align {
	width: 300px;
	border: 0;
	color: #66F;
	font-weight: bold;
}
.login-align .login-name {
	width: 100px;
}
.form-group {
	margin-bottom: 0;
}
.btn-wide {
	min-width: 130px;
}
</style>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
    <![endif]-->
</head>
<body>
<div class="container" >
  <div class="login">
    <div class="login-screen">
      <div class="login-icon"> <img src="images/icons/png/Retina-Ready.png" alt="Welcome to Mail App">
        <h4>Welcome to <small>LFMMS</small></h4>
      </div>
      <div class="login-form">
        <form method="post" action="servlet/AdminManage?action=<%=CONSTANT.ACTIONPARAM.LOGIN %>&redirect=<%=path %>/index.jsp" name="Admin Login">
          <table class="login-align">
            <tr>
              <div class="control-group">
                <td class="login-align login-name" > 用户名：</td>
                <td><div class="form-group">
                    <input type="text" maxlength="30" name="username" placeholder="username" class="form-control input-sm"/>
                    <span class="input-icon fui-user"></span></div></td>
              </div>
            </tr>
            <tr>
              <div class="control-group">
                <td class="login-align login-name">密码:</td>
                <td><div class="form-group">
                    <input type="password" maxlength="30" name="password" placeholder="password" class="form-control input-sm"/>
                    <span class="input-icon fui-lock"></span></div></td>
              </div>
            </tr>
          </table>
          <input type="submit" value="  登陆  " name="login" class="btn btn-primary btn-wide">
          <input type="button" value="  返回  " class="btn btn-default btn-wide" onclick="javascript:window.location.href='./';">
        </form>
      </div>
    </div>
  </div>
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
