<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page</h1>
	<hr />
	<form action="rep1.jsp" method="GET">
		<%--name 속성 = 파라미터의 이름 --%>
		username : <input type="text" name="username"><br />
		age : <input type="text" name="age"><br />
		hobby : <input type="checkbox" name="hobbies" value="독서">책읽기&nbsp;
				<input type="checkbox" name="hobbies" value="코딩">코딩하기<br />
		bgcolor : <select name="bgcolor">
					<option value="red">빨강</option>
					<option value="blue">파랑</option>
				</select>
		<input type="submit" value="전송">
	</form>
	<a href="empList.jsp">사원목록보기</a>
	
	<h3>학생정보추가하기</h3>
	<form action="a.jsp" method="GET">
		학번 : <input type="text" name="stu_no"><br />
		이름 : <input type="text" name="stu_name"><br />
		학과 : <input type="text" name="stu_dept"><br />
		학년 : <input type="text" name="stu_grade"><br />
		반 : <input type="text" name="stu_class"><br />
		성별 : <input type="text" name="stu_gender"><br />
		키 : <input type="text" name="stu_height"><br />
		체중 : <input type="text" name="stu_weight"><br />
		<input type="submit" value="추가하기">
	</form>
	<a href="studentList.jsp">학생목록보기</a>
</body>
</html>