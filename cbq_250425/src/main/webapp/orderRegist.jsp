<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h1>주문등록</h1>
		<form action="order" method="POST" onsubmit="return f1()">
		<table border="1">
			<tbody>
				<tr><td>주문번호</td><td><input type="text" name="orderno" id="orderno"></td></tr>
				<tr><td>주문점포</td><td>
				<select name="shopno">
					<option value="none">점포선택</option>
					<option value="S001">S001</option>
					<option value="S002">S002</option>
					<option value="S003">S003</option>
					<option value="S004">S004</option>
				</select>
				</td></tr>
				<tr><td>주문일자</td><td><input type="text" name="orderdate"></td></tr>
				<tr><td>제품코드</td><td>
				<select name="pcode">
					<option value="none">코드선택</option>
					<option value="AA01">AA01</option>
					<option value="AA02">AA02</option>
					<option value="AA03">AA03</option>
					<option value="AA04">AA04</option>
					<option value="AA05">AA05</option>
					<option value="AA06">AA06</option>
				</select>
				</td></tr>
				<tr><td>주문수량</td><td><input type="text" name="amount"></td></tr>
				<tr><td colspan="2">
					<button type="submit" onclick="f1()">주문등록</button>
					<button type="reset">다시쓰기</button>
				</td></tr>
				
				<script>
				function f1(){
					if(document.getElementById('orderno').value == ""){
						alert("주문번호가 입력되지 않았습니다!");
						document.getElementById('orderno').focus();
						return false;
					}
					else{
						alert("주문등록이 정상적으로 등록되었습니다!")
						return true;
					}
				}
				</script>
			</tbody>
		</table>
		</form>
	</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>