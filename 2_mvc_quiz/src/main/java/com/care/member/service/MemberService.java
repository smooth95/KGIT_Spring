package com.care.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.member.dao.MemberDAO;
import com.care.member.dto.MemberDTO;

@Service("ms")
public class MemberService {
	@Autowired
	MemberDAO dao;
	public MemberService() {
		System.out.println("memberservice 실행");
	}
	
	public void setData(MemberDTO dto) {
		dao.setData(dto);
		System.out.println("setdata실행");
		
	}
	
	public ArrayList<MemberDTO> getData() {
		ArrayList<MemberDTO> arr = dao.getData();
		return arr;
	}
}
