<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보조회</h1><hr />
	<table border="1">
		<thead>
			<tr><th>id</th><th>name</th><th>phone</th></tr>
		</thead>
		<tbody>
			<tr>
				<td>${member1.id }</td>
				<td>${member1.name }</td>
				<td>${member1.phone }</td>
			</tr>
		</tbody>
	</table><hr />
	
	<a href="/">Index Page 바로가기</a>
</body>
</html>