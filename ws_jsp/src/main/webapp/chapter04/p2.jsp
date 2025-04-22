<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//String name = request.getParameter("name");
	//String age = request.getParameter("age");
	
	String name = (String)request.getAttribute("name");
	String age = (String)request.getAttribute("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>P2 Page</h1><hr />
	name 파라미터 값 : <%=name %> <br />
	age 파라미터 값 : <%=age %> <br />
</body>
</html>