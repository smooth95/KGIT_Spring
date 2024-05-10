package com.care.ex02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex02")
// 메인에 경로를 지정하면 하위 메서드의 어노테이션에서는 ex02를 사용하지않아도된다.
public class MemberController {
	
	@Autowired
	
	private MemberService ms;
	
	public MemberController() {
		System.out.println("---------MemberController------------");
	}
	
	@RequestMapping("index")
	public String index(Model model) {
		System.out.println("service : " + ms);
		ms.getData( model );
		return "ex02/index";
	}
	@RequestMapping(value = "ex02/result", method = RequestMethod.GET)
	public String result(HttpServletRequest req, Model model) {
		System.out.println(req.getMethod());
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("age"));
		model.addAttribute("method", req.getMethod());
		model.addAttribute("name", req.getParameter("name"));
		model.addAttribute("age", req.getParameter("age"));
		return "ex02/result";
	}
	
	@PostMapping("result")
	public String result02(
				@RequestParam("name") String n,
				@RequestParam int age,
//				페이지에서 전달되는 name과 변수명이 같으면 param뒤에 이름은 생략 가능하다.
				Model model,
				HttpServletRequest req
			) {
		model.addAttribute("method", req.getMethod());
		model.addAttribute("name", n );
		model.addAttribute("age", age );
		
		return "ex02/result";
	}
	
	@PostMapping("object")
	public String object(MemberDTO dto, Model model) {
//		jsp의 이름과 dto의 이름이 동일해야 불러올 수 있다.
		model.addAttribute("dto", dto);
		return "ex02/object";
	}
	
	
}
