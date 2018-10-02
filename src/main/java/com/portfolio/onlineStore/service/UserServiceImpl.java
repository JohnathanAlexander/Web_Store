package com.portfolio.onlineStore.service;
import com.portfolio.onlineStore.entity.User;

import java.sql.SQLException;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
public class UserServiceImpl{
	@Autowired
	private UserRepositoryImpl repository;
	
	public User login(User user) throws SQLException {
		user = repository.loginProc(user);
		
		return user;
	}
	public User register(User user) throws SQLException, ClassNotFoundException{
		System.out.println("leaving service");
		user = repository.registerProc(user);
		return user;
	}
	public String[] createCookie(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		String userAuthLevel = user.getUserAuthLevel();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		
		StringBuilder sb = new StringBuilder();
		sb.append(username).append("|").append(password).append("|");
		sb.append(userAuthLevel).append("|").append(firstName);
		sb.append("|").append(lastName);
		
		return new String[]{"stayLog", sb.toString()};
	}
	public String addElevatedUser(User user) {
		return repository.addElevatedUser(user);
	}
	// masteruser|password|admin|johnathan|alexander
}
