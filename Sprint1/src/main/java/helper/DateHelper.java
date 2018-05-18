package main.java.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	public static String ToDateString(Date d0) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		return sdf.format(d0); 
	}
	
	public static String ToTimeString(Date d0) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(d0); 
	}
}
