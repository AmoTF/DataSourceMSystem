<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大数据之数据源综合管理系统</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" />

<style type="text/css">
body {
	background: #FFF
}
</style>
</head>

<body>
	<%@ include file="/WEB-INF/common/head.jsp"%>

	<div id="contentWrap">

		<div class="hdfsColumn">
			<table>
				<thead>
					<th></th>
					<th>Permission</th>
					<th>Owner</th>
					<th>Group</th>
					<th>Size</th>
					<th>Last Modified</th>
					<th>Replication</th>
					<th>Block Size</th>
					<th>IsDirectory</th>
					<th>Name</th>
				</thead>
				<tbody>
					<c:forEach items="${listFile}" var="listFile">
						<tr>
							<th class="checkBox"><input name="" type="checkbox" value="" /></th>
							<td>${listFile.permission}</td>
							<td>${listFile.owner}</td>
							<td>${listFile.group}</td>
							<td>${listFile.length}</td>
							<td>${listFile.modificationTime}</td>
							<td>${listFile.blockReplication}</td>
							<td>${listFile.blockSize}M</td>
							<td>${listFile.isDir}</td>
							<!--  <td><a href="javascript:void(0);" onclick="HDFSOper()">
									${listFile.name}</a></td>-->

							<td><a
								href="${pageContext.request.contextPath}/user/HDFSOperating/${id}?path=${listFile.path}&name=${listFile.name}&isDir=${listFile.isDir}">
									${listFile.name}</a></td>


						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>

<SCRIPT type="text/javascript">
	function standardPost(url, args) {
		var form = $("<form method='post'></form>");
		form.attr({
			"action" : url
		});
		for (arg in args) {
			var input = $("<input type='hidden'>");
			input.attr({
				"name" : arg
			});
			input.val(args[arg]);
			form.append(input);
		}
		$("html").append(form);
		form.submit();
	}
</SCRIPT>
</html>
