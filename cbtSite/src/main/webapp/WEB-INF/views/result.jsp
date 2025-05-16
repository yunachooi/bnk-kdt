<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="result">
		<div id="demo">
			<c:if test="${score >= 60}">
				<p id="good"><span class="bold" id="red">합격</span>을 축하드립니다.</p>
			</c:if>
			<c:if test="${score < 60}">
				<p id="bad">불합격하셨습니다.</p>
			</c:if>
		</div>
		${e_name }님의 <span class="bold">컴퓨터일반</span> 과목 점수는 <span class="bold" id="red">${score }</span>점입니다.
	</div>
</body>
</html>