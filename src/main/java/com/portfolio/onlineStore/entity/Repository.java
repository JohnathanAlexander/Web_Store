package com.portfolio.onlineStore.entity;

import java.sql.SQLException;

public interface Repository {
	public boolean authenticate(String[] levelAuthTo,
								String username,
								String password) throws SQLException;
}
