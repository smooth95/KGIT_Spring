package com.care.ex02;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	
	public MemberDAO() {
		System.out.println("---------MemberDAO------------");
	}
	
	public String getData() {
		return "아무값";
	}
}
