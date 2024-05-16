package com.care.root.member.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberMapper mapper;
	BCryptPasswordEncoder en;
	public MemberServiceImpl() {
		en = new BCryptPasswordEncoder();
	}
	public int userCheck(String id,String pwd) {
		int result = 0;
		//MemberDTO dto = mapper.getMember( id );
		MemberDTO dto = mapper.getData(id);
		System.out.println( dto );
		//System.out.println( dto.getPwd()  );
		if(dto != null) {
			if(pwd.equals(dto.getPwd()) || en.matches(pwd, dto.getPwd() )) {
				result = 1;
			}
		}
		return result;
	}
	public void memberInfo(Model model) {
		//model.addAttribute("list", mapper.memberInfo() );
		model.addAttribute("list", mapper.getData() );
	}
	public void info(Model model,String id) {
		MemberDTO dto = mapper.getData(id);
		System.out.println( dto.getAddr() );
		String[] a = dto.getAddr().split(",");
		model.addAttribute("info", dto);
	}
	private String replaceParameter(String addr) {
		addr = addr.replace("<", "&lt;");
		addr = addr.replace(">", "&gt;");
		addr = addr.replace("\"", "&quot;");
		return addr;
	}
	public int register(MemberDTO dto) {
//		dto.setAddr( replaceParameter(dto.getAddr()) );
		System.out.println("변경 전 pwd : "+dto.getPwd() );
		System.out.println("변경 후 pwd : "+en.encode(dto.getPwd()) );
		dto.setPwd( en.encode(dto.getPwd()) );
		int result = 0;
		try {
			result = mapper.register(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public void keepLogin(String id ,String autoLogin ) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("autoLogin", autoLogin);
		mapper.keepLogin( map );
	}
}












