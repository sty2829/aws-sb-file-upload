<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인화면~~
<button onclick="getSession()">세션얻기</button>
<script>
function getSession(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET', "/user");
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var res = xhr.responseText;
			console.log(res);
		}
	}
	xhr.send();
}
</script>
</body>
</html>