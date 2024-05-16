package com.care.root;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("non_ajax")
	public String nonAjax() {
		System.out.println("non ajax");
		return "non_ajax";
	}
	@GetMapping("ajax01")
	public String ajax01() {
		System.out.println("ajax01");
		return "ajax01";
	}
	@GetMapping("ajax02")
	public String ajax02() {
		System.out.println("ajax02");
		return "ajax02";
	}
	int cnt = 0;
	@GetMapping("result02")
	@ResponseBody // return 값을 jsp페이지가 아닌 데이터로 반환한다.
	public String result02() {
		System.out.println("result02");
		return ++cnt + "";
	}
	@GetMapping("ajax03")
	public String ajax03() {
		System.out.println("ajax03");
		return "ajax03";
	}
	@PostMapping(value = "result03", 
			produces = "application/json; charset=utf-8") 
	// 넘겨받는 데이터타입을 지정한다.
	@ResponseBody
	public Map<String, Object> result03(//@RequestBody InfoDTO dto
							@RequestBody Map<String, Object> map) {
//		json으로 넘어오는 값은 body 어노테이션을 사용해서 받는다.
		System.out.println("result03");
		System.out.println("map : " + map);
//		System.out.println("dto.name : " + dto.getName());
//		System.out.println("dto.age : " + dto.getAge());
		System.out.println("map.name : " + map.get("name"));
		System.out.println("map.age : " + map.get("age"));
		return map;
	}
	@GetMapping("ajax04")
	public String ajax04() {
		return "ajax04";
	}
	@GetMapping("index")
	public String index() {
		
		return "index";
	}
}

























