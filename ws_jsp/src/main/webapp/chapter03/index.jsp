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
	<h1>회원가입</h1>
	<form action="<%=path %>/member" method="POST">
		<table>
			<tbody>
				<tr><td>id</td><td><input type="text" name="id"></td></tr>
				<tr><td>pw</td><td><input type="password" name="pw"></td></tr>
				<tr><td>name</td><td><input type="text" name="name"></td></tr>
				<td><input type="submit" value="회원가입"></td></tr>
			</tbody>
		</table>
	</form>
	<a href="memberList.jsp">회원정보보기</a>
</body>
</html>