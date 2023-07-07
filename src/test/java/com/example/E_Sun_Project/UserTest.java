package com.example.E_Sun_Project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.E_Sun_Project.repository.UserDao;
import com.example.E_Sun_Project.service.ifs.UserService;



@SpringBootTest(classes = ESunProjectApplication.class)
class UserTest {

	@Autowired
	private UserService userService;

	@Autowired
	private UserDao userDao;
	
	@Test
	public void registerTest() {
		String userId = "udn880905"; 
		String userPwd = "Zxc.883388";
		String userEmail = "udn880905@icloud.com";
		String userName = "³¯³Ó©M";
		userService.register(userId, userPwd, userEmail, userName);
	}
	
	@Test
	public void loginTest() {
		String userId = "udn880905"; 
		String userPwd = "zxc.883388";
		userService.login(userId, userPwd);
	}
	

}
