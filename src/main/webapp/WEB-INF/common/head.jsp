<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大数据之数据源综合管理系统</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" />

</head>

<body>

	<div id="wrap">
		<div id="header">
			<div class="logo fleft"></div>
			<div class="nav fleft">
				<ul>
					<div class="nav-left fleft"></div>
					<li class="first"><a href="${pageContext.request.contextPath}/index">我的主页</a></li>
					<li><a href="${pageContext.request.contextPath}/user/listDB">数据源配置管理</a></li>
					<li><a href="${pageContext.request.contextPath}/dataMigration/index">数据迁移</a></li>
					<li>用户</li>
					<li>扩展</li>
					<li>应用</li>
					<div class="nav-right fleft"></div>
				</ul>
			</div>
			<a class="logout fright"
				href="${pageContext.request.contextPath}/login"> </a>
			<div class="clear"></div>
			<div class="subnav">
				<div class="fleft"></div>
				${user.userName}

			</div>
		</div>
		<!--#header -->

	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jQuery.js"></script>
</body>
</html>