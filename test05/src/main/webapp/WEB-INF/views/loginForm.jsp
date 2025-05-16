<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h1>로그인</h1>
    <p>${errMsg }</p>
    <form action="/login" method="POST">
        <input type="text" name="id" placeholder="아이디"><br />
        <input type="password" name="pw" placeholder="비밀번호"><br />
        <button type="submit">로그인</button>
    </form>

    <script>
        <%= request.getAttribute("error") != null ? "alert('" + request.getAttribute("error") + "');" : "" %>
    </script>
</body>
</html>

