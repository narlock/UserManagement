package dev.narlock.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	
	// Form to create Users
	@GetMapping("/createUserForm")
	public String createUserForm(Model model) {
		// Create domain attribute to bind form data
		User user = new User();
		model.addAttribute("user", user);
		return "new_user";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/";
	}
	
	// Update User
	@GetMapping("/updateUser/{id}")
	public String updateUser(@PathVariable(value="id") long id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "update_user";
	}
	
	
	// Delete User
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(value="id") long id, Model model) {
		this.userService.deleteUserById(id);
		return "redirect:/";
	}
}
