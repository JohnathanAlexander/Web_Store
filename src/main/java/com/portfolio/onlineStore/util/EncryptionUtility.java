package com.portfolio.onlineStore.util;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class EncryptionUtility {
	private static EncryptionUtility peu;
	private EncryptionUtility() {}
	public static EncryptionUtility getInstance() {
		return peu;
	}
	public static String encrypt(String password) {
		StrongPasswordEncryptor encrypt = new StrongPasswordEncryptor();
		String encryptedPassword = encrypt.encryptPassword(password);
		
		return encryptedPassword;
	}
}
