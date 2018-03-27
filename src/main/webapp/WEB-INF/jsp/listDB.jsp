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
					<th>操作</th>
				</thead>
				<tbody>
					<c:forEach items="${db}" var="db">
						<tr>
							<th class="checkBox"><input name="" type="checkbox" value="" /></th>
							<td style="display:none;">${db.id}</td>
							<td>${db.name}</td>
							<td>${db.title}</td>
							<td>${db.dbType}</td>
							<td>无1</td>
							<td width="6%">正常</td>
							<td width="11%">${db.lastDate}</td>
							<td>${db.creater}</td>
							<td>${db.server}</td>
							<td>${db.remarks}</td>
							<td width="3.5%"><a class="logon fright"
				href="${pageContext.request.contextPath}/user/indexDB/${db.id}"> </a></td>
						</tr>
						
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
