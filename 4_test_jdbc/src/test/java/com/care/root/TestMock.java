package com.care.root;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.care.root.member.controller.MemberController;

@RunWith(SpringRunner.class)
@ContextConfiguration( locations = {"classpath:testMember.xml",
								"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class TestMock {
	@Autowired
	MemberController mc;
	
	MockMvc mock;
	
	@Before
	public void setUp() {
		System.out.println("특정 test들 전에 실행된다.");
		mock = MockMvcBuilders.standaloneSetup(mc).build();
		
	}
	@Test
	@Transactional( transactionManager = "txMgr")
	public void testInsert() throws Exception {
		System.out.println("test코드 실행!!!");
		mock.perform(post("/insert").param("id", "1234").param("name", "아무거나")).andDo(print())
		.andExpect(status().isOk())
//		.andExpect(status().is3xxRedirection())
//		리다이렉트시 비교
		.andExpect(forwardedUrl("member/index") );
		
//		assertNull(null);
//		null값이면 성공
		
	}
	
	@Test
	public void testIndex() throws Exception{
		mock.perform( get("/index"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("member/index"))
		.andExpect(model().attributeExists("list"));
	}
}























