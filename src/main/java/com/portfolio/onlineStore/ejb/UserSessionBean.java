package com.portfolio.onlineStore.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.portfolio.onlineStore.entity.User;

public class UserSessionBean {
	@PersistenceContext
	EntityManager em;
	
	public User find(String username, String password) {
		return null;
	}
	public void delete(User user) {
		
	}
	private void permanentlyDelete(User user) {
		
	}
}
