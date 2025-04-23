<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
	    padding: 0;
	    margin: 0;
	    border: none;
	}
	body{
	    font-size: 14px;
	    font-family: 'Roboto', sans-serif;
	}
	.login-wrapper{
	    width: 400px;
	    height: 350px;
	    padding: 40px;
	    box-sizing: border-box;
	}
	.login-wrapper > h2{
	    font-size: 24px;
	    color: #6A24FE;
	    margin-bottom: 20px;
	}
	#login-form > input{
	    width: 100%;
	    height: 48px;
	    padding: 0 10px;
	    box-sizing: border-box;
	    margin-bottom: 16px;
	    border-radius: 6px;
	    background-color: #F8F8F8;
	}
	#login-form > input::placeholder{
	    color: #D2D2D2;
	}
	#login-form > input[type="submit"]{
	    color: #fff;
	    font-size: 16px;
	    background-color: #6A24FE;
	    margin-top: 20px;
	}
</style>
</head>
<body>
	<div class="login-wrapper">
		<h1>Login</h1><br />
		<form action="<%=path%>/login" method="POST" id="login-form">
					<input type="text" name="id" placeholder="id"><br />
					<input type="password" name="pw" placeholder="pw"><br />
					<input type="submit" value="로그인">
		</form>
		<form action="memberIndex.jsp">
			<input type="submit" value="회원가입">
		</form>
	</div>
</body>
</html>