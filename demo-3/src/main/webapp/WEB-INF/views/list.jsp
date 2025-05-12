<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보</h1><hr />
	
	<table border="1">
		<thead>
			<tr><th>no</th><th>id</th><th>name</th><th>회원탈퇴</th></tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${list }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td><a href="detail?id=${member.id}">${member.id }</td>
				<td>${member.name }</td>
				<td><a href="remove?id=${member.id}">탈퇴하기</td>
			</tr>
			</c:forEach>
		</tbody>
	</table><hr />
</body>
</html>