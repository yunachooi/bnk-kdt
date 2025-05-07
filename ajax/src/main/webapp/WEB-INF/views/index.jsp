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
	
	<!-- Get 방식 -->
	<h4>1. Ajax Get 요청</h4>
	<button onclick="getData()">1. Ajax Get 요청</button><br />
	<div id="demo1"></div><hr />
	
	<h4>2-1. Ajax Get 요청2-1(User 정보 요청 : JSON 직접 작성)</h4>
	<!-- Json 키와 값으로 쌍이 이루어짐 -->
	<button onclick="getUserData()">2-1. Ajax Get 요청</button><br />
	<div id="demo2_1"></div><hr />
	
	<h4>2-2. Ajax Get 요청2-2(User 정보 요청 : Jackson 라이브러리 활용)</h4>
	<button onclick="getUserData2()">2-2. Ajax Get 요청</button><br />
	<div id="demo2_2"></div><hr />
	
	<h4>3. Ajax Get 요청3(파라미터 보내기)</h4>
	<button onclick="sendParameter()">3. Ajax Get 요청</button><br />
	<div id="demo3"></div><hr />
	
	<h4>4. Ajax Get 요청4(파라미터 보내기-패스이용)</h4>
	<button onclick="sendParameter2()">4. Ajax Get 요청</button><br />
	<div id="demo4"></div><hr />
	
	<h4>5. Ajax Get 요청5(파라미터 보내기-쿼리스트링)</h4>
	<button onclick="sendParameter3()">5. Ajax Get 요청</button><br />
	<div id="demo5"></div><hr />
	
	
	<!-- Post방식 -->
	<h4>6. Ajax Post 요청</h4>
	<button onclick="regData()">6. Ajax Post 요청</button><br />
	<div id="demo6"></div><hr />
	
	<h4>7. Ajax Post 요청2(커맨드객체 사용)</h4>
	<button onclick="regData2()">7. Ajax Post 요청2</button><br />
	<div id="demo7"></div><hr />
	
	<h4>8. Ajax Post 요청3(JSON 데이터 전송)</h4>
	<button onclick="regData3()">8. Ajax Post 요청3</button><br />
	<div id="demo8"></div><hr />
	
	<script>
		const demo2_1 = document.getElementById("demo2_1");
		const demo2_2 = document.getElementById("demo2_2");
		const demo3 = document.getElementById("demo3");
		const demo4 = document.getElementById("demo4");
		const demo5 = document.getElementById("demo5");
		const demo6 = document.getElementById("demo6");
		const demo7 = document.getElementById("demo7");
		const demo8 = document.getElementById("demo8");
		
		/*1. Ajax Get 요청*/
		function getData(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				/*응답 데이터를 받는 함수*/
				document.getElementById('demo1').innerHTML = xhr.responseText;
			}
			xhr.open('GET', 'req1', true);
			xhr.send();
		}
		
		/*2-1. Ajax Get 요청2-1(User 정보 요청 : JSON 직접 작성)*/
		function getUserData(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				const obj = JSON.parse(xhr.responseText);
				demo2_1.innerHTML = "<h3>" + obj.name + " " + obj.age + "</h3>";
			}
			xhr.open('GET', 'req2_1'); //true는 생략 가능
			xhr.send();
		}
		
		/*2-2. Ajax Get 요청2-2(User 정보 요청 : Jackson 라이브러리 활용)*/
		function getUserData2(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				const obj = JSON.parse(xhr.responseText);
				demo2_2.innerHTML = "<h3>" + obj.name + " " + obj.age + "</h3>";
			}
			xhr.open('GET', 'req2_2');
			xhr.send();
		}
		
		/*3. Ajax Get 요청3(파라미터 보내기)*/
		function sendParameter(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				demo3.innerHTML = xhr.responseText;
			}
			xhr.open('GET', 'req3?param=aaa');
			xhr.send();
		}
		
		/*4. Ajax Get 요청4(파라미터 보내기-패스이용)*/
		function sendParameter2(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				demo4.innerHTML = xhr.responseText;
			}
			xhr.open('GET', 'req4/Jane/33');
			xhr.send();
		}
		
		/*5. Ajax Get 요청5(파라미터 보내기-쿼리스트링)*/
		function sendParameter3(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				demo5.innerHTML = xhr.responseText;
			}
			xhr.open('GET', 'req5?name=Tom&age=22');
			xhr.send();
		}
		
		/*6. Ajax Post 요청*/
		function regData(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				demo6.innerHTML = xhr.responseText;
			}
			xhr.open('POST', 'req6');
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.send('name=Jackson&age=29');
		}
		
		/*7. Ajax Post 요청2(커멘드객체 사용)*/
		function regData2(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				demo7.innerHTML = xhr.responseText;
			}
			xhr.open('POST', 'req7');
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.send('name=Jackson&age=29');
		}
		
		/*8. Ajax Post 요청3(JSON 데이터 전송)*/
		function regData3(){
			const obj = {
					name : 'Hong',
					age : 33
			}
			
			const jsonStr = JSON.stringify(obj);
			
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				demo8.innerHTML = xhr.responseText;
			}
			xhr.open('POST', 'req8');
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.send(jsonStr);
		}
	</script>
</body>
</html>