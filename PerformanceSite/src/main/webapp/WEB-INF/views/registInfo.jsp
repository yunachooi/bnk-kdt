<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공연정보등록</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<jsp:include page="./header.jsp" />
	<jsp:include page="./nav.jsp" />

	<div id="registInfoContainer">
		<h2>공연정보등록 - 관리자전용</h2>
		<form action="registInfo" method="POST">
			공연코드 : <input type="text" name="p_code" placeholder="공연코드 입력"><br />
			공연이름 : <input type="text" name="p_name" placeholder="공연이름 입력"><br />
			<label for="p_genre">공연장르:</label> <select name="p_genre"
				id="p_genre">
				<option value="연극">연극</option>
				<option value="영화">영화</option>
				<option value="공연">공연</option>
			</select><br /> 공연기간 : <input type="text" name="p_schedule"
				placeholder="공연기간 입력"><br /> 공연시간 : <input type="text"
				name="p_time" placeholder="공연시간 입력"><br /> 러닝타임 : <input
				type="text" name="p_runningTime" placeholder="러닝타임 입력"><br />
			<label for="p_grade">관람등급:</label> <select name="p_grade"
				id="p_grade">
				<option value="12세 이상 관람가">12세 이상 관람가</option>
				<option value="15세 이상 관람가">15세 이상 관람가</option>
				<option value="19세 이상 관람가">19세 이상 관람가</option>
			</select><br /> 공연정보 : <input type="text" name="p_info" placeholder="공연정보 입력"><br />
			<input type="hidden" name="p_state" value="상영예정"><br />
			<button type="submit">등록하기</button>
			<button type="reset">다시쓰기</button>
			<button type="button" onclick="closeinfo()">등록취소</button>
		</form>
	</div>

	<script>
		function closeinfo() {
			location.href="/";
		}
	</script>
</body>
</html>