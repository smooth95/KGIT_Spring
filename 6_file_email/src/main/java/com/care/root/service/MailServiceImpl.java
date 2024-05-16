package com.care.root.service;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl {
	@Autowired JavaMailSender sender;
	public void sendMail(String to, String subject, String body) {
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper h = new MimeMessageHelper(message, true, "UTF-8");
			h.setSubject(subject);
			h.setTo(to);
			h.setText(body);
			sender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sendMail02(String to, String subject, String body) {
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper h = new MimeMessageHelper(message, true, "UTF-8");
			h.setSubject(subject);
			h.setTo(to);
			h.setText(body , true);
			//true값을 넣어야 text형식이 아닌 html형식으로 전달된다.
			sender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private String rand() {
		Random ran = new Random();
		String str = "";
		int num;
		while(str.length() != 20) {
			num = ran.nextInt(75) + 48;
			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90)
					|| (num >= 97 && num <= 122)) {
				str += (char)num;
			}
		}
		return str;
	}
	public void auth(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String userId = req.getParameter("email");
		String userKey = rand();
		session.setAttribute(userId, userKey);
		
		String body ="<h3>이메일 인증</h3> <a href='http://localhost:8080/root/auth_check?userId="+userKey+"'>인증하기</a>";
		sendMail02(userId, "이메일 인증", body);
	}
}










