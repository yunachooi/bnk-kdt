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
	<h1>Index Page</h1><hr />
	<ul>
		<li><a href="registForm.jsp">게시글 작성하기</a></li>
		<li><a href="registForm.jsp">게시글 작성하기</a></li>
		<li><a href="test4">test4</a></li>
	</ul><hr />
	
	<h1>Get방식</h1>
	<form action="<%=path %>/test1" method="GET">
		<input type="text" name="name" value="aaa">
		<input type="submit" value="전송">
	</form>
	
	<h1>Post방식</h1>
	<form action="<%=path %>/test2" method="POST">
		<input type="text" name="name" value="aaa">
		<input type="submit" value="전송">
	</form>
	
	<h1>Post방식 - 2</h1>
	<form action="<%=path %>/test3" method="POST">
		<input type="text" name="name" value="aaa">
		<input type="submit" value="전송">
	</form>
</body>
</html>