<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	* 요청(request) 
		1.Get방식(주소 창에 파라미터가 보여짐)
			1)a태그 이용 (파라미터 직접 작성)
			2)form - get method (파라미터 자동 생성)
		
		2.Post방식(주소 창에 파라미터가 보여지지 않음)
			요청 몸통(body)에 파라미터를 실어보냄
			form - post method
	-->
	
	<!--
	* 응답(response)
		1.요청을 처리하는 과정에서 view를 지정하는 것
			request 객체를 활용
			request.getRequesDisptcher("페이지지정")forward(request, response);
			
		2.클라이언트의 요청을 완료한 후 view를 지정하는 것
			response 객체를 활용 
			response.sendRedirect("페이지지정");
	-->
	
	<!-- 
	               *Data(parameter)
		클라이언트(view)------------@>서버(servlet)
		
			       *Data(request영역에 저장)
		클라이언트(view)<@------------서버(servlet)
	 -->
	 
	 
	<h1>Index Page</h1><hr />
	
	<h2>GET 방식1 - a태그 활용</h2>
	<a href="p1.jsp">p1페이지로 가기(jsp로 바로가기)</a><br />
	<a href="<%=path %>/p1">p1페이지로 가기(servlet으로 바로가기)</a>
	
	<h2>GET 방식2 - a태그 활용(파라미터 보내기 --> 쿼리스트링 만들기)</h2>
	<a href="p2.jsp?name=James&age=26">p2페이지로 가기(jsp로 바로가기)</a><br />
	<a href="<%=path %>/p2?name=James&age=26">p2페이지로 가기(servlet으로 바로가기)</a>
	
	<h2>GET 방식3 - form - 서블릿 활용 (쿼리스트링 자동 생성)</h2>
	<!-- 예상쿼리스트링 : p3.jsp?fruit=apple&subject=JAVA&animal=cat&movies=bumblebee&movies=transformer -->
	<form action="<%=path %>/p4" method="GET">
		<input type="text" name="fruit" value="apple">
		<input type="radio" name="subject" value="JAVA">JAVA
		<input type="radio" name="subject" value="SQL">SQL
		<input type="radio" name="subject" value="HTML/CSS">HTML/CSS<br />
		<select name="animal">
			<option value="dog">강아지</option>
			<option value="cat">고양이</option>
			<option value="tiger">호랑이</option>
		</select>
		<input type="checkbox" name="movies" value="bumblebee">범블비
		<input type="checkbox" name="movies" value="transformer">트랜스포머
		<input type="checkbox" name="movies" value="The Fast and the Furious">분노의 질주
		
		<input type="submit" value="전송">
	</form>
	
</body>
</html>