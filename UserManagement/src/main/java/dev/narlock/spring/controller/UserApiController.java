package dev.narlock.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	// Get a single user from userService
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable long id) {
		return userService.getUserById(id);
	}
	
	// Saves a user to the database
	@PostMapping("/create")
	public void addUserToDatabase(@RequestBody User user) {
		userService.saveUser(user);
	}
	
	// Updates a user by their id
	@PutMapping("/users/{id}")
	public void updateUserById(@RequestBody User updatedUser, @PathVariable long id) {
		//Gets user in database
		User user = getUserById(id);
		
		//Updates fields depending on updates to be made
		if(updatedUser.getFirstName() != null) {
			user.setFirstName(updatedUser.getFirstName());
		}
		if(updatedUser.getLastName() != null) {
			user.setLastName(updatedUser.getLastName());
		}
		if(updatedUser.getEmail() != null) {
			user.setEmail(updatedUser.getEmail());
		}
		
		//Saves the user
		userService.saveUser(user);
	}
	
}
