package com.portfolio.onlineStore.ejb;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.portfolio.onlineStore.entity.User;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserSessionBean {
	Logger logger = Logger.getLogger(UserSessionBean.class.getName()); 
	
	@PersistenceContext
	EntityManager em;
	
	public User find(String username, String password) {
		return null;
	}
	public void delete(User user) {
		try {
			User pendingDelete = em.find(User.class, user.getUserId());
			
			em.remove(pendingDelete);
			em.flush();
		}catch(Exception e) {
			
		}
	}
	public Long retrieveUserCount() {
		return 0L;
	}
	public User create() {
		return null;
	}
	//TODO
	private void permanentlyDelete(User user) {
		
	}
}
