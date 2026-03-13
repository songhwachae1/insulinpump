package com.songhwa.insulin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.songhwa.insulin.entity.User;
import com.songhwa.insulin.service.UserService;

@Controller
public class AuthController {

	@Autowired
	UserService userService;
	
  @RequestMapping("/auth/register")
	public ModelAndView register(@ModelAttribute User user) {
		ModelAndView mv = new ModelAndView();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!111");

		try {
			userService.registerUser(user);
			System.out.println("======================================");
			System.out.println(user.toString());
			System.out.println("======================================");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("msg", e.getMessage());
			mv.setViewName("redirect:/error");
			return mv;
		}

		mv.setViewName("redirect:/login");
		return mv;
	}
}
