<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>P1 Page</h1>
	param : ${param.name }<br />
	name: ${name }<br />
	age : ${age }
	<hr />
	
	<table border="1">
		<thead>
			<tr><th>아이디</th><th>비밀번호</th><th>이름</th></tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}">
			<tr><td>${item.id}</td><td>${item.pw}</td><td>${item.name}</td></tr>
			</c:forEach>
		</tbody>
	</table>
	
	${memberDTO}
</body>
</html>