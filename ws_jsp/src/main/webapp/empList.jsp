<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EMP List Page</h1>
	<hr />
	<%
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "green";
		String password = "1234";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(url, user, password);
		String query = "SELECT * FROM emp";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
	%>
	<table border="1">
	<thead>
	<tr><th>empno</th><th>empname</th></tr>
	</thead>
	<tbody>
	<%
		while(rs.next()) {
	%>
	<tr>
		<td><%=rs.getString("empno") %></td>
		<td><%=rs.getString("ename") %></td>
	</tr>
	<%
		}
	%>
	</tbody>
	</table>

</body>
</html>