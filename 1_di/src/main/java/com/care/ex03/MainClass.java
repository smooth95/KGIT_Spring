package com.care.ex03;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.care.di_test.PrintBean;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:application_db.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext( path );
		DBClass db01 = ctx.getBean("db01", DBClass.class);
		System.out.println("id : " + db01.getId());
		System.out.println("pwd : " + db01.getPwd());
		System.out.println("------------------------------");
		DBClass db02 = ctx.getBean("db02", DBClass.class);
		System.out.println("id : " + db02.getId());
		System.out.println("pwd : " + db02.getPwd());
		System.out.println("-----------------------------");
		System.out.println("list.size : " + db02.getList().size());
		System.out.println("map.size : " + db02.getMap().size());
		System.out.println("list 0 : " +db02.getList().get(0));
		System.out.println("list 1 : " +db02.getList().get(1));
		System.out.println("list 2 : " +db02.getList().get(2));
		System.out.println("map num1 : " + db02.getMap().get("num1"));
		System.out.println("map num2 : " + db02.getMap().get("num2"));
		
	}
}
