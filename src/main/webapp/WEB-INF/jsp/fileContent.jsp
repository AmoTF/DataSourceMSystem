<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大数据之数据源综合管理系统</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/demo.css" type="text/css">
<style type="text/css">
body {
	background: #FFF
}
</style>
</head>

<body>
	<%@ include file="/WEB-INF/common/head.jsp"%>
	<h1>文件${name}</h1>
	<h6>[ 文件路径:${dir} ]</h6>
	<div>
		<a href="javascript:history.back(-1)">返回上一页</a>

		<textarea rows="40px" cols="200px" id="content" class="content"
			readonly>	
		${content}
		</textarea>
	</div>

</body>

<SCRIPT type="text/javascript">
	
</SCRIPT>
</html>
