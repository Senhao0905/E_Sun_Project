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

		// 8~12�X �ܤ֥]�t�@�ӯS��Ÿ�
		String patternPwd = "^(?=.+[\\p{Punct}])(?!.*[\\s\\t\\r\\n\\f])[\\p{Print}]{8,12}$";

		String patternUserId = "[0-9]{10}";
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		// �ˬd��J�O�_����
		if (!StringUtils.hasText(userId) || !StringUtils.hasText(userPwd) || !StringUtils.hasText(userEmail)
				|| !StringUtils.hasText(userName)) {
			return new RegisterResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		
		//�ˬd�b���O�_���q�ܸ��X
		if(!userId.matches(patternUserId)) {
			return new RegisterResponse(RtnCode.DATA_ERROR.getMessage());
		}

		// �ˬd�K�X�O�_�ŦX���W
		if (!userPwd.matches(patternPwd)) {
			return new RegisterResponse(RtnCode.DATA_ERROR.getMessage());
		}

		// �K�X�[�K
		String encoderPwd = passwordEncoder.encode(userPwd);

		// �إ�User
		User newUser = new User(userId, userName, userEmail, encoderPwd, null);

		return new RegisterResponse(RtnCode.SUCCESSFUL.getMessage(), userDao.save(newUser));
	}

	@Override
	public LoginResponse login(String userId, String userPwd) {

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		// �P�_�ѤJ�O�_����
		if (!StringUtils.hasText(userId) || !StringUtils.hasText(userPwd)) {
			return new LoginResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		Optional<User> op = userDao.findById(userId);

		// �P�_�b���O�_�s�b
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

		//�ˬd�O�_�n�J�L
		String account = (String) session.getAttribute("account");
		
		String pwd = (String) session.getAttribute("pwd");
		
		
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new UpdateResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}
		// 8~12�X �ܤ֥]�t�@�ӯS��Ÿ�
		String patternPwd = "^(?=.+[\\p{Punct}])(?!.*[\\s\\t\\r\\n\\f])[\\p{Print}]{8,12}$";

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		// �ˬd��J�O�_����
		if (!StringUtils.hasText(user.getUserId()) || !StringUtils.hasText(user.getUserPwd()) || !StringUtils.hasText(user.getUserEmail())
				|| !StringUtils.hasText(user.getUserName())) {
			return new UpdateResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		// �ˬd�K�X�O�_�ŦX���W
		if (!user.getUserPwd().matches(patternPwd)) {
			return new UpdateResponse(RtnCode.DATA_ERROR.getMessage());
		}

		// �K�X�[�K
		String encoderPwd = passwordEncoder.encode(user.getUserPwd());

		//�ۧڤ��Ь�null���ܳ]�w���Ŧr��
		String Biography = StringUtils.hasText(user.getUserBiography()) ? user.getUserBiography() : "";
		
		// �إ�User
		User newUser = new User(user.getUserId(), user.getUserName(), user.getUserEmail(), encoderPwd, Biography);

		return new UpdateResponse(RtnCode.SUCCESSFUL.getMessage(), userDao.save(newUser));
	}

}
