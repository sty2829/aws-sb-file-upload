<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button onclick="goInsert()">테스트</button>
<script>
function goInsert(){
	var xhr = new XMLHttpRequest();
	xhr.open('POST', "/user");
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var res = xhr.responseText;
			console.log(res);
		}
	}
	var param = {
			userID : 'haha'
	}
	
	xhr.setRequestHeader('content-type', 'application/json;charset=UTF-8');
	xhr.send(JSON.stringify(param));
}
</script>
</body>
</html>