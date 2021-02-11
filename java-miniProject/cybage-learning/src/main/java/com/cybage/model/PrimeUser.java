package com.cybage.model;

public class PrimeUser extends User{
	boolean is_prime_user;

	public PrimeUser(String fullName, String username, String password, String securityQuestion, String securityAnswer, boolean isPrimeUser) {
		super(fullName,username,password,securityQuestion,securityAnswer);
		this.is_prime_user = isPrimeUser;
	}

	public PrimeUser() {
		super();
		this.is_prime_user = false;
	}

	public PrimeUser(String fullName, String userName, String password, boolean isPrimeUser) {
		super(fullName, userName, password);
		this.is_prime_user = isPrimeUser;
	}

	public boolean isIs_prime_user() {
		return is_prime_user;
	}

	public void setIs_prime_user(boolean is_prime_user) {
		this.is_prime_user = is_prime_user;
	}

	@Override
	public String toString() {
		return "PrimeUser [is_prime_user=" + is_prime_user + ", getUserId()=" + getUserId() + ", getFullName()="
				+ getFullName() + ", getUserName()=" + getUserName() + ", getPassword()=" + getPassword()
				+ ", getRole()=" + getRole() + ", getUserSecurityQuestion()=" + getUserSecurityQuestion()
				+ ", getUserSecurityAnswer()=" + getUserSecurityAnswer() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
	
	
	
}
