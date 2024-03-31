package com.jp.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping(path = "/")
	public String start() {
		
		return "Application Started";
	}
	
	
}
