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
<h1>student List Page</h1>
	<hr />
	<%
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "green";
		String password = "1234";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(url, user, password);
		String query = "SELECT * FROM student";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
	%>
	<table border="1">
	<thead>
	<tr><th>학번</th><th>이름</th><th>학과</th><th>학년</th><th>반</th><th>성별</th><th>키</th><th>체중</th></tr>
	</thead>
	<tbody>
	<%
		while(rs.next()) {
	%>
	<tr>
		<td><%=rs.getString("stu_no") %></td>
		<td><a href="c.jsp?stu_no=<%=rs.getString("stu_no") %>"><%=rs.getString("stu_name")%></a></td>
		<td><%=rs.getString("stu_dept") %></td>
		<td><%=rs.getInt("stu_grade") %></td>
		<td><%=rs.getString("stu_class") %></td>
		<td><%=rs.getString("stu_gender") %></td>
		<td><%=rs.getInt("stu_height") %></td>
		<td><%=rs.getInt("stu_weight") %></td>
	</tr>
	<%
		}
	%>
	</tbody>
	</table>
	<a href="index.jsp">Index로 돌아가기</a>
</body>
</html>