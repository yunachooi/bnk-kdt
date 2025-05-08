<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원등록</h1><hr />
	
	<form action="writeMember" method="POST" id="frm">
		<input type="text" name="id" id="id" placeholder="Input id">
		<button type="button" onclick="idCheck()">중복확인</button><br />
		<div id="demo">아이디 중복 검사를 진행하세요.</div>
		<input type="text" id="hid" value="0"><br />
		<input type="password" id="pw1" oninput="pwCheck()" placeholder="Input pw"><br />
		<input type="password" id="pw2" oninput="pwCheck()" placeholder="Check pw"><br />
		<div id="demo2">비밀번호가 불일치 합니다.</div>
		<input type="text" id="hpw" value="0"><br />
		<input type="text" name="name" placeholder="Input name"><br />
		<input type="text" name="phone" placeholder="Input phone"><br />
		<button type="submit">회원등록</button>
		<button type="reset">다시쓰기</button>
	</form><br />
	
	<script>
		const id = document.getElementById("id");
		const pw1 = document.getElementById("pw1");
		const pw2 = document.getElementById("pw2");
	
		/*onChange 이벤트*/
	    id.addEventListener("change", function(){
	    	hid.value = "0";
	    })
	    pw1.addEventListener("change", function(){
	    	hpw.value = "0";
	    })
	    pw2.addEventListener("change", function(){
	    	hpw.value = "0";
	    })
	    
		const frm = document.getElementById("frm");
		const hid = document.getElementById("hid");
		const hpw = document.getElementById("hpw");
	
		frm.addEventListener('submit', function(e) {
		    e.preventDefault();
	
		    if (hid.value === '1' && hpw.value === '1') {
		        alert('등록이 완료되었습니다...');
		        frm.submit(); 
		    } else {
		        alert('아이디 또는 비밀번호 확인바랍니다...');
		    }
		});
	
		function idCheck() {
		    const id = document.querySelector("input[name=id]").value;
			const demo = document.getElementById("demo");
	
		    const xhr = new XMLHttpRequest();
		    xhr.onload = function () {
		        demo.innerHTML = xhr.responseText;
	
		        if (xhr.responseText.includes('사용가능한 아이디입니다.')) {
		            hid.value = "1";
		        } else {
		            hid.value = "0";
		        }
		    }
	
		    xhr.open('POST', 'idCheck');
		    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		    xhr.send("id=" + encodeURIComponent(id));
		}
	
		function pwCheck() {
			const pw1 = document.getElementById("pw1").value;
			const pw2 = document.getElementById("pw2").value;
			const demo2 = document.getElementById("demo2");
			
		    if (pw1 === pw2 && pw1 !== "") {
		        demo2.innerText = '비밀번호가 일치합니다.';
		        hpw.value = "1";
		    } else {
		        demo2.innerText = '비밀번호가 불일치 합니다.';
		        hpw.value = "0";
		    }
		}
	</script>
</body>
</html>