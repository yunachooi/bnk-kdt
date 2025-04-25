<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL & JSTL</h1><hr />
<c:set var="msg" value="Hello" scope="session" />
<p>msg : ${msg }</p>
<c:set var="age">
	30
</c:set>
<p>age : ${age }</p>
<a href="jstlTest2.jsp">jstl 페이지 2로 가기</a>
<c:set var="man" value="<%=new chapter06.Man()%>" />
<c:set target="${man }" property="name" value="James" />
<c:set target="${man }" property="age" value="33" />
<c:set target="${man }" property="job" value="student" />

man 정보 : %{man }<br />
<c:remove var="man" scope="page" />

msg 정보(page) : %{pageScope.msg }<br />
msg 정보(session) : %{sessionScope.msg }<hr />

<form action="jstlTest2.jsp">
	<label for="color">색상을 선택하세요</label>
	<select id="color" name="color">
		<option value="1">빨강</option>
		<option value="2">초록</option>
		<option value="3">파랑</option>
	</select>
	<input type="submit" value="전송">
</form><hr />
	
<form action="jstlTest2.jsp">
	<label for="fruit">과일을 선택하세요</label>
	<select id="fruit" name="fruit">
		<option value="1">사과</option>
		<option value="2">복숭아</option>
		<option value="3">포도</option>
	</select>
	<input type="submit" value="전송">
</form><hr />

<c:forEach var="cnt" begin="1" end="10" step="1" varStatus="status">
	${cnt } <c:if test="${not status.last }">, </c:if>
</c:forEach><hr />

<table border="1">
	<thead>
		<tr>
		<th>index</th><th>count</th><th>cnt</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="cnt" begin="0" end="14" step="2" varStatus="status">
			<tr>
				<td>${status.index }</td>
				<td>${status.count }</td>
				<td>${cnt }</td>
			</tr>
		</c:forEach>
	</tbody>
</table><hr />

<c:forTokens var="city" items="서울, 대전, 대구, 부산" delims=",">
	${city }<br />
</c:forTokens><hr />

<c:forTokens var="city" items="서울, 대전, 대구, 부산" delims=",">
	${city }<br />
</c:forTokens><hr />

<c:import url="http://localhost:8090/ws_jsp/chapter06/header.jsp" var="data" />
	${data }<hr />
	
<c:url value="/images/cat1.jpg" var="img" />
<h3>${img }</h3>
<img src="${img }" width="200" height="150"><hr />

<c:set var="n" value="30" scope="page" />
숫자 : <c:out value="${n }" /><hr />

<c:catch var="errmsg">
	예외발생 전 <br />
	<%=1 / 0 %>
	예외발생 후 <br />
</c:catch>
<c:out value="${errmsg }" />



</body>
</html>