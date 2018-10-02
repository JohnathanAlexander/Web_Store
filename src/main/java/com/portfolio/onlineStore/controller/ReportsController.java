package com.portfolio.onlineStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.onlineStore.entity.ElevatedUserReport;
import com.portfolio.onlineStore.entity.ProductReport;
import com.portfolio.onlineStore.entity.SalesReport;
import com.portfolio.onlineStore.service.ReportsServiceImpl;
@RestController
public class ReportsController {
	@Autowired
	private ReportsServiceImpl service;
	
	public List<SalesReport> getSalesReport(){
		return null;
	}
	public List<ProductReport> getProductsReport(){
		return null;
	}
	public List<ElevatedUserReport> getElevatedUserReport(){
		return null;
	}
}
