package com.valuation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UiController {

	@RequestMapping("/home")
	public String home() {
		return "Home.jsp";
	}
}
