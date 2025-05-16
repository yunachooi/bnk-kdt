<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
    <button id="btn" onclick="f()">Run</button>
	<button id="btn2" onclick="f2()">Run</button>
    <div id="demo">---</div>
	<script>
		function f(){
			$.ajax({
				url: '/api/data',
				type: 'GET',
				success: function(response){
					console.log('GET 성공 : ', response);
					$('#demo').text(response);
				},
				error: function(xhr){
					console.log('POST 실패 : ', xhr);
				}
			})
		}
		
		function f2(){
			$.ajax({
				url: '/api/post',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify({
					name: '홍길동',
					age: 30
				}),
				success: function(response){
					console.log('POST 성공 : ', response);
					$('#demo').html(response);
				},
				error: function(xhr){
					console.log('POST 실패 : ', xhr);
				}
			})
		}
	</script>
</body>
</html>