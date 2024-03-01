package com.songhwa.insulin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class InsulinController {

	@RequestMapping("/insulin/{url}")
	public String page(@PathVariable String url) {
		return "/insulin/" + url;
	}
	
	@RequestMapping("{url}")
	public String go(@PathVariable String url) {
		return url;
	}
}
