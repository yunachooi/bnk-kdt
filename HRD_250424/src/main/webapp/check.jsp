<%@page import="vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDAO member = new MemberDAO();
	List<MemberVO> list = member.selectAll();
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
		<h1>회원목록조회/수정</h1>
		<table border="1">
			<thead>
				<tr><th>회원번호</th><th>회원성명</th><th>회원전화</th>
				<th>주소</th><th>가입일자</th><th>고객등급</th><th>거주지역</th></tr>
			</thead>
			<tbody>
				<%for (MemberVO m : list) {%>
					<tr>
					<td><a href="detail.jsp?custno=<%=m.getCustno() %>" style="color: black"><%=m.getCustno() %></td>
					<td><%=m.getCustname() %></td>
					<td><%=m.getPhone() %></td>
					<td><%=m.getAddress() %></td>
					<td><%=m.getJoindate() %></td>
					<td><%=m.getGrade() %></td>
					<td><%=m.getCity() %></td>
					</tr>
					<%}%>
			</tbody>
		</table>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>