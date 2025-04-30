<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 이체</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 20px
}

.form-container {
	max-width: 500px;
	margin: 0 auto;
	padding: 20px;
	border: 1px solid #ddd;
	border-radius: 5px;
}

.form-group {
	margin-bottom: 15px
}

label {
	display: block;
	margin-bottom: 5px;
	font_weight: bold;
}

input[type="text"] {
	width: 100%;
	padding: 8px;
	box-sizing: border-box;
}

button {
	padding: 10px 15px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="form-container">
		<h2>계좌 이체</h2>
		<form action="<%=path%>/transfer" method="post">
			<div class="form-group">
				<label for="fromAccount">출금 계좌:</label>
				<input type="text" id="fromAccount" name="fromAccount" required>
			</div>
			<div class="form-group">
				<label for="toAccount">입금 계좌:</label>
				<input type="text" id="toAccount" name="toAccount" required>
			</div>
			<div class="form-group">
				<label for="amount">이체 금액:</label>
				<input type="text" id="amount" name="amount" required>
			</div>
			<button type="submit">이체 실행</button>
		</form>
	</div>
</body>
</html>