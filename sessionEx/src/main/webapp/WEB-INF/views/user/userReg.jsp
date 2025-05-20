<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>User Regist Page</h2>
	<form action="create" method="post">
		<input type="text" name="id" placeholder="id"><br /> <input
			type="password" name="pw" placeholder="pw"><br /> <input
			type="text" name="name" placeholder="name"><br /> <input
			type="text" name="role" placeholder="role"><br />
		<button type="submit">submit</button>
	</form>
	<!-- 
		*Java Bean Validation 어노테이션 정리
		
		1. 문자열 / 컬렉션 / 배열 관련
		- @NotEmpty: null 또는 비어 있으면 안 됨 (문자열, 컬렉션, 맵, 배열에 사용 가능)
		- @NotBlank: null, 빈 문자열, 공백 문자 허용 안 됨 (문자열 전용)
		- @Size(min=, max=): 길이(크기) 제한 (문자열, 컬렉션, 배열, 맵에 사용 가능)
		
		2. 숫자 관련
		- @Min(value): 최소값 이상
		- @Max(value): 최대값 이하
		- @Positive: 양수만 허용 (0 제외)
		- @PositiveOrZero: 0 이상 허용
		- @Negative: 음수만 허용 (0 제외)
		- @NegativeOrZero: 0 이하 허용
		
		3. 형식 관련
		- @Email: 이메일 형식 검증
		- @Pattern(regexp="..."): 정규식 패턴 검사 (문자열 대상)
		
		4. 날짜 / 시간 관련
		- @Future: 현재보다 미래 날짜만 허용
		- @FutureOrPresent: 현재 또는 미래 날짜 허용
		- @Past: 현재보다 과거 날짜만 허용
		- @PastOrPresent: 현재 또는 과거 날짜 허용
	-->
</body>
</html>