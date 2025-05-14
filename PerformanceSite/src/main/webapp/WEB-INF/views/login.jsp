<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<jsp:include page="./header.jsp" />
	<jsp:include page="./nav.jsp" />
	
	<div id="loginContainer">
		<form action="login" method="POST">
			<input type="text" name="id" placeholder="아이디 입력"><br /> <input
				type="password" name="pw" placeholder="비밀번호 입력"><br />
			<button type="submit">로그인</button>
		</form>
	</div>
</body>
</html>