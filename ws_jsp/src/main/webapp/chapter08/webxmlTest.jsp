<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String driver = application.getInitParameter("OracleDriver");
String url = application.getInitParameter("OracleUrl");
String uid = application.getInitParameter("OracleId");
String upw = application.getInitParameter("OraclePw");
%>

driver : <%=driver %><br />
url : <%=url %><br />
uid : <%=uid %><br />
upw : <%=upw %><br />
</body>
</html>