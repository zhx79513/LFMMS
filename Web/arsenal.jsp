<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>阿森纳</title>
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
	width: 1350px;
	padding: 0;
	margin: 0;
	text-align: center;
}

caption {
padding: 0 0 5px 0;
width:1350px; 
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
padding: 6px 6px 6px  ;
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
font-size:11px;
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
<html>body td{ font-size:13px;}
tr {
	text-align: center;
}
</style>
</head>

<body>
<table id="mytable" cellspacing="0" summary="The technical specifications of the Apple PowerMac G5 series">


<caption> </caption>


<tr>
<th width="73" class="nobg" scope="col" abbr="Configurations">球员名字</th>

<th width="179" scope="col" abbr="Dual 1.8"> <div align="center">所属球队</div></th>
<th width="167" scope="col" abbr="Dual 1.8"><div align="center">身高</div></th>
<th width="186" scope="col" abbr="Dual 1.8"><div align="center">体重</div></th>
<th width="172" scope="col" abbr="Dual 1.8"><div align="center">生日</div></th>
<th width="201" scope="col" abbr="Dual 1"><div align="center">球队号码</div></th>
<th width="206" scope="col" abbr="Dual 1"><div align="center">位置</div></th>


</tr>



<tr>
<th scope="row" abbr="Model" class="spec">拉姆塞</th>
<td></td>

<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>





<tr>
<th scope="row" abbr="G5 Processor" class="specalt">范佩西</th>
<td class="alt"></td>
<td class="alt"></td>
<td class="alt"></td>
<td class="alt"></td>
<td class="alt"></td>
<td class="alt"></td>
</tr>





<tr>
<th scope="row" abbr="Frontside bus" class="spec">阿圭罗</th>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>

</tr>






<tr>
<th scope="row" abbr="L2 Cache" class="specalt">兰帕德</th>
<td class="alt"></td>
<td class="alt"></td>
<td class="alt"></td>
<td class="alt"></td>
<td class="alt"></td>
<td class="alt"></td>
</tr>








</table>

</body>
</html>