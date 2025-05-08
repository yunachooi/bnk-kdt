<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 관리 프로그램</h1>
	<button type="button" onclick="getList()">회원정보</button>
	<button type="button" onclick="registForm()">회원등록</button>
	<button type="button" onclick="updateForm()">회원정보수정</button>
	<div id="msg"></div>
	
	<script>
		/*회원등록 js*/
		function registForm() {
			const html = `
				<h3>회원등록</h3>
				<form action="writeMember" method="POST" id="frm">
					<input type="text" name="id" id="id" placeholder="아이디를 입력하세요.">
					<button type="button" onclick="idCheck()">중복확인</button><br />
					<div id="demo">아이디 중복 검사를 진행하세요.</div>
					<input type="password" name="pw" id="pw1" oninput="pwCheck()" placeholder="비밀번호를 입력하세요."><br />
					<input type="password" id="pw2" oninput="pwCheck()" placeholder="비밀번호를 다시 입력하세요."><br />
					<div id="demo2">비밀번호가 불일치 합니다.</div>
					<input type="text" name="name" placeholder="이름을 입력하세요."><br />
					<input type="text" name="phone" placeholder="전화번호를 입력하세요."><br />
					<button type="submit">회원등록</button>
					<button type="reset">다시쓰기</button>
					<input type="hidden" id="hid" value="0"><br />
					<input type="hidden" id="hpw" value="0"><br />
				</form>
			`;
		
			document.getElementById("msg").innerHTML = html;

			const id = document.getElementById("id");
			const pw1 = document.getElementById("pw1");
			const pw2 = document.getElementById("pw2");
			const frm = document.getElementById("frm");
			const hid = document.getElementById("hid");
			const hpw = document.getElementById("hpw");
		
			/*onChange 이벤트*/
			id.addEventListener("change", function () {
				hid.value = "0";
			});
			pw1.addEventListener("change", function () {
				hpw.value = "0";
			});
			pw2.addEventListener("change", function () {
				hpw.value = "0";
			});
		
			frm.addEventListener("submit", function (e) {
				e.preventDefault();
		
				if (hid.value === "1" && hpw.value === "1") {
					alert("등록이 완료되었습니다...");
					frm.submit();
				} else {
					alert("아이디 또는 비밀번호 확인바랍니다...");
				}
			});
		}

		/*회원정보 js*/
		function getList(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				const list = JSON.parse(xhr.responseText);
				let html = "<h3>회원정보</h3><table border='1'>" +
				"<thead><tr><th>no</th><th>id</th><th>이름</th><th>회원탈퇴</th></tr></thead>" +
				"<tbody>";
				
			list.forEach((member, index) => {
				html += "<tr><td>" + (index + 1) + "</td>" +
						"<td><button type='button' onclick=\"showDetail('" + member.id + "')\">" + member.id + "</button></td>" +
						"<td>" + member.name + "</td>" +
						"<td><button type='button' onclick=\"removeList('" + member.id + "')\">탈퇴하기</button></td>" +
						"</tr>";
				});
			
			html += "</tbody></table>";
			document.getElementById('msg').innerHTML = html;
			}
			
			xhr.open('GET', 'list', true);
			xhr.send();
		}
		
		/*특정아이디 정보열람 js*/
		function showDetail(id){
		    const xhr = new XMLHttpRequest();
		    xhr.onload = function(){
		        const member = JSON.parse(xhr.responseText);
		        const html = "<h3>회원정보</h3><table border='1'>" +
		            "<thead><tr><th>id</th><th>pw</th><th>name</th><th>phone</th><th>grade</th></tr></thead>" +
		            "<tbody><tr>" +
		            "<td>" + member.id + "</td>" +
		            "<td>" + member.pw + "</td>" +
		            "<td>" + member.name + "</td>" +
		            "<td>" + member.phone + "</td>" +
		            "<td>" + member.grade + "</td>" +
		            "</tr></tbody></table>";
		
		        document.getElementById('msg').innerHTML = html;
		    }
		    
		    xhr.open('GET', 'detail?id=' + encodeURIComponent(id), true);
		    xhr.send();
		}
		
		/*특정아이디 정보삭제 js*/
		function removeList(id){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				if(xhr.responseText === "1"){
					alert("회원정보가 정상적으로 삭제되었습니다.");
				} else {
					alert("오류가 발생하였습니다. 다시 시도하세요.");
				}
				
				document.getElementById('msg').innerHTML = "";
			}
			xhr.open('GET', 'remove?id=' + encodeURIComponent(id), true);
			xhr.send();
		}
	
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