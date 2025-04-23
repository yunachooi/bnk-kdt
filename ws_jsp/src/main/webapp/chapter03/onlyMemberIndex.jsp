<%@page import="chapter03.vo.BoardVO"%>
<%@page import="chapter03.dao.BoardDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	BoardDao board = new BoardDao();
	List<BoardVO> list = board.selectAll();
%>
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
	table{
		width:400px;
	}
	#login-form > input{
	    width: 35%;
	    height: 40px;
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
		<h2>자유게시판</h2>
		<table>
			<thead><tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일자</th></tr></thead>
			<tbody>
			<%for (BoardVO b : list) {%>
				<tr>
				<td><%=b.getBno() %></td>
				<td><%=b.getTitle() %></td>
				<td><%=b.getWriter() %></td>
				<td><%=b.getRegdate() %></td>
				</tr>
				<%}%>
			</tbody>
		</table>
		<form action="writeIndex.jsp" id="login-form">
			<input type="submit" value="게시글 작성">
		</form>
		<form action="<%=path%>/logout" method="POST">
			<input type="submit" value="로그아웃">
		</form>
	</div>
</body>
</html>