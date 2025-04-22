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
	<h1>가위바위보 게임</h1>
	<form action="<%=path %>/rsp" method="GET">
		<input type="radio" name="rsp" value="2">바위
		<input type="radio" name="rsp" value="1">가위
		<input type="radio" name="rsp" value="3">보<br />
		<input type="submit" value="과연 승자는 누구?!">
	</form>
</body>
</html>