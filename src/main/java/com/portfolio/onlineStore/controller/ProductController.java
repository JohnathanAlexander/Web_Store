package com.portfolio.onlineStore.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.onlineStore.entity.Product;
import com.portfolio.onlineStore.service.ProductService;

import java.io.IOException;
import java.lang.annotation.Repeatable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController

public class ProductController {
	@Autowired
	ProductService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/getAllProducts")
	public @ResponseBody List<Product> getAllProducts() throws SQLException, IOException{
		List<Product> list = service.getAllProducts();
		return list;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getProduct")
	public Product getProduct(@RequestParam("searchProductId") int productId) throws SQLException{
		System.out.println("hello");
		service.getProductByProductId(productId);
		return null;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/getAllFeatured")
	public @ResponseBody List<Product> getAllFeatured() throws SQLException, IOException{
		List<Product> featuredList = service.getAllFeatured(); 
		return featuredList;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addNewProduct")
	public @ResponseBody String addNewProduct(Product product) throws SQLException, IOException{
		System.out.println(product.getDescription());
		String ret = service.addNewProduct(product);
		return ret;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("removeExistingProduct")
	public @ResponseBody String removeExistingProduct(Product product) throws SQLException{
		return null;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/updateExistingProduct")
	public @ResponseBody String updateExistingProduct(Product product) throws SQLException{
		return null;
	}
}