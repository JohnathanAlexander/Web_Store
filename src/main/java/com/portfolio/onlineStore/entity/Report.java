package com.portfolio.onlineStore.entity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.portfolio.onlineStore.util.DateUtility;

public abstract class Report {
	protected String reportName;
	private final LocalDate REPORT_DATE;
	public Report() {
		REPORT_DATE = DateUtility.getInstance().getDate();
	}
	
	public abstract void setReportName(String repName);
	public abstract void getReportName();
	
}
