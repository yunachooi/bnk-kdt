<%@page import="com.example.PerformanceSite.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%MemberDTO member = (MemberDTO) session.getAttribute("member");%>
<header id="userContainer">
	<span><%=member != null ? member.getName() : "비회원"%>님 환영합니다.</span>
	<%
	if (member == null) {
	%>
	<button onclick="loginbtn()">로그인</button>
	<button onclick="registbtn()">회원가입</button>
	<%
	} else {
	%>
	<button onclick="logoutbtn()">로그아웃</button>
	<%
	}
	%>
</header>
<script>
	function loginbtn() {
		location.href = "/login";
	}
	function registbtn() {
		location.href = "/regist";
	}
	function logoutbtn() {
		location.href = "/logout";
	}
</script>