<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大数据之数据源综合管理系统</title>
<link href="${pageContext.request.contextPath}/css/style2.css"
	rel="stylesheet" type="text/css" />

<style type="text/css">
body {
	background: #FFF
}
</style>


</head>

<body>
	<%@ include file="/WEB-INF/common/head.jsp"%>
<div id="wrap">
	
   
    <div class="menu fleft">
    	<ul>
        	<li class="subMenuTitle">数据迁移</li>
            <li id="data1" class="subMenu"><a  >MySQLToHDFS</a></li>
            <li class="subMenu"><a href="main.html" target="right">HDFSToMySQL</a></li>
            <li class="subMenu"><a href="#" target="right">标题标题标题</a></li>
            <li class="subMenu"><a href="#" target="right">标题标题标题</a></li>
        </ul>
    </div>
    <div class="sidebar fleft"><div class="btn"></div></div>
    <div class="page">
    <iframe width="100%" scrolling="auto" height="100%" frameborder="false" allowtransparency="true" style="border: medium none;" src="" id="rightMain" name="right"></iframe>
    </div>
    </div><!--#content -->
    <div class="clear"></div>
   
</div><!--#wrap -->
	
</body>

<script type="text/javascript">
$(function(){
	//setMenuHeight
	$('.menu').height($(window).height()-51-27-26);
	$('.sidebar').height($(window).height()-51-27-26);
	$('.page').height($(window).height()-51-27-26);
	$('.page iframe').width($(window).width()-15-168);
	
	//menu on and off
	$('.btn').click(function(){
		$('.menu').toggle();
		
		if($(".menu").is(":hidden")){
			$('.page iframe').width($(window).width()-15+5);
			}else{
			$('.page iframe').width($(window).width()-15-168);
				}
		});
		
	//
	$('.subMenu a[href="#"]').click(function(){
		//$("#rightMain").attr("src","dataMigration/");

		$(this).next('ul').toggle();
		return false;
		});
	
	$("#data1").click(function(){
		$("#rightMain").attr("src","MySQLToHDFS");
	});
})

</script>
</html>