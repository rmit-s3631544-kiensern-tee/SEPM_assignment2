package main.java.model.object;

import java.util.ArrayList;
import java.util.Date;

public class Session {
	private int sessionTime;
	public Date getSessionTime() {
		// TODO: Need to implement this to return correct times
		return new Date();
	}
	
	private ArrayList<Seat> sessionSeats;
	public ArrayList<Seat> getSessionSeats() {
		return sessionSeats;
	}
}
