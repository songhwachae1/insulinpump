package com.songhwa.insulin.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {

	@RequestMapping("{url}")
	public String page(@PathVariable String url, @AuthenticationPrincipal UserDetails userDetails) {
		// if (userDetails == null) {

		return url;
	}

}
