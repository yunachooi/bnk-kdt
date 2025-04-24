<%@page import="vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.MemberDAO"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDAO member = new MemberDAO();
	int custno = Integer.parseInt(request.getParameter("custno"));
	List<MemberVO> list = member.detailSelect(custno);
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
		<h1>홈쇼핑 회원 정보 수정</h1>
		<form action="update" method="POST">
		<table border="1">
			<tbody>
				<%for (MemberVO m : list) {%>
				<tr><td>회원번호</td><td><input type="text" name="custno" value="<%=custno %>" ></td></tr>
				<tr><td>회원성명</td><td><input type="text" name="custname" id="custname" value="<%=m.getCustname() %>"></td></tr>
				<tr><td>회원전화</td><td><input type="text" name="phone" value="<%=m.getPhone() %>"></td></tr>
				<tr><td>회원주소</td><td><input type="text" name="address" value="<%=m.getAddress() %>"></td></tr>
				<tr><td>가입일자</td><td><input type="text" name="joindate" value="<%=m.getJoindate() %>"></td></tr>
				<tr><td>고객등급[A:VIP, B:일반, C:직원]</td><td><input type="text" name="grade" value=<%=m.getGrade() %>></td></tr>
				<tr><td>도시코드</td><td><input type="text" name="city" value=<%=m.getCity() %>></td></tr>
				<tr><td colspan="2" class="center">
					<input type="submit" value="수정" onclick="f1()">
					<input type="button" value="조회" onclick="f2()">
				</td></tr>
				<%}%>
				<script>
					function f1(){
						alert("회원정보수정이 완료 되었습니다!")
					}
					function f2(){
						location.href="check.jsp";
					}
				</script>
				
			</tbody>
		</table>
		</form>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>