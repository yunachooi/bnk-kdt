<%@page import="com.example.PerformanceSite.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%MemberDTO member = (MemberDTO) session.getAttribute("member");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>
	<jsp:include page="./header.jsp" />
	<jsp:include page="./nav.jsp" />
	
	<div id="noticeContrainer">
		<div id="msg">
			<h2>홈 > 공지사항</h2>
			<table border="1">
				<thead>
					<tr>
						<th>번호</th>
						<th>분류</th>
						<th>제목</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody id="notice-list">
					<c:forEach var="notice" items="${list}">
						<tr>
							<td>${notice.n_no}</td>
							<td>${notice.n_genre}</td>
							<td><a href="#" onclick="detail(${notice.n_no})">${notice.n_title}</a></td>
							<td>${notice.n_regdate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table><br />
			
			<%if (member != null && "admin".equals(member.getName())) {%>
			<button onclick="noticeInfobtn()">공지사항등록</button>
			<%}%>
		</div>
	</div>
	
	<script>
		function noticeInfobtn(){
			location.href = "/noticeInfo";
		}
		
		function detail(n_no){
			const xhr = new XMLHttpRequest();
			xhr.open("GET", "/noticeDetail?n_no=" + encodeURIComponent(n_no), true);
			xhr.onreadystatechange = function() {
				if (xhr.readyState === 4 && xhr.status === 200) {
					const data = JSON.parse(xhr.responseText);
					
					const html = `
					    <h2>홈 > 공지사항 > 공지사항 상세</h2><br />
					    <p>| \${data.n_genre} |</p>
					    <p id="title">\${data.n_title}</p>
					    <p>등록일 \${data.n_regdate}</p><hr />
					    \${data.n_content}<br />
					    
					    <button onclick="closeDetail()">목록보기</button>
					`;

					document.getElementById("msg").innerHTML = html;
				}
			};
			xhr.send();
		}

		function closeDetail(){
			location.reload();
		}
	</script>
</body>
</html>
