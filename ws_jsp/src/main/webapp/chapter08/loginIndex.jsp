<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	padding: 0;
	margin: 0;
	border: none;
}

body {
	font-size: 14px;
	font-family: 'Roboto', sans-serif;
	text-align: center;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-color: #f0f0f0;
}

.login-wrapper {
	width: 400px;
	padding: 40px;
	box-sizing: border-box;
	background: white;
	box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
	border-radius: 10px;
}

.login-wrapper>h2 {
	font-size: 24px;
	color: #6A24FE;
	margin-bottom: 20px;
}

#login-form>input {
	width: 100%;
	height: 48px;
	padding: 0 10px;
	box-sizing: border-box;
	margin-bottom: 16px;
	border-radius: 6px;
	background-color: #F8F8F8;
}

#login-form>input::placeholder {
	color: #D2D2D2;
}

#login-form>input[type="submit"] {
	color: #fff;
	font-size: 16px;
	background-color: #6A24FE;
	margin-top: 20px;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="login-wrapper">
		<h1>Login</h1><br />
		<form action="<%=path%>/chapter08/login_i" method="POST" id="login-form">
			<input type="text" name="id" placeholder="id"><br />
			<input type="password" name="pw" placeholder="pw"><br />
			<input type="submit" value="로그인">
			계정이 없으신가요? <button type="button" id="myLink">회원가입</button>
		</form>
		
		<script>
		document.getElementById("myLink").onclick = function(event) {
            event.preventDefault();
            location.href = "memberIndex.jsp";
        };
		</script>
	</div>
</body>
</html>