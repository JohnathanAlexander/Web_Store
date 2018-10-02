package com.portfolio.onlineStore.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.portfolio.onlineStore.ejb.ProductRepositoryImpl;
import com.portfolio.onlineStore.entity.Product;
public class ProductService{
	@Autowired
	ProductRepositoryImpl repository;
	
	public Product getProductByProductId(String productId) throws SQLException{
		Product product = repository.getProductByProductId(productId);
		return product;
	}
	public List<Product> getAllFeatured() throws SQLException, IOException{
		List<Product> list = repository.getAllFeaturedProducts();
				
		return list;
	}
	public List<Product> getAllProducts() throws SQLException, IOException{
		List<Product> list = repository.getAllProducts();
		
		return list;
	}
	public String addNewProduct(Product product) throws SQLException, IOException {
		String name = product.getTitle();
		String desc = product.getDescription();
		String prodId = product.getProductId();
		double cost = product.getCost();
		double price = product.getPrice();
		byte[] image = product.getImage();
		String imgExt = getImageExtension(product.getImage());
		int stock = product.getQuantityInStock();
		int order = product.getQuantityOnOrder();
		
		String ret = repository.addNewProduct(
												name, desc, prodId,
												cost, price, image,
												imgExt, stock, order
											 );
		
		return ret;
	}
	public String getImageExtension(byte[] image) throws IOException {
		String imageExtension = URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(image));
		System.out.println(imageExtension);
		
		return imageExtension;
	}
}
