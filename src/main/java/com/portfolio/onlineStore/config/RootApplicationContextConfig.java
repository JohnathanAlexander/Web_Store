package com.portfolio.onlineStore.config;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.portfolio.onlineStore.entity.User;
import com.portfolio.onlineStore.entity.UserServiceImpl;
import com.portfolio.onlineStore.entity.Product;
import com.portfolio.onlineStore.entity.ProductRepositoryImpl;
import com.portfolio.onlineStore.entity.UserRepositoryImpl;
import com.portfolio.onlineStore.service.ProductServiceImpl;
import com.portfolio.onlineStore.service.ReportsServiceImpl;
@Configuration
@ComponentScan("com.alexandersEmporium.onlineStore")
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
	public ProductServiceImpl getProductService() {
		return new ProductServiceImpl();
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
	public UserServiceImpl getUserServiceImpl() {
		return new UserServiceImpl();
	}
	@Bean
	public ReportsServiceImpl getReportsServiceImpl() {
		return new ReportsServiceImpl();
	}
}
