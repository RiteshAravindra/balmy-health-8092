package com.onlinebanking.usecases;

import java.util.Scanner;

import com.dao.Customer;
import com.dao.CustomerDao;

public class RegisterCustomerusecase1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Customer Username");
		
		String Username =sc.nextLine();
		

		System.out.println("Enter Customer Password");
		
		String Password =sc.nextLine();
		

		System.out.println("Enter Customer Mobile Number");
		
		String Mobile =sc.nextLine();
		
		CustomerDao dao = new Customer();
		
		String result =dao.registerCustomer(Username, Password, Mobile);
		
		System.out.println(result);
	}

}
