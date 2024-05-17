package com.care.root;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class TestSocket extends TextWebSocketHandler{
	List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	@Override // 연동성공시 실행되는 메서드
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(session.getId() + "부터 연결됨");
		System.out.println("attribute : " + session.getAttributes());
		sessionList.add(session);
	}

	@Override // 사용자가 메세지를 보낼경우 이 메서드 실행
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String sender = (String)session.getAttributes().get("name");
		String msg = session.getId() + " 부터";
		msg += message.getPayload() + " 내용 받음";
		System.out.println(msg);
		
		for (WebSocketSession s : sessionList) {
			Map<String, Object> map = s.getAttributes();
			TextMessage text = new TextMessage(sender + " : " + message.getPayload());
			s.sendMessage( text );
		}
	}

	@Override // 사용자가 소켓 연결이 끊어질 경우 실행 
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session.getId() + " 연결 끊김");
		sessionList.remove(session);
		session.close();
	}
	
}
