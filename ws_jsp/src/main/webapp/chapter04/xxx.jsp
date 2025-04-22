<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>XXX Page</h1><hr />
<form action="<%=path %>/xtest" method="GET">
	ID : <input type="text" name="id" value="aaa"><br />
	pw : <input type="text" name="pw" value="aaa"><br />
	name : <input type="text" name="name" value="aaa"><br />
	<input type="submit" value="전송">
</form>
</body>
</html>