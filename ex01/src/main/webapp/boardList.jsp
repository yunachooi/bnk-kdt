<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:testdb",
			"green",
			"1234"
			);
	String query = "SELECT * FROM tbl_board ORDER BY bno";
	
	PreparedStatement pstmt = conn.prepareStatement(query);
	ResultSet rs = pstmt.executeQuery();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Board List Page</h1><hr />
	<table border="1">
		<thead>
		<tr>
			<th>bno</th><th>title</th><th>writer</th><th>regdate</th>
		</tr>
		</thead>
		<tbody>
		<%
			while(rs.next()){
		%>
			<tr>
				<td><%=rs.getString("bno") %></td>
				<td><a href="boardDetail.jsp?bno=<%=rs.getString("bno") %>"><%=rs.getString("title") %></a></td>
				<td><%=rs.getString("writer") %></td>
				<td><%=rs.getString("regdate") %></td>
			</tr>
		<%
			
			}
		%>
		</tbody>
	</table>
</body>
</html>