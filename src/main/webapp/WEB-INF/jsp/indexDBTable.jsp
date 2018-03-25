<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大数据之数据源综合管理系统</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" />
</head>

<body>

	<div id="contentWrap">

		<div class="pageColumn">
			<table>
				<thead>
					<!-- <c:forEach items="${colmun}" var="colmun" varStatus="status">
						 <th>${colmun.get(id)}</th> 
						<th>${colmun.get(id)}</th> 
						<th>${colmun.get(id)}</th> 
					</c:forEach> -->

					<%
						List colmun = (List) request.getAttribute("colmun");
						for (int i = 0; i < colmun.size(); i++)
							out.print("<th>" + colmun.get(i) + "</th>");
					%>

				</thead>
				<tbody id="tableData">				
				</tbody>
			</table>
		</div>
	</div>

</body>

<SCRIPT type="text/javascript">
	var jr = ${jr}
	var htmlStr = "";
	var html="";
	var htm = document.getElementById("tableData").innerHTML;
	
	for ( var size in jr) {
		 html=html+'<tr>';
		for ( var key in jr[size]) {
			html = html+'<td>' + jr[size][key] + '</td>';
		}
		html=html+'</tr>';
	}
	htmlStr += html;
	
	document.getElementById("tableData").innerHTML=htm+html; 
</SCRIPT>
</html>
