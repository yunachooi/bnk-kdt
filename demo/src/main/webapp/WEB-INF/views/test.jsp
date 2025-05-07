<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Test Page</h1><hr />
	<a href="p1?name=James">p1 페이지로 가기</a><hr />
	
	<form action="p1" method="post">
		<input type="text" name="id"><br />
		<input type="password" name="pw"><br />
		<input type="text" name="name"><br />
		<input type="submit" value="등록">
	</form><hr />
	
	<form action="p2" method="post">
		<input type="text" name="id"><br />
		<input type="password" name="pw"><br />
		<input type="submit" value="등록">
	</form><hr />
	
	<a href="p3/aaa/1234">PathVariable로 파라미터 처리하기</a>
</body>
</html>