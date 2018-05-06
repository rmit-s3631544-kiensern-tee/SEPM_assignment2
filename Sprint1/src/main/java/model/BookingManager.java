package main.java.model;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.model.object.Booking;
import main.java.model.object.Theatre;

public class BookingManager {
	private static BookingManager _instance;
	public static BookingManager getInstance() {
		if (_instance == null) {
			_instance = new BookingManager();
		}
		return _instance;
	}
	
	private ArrayList<Booking> bookings;
	
	public BookingManager() {
		
	}
	
	public Booking GetBookingById(int id) {
		for (Booking booking : bookings) {
			if (booking.getBookingId() == id) {
				return booking;
			}
		}
		return null;
	}
	
	private TheatreManager theatre = new TheatreManager();
	public void CreateBooking(int userid) {
		int user = userid;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer's email :");
		String customer = sc.nextLine();
		System.out.println("Enter suburb :");
		String suburb = sc.nextLine();
		Theatre current = theatre.searchTheatreByName();  
		System.out.println(current.toString());  // for testing purpose remove later 
		
		
	}
}
