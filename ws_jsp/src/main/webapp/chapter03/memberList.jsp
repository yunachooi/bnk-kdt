<%@page import="chapter03.dao.MemberDao"%>
<%@page import="chapter03.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
MemberDao member = new MemberDao();
List<MemberVO> list = member.selectAll();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member List Page</h1>
	<hr />
	<table border="1">
		<thead>
			<tr><th>id</th><th>pw</th><th>name</th><th>grade</th></tr>
		</thead>
		<tbody>
			<%
			for (MemberVO m : list) {
			%>
			<tr>
				<td><%=m.getId()%></td>
				<td><%=m.getPw()%></td>
				<td><%=m.getName()%></td>
				<td><%=m.getGrade()%></td>
			</tr>
			<%}%>
		</tbody>
	</table>
</body>
</html>