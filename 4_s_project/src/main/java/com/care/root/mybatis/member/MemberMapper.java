package com.care.root.mybatis.member;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.care.root.member.dto.MemberDTO;

@Repository
public interface MemberMapper {
	public ArrayList<MemberDTO> getUser(String id);
	public ArrayList<MemberDTO> getMember();
	public void register(MemberDTO dto);
	public void keepLogin(Map<String, Object> map);

}
