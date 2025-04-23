<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 4대저장소 = 내장개체 : 작은 범위부터 큰 범위 순서 (범위 == 거리) */
	/* 해당 페이지에서만 존재하는 저장소 : 공유되지 않음. */
	pageContext.setAttribute("x", "page_X");
	/* 하나의 페이지에만 저장소 할당 : 하지만 다른 페이지로 복사 가능 */
	request.setAttribute("x", "request_X");
	/* 브라우저(사용자)에 귀속됨 : 사용자에게 저장되며, 개인화된 특수한 저장소, 삭제해도 이전 데이터를 가지고 있음(기억), EL표기법*/
	session.setAttribute("x", "session_X");
	/* 해당 프로젝트(서비스)를 사용하는 모든 사람들이 공유 */
	application.setAttribute("x", "application_X");
	
	String s = "hello";
	pageContext.setAttribute("s", s);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	page 저장소 값 : <%=pageContext.getAttribute("x") %><br />
	request 저장소 값 : <%=request.getAttribute("x") %><br />
	session 저장소 값 : <%=session.getAttribute("x")  %><br />
	application 저장소 값 : <%=application.getAttribute("x")  %><hr />
	
	page 저장소 값 :${pageScope.x }<br />
	request 저장소 값 : ${requestScope.x }<br />
	session 저장소 값 : ${sessionScope.x }<br />
	application 저장소 값 : ${applicationScope.x }<hr />
	
	s(EL) : ${s }<br>
	s(표현식) : <%=s %><hr />
	
	파라미터 y = ${param.y}<br />
	
	
</body>
</html>