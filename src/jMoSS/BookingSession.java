package jMoSS;

import java.util.*;

public class BookingSession {

	private String id;
	private String name;
	List<String> seats = new ArrayList<>();
	private Movies movie;
	
	
	public BookingSession(String id, String name, Movies movie){
		this.id = id;
		this.name = name;
		this.movie = movie;
	}
	
	
	public String getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Movies getMovie(){
		return this.movie;
	}
	
	public void addSeat(String seatid){
		seats.add(seatid);
	}
	
	public int count(){
		return seats.size();
	}
	
	public boolean removeSeat(String seatid){
		return seats.remove(seatid);
	}
	
	public String toString(){
		return String.format("Booking ID: %s\nBooking Name: %s\nMovie :%s\nSeats : %s\n", 
				this.id, this.name, this.movie.toString(),this.seats.toString());
	}
	
//	public static void main(String[] args) {
//		Movies movie = new Movies("m01","kong","23-4-2018","4.07pm");
//		BookingSession session = new BookingSession("b1","chris",movie);
//		session.addSeat("b1");
//		session.addSeat("b2");
//		session.addSeat("b3");
//		session.removeSeat("b1");
//		System.out.println(session.toString());
//	}
}
