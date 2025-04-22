<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>온라인 계산기</h1>
	<form action="<%=path %>/cal" method="GET">
		첫 번째 값 : <input type="text" name="a"><br />
		두 번째 값 : <input type="text" name="b"><br />
		<select name="calculation">
			<option value="더하기">더하기</option>
			<option value="빼기">빼기</option>
			<option value="곱하기">곱하기</option>
			<option value="나누기">나누기</option>
		</select>
		<input type="submit" value="계산하기">
	</form>
</body>
</html>