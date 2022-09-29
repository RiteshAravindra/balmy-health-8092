package com.onlinebanking.usecases;

import java.util.Scanner;

import com.dao.Customer;
import com.dao.CustomerDao;
import com.onlinebanking.bean.CustomerBean;

public class GetCustomerUseCase {

	public static void main(String[] args) {
		

Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Customer Accountnum");
		
		int Acc=sc.nextInt();
		
		CustomerDao dao = new Customer();
		
		CustomerBean  customer = dao.getAccountDetailsByAccount(Acc);
		
		if(customer!=null) {
			System.out.println("Customer details are " + customer );
		}else {
			System.out.println("Not Available");
		}
		
		

	}

}
