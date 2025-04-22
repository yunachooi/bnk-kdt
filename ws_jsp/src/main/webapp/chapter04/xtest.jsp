<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*jsp로 할 필요성 X -> 따라서 servlet로 변경*/
	String grade = "A";
	request.setAttribute("grade", grade);
	request.getRequestDispatcher("result.jsp").forward(request, response);
%>