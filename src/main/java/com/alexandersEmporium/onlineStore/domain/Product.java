package com.alexandersEmporium.onlineStore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")

public class Product implements Serializable{


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
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return this.title;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public int getRecordId() {
		return this.recordId;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return this.description;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductId() {
		return this.productId;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public int getQuantityInStock() {
		return this.quantityInStock;
	}
	public void setQuantityOnOrder(int quantityOnOrder) {
		this.quantityOnOrder = quantityOnOrder;
	}
	public int getQuantityOnOrder() {
		return this.quantityOnOrder;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return this.price;
	}
	public void setTotalSalesLifetime(int totalSalesLifetime) {
		this.totalSalesLifetime = totalSalesLifetime;
	}
	public int getTotalSalesLifetime() {
		return this.totalSalesLifetime;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getCost() {
		return this.cost;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public byte[] getImage() {
		return this.image;
	}
	public void setImageExtension(String ext) {
		this.imageExtension = ext;
	}
	public String getImageExtension() {
		return this.imageExtension;
	}
}
