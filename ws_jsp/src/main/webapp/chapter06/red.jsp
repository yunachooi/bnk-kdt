<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		background-color: red;
	}
</style>
</head>
<body>
	<h1>Red Page</h1>
	<jsp:forward page="yellow.jsp">
		<jsp:param value="red" name="color"/>
	</jsp:forward>
</body>
</html>