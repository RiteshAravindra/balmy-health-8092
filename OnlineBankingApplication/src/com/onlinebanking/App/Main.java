package com.onlinebanking.App;

import java.util.List;
import java.util.Scanner;

import com.dao.AccountantDao;
import com.dao.AccountantImpl;
import com.dao.CustomerDao;
import com.dao.CustomerImpl;
import com.onlinebanking.bean.Accountant;
import com.onlinebanking.bean.CustomerBean;
import com.onlinebanking.exception.AccountantException;
import com.onlinebanking.exception.CustomerException;

public class Main {

	public static void main(String[] args) throws CustomerException {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Welcome to Online Banking");
		
		while(true) {
			
			System.out.println("Login as Bank customer or Bank Accountant");
			
			System.out.println("Select one option to login");
			
			System.out.println("To register as Customer");
			
			
			
			System.out.println("Bankcustomer");
			
			System.out.println("BankAccountant");
			
			System.out.println("RegisterCustomer");
			
			String person = sc.nextLine();
			
			AccountantDao adao =new AccountantImpl();
			
			CustomerDao cdao = new CustomerImpl();
			
			if(person.equalsIgnoreCase("BankAccountant")) {
				

				System.out.println("Enter Accountant username");
				String Username =sc.nextLine();

				System.out.println("Enter Accountant Password");
				String Password = sc.nextLine();
				
				
				
				try {
					Accountant accountant =adao.loginAccountant(Username, Password);
					
					System.out.println("Login sucessful as Accountant "+accountant.getAccountantName() );
					
//					System.out.println(accountant);
					
					System.out.println("select the operation number" + "\n" + "* 1 Get details of a customer");
					System.out.println("* 2 Get details os all customers");
					System.out.println("* 3 Register a customer");
					System.out.println("* 4 Remove a customer");
					System.out.println("* 5 Show transaction history of all customers");
					System.out.println("* 6 Update details of customer");
					System.out.println("* 7 Add a new Accountant");
					
					System.out.println("Enter the Option number");
					
					int opt= sc.nextInt();
					
					if(opt==1) {
						System.out.println("Enter Account number to show Customer");
						
						
						int AccountNumber = sc.nextInt();
						
						
						
						try {
							CustomerBean result = adao.showCustomer(AccountNumber);
							
							System.out.println("Account details extracted successfully " + result.getUsername());
							
							System.out.println(result);
						} catch (CustomerException e) {
							// TODO Auto-generated catch block
						System.out.println(e.getMessage());
						}
						
					}else if(opt==2) {
						
						try {
							List<CustomerBean> customers =adao.getllCustomerDetails();
							
//							customers.forEach(s -> System.out.println(s));
							int count =0;
							customers.forEach(s -> {
								
								
								
								System.out.println("Customer Username " + s.getUsername());
								System.out.println("Customer Account Number " + s.getAccountNumber());
								System.out.println("Customer Mobile Number " + s.getMobile());
								System.out.println("Customer password " + s.getPassword());
								System.out.println("Customer balance " + s.getBalance());
								
								System.out.println("===================================================");
							});
						} catch (AccountantException e) {
								throw new AccountantException(e.getMessage());
										
						} catch (CustomerException e) {
							throw new CustomerException(e.getMessage());
						}
						
						
						
					}else if(opt==3) {
						
						System.out.println("Enter Username");
						
						String username = sc.nextLine();
						
						System.out.println("Enter Password");
						
						

						String password = sc.nextLine();
						
						System.out.println("Enter Mobile");
						

						String Mobile=sc.nextLine();
						
						System.out.println("Enter Balance");
						
						int balance =sc.nextInt();
						
						AccountantDao dao = new AccountantImpl();
						
						CustomerBean customer = new CustomerBean();
						
						customer.setUsername(username);
						customer.setPassword(password);
						customer.setMobile(Mobile);
						customer.setBalance(balance);
						
						String result =dao.registerCustomerByAccountant(customer);
						
						System.out.println(result);
						
						
					}else if(opt==4) {
						
						System.out.println("Enter the account no to delete");
						
						int AccountNumber = sc.nextInt();
						
						AccountantDao dao = new AccountantImpl();
						
						try {
							dao.deletaacustomer(AccountNumber);
							
							System.out.println("Account deleteed sucessfully");
						} catch (CustomerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}else if(opt==5) {
						try {
							adao.showAllTransactions();
						} catch (CustomerException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						
					}
					}else if(opt==6) {
						
						System.out.println("Enter the account number where you have to update the name " );
						
						int Accountnumber =sc.nextInt();
						
						
						
						try {
							adao.updateCustomerDetails(Accountnumber);
							
							
						} catch (CustomerException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						
					}
						
					}else if(opt==7) {
						System.out.println("enter your Name");
						
						String Accountantname =sc.nextLine();
						
						System.out.println("enter your Username");
						
						String AccountantUsername =sc.nextLine();
						
						System.out.println("enter your Password");
						
						String password = sc.nextLine();
						
						AccountantDao dao =new AccountantImpl();
						
						Accountant accountantr =new Accountant();
						
						accountantr.setAccountantName(Accountantname);
						
						accountantr.setAccountantUsername(AccountantUsername);
						
						accountantr.setPassword(password);
						
						String result;
						try {
							result = dao.registerAccountant(accountantr);
							
							System.out.println(result);
						} catch (AccountantException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
//					
				} catch (AccountantException e) {
					
					System.out.println(e.getMessage());
				}
				
				
				
			}else if(person.equalsIgnoreCase("Bankcustomer")) {
				
				System.out.println("Welcome to online Banking");
				
				System.out.println("=============================");
				System.out.println("Enter Account no.");
				
				int AccountNumber =sc.nextInt();
				
				sc.nextLine();
				
				System.out.println("Enter Account password");
				String Password =sc.next();
				
				System.out.println("=============================");

				
				try {
					CustomerBean customer = cdao.loginCustomer(AccountNumber, Password);
					
					System.out.println("Welcome to online banking " + customer.getUsername());
					
					System.out.println("select the operation number" + "\n" + "* 1 Get your account details");
					System.out.println("* 2 Get your transaction history");
					System.out.println("* 3 Withdraw amount");
					System.out.println("* 4 Deposit amount");
					System.out.println("* 5 Transfer amount");
					System.out.println("=============================");

					System.out.println("Enter the Option number");
					
					int opt= sc.nextInt();
					
					if(opt==1) {
						
						System.out.println("Enter Customer Accountnum");
						
						int Acc=sc.nextInt();
						
						
						
						CustomerBean bcustomer;
						try {
							bcustomer = cdao.getAccountDetailsByAccount(Acc);
							System.out.println(bcustomer);
						} catch (CustomerException ce) {
//							// TODO Auto-generated catch block
//							ce.printStackTrace();
							System.out.println(ce.getMessage());
						}
					}//1
					else if(opt==2) {
						
						
						System.out.println("Enter your Account Number");
						
						int accountNumber =sc.nextInt();
						
						
						cdao.checkTransactionHistory(accountNumber);
						
					}//2
					else if(opt==3) {
						
						System.out.println("Enter the Amount");
						int Amount = sc.nextInt();
						
						
						System.out.println("Enter the Account NUmber");
						int accountNumber = sc.nextInt();
						
						System.out.println("=============================");

						
						try {
							String message =cdao.withdrawammount(Amount, accountNumber);
							
							System.out.println(message);
						} catch (CustomerException e) {
						System.out.println(e.getMessage());
						}
					}//3
					else if(opt==4) {
						
						System.out.println("Enter Amount to deposit");
						
						int Amount =sc.nextInt();
						
						System.out.println("Enter your Account Number");
						
						int accountNumber =sc.nextInt();
						
						
						System.out.println("=============================");

						
						try {
							
							
							String message =cdao.depositAmount(Amount, accountNumber);
							
							CustomerBean bcustomer =adao.showCustomer(accountNumber);
							
							System.out.println(message+bcustomer.getBalance() );
							
							
							
							
							
//							System.out.println(message);
						} catch (CustomerException e) {
							
							System.out.println(e.getMessage());
						}
						
						
					}//4
					else if(opt==5) {
						
						System.out.println("Enter Amount");
						
						int amount =sc.nextInt();
						
						System.out.println("Enter Your Account Number");
						
						int sendersaccount =sc.nextInt();
						
						System.out.println("Enter Recievers Account number ");
						
						System.out.println("=============================");

						int recieversaccount = sc.nextInt();
						
						CustomerDao dao =new CustomerImpl();
						
						try {
							String message =dao.transferMoney(amount, sendersaccount, recieversaccount);
							System.out.println(message);
						} catch (CustomerException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
						
						
					}//5
					
					
				} catch (CustomerException e) {
					
				   System.out.println(e.getMessage());
				}
				
				
				
			}else if(person.equalsIgnoreCase("RegisterCustomer")) {
				
				System.out.println("Enter Customer Username");
				
				String Username =sc.nextLine();
				

				System.out.println("Enter Customer Password");
				
				String Password =sc.nextLine();
				

				System.out.println("Enter Customer Mobile Number");
				
				System.out.println("=============================");

				String Mobile =sc.nextLine();
				
				CustomerDao dao = new CustomerImpl();
				
				CustomerBean customer = new CustomerBean();
				
				customer.setUsername(Username);
				customer.setPassword(Password);
				customer.setMobile(Mobile);
				customer.setBalance(0);
			
				String result =dao.registerCustomer2(customer);
				System.out.println(result);
			}
			
		}

	

}
		
	}

