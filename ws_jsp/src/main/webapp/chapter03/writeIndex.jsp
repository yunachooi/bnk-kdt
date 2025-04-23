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
	.board-wrapper {
	    width: 400px;
	    padding: 40px;
	    box-sizing: border-box;
	}
	.board-wrapper > h2{
	    font-size: 24px;
	    color: #6A24FE;
	    margin-bottom: 20px;
	}
	#login-form > input{
	    width: 100%;
	    padding: 0 10px;
	    box-sizing: border-box;
	    margin-bottom: 16px;
	    border-radius: 6px;
	    background-color: #F8F8F8;
	}
	#title{
		height: 48px
	}
	#content{
		height: 200px
	}
	#login-form > input::placeholder{
	    color: #D2D2D2;
	}
	#login-form > input[type="submit"]{
		height: 40px;
	    color: #fff;
	    font-size: 16px;
	    background-color: #6A24FE;
	    margin-top: 20px;
	}
</style>
</head>
<body>
	<div class="board-wrapper">
		<h2>게시물 작성하기</h2>
		<form action="<%=path %>/write" method="POST" id="login-form">
			<input type="text" name="title" placeholder="title" id="title"><br />
			<input type="text" name="content" placeholder="content" id="content"><br />
			<input type="submit" value="완료">
		</form>
		<form action="onlyMemberIndex.jsp" method="POST">
			<input type="submit" value="게시판보기">
		</form>
	</div>
</body>
</html>