package dev.narlock.spring.service;

import java.util.List;

import dev.narlock.spring.domain.User;

public interface UserService {
	List<User> getAllUsers();
}
