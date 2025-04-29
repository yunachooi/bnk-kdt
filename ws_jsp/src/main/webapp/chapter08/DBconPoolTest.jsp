<%@page import="chapter08.dao.DBconnPool"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
DBconnPool dbp = new DBconnPool();

dbp.close();
%>
</body>
</html>