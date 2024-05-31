package com.team2.root;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String home(Locale locale, Model model, HttpSession session, HttpServletResponse res, @CookieValue(value="userName", required = false) Cookie cook) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		session.setAttribute("time", formattedDate);
		if (cook != null) {
			model.addAttribute("userName", cook.getValue());			
		}
		
		return "home";
	}
	
	@GetMapping("login/sns_naver")
	public String snsNaver() {
		
		return "login/sns_naver";
	}	
	@GetMapping("login/sns_naver/add_info")
	public String addInfo(HttpServletRequest req) {
		System.out.println(req.getParameter("code"));
		System.out.println(req.getParameter("state"));
		return "login/add_info";
	}
	@GetMapping("login/sns_naver/add_info/info")
	public String info(HttpServletRequest req) {
		System.out.println("ㅁㄴㅇㄹ");
		
		return "login/info";
	}
	
	
}
