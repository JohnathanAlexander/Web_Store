package com.portfolio.onlineStore.util;

import java.time.LocalDate;

public class DateUtility {
	private static LocalDate date;
	
	private static DateUtility dateUtility = new DateUtility();
	
	private DateUtility() {}
	
	public static DateUtility getInstance() {
		return dateUtility;
	}
	public LocalDate getDate() {
		date = LocalDate.now();
		return date;
	}
}
