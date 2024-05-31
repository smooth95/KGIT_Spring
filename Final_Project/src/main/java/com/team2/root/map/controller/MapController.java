package com.team2.root.map.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("map")
public class MapController {
	@GetMapping("view")
	public String view(HttpSession session, HttpServletResponse res, Model model) {
		session.setAttribute("times", "시간표시할거야");

		Cookie cookie = new Cookie("userName", "홍길동");
		cookie.setMaxAge(10);
//		cookie.setPath("/");
		res.addCookie(cookie);
//		System.out.println(cookie.getName());
//		model.addAttribute("userName", cookie.getValue());
		
		return "map/map";
	}
}
