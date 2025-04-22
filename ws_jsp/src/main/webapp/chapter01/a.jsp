<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	response.sendRedirect(request.getContextPath() + "/chapter01/studentList.jsp"); //studentList.jsp를 응답함.
%>
<%
	String stu_no = request.getParameter("stu_no");
	String stu_name = request.getParameter("stu_name");
	String stu_dept = request.getParameter("stu_dept");
	int stu_grade = Integer.parseInt(request.getParameter("stu_grade"));
	String stu_class = request.getParameter("stu_class");
	String stu_gender = request.getParameter("stu_gender");
	int stu_height = Integer.parseInt(request.getParameter("stu_height"));
	int stu_weight = Integer.parseInt(request.getParameter("stu_weight"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "green";
	String password = "1234";
		
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection(url, user, password);
		
	String query = "INSERT INTO student VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	PreparedStatement pstmt = conn.prepareStatement(query);
	pstmt = conn.prepareStatement(query);
		
	pstmt.setString(1, stu_no);
	pstmt.setString(2, stu_name);
	pstmt.setString(3, stu_dept);
	pstmt.setInt(4, stu_grade);
	pstmt.setString(5, stu_class);
	pstmt.setString(6, stu_gender);
	pstmt.setInt(7, stu_height);
	pstmt.setInt(8, stu_weight);
		
	pstmt.executeUpdate();
%>
</body>
</html>