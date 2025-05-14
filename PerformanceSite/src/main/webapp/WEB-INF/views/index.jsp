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
<title>공연 예약 사이트</title>
</head>
<body>
	<jsp:include page="./header.jsp" />
	<jsp:include page="./nav.jsp" />
	<div id="mainContrainer">
		<div id="msg">
			<h2>홈 > 공연 일정</h2>
			<ul>
				<li><a href="#" onclick="state('상영중')">상영중</a></li>
				<li><a href="#" onclick="state('상영예정')">상영예정</a></li>
				<li><a href="#" onclick="state('상영종료')">상영종료</a></li>
			</ul>

			<table border="1">
				<thead>
					<tr>
						<th>공연장르</th>
						<th>공연이름</th>
						<th>공연기간</th>
						<th>러닝타임</th>
						<th>관람등급</th>
						<th>예매</th>
						<th>정보</th>
					</tr>
				</thead>
				<tbody id="performance-list">
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.p_genre}</td>
							<td>${item.p_name}</td>
							<td>${item.p_schedule}</td>
							<td>${item.p_runningTime}분</td>
							<td>${item.p_grade}</td>
							<td><c:choose>
									<c:when test="${item.p_state == '상영중'}">
										<button onclick="ticket()">예매하기</button>
									</c:when>
									<c:otherwise>
										<button onclick="noTicket()">예매불가</button>
									</c:otherwise>
								</c:choose></td>
							<td><button onclick="detail('${item.p_code}')">상세보기</button>
							 <c:if test="${member != null && member.name == 'admin'}">
				                <button onclick="removeInfobtn('${item.p_code}')">삭제하기</button>
				            </c:if></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<br />

		<%
		if (member != null && "admin".equals(member.getName())) {
		%>
		<div id="admin-buttons">
			<button onclick="registInfobtn()">공연등록</button>
		</div>
		<%
		}
		%>
	</div>

	<script>
		function ticket(){
			alert('예매가 정상적으로 완료되었습니다.');
		}
		
		function noTicket(){
			alert('예매 불가 상품입니다.');
		}
		
		function registInfobtn(){
			location.href = "/registInfo"
		}
		
		function state(p_state){
			const xhr = new XMLHttpRequest();
			xhr.open("GET", "/state?p_state=" + encodeURIComponent(p_state), true);
			xhr.onreadystatechange = function() {
				if (xhr.readyState === 4 && xhr.status === 200) {
					const data = JSON.parse(xhr.responseText);

					let html = '';
					data.forEach(item => {
						let ticketButton = '';
						if (item.p_state === '상영중') {
							ticketButton = `<button onclick="ticket()">예매하기</button>`;
						} else {
							ticketButton = `<button onclick="noTicket()">예매불가</button>`;
						}

						html += `
							<tr>
								<td>\${item.p_genre}</td>
								<td>\${item.p_name}</td>
								<td>\${item.p_schedule}</td>
								<td>\${item.p_runningTime}분</td>
								<td>\${item.p_grade}</td>
								<td>\${ticketButton}</td>
								<td><button onclick="detail('${item.p_code}')">상세보기</button></td>
							</tr>
						`;
					});
					
					document.getElementById("performance-list").innerHTML = html;
				}
			};
			xhr.send();
		}
		
		function detail(p_code){
		    const xhr = new XMLHttpRequest();
		    xhr.open("GET", "/detail?p_code=" + p_code, true);

		    xhr.onreadystatechange = function() {
		        if (xhr.readyState === 4 && xhr.status === 200) {
		            const data = JSON.parse(xhr.responseText);
		            
		            const adminButtons = document.getElementById("admin-buttons");
		            if (adminButtons) {
		                adminButtons.style.display = "none";
		            }

		            let ticketButton = '';
		            if (data.p_state === '상영중') {
		                ticketButton = `<button onclick="ticket()">예매하기</button>`;
		            } else {
		                ticketButton = `<button onclick="noTicket()">예매불가</button>`;
		            }

		            // 댓글 목록 가져오기
		            const commentXhr = new XMLHttpRequest();
		            commentXhr.open("GET", "/comments?p_code=" + p_code, true);

		            commentXhr.onreadystatechange = function() {
		                if (commentXhr.readyState === 4 && commentXhr.status === 200) {
		                    const comments = JSON.parse(commentXhr.responseText);
		                    
		                    const sessionId = '<%= (member != null) ? member.getId() : "" %>';

		                    let commentHtml = '';
		                    comments.forEach(comment => {
		                    	let deleteBtn = '';
		                    	if (sessionId === comment.c_writer || sessionId === 'admin') {
		                    		deleteBtn = `<button onclick="rmComment('\${comment.c_no}')">삭제하기</button>`;
		                    	}
		                    	
		                        commentHtml += `
		                            <tr>
		                                <td>\${comment.c_comment}</td>
		                                <td>\${comment.c_writer}</td>
		                                <td>\${comment.c_regdate}</td>
		                                <td>\${deleteBtn}</td>
		                            </tr>
		                        `;
		                    });

		                    let reviewForm = '';
		                    if (${member != null}) {
		                        reviewForm = `
		                            <form id="commentForm" action="/comment/${member.id}" method="POST">
		                                <input type="text" name="c_comment" placeholder="기대/감상평 입력" required>
		                                <button type="button" onclick="submitComment()">등록</button>
		                                <input type="hidden" name="p_code" value="\${data.p_code}" />
		                            </form>
		                        `;
		                    }

		                    const html = `
		                        <h2>홈 > 공연일정 > 공연상세</h2><br />
		                        <table border="1">
		                            <tbody>
		                                <tr>
		                                    <td rowspan="6"><img src="./images/img.jpeg" width="300" height="400"/></td>
		                                    <td>\${data.p_genre}</td>
		                                    <td rowspan="5">
		                                        R석 30,000<br />
		                                        S석 20,000<br />
		                                        A석 10,000<br />
		                                        학생석 5,000<br />
		                                    </td>
		                                </tr>
		                                <tr><td>\${data.p_name} (\${data.p_state})</td></tr>
		                                <tr><td><strong>공연일정:</strong> \${data.p_schedule}</td></tr>
		                                <tr><td><strong>상영시간:</strong> \${data.p_time}</td></tr>
		                                <tr><td><strong>러닝타임:</strong> \${data.p_runningTime}분</td></tr>
		                                <tr>
		                                    <td><strong>관람등급:</strong> \${data.p_grade}</td>
		                                    <td>\${ticketButton}</td>
		                                </tr>
		                            </tbody>
		                        </table>

		                        <h3>공연종합정보</h3>
		                        <p>\${data.p_info}</p>

		                        <h3>한줄 기대/감상평</h3>
		                        \${reviewForm}<br />
		                        <table border="1">
		                            <thead>
		                                <tr>
		                                    <th>내용</th>
		                                    <th>작성자</th>
		                                    <th>등록일</th>
		                                    <th>비고</th>
		                                </tr>
		                            </thead>
		                            <tbody id="commentTableBody">
		                                \${commentHtml}
		                            </tbody>
		                        </table><br />

		                        <button onclick="closeDetail()">목록보기</button>
		                    `;

		                    document.getElementById("msg").innerHTML = html;
		                }
		            };
		            commentXhr.send();
		        }
		    };
		    xhr.send();
		}

		function closeDetail(){
			location.reload();
		}

		function registUser(){
			alert('등록되었습니다.');
		}
		
		function submitComment() {
		    const comment = document.querySelector("input[name='c_comment']").value;
		    if (comment.trim()) {
		        const form = document.getElementById("commentForm");
		        form.submit();
		    } else {
		        alert("기대/감상평을 입력해주세요.");
		    }
		}
		
		function removeInfobtn(p_code){
			location.href="/rmPerformance/" + p_code;
			alert("공연정보가 삭제되었습니다.");
		}
		
		function rmComment(c_no){
			location.href="/rmComment/" + c_no;
			alert("기대/감상평이 삭제되었습니다.");
		}
	</script>
</body>
</html>
