<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	page 저장소 값 : <%=pageContext.getAttribute("x") %><br />
	request 저장소 값 : <%=request.getAttribute("x") %><br />
	session 저장소 값 : <%=session.getAttribute("x")  %><br />
	application 저장소 값 : <%=application.getAttribute("x")  %><br />
</body>
</html>