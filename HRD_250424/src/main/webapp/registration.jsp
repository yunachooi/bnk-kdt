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
		<h1>홈쇼핑 회원 등록</h1>
		<form action="regist" method="POST">
		<table border="1">
			<tbody>
				<tr><td>회원번호</td><td><input type="text" name="custno"></td></tr>
				<tr><td>회원성명</td><td><input type="text" name="custname" id="custname"></td></tr>
				<tr><td>회원전화</td><td><input type="text" name="phone"></td></tr>
				<tr><td>회원주소</td><td><input type="text" name="address"></td></tr>
				<tr><td>가입일자</td><td><input type="text" name="joindate" value="<%=LocalDate.now() %>"></td></tr>
				<tr><td>고객등급[A:VIP, B:일반, C:직원]</td><td><input type="text" name="grade"></td></tr>
				<tr><td>도시코드</td><td><input type="text" name="city"></td></tr>
				<tr><td colspan="2" class="center">
					<input type="submit" value="등록" onclick="f1()">
					<input type="button" value="조회" onclick="f2()">
				</td></tr>
				<script>
					function f1(){
						if(document.getElementById('custname').value == ""){
							alert("회원 성명이 입력되지 않았습니다");
							document.getElementById('custname').focus();
						}
						else{
							alert("회원등록이 완료 되었습니다!")
						}
					}
					function f2(){
						location.href="check.jsp";
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