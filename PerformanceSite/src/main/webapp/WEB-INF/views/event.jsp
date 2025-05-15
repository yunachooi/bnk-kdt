<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈 > 이벤트</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<jsp:include page="./header.jsp" />
	<jsp:include page="./nav.jsp" />

	<div id="eventContrainer">
		<h2>홈 > 이벤트</h2>
		
		<div class="event-list">
			<div class="event-card">
				<img src="./images/event1.jpg" alt="이벤트1">
				<h3>회원 가입 이벤트</h3>
				<p>지금 가입하면 예매 할인 쿠폰을 드립니다!</p>
			</div>
			
			<div class="event-card">
				<img src="./images/event2.jpg" alt="이벤트2">
				<h3>기대/감상평 작성 이벤트</h3>
				<p>공연 기대/감상평 남기고 기프티콘 받자!</p>
			</div>
		</div>
	</div>
</body>
</html>
