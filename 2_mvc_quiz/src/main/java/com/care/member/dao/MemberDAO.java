package com.care.member.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.member.dto.MemberDTO;

@Repository
public class MemberDAO {
	private ArrayList<MemberDTO> list;
	public MemberDAO() {
		list = new ArrayList<MemberDTO>();
		System.out.println("memberdao 실행");
	}
	
	public void setData(MemberDTO dto) {
		System.out.println("dao 실행");
		list.add(dto);
	}
	
	public ArrayList<MemberDTO> getData() {
		return list;
	}
}
