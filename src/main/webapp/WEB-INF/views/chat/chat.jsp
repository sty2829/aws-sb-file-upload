<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="startDiv">
<input type="text" id="name" placeholder="대화명"><button onclick="startChat()">시작</button><br>
</div>
<div id="chatDiv" style="display:none">
<textarea id="chat" cols="40" rows="10"></textarea><br>
<label id="lName"></label><input type="text" id="msg"><button onclick="sendMsg()">전송</button>
</div>
<script>
var ws;
function sendMsg(){
	var param = {
			type : "msg",
			name : document.querySelector('#name').value,
			msg : document.querySelector('#msg').value
	}
	ws.send(JSON.stringify(param));
}
function startChat(){
	if(!document.querySelector('#name').value.trim()){
		alert("대화명을 작성해 주세요");
		return;
	}
	
	ws = new WebSocket('ws://localhost/chat');
	ws.onopen = function(data){
		var param = {
				type : "enter",
				name : document.querySelector('#name').value
		}
		document.querySelector('#lName').innerText = document.querySelector('#name').value + ':';
		ws.send(JSON.stringify(param));
		document.querySelector('#startDiv').style.display = 'none';
		document.querySelector('#chatDiv').style.display = '';
	}
	ws.onmessage = function(data) {
		console.log(data);
		var msg = JSON.parse(data.data);
		if(msg.type && msg.type == 'enter'){
			document.querySelector('#chat').value += '[입장 : ' + msg.name + '님이 입장하였습니다.]\r\n';
		}else if(msg.type && msg.type == 'msg'){
			document.querySelector('#chat').value += msg.name + ' : ' + msg.msg + '\r\n';
		}else{
			document.querySelector('#chat').value += '[퇴장 : ' + msg.name + '님이 퇴장하였습니다.]\r\n';
		}
			
	}
	ws.onclose = function(data){
		alert('채팅이 종료되었습니다.');
	}
	
}
window.onload = function (){
	
}

</script>
</body>
</html>