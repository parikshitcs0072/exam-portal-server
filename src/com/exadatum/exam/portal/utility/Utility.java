package com.exadatum.exam.portal.utility;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utility {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public static Date parseDate(String strDate){
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}

}
