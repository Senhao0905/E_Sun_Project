package com.example.E_Sun_Project.service.impl;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.E_Sun_Project.constant.RtnCode;
import com.example.E_Sun_Project.entity.User;
import com.example.E_Sun_Project.repository.UserDao;
import com.example.E_Sun_Project.service.ifs.UserService;
import com.example.E_Sun_Project.vo.userVo.LoginResponse;
import com.example.E_Sun_Project.vo.userVo.RegisterResponse;
import com.example.E_Sun_Project.vo.userVo.UpdateResponse;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public RegisterResponse register(String userId, String userPwd, String userEmail, String userName) {

		// 8~12碼 至少包含一個特殊符號
		String patternPwd = "^(?=.+[\\p{Punct}])(?!.*[\\s\\t\\r\\n\\f])[\\p{Print}]{8,12}$";

		String patternUserId = "[0-9]{10}";
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		// 檢查輸入是否為空
		if (!StringUtils.hasText(userId) || !StringUtils.hasText(userPwd) || !StringUtils.hasText(userEmail)
				|| !StringUtils.hasText(userName)) {
			return new RegisterResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		
		//檢查帳號是否為電話號碼
		if(!userId.matches(patternUserId)) {
			return new RegisterResponse(RtnCode.DATA_ERROR.getMessage());
		}

		// 檢查密碼是否符合正規
		if (!userPwd.matches(patternPwd)) {
			return new RegisterResponse(RtnCode.DATA_ERROR.getMessage());
		}

		// 密碼加密
		String encoderPwd = passwordEncoder.encode(userPwd);

		// 建立User
		User newUser = new User(userId, userName, userEmail, encoderPwd, null);

		return new RegisterResponse(RtnCode.SUCCESSFUL.getMessage(), userDao.save(newUser));
	}

	@Override
	public LoginResponse login(String userId, String userPwd) {

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		// 判斷書入是否為空
		if (!StringUtils.hasText(userId) || !StringUtils.hasText(userPwd)) {
			return new LoginResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		Optional<User> op = userDao.findById(userId);

		// 判斷帳號是否存在
		if (op == null) {
			return new LoginResponse(RtnCode.NOT_FOUND.getMessage());
		}

		User user = op.get();

		if (!passwordEncoder.matches(userPwd, user.getUserPwd())) {
			return new LoginResponse(RtnCode.PWD_ERROR.getMessage());
		}

		return new LoginResponse(RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public UpdateResponse updateInfo(User user , HttpSession session) {

		//檢查是否登入過
		String account = (String) session.getAttribute("account");
		
		String pwd = (String) session.getAttribute("pwd");
		
		
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new UpdateResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}
		// 8~12碼 至少包含一個特殊符號
		String patternPwd = "^(?=.+[\\p{Punct}])(?!.*[\\s\\t\\r\\n\\f])[\\p{Print}]{8,12}$";

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		// 檢查輸入是否為空
		if (!StringUtils.hasText(user.getUserId()) || !StringUtils.hasText(user.getUserPwd()) || !StringUtils.hasText(user.getUserEmail())
				|| !StringUtils.hasText(user.getUserName())) {
			return new UpdateResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		// 檢查密碼是否符合正規
		if (!user.getUserPwd().matches(patternPwd)) {
			return new UpdateResponse(RtnCode.DATA_ERROR.getMessage());
		}

		// 密碼加密
		String encoderPwd = passwordEncoder.encode(user.getUserPwd());

		//自我介紹為null的話設定為空字串
		String Biography = StringUtils.hasText(user.getUserBiography()) ? user.getUserBiography() : "";
		
		// 建立User
		User newUser = new User(user.getUserId(), user.getUserName(), user.getUserEmail(), encoderPwd, Biography);

		return new UpdateResponse(RtnCode.SUCCESSFUL.getMessage(), userDao.save(newUser));
	}

}
