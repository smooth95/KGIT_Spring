package com.care.di_test;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:application_test.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext( path );
		PrintBean p = ctx.getBean("pb", PrintBean.class );

		p.setPrint("asdf");
		p.PrintString();
		
//		s.setName("ȫȫȫ");
//		s.setAge(23);
//		s.namePrint();
//		s.agePrint();
		
	}
}
