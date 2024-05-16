package com.care.root.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberMapper dao;
	
	// 암호화를 위한 기능 추가
	BCryptPasswordEncoder en;
	public MemberServiceImpl() {
		en = new BCryptPasswordEncoder();
	}
	
	MemberDTO dto;
	public ArrayList<MemberDTO> loginChk(String id, String pw) {
		ArrayList<MemberDTO> arr;
		System.out.println("service실행");
		arr = dao.getUser(id);
		System.out.println("실행4");
		en.matches(pw, arr.get(0).getPw());
		System.out.println("실행3");
		//if문으로 비교해야함.
		return arr;
		
	}
	@Override
	public ArrayList<MemberDTO> getMember() {
		ArrayList<MemberDTO> arr;
		arr = dao.getMember();
		return arr;
	}
	
	@Override
	public ArrayList<MemberDTO> getUser(String id) {
		ArrayList<MemberDTO> arr;
		arr = dao.getUser(id);
		return arr;
	}
	@Override
	public void register(MemberDTO dto) {
		
		System.out.println("변경 전 pwd : " + dto.getPw());
		System.out.println("변경 후 pwd : " + en.encode(dto.getPw()));
		
		dto.setPw(en.encode(dto.getPw()));
		
		dao.register(dto);
	}
	@Override
	public void keepLogin(String id, String autoLogin) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("autoLogin", autoLogin);
		dao.keepLogin( map );
	}
}
