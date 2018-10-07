package com.portfolio.onlineStore.ejb;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.portfolio.onlineStore.entity.User;
import com.portfolio.onlineStore.enums.Role;
import com.portfolio.onlineStore.entity.UserInformation;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserSessionBean {
	Logger logger = Logger.getLogger(UserSessionBean.class.getName()); 
	
	@PersistenceContext
	EntityManager em;
	
	//login method
	public User find(String username, String password) {
		User user = em.find(User.class, username);
		return roleSetter(user);
	}
	public void delete(User user) {
		try {
			User pendingDelete = em.find(User.class, user.getUserId());
			
			update(user);
			
		}catch(Exception e) {
			
		}
	}
	public void update(User user) {
		em.merge(user);
		em.flush();
	}
	public void update(User user, UserInformation info) {
		em.merge(user);
		em.merge(info);
		em.flush();
	}
	public User roleSetter(User user) {
		Role role;
		switch(user.getDbRole()) {
			case "employee":
				role = Role.EMPLOYEE;
				break;
			case "manager":
				role = Role.MANAGER;
				break;
			case "administrator":
				role = Role.ADMINISTRATOR;
				break;
			default:
				role = Role.USER;
				break;
		}
		user.setRole(role);
		
		return user;
	}
	//TODO
	public Long retrieveUserCount() {
		return 0L;
	}
	//TODO
	public User create(String username, String password, String firstName, String lastName, String email) {
		return null;
	}
	
	private void permanentlyDelete(User user) {
		try {
			User permDeletePending = em.find(User.class, user.getUsername());
			
			em.remove(permDeletePending);
			em.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
