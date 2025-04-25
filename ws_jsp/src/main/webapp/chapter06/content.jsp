<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header2.jsp" />
	<!-- 컴파일 시 page를 읽은 후 다시 넘어옴(페이지가 나누어져있음), 페이지 영역이 다름 -->
	내용 페이지입니다.<br />
	<a href="sub.jsp">서브 페이지로 가기</a><br />
	header의 페이지영역의 X 값 : ${pageScope.x }
	<jsp:include page="footer.jsp" />
</body>
</html>