<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	let sock = null;
	window.onload = () => {
		console.log("test")
		let wsUri = "ws://localhost:8080/root/chat/websocket";
		sock = new WebSocket(wsUri);
		sock.onmessage = onMessage;
// 		서버로부터 받은 메세지 저장
		sock.onclose = onClose;
// 		종료메세지를 저장
		
		$("#sendBtn").click( () => {
			console.log('test')
			sendMessage();
			$("#send_msg").val("");
		})
		$("#send_msg").keydown( (key ) => {
			if (key.keyCode == 13) {
				sendMessage();
				$("#send_msg").val("");
			}
		})
	}
	function sendMessage() {
		sock.send($("#send_msg").val());
	}
	function onMessage( msg ) {
		$("#rec_data").append(msg.data + "<br>");
	}
	function onClose( ) {
		$("#rec_data").append("연결 끊김!!!<br>");	
		sock.close();
	}
</script>
</head>
<body>
	<div id="rec_data"></div>
	<hr>
	<textarea id="send_msg"></textarea><br>
	<input type="button" id="sendBtn" value="전송">
	
</body>
</html>