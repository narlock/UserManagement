package dev.narlock.spring.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import dev.narlock.spring.TestingUtil;
import dev.narlock.spring.service.UserServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class UserApiControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	UserServiceImpl userService;
	
	@Test
	public void testGetUser() throws Exception {
		Mockito.when(userService.getAllUsers()).thenReturn(TestingUtil.testUsersObject());
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.get("/api/v1/users"))
				.andExpect(status().isOk())
				.andReturn();
	}
}
