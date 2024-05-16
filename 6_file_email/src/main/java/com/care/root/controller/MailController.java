package com.care.root.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.service.MailServiceImpl;

@Controller
public class MailController {
	@Autowired
	MailServiceImpl ms;
	@GetMapping("sendmail")
	public void sendMail(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		// 이메일을 전달할때 사용할 문자형식을 지정한다.
		PrintWriter out = res.getWriter();
		
		ms.sendMail("smooth95@naver.com", "이메일 테스트중입니다.", "이메일 테스트 내용입니다.");
		// 받는사람 이메일, 제목, 내용 순으로 넘겨준다.
		
		out.print("메일을 보냈습니다.");
	}
	@GetMapping("sendmail02")
	public void sendMail02(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		// 이메일을 전달할때 사용할 문자형식을 지정한다.
		PrintWriter out = res.getWriter();
		
		StringBuffer body = new StringBuffer(); 
		body.append("<html><body>");
		body.append("<h1>제품소개</h1>");
		body.append("<a href='https://www.naver.com'>");
		body.append("<img alt='불러온이미지' src='https://gongu.copyright.or.kr/gongu/wrt/cmmn/wrtFileImageView.do?wrtSn=9046601&filePath=L2Rpc2sxL25ld2RhdGEvMjAxNC8yMS9DTFM2L2FzYWRhbFBob3RvXzI0MTRfMjAxNDA0MTY=&thumbAt=Y&thumbSe=b_tbumb&wrtTy=10004'>");
		body.append("</a>");
		body.append("</body></html>");
		
		ms.sendMail02("smooth95@naver.com", "이메일 테스트중입니다.", body.toString());
		// 받는사람 이메일, 제목, 내용 순으로 넘겨준다.
		
		out.print("메일을 보냈습니다.");
	}
	@GetMapping("auth_form")
	public String authForm() {
		
		return "auth";
	}
	@GetMapping("auth")
	public String auth(HttpServletRequest req) {
		ms.auth(req);
		return "redirect:http://www.naver.com";
		
	}
	@GetMapping("auth_check")
	public String authCheck(@RequestParam String userId,HttpSession session) {
		String userKey = (String)session.getAttribute("smooth95@naver.com");
		if (userKey.equals(userId)) {
			session.setAttribute("userId", "smooth95");
		}
		return "redirect:auth_form";
	}
}













