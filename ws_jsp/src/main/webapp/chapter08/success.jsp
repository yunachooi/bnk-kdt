<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Success ...</h1>
<img src="<%= path + "/chapter08/images/" + request.getAttribute("filename") %>" alt="이미지"/>
</body>
</html>