<%@page import="vo.ProductCodeVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductCodeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ProductCodeDAO order = new ProductCodeDAO();
List<ProductCodeVO> list = order.selectAll();
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
	<div class="center-wrapper">
		<h1>제품코드조회</h1>
		<table border="1">
			<thead>
				<tr><th>제품코드</th><th>제품명</th><th>단가</th><th>할인률(10%)</th><th>할인율(15%)</th></tr>
			</thead>
			<tbody>
				<% for (ProductCodeVO p : list) {%>
				<tr>
					<td><%=p.getPcode() %></td>
					<td><%=p.getPname() %></td>
					<td><%=p.getCost() %></td>
					<td><%=p.getDis10() %></td>
					<td><%=p.getDis15() %></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>