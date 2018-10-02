package com.alexandersEmporium.onlineStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.alexandersEmporium.onlineStore.domain.Reports.ElevatedUserReport;
import com.alexandersEmporium.onlineStore.domain.Reports.ProductReport;
import com.alexandersEmporium.onlineStore.domain.Reports.SalesReport;
import com.alexandersEmporium.onlineStore.serviceImpl.ReportsServiceImpl;
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
