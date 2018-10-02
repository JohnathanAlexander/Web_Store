package com.portfolio.onlineStore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User{

	private int recordId;

	private String username;
	private String password;
	private String userAuthLevel = "user";
	private String email;

	private String firstName;
	private String lastName;
	
	private boolean isLoggedIn;
	private boolean isRegistered;
	private boolean stayLoggedIn;
	
	private String cookieName;
	private String cookieValue;
	private String notes;
	
	public User() {}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	
	@Id
	public int getRecordId() {
		return recordId;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getUserAuthLevel() {
		return userAuthLevel;
	}
	public String getEmail() {
		return email;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public boolean isRegistered() {
		return isRegistered;
	}
	public boolean isStayLoggedIn() {
		return stayLoggedIn;
	}
	
	public void isLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public void isRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}
	public void isStayLoggedIn(boolean stayLoggedIn) {
		this.stayLoggedIn = stayLoggedIn;
	}
	public String getCookieName() {
		return cookieName;
	}
	public String getCookieValue() {
		return cookieValue;
	}
	public String getNotes() {
		return notes;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserAuthLevel(String userAuthLevel) {
		this.userAuthLevel = userAuthLevel;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}
	public void setStayLoggedIn(boolean stayLoggedIn) {
		this.stayLoggedIn = stayLoggedIn;
	}
	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}
	public void setCookieValue(String cookieValue) {
		this.cookieValue = cookieValue;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
