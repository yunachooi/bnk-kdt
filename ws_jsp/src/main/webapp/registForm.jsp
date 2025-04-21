<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Regist Form Page</h1><hr />
	<form action="registProc.jsp" method="GET"> <!-- Proc = 처리 -->
		제목 : <input type = "text" name = "title"><br />
		내용 : <input type = "text" name = "content"><br />
		작가 : <input type = "text" name = "writer"><br />
		<input type = "submit" value = "등록">
	</form>
	
</body>
</html>