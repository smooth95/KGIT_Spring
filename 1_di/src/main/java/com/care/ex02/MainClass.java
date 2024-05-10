package com.care.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.care.ex01.STBean;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:applicationST.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext( path );
		STBean s = ctx.getBean("stb", STBean.class );
//		s.setName("ȫȫȫ");
//		s.setAge(23);
		s.namePrint();
		s.agePrint();
	}
}
