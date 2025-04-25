<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>msg(session) : ${msg }</p>
	<p>age(session) : ${age }</p><hr />
	
	<c:if test="${param.color == 1 }">
		<span style="color: red;">빨강</span>
	</c:if>
	<c:if test="${param.color == 2 }">
		<span style="color: green;">초록</span>
	</c:if>
	<c:if test="${param.color == 3 }">
		<span style="color: blue;">파랑</span>
	</c:if><hr>
	<c:choose>
		<c:when test="${param.fruit == 1 }">
			<span style="color:red;">사과</span>
		</c:when>
		<c:when test="${param.fruit == 2 }">
			<span style="color:pink;">복숭아</span>
		</c:when>
		<c:otherwise>
			<span style="color:purple;">포도</span>
		</c:otherwise>
	</c:choose>
</body>
</html>