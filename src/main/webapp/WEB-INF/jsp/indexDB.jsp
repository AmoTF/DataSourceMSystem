<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大数据之数据源综合管理系统</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/demo.css" type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.ztree.core.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.ztree.exedit.js"></script>
<SCRIPT type="text/javascript">

	var setting = {
		view : {
			selectedMulti : false
		},
		edit : {
			enable : true,
			showRemoveBtn : false,
			showRenameBtn : false
		},
		data : {
			keep : {
				parent : true,
				leaf : true
			},
			simpleData : {
				enable : true
			}
		},
		callback : {
			beforeDrag : beforeDrag,
			beforeRemove : beforeRemove,
			beforeRename : beforeRename,
			onRemove : onRemove,
			beforeClick : beforeClick,
		}
	}; 
	

	var $j = jQuery.noConflict();
   
    
	//树节点
	var zNodes = ${result};
	//数据库编号
	var id=${id};
	var log, className = "dark";
	function beforeDrag(treeId, treeNodes) {
		return false;
	}
	function beforeRemove(treeId, treeNode) {
		className = (className === "dark" ? "" : "dark");
		showLog("[ " + getTime() + " beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; "
				+ treeNode.name);
		return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
	}
	function onRemove(e, treeId, treeNode) {
		showLog("[ " + getTime() + " onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; "
				+ treeNode.name);
	}
	function beforeRename(treeId, treeNode, newName) {
		if (newName.length == 0) {
			alert("节点名称不能为空.");
			var zTree = $j.fn.zTree.getZTreeObj("treeDemo");
			setTimeout(function() {
				zTree.editName(treeNode)
			}, 10);
			return false;
		}
		return true;
	}
	
	
	//点击节点,显示右边
	function beforeClick(treeId, treeNode, clickFlag) {
		
		if(treeNode.id<100)
			$("#rightMain").attr("src","../DBTableData/"+id+"/"+treeNode.name);
		else{
			$("#rightMain").attr("src","");
		}
		
	}
	
	var newCount = 1;
	function add(e) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"), isParent = e.data.isParent, nodes = zTree
				.getSelectedNodes(), treeNode = nodes[0];
		if (treeNode) {
			treeNode = zTree.addNodes(treeNode, {
				id : (100 + newCount),
				pId : treeNode.id,
				isParent : isParent,
				name : "new node" + (newCount++)
			});
		} else {
			treeNode = zTree.addNodes(null, {
				id : (100 + newCount),
				pId : 0,
				isParent : isParent,
				name : "new node" + (newCount++)
			});
		}
		if (treeNode) {
			zTree.editName(treeNode[0]);
		} else {
			alert("叶子节点被锁定，无法增加子节点");
		}
	};
	function edit() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"), nodes = zTree
				.getSelectedNodes(), treeNode = nodes[0];
		if (nodes.length == 0) {
			alert("请先选择一个节点");
			return;
		}
		zTree.editName(treeNode);
	};
	function remove(e) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"), nodes = zTree
				.getSelectedNodes(), treeNode = nodes[0];
		if (nodes.length == 0) {
			alert("请先选择一个节点");
			return;
		}
		var callbackFlag = $("#callbackTrigger").attr("checked");
		zTree.removeNode(treeNode, callbackFlag);
	};
	function clearChildren(e) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"), nodes = zTree
				.getSelectedNodes(), treeNode = nodes[0];
		if (nodes.length == 0 || !nodes[0].isParent) {
			alert("请先选择一个父节点");
			return;
		}
		zTree.removeChildNodes(treeNode);
	};

	
	$j(document).ready(function() {
		$j.fn.zTree.init($("#treeDemo"), setting, zNodes);
		$("#addParent").bind("click", {
			isParent : true
		}, add);
		$("#addLeaf").bind("click", {
			isParent : false
		}, add);
		$("#edit").bind("click", edit);
		$("#remove").bind("click", remove);
		$("#clearChildren").bind("click", clearChildren);

	});
</SCRIPT>

</head>

<body>
	<%@ include file="/WEB-INF/common/head.jsp"%>

	<div class="content_wrap">

		<div class="zTreeDemoBackground left">
			<ul id="treeDemo" class="ztree"></ul>
		</div>

		<div class="right">
			<iframe width="100%" scrolling="auto" height="100%"
				frameborder="false" allowtransparency="true"
				style="border: medium none;"
				src="",
				id="rightMain" name="rightMain"></iframe>
		</div>

	</div>


</body>
</html>
