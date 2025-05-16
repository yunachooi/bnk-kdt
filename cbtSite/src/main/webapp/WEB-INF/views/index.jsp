<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자격검정 CBT 웹서비스 구현</title>
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="controller">
		<form action="/exam" method="POST" class="form-box">
			<h2>수험생 정보</h2>
			<div class="input-group">
				<label for="e_number">수험번호</label> <input type="text" id="e_number"
					name="e_number" required placeholder="수험번호 입력">
			</div>
			<div class="input-group">
				<label for="e_name">수험자명</label> <input type="text" id="e_name"
					name="e_name" required placeholder="수험자명 입력">
			</div>
			<button type="submit" class="start-btn">시험 시작</button>
		</form>
	</div>

</body>
</html>