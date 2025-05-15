<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="jakarta.tags.core"%>
<% int setStart = 1; int setEnd = 5; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글</h1>
	<div id="msg">
		<table border="1">
			<thead><tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr></thead>
			<tbody>
				<c:forEach var="item" items="${list}" varStatus="status">
				<tr>
					<td>${item.bno}</td>
					<td>${item.title}</td>
					<td>${item.writer}</td>
					<td>${item.regdate}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<button type="button" onclick="prev()">&lt</button>
	
	<c:forEach var="i" begin="<%=setStart %>" end="<%=setEnd %>">
	    <c:set var="start" value="${(i - 1) * 10 + 1}" />
	    <c:set var="end" value="${i * 10}" />
	    <a href="/${start}/${end}">${i}</a>
	</c:forEach>

	<button type="button" onclick="next()">&gt</button>
		
	<script>
		function prev(){
			if(<%=setStart%> == 1){
				alert("첫 페이지입니다.");
				return;
			}
		}
		function next(){
			if(<%=setEnd%> == 11){
				alert("마지막 페이지입니다.");
				return;
			}
			
			<%=setStart += 5%>;
			<%=setEnd += 5%>;
			
			console.log(<%=setStart%>);
		}
	</script>

</body>
</html>