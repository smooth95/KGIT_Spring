package com.care.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//controller로 사용시 어노테이션을 사용해야한다. (경로를 인식할 수 있다.)
public class MyController {
	
	
//	경로를 지정하기위해서 어노테이션을 사용한다. (get, post 둘다 받아준다.)
	@RequestMapping( value="/index" )
	public String memberIndex() {
		return "/member/index";
//		jsp파일의 이름을 반환한다.
	}
	
	// mapping에 하나의 값만 들어갈경우 기본값이 value이므로 value는 생략가능하다.
	@GetMapping( "logout")
	public String memberLogout(Model model) {
		model.addAttribute("test", "로그아웃 되었습니다.");
		return "member/logout";
	}
	
	@GetMapping( "login" )
	public ModelAndView memberLogin() {
		ModelAndView model = new ModelAndView();
		model.addObject("login", "로그인 성공!!!");
		model.setViewName("member/login");
		return model;
	}
	
}
