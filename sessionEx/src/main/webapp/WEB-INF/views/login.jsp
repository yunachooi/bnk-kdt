<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Form</h1>
	<div id="msg">${msg }</div>
	<form action="login" method="post">
		<input type="text" name="id" placeholder="아이디 입력"><br />
		<input type="password" name="pw" placeholder="비밀번호 입력"><br />
		<button type="submit">로그인하기</button>
	</form>
</body>
</html>