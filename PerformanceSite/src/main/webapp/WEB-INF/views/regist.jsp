<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<jsp:include page="./header.jsp" />
	<jsp:include page="./nav.jsp" />
	
	<div id="registContainer">
		<form action="regist" method="POST" id="hfm">
			<input type="text" name="id" id="id" placeholder="아이디 입력"><br />
			<button type="button" id="idCheckBtn">아이디 중복 확인</button>
			<br />
			<div id="demo" class="orange">아이디 중복 검사를 진행해주세요...</div>
			<input type="password" name="pw" id="pw1" placeholder="비밀번호 입력"><br />
			<input type="password" id="pw2" placeholder="비밀번호 확인"><br />
			<div id="demo2" class="orange">비밀번호가 불일치합니다...</div>
			<input type="text" name="name" placeholder="이름 입력"><br /> <input
				type="text" name="phone" placeholder="전화번호 입력"><br />
			<button type="submit">회원가입</button>
			<button type="reset">다시쓰기</button>
			<input type="hidden" id="hid" value="0"> <input type="hidden"
				id="hpw" value="0">
		</form>
	</div>

	<script>
		const idInput = document.getElementById("id");
	    const pw1 = document.getElementById("pw1");
	    const pw2 = document.getElementById("pw2");
	    const hid = document.getElementById("hid");
	    const hpw = document.getElementById("hpw");
	    const demo = document.getElementById("demo");
	    const demo2 = document.getElementById("demo2");
	
	    idInput.addEventListener("change", () => hid.value = "0");
	    pw1.addEventListener("input", pwCheck);
	    pw2.addEventListener("input", pwCheck);
	
	    document.getElementById("idCheckBtn").addEventListener("click", () =>{
	        const idVal = idInput.value;
	
	        const xhr = new XMLHttpRequest();
	        xhr.onload = function () {
	            demo.innerHTML = xhr.responseText;
	
	            if (xhr.responseText.includes('사용가능한 아이디')) {
	                hid.value = "1";
	            } else {
	                hid.value = "0";
	            }
	       };
	
	        xhr.open('POST', 'idCheck');
	        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	        xhr.send("id=" + encodeURIComponent(idVal));
	    });
		
	    function pwCheck() {
	        if (pw1.value === pw2.value && pw1.value !== "") {
	            demo2.innerText = "비밀번호가 일치합니다...";
	            demo2.classList.remove('orange');
	            demo2.classList.add('green');
	            hpw.value = "1";
	        } else {
	            demo2.innerText = "비밀번호가 불일치합니다...";
	            demo2.classList.remove('green');
	            demo2.classList.add('orange');
	            hpw.value = "0";
	        }
	    }
	
	    // 폼 제출 시 검증
	    const frm = document.getElementById("hfm");
	    
	    frm.addEventListener("submit", function (e) {
	        e.preventDefault();
	        if (hid.value === "1" && hpw.value === "1") {
	            alert("등록이 완료되었습니다...");
	            frm.submit();
	        } else {
	            alert("아이디 또는 비밀번호 확인바랍니다...");
	        }
	    });
	</script>
</body>
</html>