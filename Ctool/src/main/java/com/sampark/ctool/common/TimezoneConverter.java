package com.sampark.ctool.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimezoneConverter {
	
	
	public static Date getDate(Date date)
	{
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
	formatter.setTimeZone(TimeZone.getTimeZone("CET"));
	formatter.setTimeZone(TimeZone.getTimeZone("IST"));
	  String ist=formatter.format(date);
	  
	  Date date1 = null;
	try {
		date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(ist);
	} catch (ParseException e) {
		
		e.printStackTrace();
	} 
	System.out.println(date1);
	return date1;
	}

	
}
