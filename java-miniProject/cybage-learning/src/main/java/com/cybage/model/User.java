package com.cybage.model;

public class User {
	private int userId;
	private String fullName, userName, password, role,userSecurityQuestion, userSecurityAnswer;
	
	
	
	public User() {
		super();
		this.fullName = null;
		this.userName = null;
		this.password = null;
		this.userSecurityQuestion = null;
		this.userSecurityAnswer = null;
	}


	public User(String fullName2, String username2, String password2, String securityQuestion, String securityAnswer) {
		super();
		this.userId=-1;
		this.fullName = fullName2;
		this.userName = username2;
		this.password = password2;
		this.role = "user";
		this.userSecurityQuestion = securityQuestion;
		this.userSecurityAnswer = securityAnswer;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserSecurityQuestion() {
		return userSecurityQuestion;
	}

	public void setUserSecurityQuestion(String userSecurityQuestion) {
		this.userSecurityQuestion = userSecurityQuestion;
	}

	public String getUserSecurityAnswer() {
		return userSecurityAnswer;
	}

	public void setUserSecurityAnswer(String userSecurityAnswer) {
		this.userSecurityAnswer = userSecurityAnswer;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", userName=" + userName + ", password=" + password
				+ ", role=" + role + ", userSecurityQuestion=" + userSecurityQuestion + ", userSecurityAnswer="
				+ userSecurityAnswer + "]";
	}

	
	
	
}
