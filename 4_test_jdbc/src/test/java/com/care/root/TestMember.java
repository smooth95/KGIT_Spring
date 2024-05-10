package com.care.root;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.root.member.controller.MemberController;
import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@RunWith(SpringRunner.class)
@ContextConfiguration( locations = {"classpath:testMember.xml",
								"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestMember {
	@Autowired
	MemberController mc;
	@Test
	public void testMc() {
		System.out.println("mc : " + mc);
		assertNotNull(mc);
//		특정 객체가 null인지 아닌지 확인 (null값이면 실패로 표시)
		
	}
	
	@Autowired 
	MemberService ms;
	@Test
	public void testMs() {
		assertNotNull(ms);
	}
	@Autowired 
	MemberDAO dao;
	@Test
	public void testDao() {
		assertNotNull(dao);
	}
	@Test
	public void testIns() {
		MemberDTO dto = new MemberDTO();
		dto.setId(1111);
		dto.setName("홍길동");
		dao.insert( dto );
	}
	
	@Test
	public void testSerIns() {
		MemberDTO dto = new MemberDTO();
		dto.setId(2222);
		dto.setName("김개똥");
		ms.insert( dto );
	}
	
	@Test
	public void testDaoDel() {
		int userId = 222;
		int result = dao.deleteUser( userId );
		System.out.println("result : " + result);
		assertEquals(0, result);
//		앞의값과 뒤에값이 같은지 확인
	}
	
	@Test
	public void testDaoSel() {
		assertNotNull( dao.list() );
	}
}














