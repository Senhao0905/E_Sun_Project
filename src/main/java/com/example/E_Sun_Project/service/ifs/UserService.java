package com.example.E_Sun_Project.service.ifs;

import javax.servlet.http.HttpSession;

import com.example.E_Sun_Project.entity.User;
import com.example.E_Sun_Project.vo.userVo.LoginResponse;
import com.example.E_Sun_Project.vo.userVo.RegisterResponse;
import com.example.E_Sun_Project.vo.userVo.UpdateResponse;


public interface UserService {

	public RegisterResponse register (String userId ,String userPwd , String userEmail,
			String userName );
	
	public LoginResponse login (String userId ,String userPwd);
	
	public UpdateResponse updateInfo(User user,HttpSession session);
}
