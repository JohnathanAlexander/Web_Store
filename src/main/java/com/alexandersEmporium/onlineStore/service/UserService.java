package com.alexandersEmporium.onlineStore.service;
import java.sql.SQLException;

import com.alexandersEmporium.onlineStore.domain.Users.User;
public interface UserService {
	User login(User user) throws SQLException;
}
