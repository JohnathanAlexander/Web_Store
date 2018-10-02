package com.portfolio.onlineStore.entity;

import java.util.ArrayList;
import java.util.List;

import com.portfolio.onlineStore.entity.User;

@SuppressWarnings("serial")
public class ElevatedUser extends User{
	private ArrayList<String> actionsPerformed;
	{
		this.actionsPerformed = new ArrayList<>();
	}
	public ElevatedUser() {}
	public ElevatedUser(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
	@Override
	public void addAction(String action) {
		this.actionsPerformed.add(action);
	}
	@Override
	public List<String> getAllActions(){
		return this.actionsPerformed;
	}
}
