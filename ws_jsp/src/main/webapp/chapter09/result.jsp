<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이체 결과</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 20px
}
.result-container{
	max-width: 500px;
	margin: 0 auto;
	padding: 20px;
	border: 1px solid #ddd;
	border-radius: 5px;
}
.sucess{color: green;}
.error{color: red;}
.back-link{margin-top: 20px;}
</style>
</head>
<body>
	<div class="result-container">
		<h2>이체 결과</h2>
		<%if (request.getAttribute("message") != null) {%>
		<p class="success"><%=request.getAttribute("message")%>
		<%}%>

		<%if (request.getAttribute("errorMessage") != null) {%>
		<p class="error"><%=request.getAttribute("errorMessage")%>
		<%}%>
		
		<div class="back-Link">
			<a href="<%=path %>/chapter09/transfer_form.jsp">다시 이체하기</a>
		</div>
	</div>
</body>
</html>