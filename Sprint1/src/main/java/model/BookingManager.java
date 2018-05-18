package main.java.model;

import java.util.ArrayList;
import java.util.HashSet;

import main.java.model.object.Booking;
import main.java.model.object.Movie;
import main.java.model.object.Session;
import main.java.model.object.Theatre;

public class BookingManager {
	private static BookingManager _instance;
	public static BookingManager GetInstance() {
		if (_instance == null) {
			_instance = new BookingManager();
		}
		return _instance;
	}
	
	private ArrayList<Booking> bookings;
	
	public BookingManager() {
		pendingBookingSeats = new HashSet<Integer>();
		bookings = new ArrayList<Booking>();
	}
	
	// Used for storing the current selected theatre in a booking session.
	private Theatre _selectedTheatre;
	public Theatre GetSelectedTheatre() {
		return _selectedTheatre;
	}
	public void SetSelectedTheatre(Theatre t0) {
		_selectedTheatre = t0;
	}
	
	// Used for storing the current selected movie in a booking session.
	private Movie _selectedMovie;
	public Movie GetSelectedMovie() {
		return _selectedMovie;
	}
	public void SetSelectedMovie(Movie m0) {
		_selectedMovie = m0;
	}
	
	// Used for storing the current selected session in a booking session.
	private Session _selectedSession;
	public Session GetSelectedSession() {
		return _selectedSession;
	}
	public void SetSelectedSession(Session t0) {
		_selectedSession = t0;
	}
	
	private HashSet<Integer> pendingBookingSeats;
	public HashSet<Integer> GetPendingBookingSeats() {
		return pendingBookingSeats;
	}
	public void AddPendingBookingSeats(int number) {
		pendingBookingSeats.add(number);
	}
	public void RemovePendingBookingSeats(int number) {
		pendingBookingSeats.remove(number);
	}
	
	public Booking GetBookingById(int id) {
		for (Booking booking : bookings) {
			if (booking.getBookingId() == id) {
				return booking;
			}
		}
		return null;
	}
	
	public boolean IsSeatBooked(int sessionId,int seatId,boolean includePendingBookings) {
		if (bookings != null) {
			for (Booking booking : bookings) {
				if (booking.getSessionId() == sessionId && booking.getSeats().contains(seatId)) {
					return true;
				}
			}
		}
		if (includePendingBookings) {
			for (Integer seat : pendingBookingSeats) {
				if (seatId == seat) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String GetPendingBookingSeatString() {
		String seatsSelected = "";
		if (BookingManager.GetInstance().GetPendingBookingSeats() != null && BookingManager.GetInstance().GetPendingBookingSeats().size() != 0) {
			for (Integer seat : BookingManager.GetInstance().GetPendingBookingSeats()) {
				if (seat < 5) {
					seatsSelected += "A"+(seat+1)+" ";
				}
				else if (seat < 10) {
					seatsSelected += "B"+((seat+1)-5)+" ";
				}
				else if (seat < 15) {
					seatsSelected += "C"+((seat+1)-10)+" ";
				}
				else if (seat < 20) {
					seatsSelected += "D"+((seat+1)-15)+" ";
				} 
			}
		}
		return seatsSelected;
	}
	
	public Booking CreateBooking(String name,String email,String suburb) {
		//Booking(int id,String name,String email,String suburb,int theMovieId,int theSessionId,ArrayList<Integer> theSeats)
		Booking newBooking = new Booking(
				bookings.size(),
				name,
				email,
				suburb,
				GetSelectedTheatre().getTheatreId(),
				GetSelectedMovie().getMovieId(),
				GetSelectedSession().getSessionId(),
				new ArrayList<Integer>(pendingBookingSeats));
		
		bookings.add(newBooking);
		return newBooking;
	}
}
