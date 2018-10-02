package com.portfolio.onlineStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WEBSTORE.USER")
public class User{

	private int userId;
	private String username;
	private String password;
	private String role;
	/*
	private String userAuthLevel = "user";
	private String email;

	private String firstName;
	private String lastName;
	
	private boolean isLoggedIn;
	private boolean isRegistered;
	private boolean stayLoggedIn;
	
	private String cookieName;
	private String cookieValue;
	private String notes;*/
	
	@Id
	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}
	@Column(name = "username")
	public String getUsername() {
		return username;
	}
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	@Column(name = "role")//TODO: needs to join with role table to get string
	public String getRole() {
		return role;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
