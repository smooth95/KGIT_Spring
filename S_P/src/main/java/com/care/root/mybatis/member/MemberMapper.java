package com.care.root.mybatis.member;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {
	public MemberDTO getMember( String id );
	public ArrayList<MemberDTO> memberInfo();
	public ArrayList<MemberDTO> getData();
	public MemberDTO getData(@Param("aaa") String id);
	public int register(MemberDTO dto);
	public void keepLogin(Map<String, Object> map );
}







