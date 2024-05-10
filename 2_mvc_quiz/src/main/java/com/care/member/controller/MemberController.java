package com.care.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.member.dto.MemberDTO;
import com.care.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	@RequestMapping("member")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("register_form")
	public String registerForm() {
		
		return "register_form";
	}
	
	@RequestMapping("memInfo")
	public String memInfo(Model model) {
		ArrayList<MemberDTO> arr = ms.getData();
		model.addAttribute("arr", arr);
		return "memInfo";
	}
	
	@RequestMapping("register")
	public String register(MemberDTO dto, HttpServletRequest req) {
		System.out.println("id : " + dto.getId());
		System.out.println("name : " + dto.getName());
		System.out.println("ms : " + ms);
		ms.setData(dto);
		return "redirect:member";
	}

}
