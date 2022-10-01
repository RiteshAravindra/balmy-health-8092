package com.dao;

import java.util.List;

import com.onlinebanking.bean.Accountant;
import com.onlinebanking.bean.CustomerBean;
import com.onlinebanking.exception.AccountantException;
import com.onlinebanking.exception.CustomerException;

public interface AccountantDao {
	
	public List<CustomerBean> getllCustomerDetails() throws AccountantException,CustomerException;
	
	public String registerCustomerByAccountant(CustomerBean customer);
	
	public String registerAccountant(Accountant accountant) throws AccountantException;
	
	public Accountant loginAccountant(String AccountantUsername ,String AccountantPassword ) throws AccountantException;
	
	public String deletaacustomer(int AccountNumber) throws CustomerException;
	
	public CustomerBean showCustomer(int AccountNumber) throws CustomerException;
	
	public void updateCustomerDetails(int AccountNumber)throws CustomerException;
	
	public void showAllTransactions() throws CustomerException ;
	
	
	
	
	
	
	
	

}
