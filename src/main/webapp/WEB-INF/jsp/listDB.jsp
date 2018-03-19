<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>简单漂亮的后台管理界面模板 - 源码之家</title>
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

		<div class="pageColumn">
			<table>
				<thead>
					<th></th>
					<th width="10%">名称</th>
					<th width="10%">标题</th>
					<th>种类</th>
					<th>类型</th>
					<th>启用状态</th>
					<th>创建时间</th>
					<th>创建人</th>
					<th>服务器</th>
					<th>备注</th>
				</thead>
				<tbody>
					<c:forEach items="${db}" var="db">
						<tr>
							<th class="checkBox"><input name="" type="checkbox" value="" /></th>
							<th>${db.name}</th>
							<th>${db.title}</th>
							<th>${db.dbType}</th>
							<th>无1</th>
							<th>正常</th>
							<th>${db.lastDate}</th>
							<th>${db.creater}</th>
							<th>${db.server}</th>
							<th>${db.remarks}</th>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
