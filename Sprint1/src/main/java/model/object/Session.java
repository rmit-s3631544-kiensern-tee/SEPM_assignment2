package main.java.model.object;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Session {
	private int sessionId;
	public int getSessionId() {
		return sessionId;
	}
	
	private String sessionTime;
	private Date sessionTimeDate;
	public Date getSessionTime() {
		// TODO: Need to implement this to return correct times
		if (sessionTimeDate != null) {
			return sessionTimeDate;
		}
		
		DateFormat format = new SimpleDateFormat("dd-MM-yy HH:mm", Locale.ENGLISH);
		try {
			sessionTimeDate = format.parse(sessionTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sessionTimeDate;
	}
	
	private ArrayList<Seat> sessionSeats;
	public ArrayList<Seat> getSessionSeats() {
		return sessionSeats;
	}
	
	public int getAvailableSeatCount() {
		int count = 0;
		for (Seat seat : sessionSeats) {
			count += seat.getSeatStatus() == 0 ? 1:0;
		}
		return count;
	}
}
