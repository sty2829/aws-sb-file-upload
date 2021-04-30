<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="test"></div>
<button id="btn">버튼</button>
<script>
var btnClick = function (){
	alert(1);
}
document.querySelector('#btn').addEventListener('click', btnClick);
</script>
</body>
</html>