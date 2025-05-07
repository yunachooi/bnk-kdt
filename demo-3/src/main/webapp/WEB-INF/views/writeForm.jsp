<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원등록</h1><hr />
	
	<form action="writeMember" method="POST">
		<input type="text" name="id" placehover="Input id"><br>
		<input type="text" name="pw" placehover="Input pw"><br>
		<input type="text" name="name" placehover="Input name"><br>
		<input type="text" name="phone" placehover="Input phone"><br>
		<button type="submit">등록</button>
	</form><hr />
	
	<a href="/">Index 바로가기</a>
	
	
	
</body>
</html>