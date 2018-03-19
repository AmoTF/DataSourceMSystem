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
			onRemove : onRemove
		}
	};

	var $j = jQuery.noConflict();

	var zNodes = [ {
		id : 1,
		pId : 0,
		name : "父节点 1",
		open : true
	}, {
		id : 11,
		pId : 1,
		name : "叶子节点 1-1"
	}, {
		id : 12,
		pId : 1,
		name : "叶子节点 1-2"
	}, {
		id : 13,
		pId : 1,
		name : "叶子节点 1-3"
	}, {
		id : 2,
		pId : 0,
		name : "父节点 2",
		open : true
	}, {
		id : 21,
		pId : 2,
		name : "叶子节点 2-1"
	}, {
		id : 22,
		pId : 2,
		name : "叶子节点 2-2"
	}, {
		id : 23,
		pId : 2,
		name : "叶子节点 2-3"
	}, {
		id : 3,
		pId : 0,
		name : "父节点 3",
		open : true
	}, {
		id : 31,
		pId : 3,
		name : "叶子节点 3-1"
	}, {
		id : 32,
		pId : 3,
		name : "叶子节点 3-2"
	}, {
		id : 33,
		pId : 3,
		name : "叶子节点 3-3"
	} ];
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
	function showLog(str) {
		if (!log)
			log = $("#log");
		log.append("<li class='"+className+"'>" + str + "</li>");
		if (log.children("li").length > 8) {
			log.get(0).removeChild(log.children("li")[0]);
		}
	}
	function getTime() {
		var now = new Date(), h = now.getHours(), m = now.getMinutes(), s = now
				.getSeconds(), ms = now.getMilliseconds();
		return (h + ":" + m + ":" + s + " " + ms);
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

			<div class="right" >
				<iframe width="100%" scrolling="auto" height="100%"
					frameborder="false" allowtransparency="true"
					style="border: medium none;"
					src="${pageContext.request.contextPath}/user/indexDBTable"
					id="rightMain" name="right"></iframe>
			</div>
	
	</div>


</body>
</html>