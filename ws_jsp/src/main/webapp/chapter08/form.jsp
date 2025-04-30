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
<form action="<%=path %>/chapter08/uploadProc" method="POST" enctype="multipart/form-data">
	<input type="text" name="desc" placeholder="파일설명"><br />
	<input type="file" name="imgfile"><br />
	<input type="submit" value="업로드">
</form>

</body>
</html>