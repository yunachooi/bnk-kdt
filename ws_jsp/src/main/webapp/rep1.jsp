<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	/* 스크립틀릿 */
	String param1 = request.getParameter("username");
	String param2 = request.getParameter("age");
	String[] hobbies = request.getParameterValues("hobbies");
	String bgcolor = request.getParameter("bgcolor");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{ background-color:<%=bgcolor%>;}
</style>
</head>
<body>
	<h1>REQ1 Page</h1><hr />
	username = <%=param1%><br /> 
	age = <%=param2%><br />
	hobby1 = <%=hobbies[0]%><br />
	hobby2 = <%=hobbies[1]%><br />
</body>
</html>