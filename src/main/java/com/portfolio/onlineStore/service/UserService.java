package com.portfolio.onlineStore.service;
import java.sql.SQLException;

import com.portfolio.onlineStore.entity.User;
public interface UserService {
	User login(User user) throws SQLException;
}
