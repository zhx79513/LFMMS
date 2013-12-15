<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*, com.LFMMS.library.Hibernate.*" errorPage="" %>
<%@ include file="title_bar.jsp" %>
<jsp:useBean id="courses" class="java.util.ArrayList" scope="session"></jsp:useBean>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>赛事中心</title>
<link href="styles.css" rel="stylesheet" type="text/css" />
<style type="text/css">
/* CSS Document */



body {
	font: normal 11px auto "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #4f6b72;
	background: #E6EAE9;
}

a {
	color: #c75f3e;
}

#mytable {
	width: 1000px;
	padding: 0;
	margin: 0;
	text-align: center;
}

caption {
	padding: 0 0 5px 0;
	width: 1000px;
	font: italic 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	text-align: right;
}

th {
	font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #4f6b72;
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
	letter-spacing: 2px;
	text-transform: uppercase;
	text-align: left;
	padding: 6px 6px 6px;
	background: #CAE8EA;
}

th.nobg {
	border-top: 0;
	border-left: 0;
	border-right: 1px solid #C1DAD7;
	background: none;
}

td {
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	background: #fff;
	font-size: 11px;
	padding: 6px 6px 6px 12px;
	color: #4f6b72;
}

td.alt {
	background: #F5FAFA;
	color: #797268;
}

th.spec {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #fff url(images/bullet1.gif) no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
}

th.specalt {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #f5fafa url(images/bullet2.gif) no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #797268;
}
/*---------for IE 5.x bug*/
<html>body td {
font-size:13px;
}

tr {
	text-align: center;
}
</style>
</head>

<body>
<table id="mytable" cellspacing="0" summary="The technical specifications of the Apple PowerMac G5 series">
  <caption>
  </caption>
  <tr>
    <th width="200" class="nobg" scope="col" abbr="Configurations">主场球队</th>
    <th width="120" scope="col" abbr="Dual 1.8"> <div align="center">客场球队</div></th>
    <th width="120" scope="col" abbr="Dual 1.8"><div align="center">比赛轮次</div></th>
    <th width="120" scope="col" abbr="Dual 1.8"><div align="center">比赛日期</div></th>
  </tr>
  <% 
  Iterator<Course> it = courses.iterator();
  boolean odd = true;
  while (it.hasNext()) {
  Course course = it.next();
  if (odd) {
  %>
  <tr>
    <th scope="row" class="spec"><%=course.getTeamByHomeId().getName() %></th>
    <td><%=course.getTeamByAwayId().getName() %></td>
    <td><%=course.getTurn() %></td>
    <td><%=course.getMatchDate() %></td>
  </tr>
  <%
  	} else {
  %>
  <tr>
    <th scope="row" class="specalt"><%=course.getTeamByHomeId().getName() %></th>
    <td class="alt"><%=course.getTeamByAwayId().getName() %></td>
    <td class="alt"><%=course.getTurn() %></td>
    <td class="alt"><%=course.getMatchDate() %></td>
  </tr>
  <%
  	}
  	odd = !odd;
  }
   %>
</table>
</body>
</html>