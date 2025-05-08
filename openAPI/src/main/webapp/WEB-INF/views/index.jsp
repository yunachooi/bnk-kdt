<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경상남도 자주찾는 문화재</title>
<style>
	img{
		width: 200px;
		height: 200px;
	}
</style>
</head>
<body>
	<h1>경상남도_자주찾는 문화재</h1>
	<button onclick="viewAll()">문화재 전체 조회</button><br />
	<button onclick="beforePage()">이전페이지</button>
	<button onclick="nextPage()">다음페이지</button>
	<div id="msg"></div>
	
	<script>
		let page = 1;
		
		function viewAll(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				const obj = JSON.parse(xhr.responseText);
				const list = obj.gyeongnamculturallist.body.items.item;
				
				let html = "<br /><table border='1'>";
				html += "<thead><tr><th>지정 번호</th><th>명칭</th><th>설명</th><th>주소</th><th>첨부파일</th></tr></thead><tbody>";

				list.forEach(item => {
					html += "<tr>" +
								"<td>" + item.DOJIJUNG_NO + "</td>" +
								"<td>" + item.MYONGCHING + "</td>" +
								"<td>" + item.CONTENT + "</td>" +
								"<td>" + item.ADDRESS1 + "</td>" +
								"<td><img src='" + item.fileurl1 + "'></td>" +
							"</tr>";
				});

				html += "</tbody></table>";
				document.getElementById('msg').innerHTML = html;
			}

			xhr.open('GET', 'getList?page=' + page, true);
			xhr.send();
		}
		
		function nextPage(){
			page++;
			viewAll();
		}
		
		function beforePage(){
			page--;
			viewAll();
		}
	</script>
</body>
</html>
