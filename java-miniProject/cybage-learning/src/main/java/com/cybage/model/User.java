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


	public User(String fullName, String username, String password, String securityQuestion, String securityAnswer) {
		super();
		this.userId=-1;
		this.fullName = fullName;
		this.userName = username;
		this.password = password;
		this.role = "user";
		this.userSecurityQuestion = securityQuestion;
		this.userSecurityAnswer = securityAnswer;
	}

	public User(String fullName, String userName, String password) {
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
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
