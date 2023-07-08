package com.example.E_Sun_Project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_Sun_Project.constant.RtnCode;
import com.example.E_Sun_Project.entity.User;
import com.example.E_Sun_Project.service.ifs.UserService;
import com.example.E_Sun_Project.vo.userVo.GetUserResponse;
import com.example.E_Sun_Project.vo.userVo.LoginRequest;
import com.example.E_Sun_Project.vo.userVo.LoginResponse;
import com.example.E_Sun_Project.vo.userVo.RegisterRequest;
import com.example.E_Sun_Project.vo.userVo.RegisterResponse;
import com.example.E_Sun_Project.vo.userVo.UpdateRequest;
import com.example.E_Sun_Project.vo.userVo.UpdateResponse;


@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "register")
	public RegisterResponse register(@RequestBody RegisterRequest request) {
		return userService.register(request.getUserId() , request.getUserPwd()
				, request.getUserEmail() , request.getUserName());
	}
	
	@PostMapping(value = "login")
	public LoginResponse login (@RequestBody LoginRequest request , HttpSession session) {
		
		LoginResponse res = userService.login(request.getUserId(), request.getUserPwd());
		if(res.getMessage().equalsIgnoreCase(RtnCode.SUCCESSFUL.getMessage())) {
			session.setAttribute("account", request.getUserId());
			session.setAttribute("pwd", request.getUserPwd());
			session.setMaxInactiveInterval(6000);// 設定session存活時間 單位:秒
		}
		return res ;
	}
	
	@PostMapping(value = "update_info")
	public UpdateResponse updateInfo(@RequestBody UpdateRequest request,HttpSession session) {
		return userService.updateInfo(request.getUser(),session);
	}
	
	
	@PostMapping(value = "get_user_info")
	public GetUserResponse getUserInfo(HttpSession session) {
		return userService.getUserInfo(session);
	}
	
}
