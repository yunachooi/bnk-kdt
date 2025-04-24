<%@page import="chapter06.A"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%! int gn = 0; %><%--전역(멤버변수영역) 정의문 --%>
<%-- 사람들이 페이지를 접속한 횟수를 알고 싶을 때 유용하게 사용됨 --%>
<%
	int ln = 0;
	gn++;
	ln++;
	
	List<A> list = new ArrayList<>();
	list.add(new A("홍길동", 23));
	list.add(new A("홍길동2", 24));
	list.add(new A("홍길동3", 25));
	
	pageContext.setAttribute("list", list);
%><%--지역(멤버메소드영역-service) 스크립틀릿 --%>
<%--service 메소드 : GET, POST 방식 자체적으로 정함 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> <view영역>
<!-- 주석 -->
<%--주석이 나오지 않음 --%>
	gn : <%=gn %> <%--표현식 --%> <br />
	ln : <%=ln %>
	<table border="1">
		<thead>
			<tr>
				<th>no</th><th>name</th><th>age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="a" items="${list }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<!-- count : 1부터 시작, index : 0부터 시작 -->
				<td>${a.name }</td>
				<td>${a.age }</td>				
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>