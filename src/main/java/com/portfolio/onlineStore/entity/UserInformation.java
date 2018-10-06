package com.portfolio.onlineStore.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.portfolio.onlineStore.interfaces.Creatable;
import com.portfolio.onlineStore.interfaces.Modifiable;

@Entity
@Table(name = "webstore.user_information")
public class UserInformation implements Creatable, Modifiable{
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private int userCreated;
	private int userModified;
	
	
	
	public int getUserId() {
		return userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}

	@Override
	public int getUserModified() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getUserCreated() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public void setUserModified(int userModified) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setUserCreated(int userCreated) {
		// TODO Auto-generated method stub
		
	}
}
