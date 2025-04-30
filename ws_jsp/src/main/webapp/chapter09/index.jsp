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
	<form action="<%=path %>/a" method="get">
		<button type="submit">a로 이동</button>
	</form>
	
	<form action="<%=path %>/b" method="get">
		<button type="submit">b로 이동</button>
	</form>
</body>
</html>