<%@page import="vo.JoinVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.MoneyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
MoneyDAO money = new MoneyDAO();
List<JoinVO> list = money.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@include file="header.jsp" %>
	<%@include file="nav.jsp" %>
	<div class="section-wrapper">
		<h1>회원매출조회</h1>
		<table border="1">
			<thead>
				<tr>
					<th>회원번호</th>
					<th>회원성명</th>
					<th>고객등급</th>
					<th>매출</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (JoinVO j : list) {
				%>
				<tr>
					<td><%=j.getCustno()%></td>
					<td><%=j.getCustname()%></td>
					<td><%=j.getGrade()%></td>
					<td><%=j.getPrice()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>