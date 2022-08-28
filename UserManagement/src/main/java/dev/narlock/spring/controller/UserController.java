package dev.narlock.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.narlock.spring.domain.User;
import dev.narlock.spring.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	// HTML Display List of Users
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listUsers", userService.getAllUsers());
		return "index";
	}
	
	
}
