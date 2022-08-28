package dev.narlock.spring.service;

import java.util.List;

import dev.narlock.spring.domain.User;

public interface UserService {
	List<User> getAllUsers();
	void saveUser(User user);
	User getUserById(long id);
	void deleteUserById(long id);
}
