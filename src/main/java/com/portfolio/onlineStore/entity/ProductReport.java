package com.portfolio.onlineStore.entity;
import java.util.ArrayList;
import java.util.List;
public class ProductReport extends Report{
	private int numTotalProducts;
	private int numTotalActiveProducts;
	private int numTotalInactiveProducts;
	public ProductReport() {
		super();
	}
	private ArrayList<Product> featuredProducts;
	{
		this.numTotalProducts = 0;
		this.numTotalActiveProducts = 0;
		this.numTotalInactiveProducts = 0;
	}
	
	public void setNumTotalProducts(int num) {
		this.numTotalProducts = num;
	}
	public int getNumTotalProducts() {
		return this.numTotalProducts;
	}
	public void setNumTotalActiveProducts(int num) {
		this.numTotalActiveProducts = num;
	}
	public int getNumTotalActiveProducts() {
		return this.numTotalActiveProducts;
	}
	public void setNumTotalInactiveProducts(int num) {
		this.numTotalInactiveProducts = num;
	}
	public int getNumTotalInactiveProducts() {
		return this.numTotalInactiveProducts;
	}
	public void setFeaturedProducts(ArrayList<Product> list) {
		this.featuredProducts = list;
	}
	public List<Product> getFeaturedProducts(){
		return this.featuredProducts;
	}

	@Override
	public void setReportName(String repName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getReportName() {
		// TODO Auto-generated method stub
		
	}
}
