package com.portfolio.onlineStore.enums;
//USER (ALL ROLES) LOG IN STATUS
public enum Status {
	LOG_IN_SUCCESSFUL,
	
	//unsuccessful login due to invalid username or password
	LOG_IN_UNSUCCESSFUL_US_PW,
	
	//unsuccessful login due to other reason than username or password
	LOG_IN_UNSUCCESSFUL,
	
	//user logged out...should result in some sort of log out window
	LOG_OUT_SUCCESSFUL,
	
	//account does not exist
	NO_ACCOUNT,
	
	
}
