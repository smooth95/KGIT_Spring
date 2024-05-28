package com.care.root.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberMapper dao;
	MemberDTO dto;
	public ArrayList<MemberDTO> loginChk(String id, String pw) {
		ArrayList<MemberDTO> arr;
		System.out.println("service실행");
		arr = dao.getUser(id);
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
		dao.register(dto);
	}
}
