package com.dao;

import com.onlinebanking.bean.CustomerBean;

public interface CustomerDao {
	
	public String registerCustomer(String Username, String Password,String Mobile);
	
	public String registerCustomer2(CustomerBean customer);
	


	public CustomerBean getAccountDetailsByAccount(int AccountNumber);
	
	

}
