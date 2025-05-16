<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
    <div class="left">자격검정 CBT 웹서비스 구현</div>

    <%
        String uri = request.getRequestURI();
        if (!uri.endsWith("index.jsp")) {
    %>
        <table class="right">
            <tbody>
                <tr><td>수험번호:</td><td><%= request.getAttribute("e_number") %></td></tr>
                <tr><td>수험자명:</td><td><%= request.getAttribute("e_name") %></td></tr>
            </tbody>
        </table>
    <%
        }
    %>
</header>
