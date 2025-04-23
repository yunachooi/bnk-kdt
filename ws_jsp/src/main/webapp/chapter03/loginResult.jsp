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
	    color: #6A24FE;
	    margin-bottom: 20px;
	}
	#page-form > input{
	    width: 100%;
	    height: 48px;
	    padding: 0 10px;
	    box-sizing: border-box;
	    margin-bottom: 16px;
	    border-radius: 6px;
	    background-color: #F8F8F8;
	}
	#page-form > input[type="submit"]{
	    color: #fff;
	    font-size: 16px;
	    background-color: #6A24FE;
	    margin-top: 20px;
	}
</style>
</head>
<body>
	<div class="login-wrapper">
		<h2><%=session.getAttribute("id") %>(<%=session.getAttribute("name") %>)님 환영합니다.</h2>
		<form action="<%=path%>/memberOnly" method="POST" id="page-form">
			<input type="submit" value="회원전용페이지 바로가기">
		</form>
		<form action="<%=path%>/logout" method="POST">
			<input type="submit" value="로그아웃">
		</form>
	</div>
</body>
</html>