package dev.narlock.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.narlock.spring.domain.User;
import dev.narlock.spring.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserApiController {
	@Autowired
	private UserService userService;
	
	// Gets the users from userService
	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
}
