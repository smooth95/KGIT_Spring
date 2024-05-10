package com.care.root.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired MemberService ms;
	
	@GetMapping("index")
	public String index() {
		
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
	public String successChk(@RequestParam String id, @RequestParam String pw, Model model, HttpServletRequest req) {
		ArrayList<MemberDTO> arr = new ArrayList<>();
		arr = ms.loginChk(id, pw);
		if (arr.size() != 0) {
			if (arr.get(0).getPw().equals(pw)) {
				HttpSession session = req.getSession();
				session.setAttribute("id", id);
				return "redirect:successLogin";
			} else {
				return "redirect:login";
			}
		} else {
			return "redirect:login";
		}
		
		
		
	}
	
	@GetMapping("member/successLogin")
	public String successLogin() {
		
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
	public String registerChk(MemberDTO dto, Model model, HttpServletResponse res) throws IOException {
		ArrayList<MemberDTO> arr = new ArrayList<>();
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

















