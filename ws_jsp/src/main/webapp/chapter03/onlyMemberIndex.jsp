<%@page import="chapter03.dao.BoardDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDao board = new BoardDao();
	List<chapter03.vo.BoardVO> list = board.selectAll();
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
</style>
</head>
<body>
	<div class="login-wrapper">
		<h2>자유게시판</h2>
		<table>
			<thead><tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일자</th></tr></thead>
			<tbody>
			<%for (chapter03.vo.BoardVO b : list) {%>
				<tr>
				<td><%=b.getBno() %></td>
				<td><%=b.getTitle() %></td>
				<td><%=b.getWriter() %></td>
				<td><%=b.getDate() %></td>
				</tr>
				<%}%>
			</tbody>
		</table>
	</div>
</body>
</html>