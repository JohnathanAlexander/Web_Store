package com.portfolio.onlineStore.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.onlineStore.entity.User;
import com.portfolio.onlineStore.entity.UserInformation;
import com.portfolio.onlineStore.service.UserService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping("/login")
	public @ResponseBody User login(@ModelAttribute("loginUser") User user) throws SQLException {
		/*boolean createCookieUponSuccess = user.isStayLoggedIn();
		System.out.println("create cookie: " + user.isStayLoggedIn());
		user = service.login(user);
		/*if(user.isLoggedIn() && createCookieUponSuccess) {
			String[] cookie = service.createCookie(user);
			user.setCookieName(cookie[0]);
			user.setCookieValue(cookie[1]);
		}*/
		
		
		
		return user;
	}
	@RequestMapping("/registerUser")
	public String registerUser(@ModelAttribute("registerUser") User user, @ModelAttribute("registerUserInformation") UserInformation info) throws SQLException, ClassNotFoundException {
		user = service.register(user, info);
		//System.out.println("success status : " + user.getNotes());
		//return user.getNotes();
		/*if(user.isRegistered()) {
			return "success";
		}*/
		return "false";
	}
	@RequestMapping("/findUser")
	public List<Object> findUser(User user, UserInformation info){
		List<Object> ret = new ArrayList<>();
		
		return null;
	}
	@RequestMapping("/alter")
	public String alter(User user, UserInformation info, User modifier) {
		return null;
	}
	@RequestMapping("/closeAccount")
	public String closeAccount(User user) throws SQLException{
		return null;
	}
}
