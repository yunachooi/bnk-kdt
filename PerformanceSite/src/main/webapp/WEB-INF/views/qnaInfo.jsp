<%@page import="com.example.PerformanceSite.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
MemberDTO member = (MemberDTO) session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈 > Q&A > Q&A등록</title>
</head>
<body>
	<jsp:include page="./header.jsp" />
	<jsp:include page="./nav.jsp" />

	<div id="qnaInfoContainer">
		<h2>홈 > Q&A > Q&A등록</h2>
		<form action="qna" method="POST">
			<input type="text" name="q_title" placeholder="제목 입력"><br />
			<input type="text" name="q_content" placeholder="내용 입력"><br />
			<button type="submit" onclick="registbtn()">등록하기</button>
			<button type="button" onclick="closeinfo()">등록취소</button>
			<input type="hidden" name="q_writer" value="<%=member.getId()%>">
		</form>
	</div>

	<script>
		function registbtn() {
			alert('등록되었습니다.');
		}

		function closeinfo() {
			location.href = "/qna";
		}
	</script>
</body>
</html>