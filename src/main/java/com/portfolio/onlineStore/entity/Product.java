package com.portfolio.onlineStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WEBSTORE.PRODUCT")
public class Product{
	private int productId;
	
	private String title;
	private String description;
	
	private double cost;
	private double price;
	
	private int totalSales;
	private int quantityInStock;
	private int quantityOnOrder;

	private byte[] image;
	private String imageExt;
	
	public Product() {}
	public Product(int productId, String description, double price) {
		this.productId = productId;
		this.description = description;
		this.price = price;
	}
	public Product(int productId, String title, String description,
				   double cost, double price, byte[] image,
				   int qInStock, int qOnOrder, int totalSales){
		this(productId, description, price);
		this.title = title;
		this.cost = cost;
		this.image = image;
		this.quantityInStock = qInStock;
		this.quantityOnOrder = qOnOrder;
		this.totalSales = totalSales;
	}
	public Product(int productId, String title, String description,
				   double price, int qInStock, byte[] image) {
		this(productId, description, price);
		this.title = title;
		this.quantityInStock = qInStock;
		this.image = image;
	}
	@Id
	@Column(name = "product_id")
	public int getProductId() {
		return productId;
	}
	@Column(name = "product_title")
	public String getTitle() {
		return title;
	}
	@Column(name = "product_description")
	public String getDescription() {
		return description;
	}
	@Column(name = "cost")
	public double getCost() {
		return cost;
	}
	@Column(name = "price")
	public double getPrice() {
		return price;
	}
	@Column(name = "total_sales")
	public int getTotalSales() {
		return totalSales;
	}
	@Column(name = "quantity_in_stock")
	public int getQuantityInStock() {
		return quantityInStock;
	}
	@Column(name = "quantity_on_order")
	public int getQuantityOnOrder() {
		return quantityOnOrder;
	}
	@Column(name = "image")
	public byte[] getImage() {
		return image;
	}
	@Column(name = "image_ext")
	public String getImageExt() {
		return imageExt;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public void setQuantityOnOrder(int quantityOnOrder) {
		this.quantityOnOrder = quantityOnOrder;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public void setImageExt(String imageExt) {
		this.imageExt = imageExt;
	}
	
}

