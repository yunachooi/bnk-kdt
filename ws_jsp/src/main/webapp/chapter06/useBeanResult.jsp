<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="man" class="chapter06.Man" />
	<jsp:setProperty property="*" name="man" />
	
	이름 : <jsp:getProperty property="name" name="man" />
	나이 : <jsp:getProperty property="age" name="man" />
	직업 : <jsp:getProperty property="job" name="man" />
</body>
</html>