package com.team2.root.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("map")
public class MapController {
	@GetMapping("view")
	public String view() {
		
		return "map/map";
	}
}
