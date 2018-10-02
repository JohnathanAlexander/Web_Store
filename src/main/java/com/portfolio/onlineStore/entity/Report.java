package com.portfolio.onlineStore.entity;

import java.text.SimpleDateFormat;

public class Report {
	protected String reportName;
	private final String REPORTDATE;
	{
		this.REPORTDATE = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new java.util.Date());
	}
	public Report() {}
	public void setReportName(String repName) {
		this.reportName = repName;
	}
	public String getReportName() {
		return this.reportName;
	}
	public String getDate() {
		return this.REPORTDATE;
	}
}
