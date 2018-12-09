package com.portfolio.onlineStore.util;

<<<<<<< Updated upstream:src/main/java/com/portfolio/onlineStore/util/PasswordEncryptionUtility.java
public class PasswordEncryptionUtility {
	private PasswordEncryptionUtility peu;
	private PasswordEncryptionUtility() {}
	public PasswordEncryptionUtility getInstance() {
		return peu;
	}
	public String encrypt(String password) {
		return null;
=======
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
>>>>>>> Stashed changes:src/main/java/com/portfolio/onlineStore/util/EncryptionUtility.java
	}
}
