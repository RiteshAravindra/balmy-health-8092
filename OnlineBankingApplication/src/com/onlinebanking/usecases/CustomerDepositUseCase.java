package com.onlinebanking.usecases;

import java.util.Scanner;

import com.dao.AccountantDao;
import com.dao.AccountantImpl;
import com.dao.CustomerDao;
import com.dao.CustomerImpl;
import com.onlinebanking.bean.CustomerBean;
import com.onlinebanking.exception.CustomerException;

public class CustomerDepositUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Amount to deposit");
		
		int Amount =sc.nextInt();
		
		System.out.println("Enter your Account Number");
		
		int AccountNumber =sc.nextInt();
		
		CustomerDao dao = new CustomerImpl();
		
		AccountantDao dao1 =new AccountantImpl();
		
		
		
		try {
			
			
			String message =dao.depositAmount(Amount, AccountNumber);
			
			CustomerBean customer =dao1.showCustomer(AccountNumber);
			
			System.out.println(message+customer.getBalance() );
			
			
			
			
			
//			System.out.println(message);
		} catch (CustomerException e) {
			
			System.out.println(e.getMessage());
		}
		
	
		
		
		
		

	}

}
