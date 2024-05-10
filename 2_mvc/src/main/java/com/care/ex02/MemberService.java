package com.care.ex02;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service("ms")
public class MemberService {
//	@Autowired
	
	@Inject
	@Qualifier("dao2")
	MemberDAO dao;
	
	public MemberService() {
		System.out.println("---------MemberService------------");
		
	}
	
	public void getData (Model model) {
		System.out.println("get data 연동 : "+ dao);
		String msg = dao.getData();
		model.addAttribute("msg", msg);
	}
}
