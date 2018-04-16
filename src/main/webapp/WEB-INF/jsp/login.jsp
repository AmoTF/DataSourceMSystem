<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>

<link href="${pageContext.request.contextPath}/css/main.css"
	rel="stylesheet" type="text/css" />
</head>
<body>

	<div class="login">
		<div class="box png">
			<div class="logo png"></div>
			<form>
				<div class="input">
					<div class="log">
						<div class="name">
							<label>用户名</label><input type="text" class="text" id="userName"
								placeholder="用户名" name="userName" tabindex="1">
						</div>
						<div class="pwd">
							<label>密 码</label><input type="password" class="text"
								id="password" placeholder="密码" name="password" tabindex="2">
						</div>
						
						<br />
						<div align="center">
							<button type="button" id="btnLogin">登录</button>
						</div>
						
							&nbsp&nbsp&nbsp&nbsp<p style="color:red" id="msg"></p>
						
						<div class="check"></div>
						<div class="tip"></div>

					</div>

				</div>
			</form>
		</div>
		<div class="air-balloon ab-1 png"></div>
		<div class="air-balloon ab-2 png"></div>
		<div class="footer"></div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jQuery.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/fun.base.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/script.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/login.js"></script>

	
</body>
</html>