package com.care.root.member.dao;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberDAO {
	public void insert(MemberDTO dto);
	public int deleteUser(int userId);
	public ArrayList<MemberDTO> list();
}
