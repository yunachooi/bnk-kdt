<%@page import="com.example.PerformanceSite.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%
MemberDTO member = (MemberDTO) session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈 > Q&A</title>
</head>
<body>
	<jsp:include page="./header.jsp" />
	<jsp:include page="./nav.jsp" />
	<div id="qnaContainer">
		<div id="msg">
			<h2>홈 > Q&A</h2>
			<table border="1">
				<thead>
					<tr>
						<th>No.</th>
						<th>제목</th>
						<th>상태</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody id="qna-list">
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.q_no}</td>
							<td><a href="#" onclick="detail(${item.q_no})">${item.q_title}</a></td>
							<td>${item.q_status }</td>
							<td>${item.q_writer }</td>
							<td>${item.q_regdate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br />
			<button type="button" onclick="registBtn()">등록</button>
		</div>
	</div>

	<script>
		const login = '<%= (member != null) ? "Y" : "N" %>';
	
		function registBtn() {
			if (login === 'Y') {
				location.href = "/qnaInfo";
			} else {
				alert('로그인 페이지로 이동합니다.');
				location.href = "/login";
			}
		}
		
		function detail(q_no) {
			const xhr = new XMLHttpRequest();
			xhr.open("GET", "/qnaDetail?q_no=" + q_no, true);
			xhr.onreadystatechange = function () {
				if (xhr.readyState === 4 && xhr.status === 200) {
					const data = JSON.parse(xhr.responseText);

					let html = `
						<h2>홈 > Q&A > Q&A 상세</h2><br />
					    <table border="1">
					    	<tbody>
					    		<tr><td>제목</td><td>\${data.q_title}  [\${data.q_status}]</td></tr>
					    		<tr><td>문의 일자</td><td>\${data.q_regdate}</td></tr>
					    		<tr><td>작성자</td><td>\${data.q_writer}</td></tr>
					    		<tr><td>문의 내용</td><td>\${data.q_content}</td></tr>
					    	</tbody>
					    </table>
					    <button onclick="closeDetail()">목록보기</button>
					`;

					const sessionid = '<%= (member != null) ? member.getId() : "" %>';
					console.log(sessionid);

					if (data.q_writer === sessionid || sessionid === 'admin') {
						html += `<button onclick="removeDetail(\${data.q_no})">삭제하기</button>`;
					}

					document.getElementById("msg").innerHTML = html;
				}
			};
			xhr.send();
		}

		function closeDetail(){
			location.reload();
		}
		
		function removeDetail(q_no){
			location.href="/rmQna/" + q_no;
			alert("문의사항이 삭제되었습니다.");
		}
	</script>
</body>
</html>