package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO dao;
	public void insert(MemberDTO dto) {
		dao.insert(dto);
	}
	
	@Override
	public void list(Model model) {
		model.addAttribute("list", dao.list());
	}
	
}
