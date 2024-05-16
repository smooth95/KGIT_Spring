package com.care.root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // jsp페이지를 리턴으로 페이지를 돌려주지않고 데이터를 돌려준다.
public class TestController {
	@GetMapping(value="rest", produces = "application/json; charset=utf-8")
	public Map<String, Object> get() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "get : 데이터 요청");
		return map;
	}
	@PostMapping(value="rest", produces = "application/json; charset=utf-8")
	public Map<String, Object> post() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "post : 데이터 요청");
		return map;
	}
	@PutMapping(value="rest", produces = "application/json; charset=utf-8")
	public Map<String, Object> put() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "put : 데이터 요청");
		return map;
	}
	@DeleteMapping(value="rest", produces = "application/json; charset=utf-8")
	public Map<String, Object> delete() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "delete : 데이터 요청");
		return map;
	}
	@Autowired DBClass db;
	
	@GetMapping(value="members", produces = "application/json; charset=utf-8")
	public ArrayList<InfoDTO> members() {
		
		return db.DB;
	}
	@GetMapping(value="members/{uId}", produces = "application/json; charset=utf-8")
	public InfoDTO getMembers(@PathVariable String uId) {
		for(InfoDTO d : db.DB) {
			if (d.getId().equals(uId)) {
				return d;
			}
		}
		return null;
	}
	@PostMapping(value="register", produces = "application/json; charset=utf-8")
	public String register(@RequestBody InfoDTO dto) {
		db.DB.add(dto);
		return "{\"num\" : 1}";
	}
	
	@GetMapping(value="idChk/{uId}", produces = "application/json; charset=utf-8")
	public int idChk(@PathVariable String uId) {
		for(InfoDTO d : db.DB) {
			if (d.getId().equals(uId)) {
				return 1;
			}
		}
		return 0;
	}
	@DeleteMapping(value="delete", produces = "application/json; charset=utf-8")
	public int delete(@RequestParam String id) {
		for(int i = 0; i < db.DB.size(); i++) {
			if(db.DB.get(i).getId().equals(id)) {
				db.DB.remove(i);
			}
		}
		return 1;
	}
	@PutMapping(value="modify", produces = "application/json; charset=utf-8")
	public int modify(@RequestBody InfoDTO dto) {
		for(int i = 0; i < db.DB.size(); i++) {
			if(db.DB.get(i).getId().equals(dto.getId())) {
				db.DB.set(i, dto);
			}
		}
		return 1;
	}
}















