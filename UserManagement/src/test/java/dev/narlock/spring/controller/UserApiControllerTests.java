package dev.narlock.spring.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import dev.narlock.spring.TestingUtil;
import dev.narlock.spring.service.UserServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class UserApiControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	UserServiceImpl userService;
	
	@Test
	public void testGetUser_OK() throws Exception {
		Mockito.when(userService.getAllUsers()).thenReturn(TestingUtil.testUsersObject());
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.get("/api/v1/users"))
				.andExpect(status().isOk())
				.andReturn();
		String responseString = result.getResponse().getContentAsString();
		assertTrue(responseString.contains("1"));
		assertTrue(responseString.contains("2"));
		assertTrue(responseString.contains("3"));
	}
	
	@Test
	public void testGetUserById_OK() throws Exception {
		Mockito.when(userService.getUserById(anyLong())).thenReturn(TestingUtil.testUserObject());
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.get("/api/v1/users/1"))
				.andExpect(status().isOk())
				.andReturn();
		String responseString = result.getResponse().getContentAsString();
		assertTrue(responseString.contains("1"));
	}
	
}
