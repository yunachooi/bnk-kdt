<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:formatNumber value="1234567.89" /><br />
<fmt:formatNumber value="1234567.89" groupingUsed="false" /><br />
<fmt:formatNumber value="0.5" type="percent" /><br />
<fmt:formatNumber value="10000" type="currency" /><br />
<fmt:formatNumber value="10000" type="currency" currencySymbol='$' /><br />
<fmt:formatNumber value="1234567.8912345" pattern="#,#00.0#" /><br />
<fmt:formatNumber value="1234567.8" pattern="#,#00.0#" /><br />
<fmt:formatNumber value="1234567.8" pattern="#,#00.00" /><hr />

<c:set var="now" value="<%=new java.util.Date() %>" />
now : ${now }<br />
<fmt:formatDate value="${now }" /><br />
date : <fmt:formatDate value="${now }" type="date" /><br />
time : <fmt:formatDate value="${now }" type="time" /><br />
both : <fmt:formatDate value="${now }" type="both" /><br />

</body>
</html>