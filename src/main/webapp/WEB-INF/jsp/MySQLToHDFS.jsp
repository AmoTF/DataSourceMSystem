<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大数据之数据源综合管理系统</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style2.css" type="text/css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/treenode.css" type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.ztree.core.js"></script>
<!--  <script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.ztree.exedit.js"></script>-->

<style type="text/css">
div.pos_exp
{
position:absolute;
left:680 !important;
top:165px !important
}

div.pos_input
{
position:absolute;
left:280px !important;
top:165px !important
}

div.pos_button
{
position:absolute;
left:550px !important;
top:400px !important;
}

</style>
<SCRIPT type="text/javascript">

		var setting = {
			view: {
				dblClickExpand: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: beforeClick,
				onClick: onClick
			}
		};
		var $j = jQuery.noConflict();

		var zNodes =${AllGDB}
			

		function beforeClick(treeId, treeNode) {
			var check = (treeNode && !treeNode.isParent);
			return check;
		}
		
		function onClick(e, treeId, treeNode) {
			var zTree = $j.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes(),
			v = "";
			var zTreeParent=treeNode.getParentNode().name;
			nodes.sort(function compare(a,b){return a.id-b.id;});
			for (var i=0, l=nodes.length; i<l; i++) {
				v += nodes[i].name + ",";
			}
			if (v.length > 0 ) v = v.substring(0, v.length-1);
			var cityObj = $j("#inputSource");
			cityObj.attr("value", zTreeParent+":"+v);
		}

		function showMenu() {
			var cityObj = $j("#inputSource");
			var cityOffset = $j("#inputSource").offset();
			$j("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

			$j("body").bind("mousedown", onBodyDown);
		}
		function hideMenu() {
			$j("#menuContent").fadeOut("fast");
			$j("body").unbind("mousedown", onBodyDown);
		}
		function onBodyDown(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $j(event.target).parents("#menuContent").length>0)) {
				hideMenu();
			}
		}
		
		function showRMenu() {
			var cityObj = $j("#exportSource");
			var cityOffset = $j("#exportSource").offset();
			$j("#menuRightContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

			$j("body").bind("mousedown", onBodyDownR);
		}
		function hideRMenu() {
			$j("#menuRightContent").fadeOut("fast");
			$j("body").unbind("mousedown", onBodyDown);
		}
		function onBodyDownR(event) {
			if (!(event.target.id == "menuBtnR" || event.target.id == "menuRightContent" || $j(event.target).parents("#menuRightContent").length>0)) {
				hideRMenu();
			}
		}

		$j(document).ready(function(){
			//$j.fn.zTree.init($j("#treeDemo"), setting, zNodes);
			$j.fn.zTree.init($j("#treeDemo"), setting, zNodes);
			
			
		});
		
		
	</SCRIPT>

</head>

<body>  
		<br><br><br>

 	<h1>关系型数据库迁移到HDFS</h1>
 			<br><br><br>
 	
	<div class="content_wrap aligncenter" style="height:200px ! important ;width:1090px ! important">
	<div class="zTreeDemoBackground left pos_input" style="height:200px ! important">
		<ul class="list"> 
			<li class="title">&nbsp;&nbsp;<span class="highlight_red">选择数据来源</span></li>
			<br>
			<li class="title">&nbsp;&nbsp;表名称：<input id="inputSource" type="text" readonly value="" style="width:120px;"/>
		&nbsp;<a id="menuBtn" href="#" onclick="showMenu(); return false;">选择</a></li>
		</ul>
	</div>
	<div class="pos_exp" style="height:200px ! important ;width:550px ! important ">
		<ul class="info">
			
			    <input type="hidden" id="hdfsId" value="2"/>
				<ul class="list">
				<li class="title">&nbsp;&nbsp;<span class="highlight_red">选择数据存放地址</span></li>
			    <br>
				<li class="title">&nbsp;&nbsp;路径地址：<input id="exportSource" type="text"  value="" style="width:120px;"/>
				</ul>
				
			</li>
		</ul>
	</div>
</div>
<div class="pos_button"><input style="height:35px;" id="dataMigration" name="dataMigration"  type="button" value="数据迁移"/>
</div>

<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
	<ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
</div>

</body>
<SCRIPT type="text/javascript">

$j("#dataMigration").click(function(){
	var inputSource =document.getElementById("inputSource").value;
	var exportSource=document.getElementById("exportSource").value;
	var hdfsId=document.getElementById("hdfsId").value;
	var source={}
	source.inputSource=inputSource;
	source.exportSource=exportSource;
	source.hdfsId=hdfsId;
	
	$j.ajax({
		url : '${pageContext.request.contextPath}/dataMigration/dataMySQLToHDFS',
		type : 'post',
		dataType : 'json', //数据类型为json格式
		data : JSON.stringify(source),

		success : function(data) {	
			if( data.result=='error'){
				alert('传输失败');
			}else{
			};
		},
		error : function() {
			$j("#show").html("Error XMLHttpRequest");
		}
	});					
  });
</SCRIPT>

</html>