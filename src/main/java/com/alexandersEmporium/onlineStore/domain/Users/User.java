package com.alexandersEmporium.onlineStore.domain.Users;

import java.io.Serializable;
import java.util.List;


@SuppressWarnings("serial")

public class User implements Serializable{

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
	public int getRecordId() {
		return this.recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setUserAuthLevel(String authLevel) {
		this.userAuthLevel = authLevel;
	}
	public String getUserAuthLevel() {
		return this.userAuthLevel;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setIsLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
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
	public void setIsRegistered(boolean bool) {
		this.isRegistered = bool;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getNotes() {
		return this.notes;
	}
	public boolean getIsRegistered() {
		return this.isRegistered;
	}
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		return this.password;
	}
	public boolean getIsLoggedIn() {
		return this.isLoggedIn;
	}
	public String getEmail() {
		return this.email;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public boolean getStayLoggedIn() {
		return this.stayLoggedIn;
	}
	public void setStayLoggedIn(boolean stayLoggedIn) {
		this.stayLoggedIn = stayLoggedIn;
	}
	public String getCookieName() {
		return this.cookieName;
	}
	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}
	public String getCookieValue() {
		return this.cookieValue;
	}
	public void setCookieValue(String cookieValue) {
		this.cookieValue = cookieValue;
	}
	public List<String> getAllActions(){return null;}
	public void addAction(String action) {}
}
