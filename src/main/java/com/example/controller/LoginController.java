package com.example.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String userLogin() {
		return "demo_sign";
	}

	@RequestMapping("/login-error")
	public String loginError() {
		return "login-error";
	}

	@RequestMapping("/whoim")
	@ResponseBody
	public Object whoIm() {
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
