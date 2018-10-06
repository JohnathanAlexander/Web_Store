package com.portfolio.onlineStore.service;
import com.portfolio.onlineStore.ejb.UserRepositoryImpl;
import com.portfolio.onlineStore.ejb.UserSessionBean;
import com.portfolio.onlineStore.entity.User;
import com.portfolio.onlineStore.entity.UserInformation;
import com.portfolio.onlineStore.enums.Status;

import java.util.List;

import java.sql.SQLException;

import javax.ejb.EJB;

public class UserService extends Service{
	@EJB
	private UserSessionBean ejb;
	
	public User login(User user) throws SQLException {
		User currUser = ejb.find(user.getUsername(), user.getPassword());

		storage.setCurrentUser(currUser);
		
		return currUser;
	}
	
	//Temporary logout method
	public Status logout(User user) {
		storage.setCurrentUser(null);
		return Status.LOG_OUT_SUCCESSFUL;
	}
	public User register(User user, UserInformation info) throws SQLException, ClassNotFoundException{
		return ejb.create(user.getUsername(), user.getPassword(),
							info.getFirstName(), info.getLastName(),
							info.getEmail());
		
	}
	@Override
	public Object retrieve(List<Object> list) {
		return null;
	}
		
//	public String[] createCookie(User user) {
//		String username = user.getUsername();
//		String password = user.getPassword();
//		/*String userAuthLevel = user.getUserAuthLevel();
//		String firstName = user.getFirstName();
//		String lastName = user.getLastName();*/
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append(username).append("|").append(password).append("|");
//		/*sb.append(userAuthLevel).append("|").append(firstName);
//		sb.append("|").append(lastName);*/
//		
//		return new String[]{"stayLog", sb.toString()};
//	}
	
	// masteruser|password|admin|johnathan|alexander
}
