<%@page import="dao.OrderStoreDAO"%>
<%@page import="java.util.List"%>
<%@page import="vo.OrderStoreVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
OrderStoreDAO order = new OrderStoreDAO();
List<OrderStoreVO> list = order.selectAll();
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
		<h1>점포별 주문현황</h1>
		<table border="1">
			<thead>
				<tr><th>할인점코드</th><th>제품코드</th><th>제품명</th><th>총주문수량</th></tr>
			</thead>
			<tbody>
				<% for (OrderStoreVO o : list) {%>
				<tr>
					<td><%=o.getShopno() %></td>
					<td><%=o.getPcode() %></td>
					<td><%=o.getPname() %></td>
					<td><%=o.getAmount() %></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>