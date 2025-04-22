<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int rsp = (int) request.getAttribute("rsp");
	String rspResult = (String) request.getAttribute("rspResult");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>가위바위보 게임 결과</h1>
	<h3><%=rspResult %></h3>
</body>
</html>