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
	.member-wrapper{
	    width: 400px;
	    height: 350px;
	    padding: 40px;
	    box-sizing: border-box;
	}
	.member-wrapper > h2{
	    font-size: 24px;
	    color: #6A24FE;
	    margin-bottom: 20px;
	}
	#member-form > input{
	    width: 100%;
	    height: 48px;
	    padding: 0 10px;
	    box-sizing: border-box;
	    margin-bottom: 16px;
	    border-radius: 6px;
	    background-color: #F8F8F8;
	}
	#member-form > input::placeholder{
	    color: #D2D2D2;
	}
	#member-form > input[type="submit"]{
	    color: #fff;
	    font-size: 16px;
	    background-color: #6A24FE;
	    margin-top: 20px;
	}
</style>
</head>
<body>
	<div class="member-wrapper">
		<h1>신규 회원가입</h1><br />
		<form action="<%=path%>/member" method="POST" id="member-form">
					<input type="text" name="id" placeholder="id"><br />
					<input type="password" name="pw" placeholder="pw"><br />
					<input type="text" name="name" placeholder="name"><br />
					<input type="submit" value="회원가입">
		</form>
	</div>
</body>
</html>