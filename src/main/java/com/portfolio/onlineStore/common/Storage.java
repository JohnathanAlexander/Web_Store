package com.portfolio.onlineStore.common;

import org.springframework.web.context.annotation.SessionScope;

import com.portfolio.onlineStore.entity.User;

@SessionScope
public class Storage {
	protected static User currentUser;
	
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User user) {
		currentUser = user;
	}
}
