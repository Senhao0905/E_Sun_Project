package com.example.E_Sun_Project.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "user_password")
	private String userPwd;

	@Column(name = "user_biography")
	private String userBiography;

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userId, String userName, String userEmail, String userPwd, String userBiography) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPwd = userPwd;
		this.userBiography = userBiography;
	}

	//------------------------------------------------------------------
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUesrPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserBiography() {
		return userBiography;
	}

	public void setUserBiography(String userBiography) {
		this.userBiography = userBiography;
	}



	

}
