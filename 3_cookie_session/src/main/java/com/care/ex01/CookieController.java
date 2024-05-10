package com.care.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookieController {
	@GetMapping("cookie")
	public String myCookie(HttpServletResponse res, 
							HttpServletRequest req, 
							@CookieValue(value="myCookie", required = false) Cookie cook) {
//		cookievalue만 사용하면 초기에 값이 없어서 cook에 할당이 되지않는다 따라서 설정이없으면 에러가 발생한다.
//		required 를 false로 설정해주어야 cook에 값이 들어가지 않아도 에러 없이 동작 가능하다.
		Cookie cookie = new Cookie("myCookie", "testCookie");
		cookie.setMaxAge(5);
		res.addCookie(cookie);
		Cookie[] arrCookie = req.getCookies();
		for(Cookie c : arrCookie) {
			System.out.println("name : " + c.getName());
			System.out.println("value : " + c.getValue());
		}
//		가지고 있는 전체 쿠키 확인하는방법
		return "cookie/cookie";
	}
	
	@GetMapping("cookie02")
	public String myCookie02( Model model,
							@CookieValue(value="myCookie", required = false) Cookie cook) {
		if(cook != null) 
			model.addAttribute("cook", cook.getValue());
		return "cookie/cookie02";
	}
	
	@GetMapping("popup02")
	public String pop02() {
		
		return "cookie/popup02";
	}
	
	@GetMapping("cookieChk")
	public void cookieChk(HttpServletResponse res) throws IOException {
		System.out.println("쿠키체크");
		Cookie cook = new Cookie("myCookie", "testCookie");
		
		cook.setMaxAge(5);
		cook.setPath("/");
//		쿠키를 /이후의 모든 경로에서 사용할 수 있도록
		res.addCookie(cook);
//		PrintWriter out = res.getWriter();
//		out.print("<script>window.close()</script>");
	}
}

















