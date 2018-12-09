package com.portfolio.onlineStore.service;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;

import com.portfolio.onlineStore.ejb.UserSessionBean;
import com.portfolio.onlineStore.entity.User;
import com.portfolio.onlineStore.entity.UserInformation;
import com.portfolio.onlineStore.enums.Role;
import com.portfolio.onlineStore.enums.Status;
import com.portfolio.onlineStore.util.EncryptionUtility;

public class UserService extends Service{
	@EJB
	private UserSessionBean ejb;
	
	public User login(User user){
		//User currUser = ejb.find(user.getUsername(), user.getPassword());
		User currUser = null;
		
			currUser = new User();
			currUser.setUsername(user.getUsername());
			
			currUser.setPassword(EncryptionUtility.encrypt(user.getPassword()));
			currUser.setRole(Role.EMPLOYEE);
			currUser.setUserId(4696566);
		
		storage.setCurrentUser(currUser);
		
		return currUser;
	}
	
	public Status close(User user) {
		Status closeStatus = Status.CLOSED;
		try {
			user.isActive(false);
			
			ejb.delete(user);
		}catch(Exception e) {
			e.printStackTrace();
			closeStatus = Status.ERROR;
		}
		return closeStatus;
		
	}
	
	//Temporary logout method
	public Status logout(User user) {
		storage.setCurrentUser(null);
		//Later:  ejb.logout(user.getUsername()); //TODO: Implement login status table in db with timestamps  insert records
		return Status.LOG_OUT_SUCCESSFUL;
	}
	public User register(User user, UserInformation info) throws SQLException, ClassNotFoundException{
		return ejb.create(user.getUsername(), user.getPassword(),
							info.getFirstName(), info.getLastName(),
							info.getEmail());
		
	}
	
	//TODO
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
