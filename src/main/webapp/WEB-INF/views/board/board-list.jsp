<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody id="tBody">
		</tbody>
	</table>
	<script>
		window.onload = function(){
			var xhr = new XMLHttpRequest();
			xhr.open('GET', '/boards?size=5&sort=boNum,desc&page=4');
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && xhr.status == 200){
					var res = JSON.parse(xhr.responseText);
					console.log(res);
					var html = '';
					for(var board of res.content){
						html += '<tr>';
						html += '<td>' + board.boNum + '</td>';
						html += '<td>' + board.boTitle + '</td>';
						html += '<td>' + board.boContent + '</td>';
						html += '</tr>';
					}
					document.querySelector('#tBody').innerHTML = html;
				}
			}
			xhr.send();
		}
	
	</script>
</body>
</html>