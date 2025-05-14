<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항등록 - 관리자전용</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<jsp:include page="./header.jsp" />
	<jsp:include page="./nav.jsp" />

	<div id="noticeInfoContainer">
		<h2>공지사항등록 - 관리자전용</h2>
		<form action="notice" method="POST">
			<label for="n_genre">분류:</label> <select name="n_genre" id="n_genre">
				<option value="티켓">티켓</option>
				<option value="보도자료">보도자료</option>
				<option value="기타">기타</option>
			</select><br /> <input type="text" name="n_title" placeholder="제목 입력"><br />
			<input type="text" name="n_content" placeholder="내용 입력"><br />
			<button type="submit" onclick="registbtn()">등록하기</button>
			<button type="button" onclick="closeinfo()">등록취소</button>
		</form>
	</div>

	<script>
		function registbtn() {
			alert('등록되었습니다.');
		}

		function closeinfo() {
			location.href = "/notice";
		}
	</script>
</body>
</html>