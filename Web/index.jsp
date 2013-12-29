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
<title>足球联赛管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/style.css" rel="stylesheet">

<!-- Loading Bootstrap -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Loading Flat UI -->
<link href="css/flat-ui.css" rel="stylesheet">
<link href="css/LFMMS.css" rel="stylesheet">
<link rel="shortcut icon" href="images/favicon.ico">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.aw-showcase.js"></script>
<script type="text/javascript">

$(document).ready(function()
{
	$("#showcase").awShowcase(
	{
		content_width:			700,
		content_height:			740,
		fit_to_parent:			false,
		auto:					false,
		interval:				3000,
		continuous:				false,
		loading:				true,
		tooltip_width:			200,
		tooltip_icon_width:		32,
		tooltip_icon_height:	32,
		tooltip_offsetx:		18,
		tooltip_offsety:		0,
		arrows:					true,
		buttons:				true,
		btn_numbers:			true,
		keybord_keys:			true,
		mousetrace:				false, /* Trace x and y coordinates for the mouse */
		pauseonover:			true,
		stoponclick:			true,
		transition:				'vslide', /* hslide/vslide/fade */
		transition_delay:		300,
		transition_speed:		500,
		show_caption:			'onhover', /* onload/onhover/show */
		thumbnails:				true,
		thumbnails_position:	'outside-last', /* outside-last/outside-first/inside-last/inside-first */
		thumbnails_direction:	'vertical', /* vertical/horizontal */
		thumbnails_slidex:		0, /* 0 = auto / 1 = slide one thumbnail / 2 = slide two thumbnails / etc. */
		dynamic_height:			false, /* For dynamic height to work in webkit you need to set the width and height of images in the source. Usually works to only set the dimension of the first slide in the showcase. */
		speed_change:			true, /* Set to true to prevent users from swithing more then one slide at once. */
		viewline:				false /* If set to true content_width, thumbnails, transition and dynamic_height will be disabled. As for dynamic height you need to set the width and height of images in the source. */
	});
});

</script>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
    <![endif]-->
<style type="text/css">
#apDiv1 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 1;
	left: 50px;
	top: 146px;
}

#apDiv2 {
	position: absolute;
	width: 1400px;
	height: 115px;
	z-index: 11;
}

#apDiv4 {
	position: absolute;
	width: 700px;
	height: 500px;
	z-index: 12;
	left: 200px;
	top: 100px;
}

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

body {
	background-color: #C7EDCC;
}
</style>
</head>
<body>
<div id="apDiv4">
  <div style="width: 845px; margin: auto;"> 
    
    <!-- This is the button used to switch between One Page and Slideshow. -->
    <p><a id="awOnePageButton" href="#"><span class="view-page">精美英超画册</span><span class="view-slide">View As Slideshow</span></a></p>
    <div id="showcase" class="showcase"> 
      <!-- Each child div in #showcase with the class .showcase-slide represents a slide. -->
      <div class="showcase-slide"> 
        <!-- Put the slide content in a div with the class .showcase-content. -->
        <div class="showcase-content"> <img src="picture/1.png" alt="01" /> </div>
        <!-- Put the thumbnail content in a div with the class .showcase-thumbnail -->
        <div class="showcase-thumbnail"> <img src="picture/1.png" alt="01" width="500" /> 
          <!-- The div below with the class .showcase-thumbnail-caption contains the thumbnail caption. -->
          <div class="showcase-thumbnail-caption"></div>
          <!-- The div below with the class .showcase-thumbnail-cover is used for the thumbnails active state. -->
          <div class="showcase-thumbnail-cover"></div>
        </div>
        <!-- Put the caption content in a div with the class .showcase-caption -->
        <div class="showcase-caption">
          <h2>Be creative. Get Noticed!</h2>
        </div>
      </div>
      <div class="showcase-slide">
        <div class="showcase-content"> <img src="picture/2.jpg" alt="02" /> </div>
        <div class="showcase-thumbnail"> <img src="picture/2.jpg" alt="01" width="1024" />
          <div class="showcase-thumbnail-caption"></div>
          <div class="showcase-thumbnail-cover"></div>
        </div>
        <!-- Put the tooltips in a div with the class .showcase-tooltips. -->
        <div class="showcase-tooltips"> 
          <!-- Each anchor in .showcase-tooltips represents a tooltip. The coords attribute represents the position of the tooltip. --> 
          
          <!-- You can add multiple elements to the anchor-tag which are display in the tooltip. --> 
        </div>
      </div>
      <div class="showcase-slide">
        <div class="showcase-content"> <img src="picture/3.jpg" alt="03" /> </div>
        <div class="showcase-thumbnail"> <img src="picture/3.jpg" alt="01" width="140px" />
          <div class="showcase-thumbnail-caption"></div>
          <div class="showcase-thumbnail-cover"></div>
        </div>
      </div>
      <div class="showcase-slide">
        <div class="showcase-content"> <img src="picture/4.jpg" alt="04" /> </div>
        <div class="showcase-thumbnail"> <img src="picture/4.jpg" alt="01" width="140px" />
          <div class="showcase-thumbnail-content"><br/>
            I'm not <b>bold</b></div>
          <div class="showcase-thumbnail-cover"></div>
        </div>
      </div>
      <div class="showcase-slide">
        <div class="showcase-content"> <img src="picture/5.jpg" alt="05" /> </div>
        <div class="showcase-thumbnail"> <img src="picture/5.jpg" alt="01" width="140px" />
          <div class="showcase-thumbnail-content"></div>
          <div class="showcase-thumbnail-cover"></div>
        </div>
      </div>
      <div class="showcase-slide">
        <div class="showcase-content"> <img src="picture/6.jpg" alt="06" /> </div>
        <div class="showcase-thumbnail"> <img src="picture/6.jpg" alt="06" width="140px" />
          <div class="showcase-thumbnail-caption"></div>
          <div class="showcase-thumbnail-cover"></div>
        </div>
      </div>
      <div class="showcase-slide">
        <div class="showcase-content"> <img src="picture/7.jpg" alt="07" /> </div>
        <div class="showcase-thumbnail"> <img src="picture/7.jpg" alt="07" width="140px" /> </div>
      </div>
    </div>
  </div>
  <div style="text-align: center; margin-top: 50px;">
    <p style="text-align:center;"></p>
    <p></p>
  </div>
</div>
</body>
</html>
