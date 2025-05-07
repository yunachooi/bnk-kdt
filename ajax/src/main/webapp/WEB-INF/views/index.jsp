<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page</h1><hr />
	<div id="demo">
		<h1>Let AJAX change this text</h1>
		<button type="button" onclick="loadDoc()">Change Content</button>
	</div>
	<div id="demo2">
	
	</div>
	<script>
		function loadDoc() {
			  const xhttp = new XMLHttpRequest();
			  xhttp.onload = function() {
			    document.getElementById("demo2").innerHTML = this.responseText;
			    }
			  xhttp.open("GET", "req1", true);
			  xhttp.send();
		}
	</script>
</body>
</html>