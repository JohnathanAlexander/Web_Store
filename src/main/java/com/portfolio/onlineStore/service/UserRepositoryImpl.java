package com.portfolio.onlineStore.service;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.portfolio.onlineStore.entity.User;

import java.sql.Connection;

public class UserRepositoryImpl{
	Connection conn;
	public UserRepositoryImpl(Connection conn) throws ClassNotFoundException {
		this.conn = conn;
	}
	public User loginProc(User user) throws SQLException {
		String username = user.getUsername();
		String password = user.getPassword();
		//this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "student", "student");
		this.conn.createStatement();
		
		CallableStatement cStmt = conn.prepareCall("{call loginUser(?,?,?,?,?,?,?)}");
		
		cStmt.setString(1, user.getUsername());
		cStmt.setString(2, user.getPassword());
		
		cStmt.registerOutParameter(3, Types.VARCHAR);
		cStmt.registerOutParameter(4, Types.VARCHAR);
		cStmt.registerOutParameter(5, Types.VARCHAR);
		cStmt.registerOutParameter(6, Types.VARCHAR);
		cStmt.registerOutParameter(7, Types.VARCHAR);
		
		cStmt.execute();
		
		
		user = new User();
			
		if(cStmt.getString("success").equals("true")) {
			user.setUsername(username);
			user.setPassword(password);
			user.setUserAuthLevel(cStmt.getString("authLevel"));
			user.setEmail(cStmt.getString("email"));
			user.setFirstName(cStmt.getString("firstName"));
			user.setLastName(cStmt.getString("lastName"));
			user.isLoggedIn(true);
			user.isRegistered(true);
		}else {
			user.setNotes("Invalid Username Or Password");
		}
		
		//access the database via DatabaseConnection here.
		//call methods
		return user;
	}
	public User registerProc(User user) throws SQLException, ClassNotFoundException{
		System.out.println("registerProc");
		
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "student", "student");
		
		CallableStatement cStmt = conn.prepareCall("{call registerUser(?,?,?,?,?,?)}");

	    cStmt.setString(1, user.getUsername());
	    cStmt.setString(2, user.getPassword());
	    cStmt.setString(3, user.getEmail());
	    cStmt.setString(4, user.getFirstName());
	    cStmt.setString(5, user.getLastName());
		System.out.println("In parameters have been set");
	    cStmt.registerOutParameter(6, Types.VARCHAR);
	    System.out.println("out parameter set");
	    ResultSet result = cStmt.executeQuery();
	    String message = "";
	    if(result.next()) {
	    	System.out.println("message = " + result.getString(1));
	    }
	   
	    
	    if(message.equals("success")) {
	    	user.isRegistered(true);
	    	user.setNotes("registerSuccess");
	    	return user;
	    }else {
	    	user.setNotes(message);
	    }
	    
		return user;
	}
	public String addElevatedUser(User user) {
		return null;
	}
	
	
}
