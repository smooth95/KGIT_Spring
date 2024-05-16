package com.care.root;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class DBClass {
	ArrayList<InfoDTO> DB;
	public DBClass() {
		DB = new ArrayList<InfoDTO>();
		for (int i = 0 ; i < 3; i ++) {
			InfoDTO dto = new InfoDTO();
			dto.setId("aaa"+i);
			dto.setName("홍길동" + i);
			dto.setAge(10+i);
			DB.add(dto);
		}
	}
	
	
}
