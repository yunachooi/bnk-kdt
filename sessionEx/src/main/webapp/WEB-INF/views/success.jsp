<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Success Page - ${id }</h1>
	<form action="${pageContext.request.contextPath}/logout" method="get">
		<button type="submit">로그아웃</button>
	</form>
</body>
</html>