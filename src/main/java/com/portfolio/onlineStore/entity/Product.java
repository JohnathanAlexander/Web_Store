package com.portfolio.onlineStore.entity;

import javax.persistence.Entity;

@Entity
public class Product{


	private int recordId;

	private String title;

	private String description;

	private String productId;
	private int quantityInStock;
	private int quantityOnOrder;
	private int totalSalesLifetime;

	private double cost;

	private double price;
	
	
	private byte[] image;
	private String imageExtension;
	public Product() {}
	public Product(String productId, String description, double price) {
		this.productId = productId;
		this.description = description;
		this.price = price;
	}
	public Product(String productId, String title, String description,
				   double cost, double price, byte[] image,
				   int qInStock, int qOnOrder, int totalSales){
		this(productId, description, price);
		this.title = title;
		this.cost = cost;
		this.image = image;
		this.quantityInStock = qInStock;
		this.quantityOnOrder = qOnOrder;
		this.totalSalesLifetime = totalSales;
	}
	public Product(String productId, String title, String description,
				   double price, int qInStock, byte[] image) {
		this(productId, description, price);
		this.title = title;
		this.quantityInStock = qInStock;
		this.image = image;
	}
	public int getRecordId() {
		return recordId;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getProductId() {
		return productId;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public int getQuantityOnOrder() {
		return quantityOnOrder;
	}
	public int getTotalSalesLifetime() {
		return totalSalesLifetime;
	}
	public double getCost() {
		return cost;
	}
	public double getPrice() {
		return price;
	}
	public byte[] getImage() {
		return image;
	}
	public String getImageExtension() {
		return imageExtension;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public void setQuantityOnOrder(int quantityOnOrder) {
		this.quantityOnOrder = quantityOnOrder;
	}
	public void setTotalSalesLifetime(int totalSalesLifetime) {
		this.totalSalesLifetime = totalSalesLifetime;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public void setImageExtension(String imageExtension) {
		this.imageExtension = imageExtension;
	}
	
}
