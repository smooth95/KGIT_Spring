package com.care.root.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired MemberService ms;
	
	@GetMapping("index")
	public String index() {
		System.out.println("index 실행");
		
		return "default/main";
	}
	
	@GetMapping("member/login")
	public String login(Model model) {
		return "member/login";
	}
	
	@GetMapping("member/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		
		return "redirect:/index";
	}
	
	@PostMapping("member/successChk")
	public String successChk(@RequestParam String id, @RequestParam String pw, Model model, HttpServletRequest req
			, @RequestParam(required = false) String autoLogin, RedirectAttributes rs) {
		System.out.println("login: " + autoLogin);
		System.out.println("id : " + id);
		ArrayList<MemberDTO> arr = new ArrayList<>();
		arr = ms.loginChk(id, pw);
		if (arr.size() != 0) {
			if (arr.get(0).getPw().equals(pw)) {
				System.out.println("실행1");
				HttpSession session = req.getSession();
				rs.addAttribute("id", id);
				rs.addAttribute("autoLogin", autoLogin);
//				session.setAttribute("id", id);
//				session.setAttribute("autoLogin", id);
				return "redirect:successLogin";
			} else {
				return "redirect:login";
			}
		} else {
			return "redirect:login";
		}
		
		
		
	}
	
	@GetMapping("member/successLogin")
	public String successLogin(@RequestParam String id, @RequestParam(required = false) String autoLogin, HttpServletResponse res) {
		System.out.println("login1 : " + autoLogin);
		if (autoLogin != null) {
			System.out.println("실행2");
			int limitTime = 60 * 60 * 24 * 90;
			Cookie cook = new Cookie("loginCookie", id);
			cook.setPath("/");
			cook.setMaxAge(limitTime);
			res.addCookie(cook);
			
			ms.keepLogin( id, autoLogin );
		}
		
		
		return "member/successLogin";
	}
	
	@GetMapping("member/memberInfo")
	public String memberInfo(Model model) {
		ArrayList<MemberDTO> arr = new ArrayList<>();
		arr = ms.getMember();
		System.out.println("arr.size : " + arr.size());
		
		model.addAttribute("member", arr);
		return "member/memberInfo";
	}
	
	@GetMapping("member/info")
	public String info(@RequestParam String id, Model model) {
		ArrayList<MemberDTO> arr = new ArrayList<>();
		arr = ms.getUser(id);
		
		model.addAttribute("user", arr);
		
		return "member/info";
	}
	
	@GetMapping("member/register")
	public String register(Model model, HttpServletRequest req) {

		model.addAttribute("msg", req.getParameter("msg"));
		
		return "member/register";
	}
	
	@PostMapping("member/registerChk")
	public String registerChk(MemberDTO dto, Model model, HttpServletResponse res, HttpServletRequest req) throws IOException {
		ArrayList<MemberDTO> arr = new ArrayList<>();
		
		System.out.println("addr : " + dto.getAddr());
		String [] addrs = req.getParameterValues("addr");
		System.out.println(addrs[0]);
		System.out.println(addrs[1]);
		System.out.println(addrs[2]);
		
		
		
		arr = ms.getUser(dto.getId());
		System.out.println("arr.size : " + arr.size());
		if (arr.size() != 0) {
			model.addAttribute("msg", "중복되는 아이디");
			return "redirect:register";
		} else {
			ms.register(dto);
			PrintWriter out = res.getWriter();
			return "redirect:login";
		}
		
		
	}
	
}

















