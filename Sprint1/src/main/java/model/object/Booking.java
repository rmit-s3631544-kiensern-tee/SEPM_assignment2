package main.java.model.object;

import java.util.ArrayList;

public class Booking {
	public Booking(int id,String name,String email,String suburb,int theTheatreId,int theMovieId,int theSessionId,ArrayList<Integer> theSeats) {
		bookingId = id;
		bookingName = name;
		bookingEmail = email;
		bookingSuburb = suburb;
		theatreId = theTheatreId;
		movieId = theMovieId;
		sessionId = theSessionId;
		seats = theSeats;
	}
	
	private int bookingId;
	public int getBookingId() {
		return bookingId;
	}
	
	private String bookingName;
	public String getBookingName() {
		return bookingName;
	}
	
	private String bookingEmail;
	public String getBookingEmail() {
		return bookingEmail;
	}
	
	private String bookingSuburb;
	public String getBookingSuburb() {
		return bookingSuburb;
	}
	
	private int theatreId;
	public int getTheatreId() {
		return theatreId;
	}
	
	private int movieId;
	public int getMovieId() {
		return movieId;
	}
	
	private int sessionId;
	public int getSessionId() {
		return sessionId;
	}
	
	private ArrayList<Integer> seats;
	public ArrayList<Integer> getSeats() {
		return seats;
	}
}
