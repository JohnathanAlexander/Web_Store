package com.alexandersEmporium.onlineStore.controller;
import java.sql.SQLException;
import javax.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexandersEmporium.onlineStore.domain.Users.ElevatedUser;
import com.alexandersEmporium.onlineStore.domain.Users.User;
import com.alexandersEmporium.onlineStore.serviceImpl.UserServiceImpl;
@RestController
public class UserController {
	@Autowired
	private UserServiceImpl service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/login")
	public @ResponseBody User login(@ModelAttribute("loginUser") User user) throws SQLException {
		boolean createCookieUponSuccess = user.getStayLoggedIn();
		System.out.println("create cookie: " + user.getStayLoggedIn());
		user = service.login(user);
		if(user.getIsLoggedIn() && createCookieUponSuccess) {
			String[] cookie = service.createCookie(user);
			user.setCookieName(cookie[0]);
			user.setCookieValue(cookie[1]);
		}
		
		return user;
	}
	@RequestMapping("/registerUser")
	@CrossOrigin(origins="http://localhost:4200")
	public String registerUser(@ModelAttribute("registerUser") User user) throws SQLException, ClassNotFoundException {
		user = service.register(user);
		System.out.println("success status : " + user.getNotes());
		//return user.getNotes();
		if(user.getIsRegistered()) {
			return "success";
		}
		return "false";
	}
	@RequestMapping("/addElevatedUser")
	public String addNewElevatedUser(User user) {
		service.addElevatedUser(user);
		return null;
	}
	@RequestMapping("/getManager")
	public @ResponseBody User getManager(User user) throws SQLException{
		return null;
	}
	@RequestMapping("/getAdmin")
	public @ResponseBody User getAdmin(User user) throws SQLException{
		return null;
	}
	@RequestMapping("/alterManager")
	public String alterManager(User user) throws SQLException{
		return null;
	}
	@RequestMapping("/alterAdmin")
	public String alterAdmin(User user) throws SQLException{
		return null;
	}
	@RequestMapping("/closeAccount")
	public String closeAccount(User user) throws SQLException{
		return null;
	}
}
