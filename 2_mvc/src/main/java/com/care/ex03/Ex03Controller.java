package com.care.ex03;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex03")
public class Ex03Controller {
	
	@RequestMapping("login")
	public String login(HttpServletRequest req) {
		System.out.println("login method : " + req.getMethod());
		System.out.println("login param id : " + req.getParameter("id"));
		System.out.println("login atta id : " + req.getAttribute("test"));
		
		return "ex03/login";
	}
	@PostMapping("result")
	public String result(HttpServletRequest req) {
		String uId = req.getParameter("id");
		req.setAttribute("test", "아무거나");
		if (uId.equals("abc") ) {
			return "forward:success";
			
		}
		return "redirect:login";
//		return "forward:login";
	}
	
	@PostMapping("success")
	public String success(HttpServletRequest req, Model model) {
		System.out.println("id : " + req.getParameter("id"));
		System.out.println("test : " + req.getAttribute("test"));
		model.addAttribute("id", req.getParameter("id"));
		model.addAttribute("test", req.getAttribute("test"));
		return "ex03/success";
	}
	
}
