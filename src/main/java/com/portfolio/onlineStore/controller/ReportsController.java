package com.portfolio.onlineStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.onlineStore.entity.ProductReport;
import com.portfolio.onlineStore.entity.SalesReport;
import com.portfolio.onlineStore.service.ReportsService;
@RestController
public class ReportsController {
	@Autowired
	private ReportsService service;
	
	public List<SalesReport> getSalesReport(){
		return null;
	}
	public List<ProductReport> getProductsReport(){
		return null;
	}
}
