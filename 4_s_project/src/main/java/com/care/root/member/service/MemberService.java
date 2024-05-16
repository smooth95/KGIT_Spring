package com.care.root.member.service;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberService {
	public ArrayList<MemberDTO> loginChk(String id, String pw);
	public ArrayList<MemberDTO> getMember();
	public ArrayList<MemberDTO> getUser(String id);
	public void register(MemberDTO dto);
	public void keepLogin(String id, String autoLogin);

}
