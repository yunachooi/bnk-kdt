<%@page import="chapter03.Dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String grade = (String) request.getAttribute("grade");
	
	MemberDao member = new MemberDao();
	member.insert(id, pw, name, grade);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입이 정상적으로 처리되었습니다.</h3>
	<table>
		<tbody>
			<tr><td>id</td><td> : </td><td><%=id %></td></tr>
			<tr><td>pw</td><td> : </td><td><%=pw %></td></tr>
			<tr><td>name</td><td> : </td><td><%=name %></td></tr>
			<tr><td>grade</td><td> : </td><td><%=grade %></td></tr>
		</tbody>
	</table>
	<a href="chapter03/index.jsp">회원가입 페이지로 돌아가기</a>
</body>
</html>