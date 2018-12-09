package com.portfolio.onlineStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.portfolio.onlineStore.enums.Role;

@Entity
@Table(name = "WEBSTORE.USER")
public class User{

	private int userId;
	private String username;
	private String password;
	private String dbRole;
	private Role role;
	private String firstName;
	private String lastName;
	private String email;
	
	private boolean isActive;
	
	
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "role")//TODO: needs to join with role table to get string
	public String getDbRole() {
		return dbRole;
	}
	public Role getRole() {
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
	public void setRole(Role role) {
		this.role = role;
	}
	public void setDbRole(String role) {
		dbRole = role;
	}
	public boolean isActive() {
		return isActive;
	}
	public void isActive(boolean active) {
		isActive = active;
	}
	
}
