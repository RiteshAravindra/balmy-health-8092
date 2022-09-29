package com.onlinebanking.bean;

public class CustomerBean {
	
	private int accountNumber;
	
	private String Username;
	
	private String Password;
	
	private String Mobile;

	
	public CustomerBean() {
	}
	
	public CustomerBean(int accountNumber, String username, String password, String mobile) {
		super();
		this.accountNumber = accountNumber;
		Username = username;
		Password = password;
		Mobile = mobile;
	}

	public CustomerBean(String username, String password, String mobile) {
		super();
		Username = username;
		Password = password;
		Mobile = mobile;
	}


	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	@Override
	public String toString() {
		return " [accountNumber=" + accountNumber + ", Username=" + Username + ", Password=" + Password
				+ ", Mobile=" + Mobile + "]";
	}
	
	

}
