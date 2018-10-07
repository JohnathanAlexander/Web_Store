package com.portfolio.onlineStore.config;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.portfolio.onlineStore.entity.User;
import com.portfolio.onlineStore.ejb.ProductRepositoryImpl;
import com.portfolio.onlineStore.ejb.UserRepositoryImpl;
import com.portfolio.onlineStore.entity.Product;
import com.portfolio.onlineStore.service.ProductService;
import com.portfolio.onlineStore.service.ReportsService;
import com.portfolio.onlineStore.service.UserService;
@Configuration
@ComponentScan("com.portfolio.onlineStore")
public class RootApplicationContextConfig {
	
	@Bean
	public User getUser() {
		return new User();
	}
	@Bean
	public Product getProduct() {
		return new Product();
	}
	@Bean
	public ProductService getProductService() {
		return new ProductService();
	}
	@Bean
	public UserRepositoryImpl getUserRepositoryImpl() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return new UserRepositoryImpl(DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "student", "student"));
	}
	@Bean
	public ProductRepositoryImpl getProductRepositoryImpl() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return new ProductRepositoryImpl(DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "student", "student"));
	}
	@Bean
	public UserService getUserServiceImpl() {
		return new UserService();
	}
	@Bean
	public ReportsService getReportsServiceImpl() {
		return new ReportsService();
	}
}
