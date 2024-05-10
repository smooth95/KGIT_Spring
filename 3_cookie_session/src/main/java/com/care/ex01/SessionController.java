package com.care.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SessionController {
	@GetMapping("makeSession")
	public String mySession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("id",  "aaa");
		session.setAttribute("name",  "홍길동");
		session.setAttribute("age",  "20");
		
		return "session/makeSession";
	}
	
	@GetMapping("resultSession")
	public String resultSession(Model model) {
		model.addAttribute("id", "model0101010101010101010");
		
		
		return "session/resultSession";
	}
	
	@GetMapping("delSession")
	public String delSession(HttpServletRequest req, HttpSession session) {
		HttpSession s = req.getSession();
		System.out.println("s.id : " + s.getAttribute("id"));
		s.removeAttribute("id");
		
		System.out.println("session : " + session.getAttribute("name"));
		session.invalidate();
//		세션의 모든 내용 삭제
		
		return "session/delSession";
	}
	
	@GetMapping("login")
	public String login() {
		
		return "session/login";
	}
	
	@PostMapping("check")
	public String check(@RequestParam String id, 
						@RequestParam String pwd, 
						HttpSession session) {
		String DB_id = "1", DB_pwd = "1";
		if (DB_id.equals(id) && DB_pwd.equals(pwd)) {
			session.setAttribute("loginUser", id);
			session.setAttribute("nick", "홍길동");
			return "session/main";
		} 
		return "redirect:login";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("loginUser") == null) {
			return "redirect:login";
		}
		session.invalidate();
		
		return "session/logout";
	}
}


















