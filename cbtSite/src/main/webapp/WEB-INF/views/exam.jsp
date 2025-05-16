<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<nav>
		<p class="left">과목명: 컴퓨터일반</p>
		<p class="right">과목 문제 수 : 5문제</p>
	</nav>
	<form action="/submitExam" method="post">
		<div id="exam1" class="e_left">
			<p>1. 관계 데이터베이스에서 하나의 애트리뷰트가 취할 수 있는 같은 타입의 모든 원자값들의 집합을 무엇이라고
				하는가?</p>
			<input type="radio" id="exam1-1" name="exam1" value=1> <label
				for="exam1-1">튜플(tuple)</label><br /> <input type="radio"
				id="exam1-2" name="exam1" value=2> <label for="exam1-2">도메인(domain)</label><br />
			<input type="radio" id="exam1-3" name="exam1" value=3> <label
				for="exam1-3">스키마(schema)</label><br /> <input type="radio"
				id="exam1-4" name="exam1" value=4> <label for="exam1-4">인스턴스(instance)</label><br />
		</div>

		<div id="exam2" class="e_right">
			<p>2. 테이블 구조 변경시 사용하는 SQL 명령은?</p>
			<input type="radio" id="exam2-1" name="exam2" value=1> <label
				for="exam2-1">ALTER TABLE</label><br /> <input type="radio"
				id="exam2-2" name="exam2" value=2> <label for="exam2-2">MODIFY
				TABLE</label><br /> <input type="radio" id="exam2-3" name="exam2" value=3>
			<label for="exam2-3">DROP TABLE</label><br /> <input type="radio"
				id="exam2-4" name="exam2" value=4> <label for="exam2-4">CREATE
				INDEX</label><br />
		</div>

		<div id="exam3" class="e_left">
			<p>3. 컴퓨터와 단말기 또는 컴퓨터 간에 데이터전송에 필요한 절차 및 사항 등을 정한 규범은?</p>
			<input type="radio" id="exam3-1" name="exam3" value=1> <label
				for="exam3-1">통신채널</label><br /> <input type="radio" id="exam3-2"
				name="exam3" value=2> <label for="exam3-2">프로토콜</label><br />
			<input type="radio" id="exam3-3" name="exam3" value=3> <label
				for="exam3-3">전송기준</label><br /> <input type="radio" id="exam3-4"
				name="exam3" value=4> <label for="exam3-4">권고사항</label><br />
		</div>

		<div id="exam4" class="e_right">
			<p>4. IP주소 100.100.100.100은 어느 Class에 속하는가?</p>
			<input type="radio" id="exam4-1" name="exam4" value=1> <label
				for="exam4-1">Class A</label><br /> <input type="radio"
				id="exam4-2" name="exam4" value=2> <label for="exam4-2">Class
				B</label><br /> <input type="radio" id="exam4-3" name="exam4" value=3>
			<label for="exam4-3">Class C</label><br /> <input type="radio"
				id="exam4-4" name="exam4" value=4> <label for="exam4-4">Class
				D</label><br />
		</div>

		<div id="exam5" class="e_left">
			<p>5. FTP는 OSI 7계층 중 어느 계층에 속하는가?</p>
			<input type="radio" id="exam5-1" name="exam5" value=1> <label
				for="exam5-1">물리계층</label><br /> <input type="radio" id="exam5-2"
				name="exam5" value=2> <label for="exam5-2">데이터링크계층</label><br />
			<input type="radio" id="exam5-3" name="exam5" value=3> <label
				for="exam5-3">응용계층</label><br /> <input type="radio" id="exam5-4"
				name="exam5" value=4> <label for="exam5-4">세션계층</label><br />
		</div>

		<div>
			<input type="hidden" name="e_number" value=${e_number }>
			<button type="submit" id="btn">답안제출</button>
		</div>
	</form>
</body>
</html>