<%@page import="chapter08.dao.GameDAO"%>
<%@page import="chapter08.dto.RspDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>가위바위보 게임</title>
<style>
* {
	padding: 0;
	margin: 0;
	border: none;
}

body {
	font-size: 30px;
	text-align: center;
}

.container {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 40px;
}

.confrontation {
	margin: 0 40px;
}

#comRSP, #userRSP {
	width: 200px;
	height: 200px;
}

#com, #user {
	font-weight: bold;
	margin-top: 10px;
}

#vs {
	font-weight: bold;
	margin: 0 20px;
}

.record {
	margin-top: 40px;
	padding: 10px 20px;
	display: inline-block;
	width: 1000px;
	height: 100px;
	align-items: center;
	font-weight: bold;
}

.btn {
	margin-top: 40px;
}

.rsp {
	width: 80px;
	height: 80px;
}

#txt_c, #txt_u {
	height: 30px;
	color: red;
	font-weight: bold;
	font-size: 20px;
}

#font {
	font-size: 15px;
}
</style>
</head>
<body>
	<h3>가위바위보 게임</h3>
	<p id="font"><%=session.getAttribute("userId")%>님 환영합니다.</p>
	<button onclick="save()" id="save">로그아웃</button>

	<%
	String userId = (String) session.getAttribute("userId");
	GameDAO gameDAO = new GameDAO(session);
	RspDTO userRecord = gameDAO.select(userId);

	int user_win = 0, user_lose = 0, user_draw = 0;
	
	if (userRecord != null) {
		user_win = userRecord.getWin();
		user_lose = userRecord.getLose();
		user_draw = userRecord.getDraw();
	}
	%>

	<div class="btn">
		<button onclick="f(1)" id="sissors">
			<img src="images/sissors.jpg" alt="sissors" class="rsp">
		</button>
		<button onclick="f(2)" id="rock">
			<img src="images/rock.jpg" alt="rock" class="rsp">
		</button>
		<button onclick="f(3)" id="paper">
			<img src="images/paper.jpg" alt="paper" class="rsp">
		</button>
	</div>

	<div class="container">
		<div class="confrontation">
			<div id="com">COM</div>
			<img src="images/questionMark.jpg" alt="computer" id="comRSP">
			<div id="txt_c"></div>
		</div>
		<div id="vs">VS</div>
		<div class="confrontation">
			<div id="user">USER</div>
			<img src="images/questionMark.jpg" alt="user" id="userRSP">
			<div id="txt_u"></div>
		</div>
	</div>

	<div class="record">
		무 : <span id="draw"><%=user_draw %></span> 승 : <span id="win"><%=user_win %></span> 패 : <span id="lose"><%=user_lose %></span>
	</div>

	<script>
		let draw = <%=user_draw%>;
		let win = <%=user_win%>;
		let lose = <%=user_lose%>;

		const txt_c = document.getElementById("txt_c");
		const txt_u = document.getElementById("txt_u");

		function f(userNum) {
			const rdNum = Math.floor(Math.random() * 3) + 1;

			if (userNum == 1) {
				document.getElementById('userRSP').src = "images/sissors.jpg";
			} else if (userNum == 2) {
				document.getElementById('userRSP').src = "images/rock.jpg";
			} else {
				document.getElementById('userRSP').src = "images/paper.jpg";
			}

			if (rdNum == 1) {
				document.getElementById('comRSP').src = "images/sissors.jpg";
			} else if (rdNum == 2) {
				document.getElementById('comRSP').src = "images/rock.jpg";
			} else {
				document.getElementById('comRSP').src = "images/paper.jpg";
			}

			let result = rdNum - userNum;

			if (result == 0) {
				txt_c.innerText = 'DRAW!';
				txt_u.innerText = 'DRAW!';
				draw++;
				document.getElementById('draw').textContent = draw;
			} else if (result == -1 || result == 2) {
				txt_u.innerText = 'WIN!';
				txt_c.innerText = '';
				win++;
				document.getElementById('win').textContent = win;
			} else {
				txt_u.innerText = '';
				txt_c.innerText = 'WIN!';
				lose++;
				document.getElementById('lose').textContent = lose;
			}
		}
	</script>
</body>
</html>
