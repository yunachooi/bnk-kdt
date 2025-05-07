<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 폼</h1>
	<form action="write" method="GET">
		<input type="text" name="id" placeholder="Input id"><br />
		<button type="button" onclick="idCheck()">ID 중복확인</button>
		<div id="demo"></div>
		<input type="text" name="pw" placeholder="Input pw"><br />
		<input type="text" name="name" placeholder="Input name"><br />
		<input type="text" name="phone" placeholder="Input phone"><br />
		<input type="text" name="grade" placeholder="Input grade"><br />
		<button type="submit">회원가입</button>
		<button type="reset">다시쓰기</button>
		
	</form>
</body>
</html>