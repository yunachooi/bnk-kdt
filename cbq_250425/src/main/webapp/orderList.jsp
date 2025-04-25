<%@page import="vo.OrderListVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.OrderListDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
OrderListDAO order = new OrderListDAO();
List<OrderListVO> list = order.selectAll();
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
		<h1>주문목록</h1>
		<table border="1">
			<thead>
				<tr>
				<th>할인점코드</th><th>점포명</th><th>주문번호</th><th>주문일자</th><th>제품코드</th>
				<th>제품명</th><th>주문수량</th><th>단가</th><th>소비자가격</th><th>할인가격</th>
				</tr>
			</thead>
			<tbody>
				<% for (OrderListVO o : list) {%>
				<tr>
					<td><%=o.getShopno() %></td>
					<td><%=o.getShopname() %></td>
					<td><%=o.getOrderno() %></td>
					<td><%=o.getOrderdate() %></td>
					<td><%=o.getPcode() %></td>
					<td><%=o.getPname() %></td>
					<td><%=o.getAmount() %></td>
					<td><%=o.getCost() %></td>
					<td><%=o.getCprice() %></td>
					<td><%=o.getDprice() %></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>