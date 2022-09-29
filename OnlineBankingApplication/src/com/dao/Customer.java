package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlinebanking.bean.CustomerBean;
import com.onlinebanking.utility.DBUtil;

public class Customer implements CustomerDao{

	@Override
	public String registerCustomer(String Username, String Password, String Mobile) {
		
		
		String message ="Not Inserted";
		
		;
		
		try(Connection connect= DBUtil.provideConnection()){
			
			PreparedStatement ps =connect.prepareStatement("insert into customer (Username , Password , Mobile) values (?,?,?)");
			
			ps.setString(1,Username);
			ps.setString(2, Password);
			ps.setString(3, Mobile);
			
			int res =ps.executeUpdate();
			
			if(res>0) {
				message = "Customer registered sucessfully";
			}
			
		}catch(SQLException e) {
			message = e.getMessage();
		}
		return message;
	}

	@Override
	public String registerCustomer2(CustomerBean customer) {
		
		String message ="Not Inserted";
		
		;
		
		try(Connection connect= DBUtil.provideConnection()){
			
			PreparedStatement ps =connect.prepareStatement("insert into customer (Username , Password , Mobile) values (?,?,?)");
			
			ps.setString(1,customer.getUsername());
			ps.setString(2,customer.getPassword());
			ps.setString(3,customer.getMobile());
			
			int res =ps.executeUpdate();
			
			if(res>0) {
				message = "Customer registered sucessfully";
			}
			
		}catch(SQLException e) {
			message = e.getMessage();
		}
		return message;
	}

	@Override
	public CustomerBean getAccountDetailsByAccount(int AccountNumber) {
		
		CustomerBean customer=null;
		
		try(Connection connect= DBUtil.provideConnection()){
			
			PreparedStatement ps =connect.prepareStatement("select * from customer where AccountNumber=?");
			
		ps.setInt(1,AccountNumber);
			
		ResultSet rs =ps.executeQuery();
		
		if(rs.next()) {
			int r =rs.getInt("AccountNumber");
			
			
			
			String username =rs.getString("username");
			
			String password =rs.getString("password");
			
			String mobile =rs.getString("mobile");
			
			customer = new CustomerBean(r,username,password,mobile) ;
			
			
			
			
		}
			
		}catch(SQLException E) {
			
		}
		
		
		return customer;
	}

	
	
	
	

}
