<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int a = (int) request.getAttribute("a");
	int b = (int) request.getAttribute("b");
	String calculation = (String) request.getAttribute("calculation");
	int result = (int) request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>계산결과</h1>
	<h3><%=calculation %> 결과는 <%=result %> 입니다.</h3>
</body>
</html>