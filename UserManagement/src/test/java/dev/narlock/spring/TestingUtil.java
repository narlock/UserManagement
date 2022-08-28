package dev.narlock.spring;

import java.util.ArrayList;
import java.util.List;

import dev.narlock.spring.domain.User;

public class TestingUtil {
	public static User makeTestUser(long id, String firstName, String lastName, String email) {
		User user = new User();
		user.setId(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		return user;
	}
	
	public static List<User> testUsersObject() {
		List<User> list = new ArrayList<User>();
		list.add(makeTestUser(1, "Anthony", "Test", "anthony@narlock.dev"));
		list.add(makeTestUser(2, "Anthony", "Test", "anthony@narlock.dev"));
		list.add(makeTestUser(3, "Anthony", "Test", "anthony@narlock.dev"));
		return list;
	}
}
