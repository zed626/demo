package com.example.service;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.DemoApplication;
import com.example.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class UserServiceTest {
	@Autowired
	private UserService userService;
	@Test
	public void findOne() {
		List<User> users=userService.get("fvrvr");
		for(User user:users) {
			System.out.println(user);
		}
	}
}
