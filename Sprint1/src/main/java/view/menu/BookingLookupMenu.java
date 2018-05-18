package main.java.view.menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import main.java.controller.ConsoleController;
import main.java.controller.ConsoleController.Menu;
import main.java.helper.DateHelper;
import main.java.model.BookingManager;
import main.java.model.TheatreManager;
import main.java.model.object.Booking;
import main.java.model.object.Movie;
import main.java.model.object.Session;
import main.java.model.object.Theatre;
import main.java.view.ConsoleView;

public class BookingLookupMenu extends ConsoleView {
	private Booking selectedForDelete;
	public BookingLookupMenu() {
		DrawView(null,false);
	}
	
	public void DrawView(ArrayList<Booking> results,boolean isDelete) {
		DrawTitle("Booking lookup");
		
		if (results != null) {
			if (isDelete) {
				System.out.println("Booking Details:");
			} else {
				System.out.println("Results:");
			}
			for (Booking booking : results) {
				Theatre theatre = TheatreManager.GetInstance().GetTheatreById(booking.getTheatreId());
				Movie movie = theatre.GetMovieById(booking.getMovieId());
				Session session = movie.GetSessionById(booking.getSessionId());
				DrawListDivider();
				System.out.println("Booking Id: "+booking.getBookingId());
				System.out.println("Theatre: "+theatre.getName());
				System.out.println("Movie: "+movie.getMovieName());
				System.out.println(String.format("Date: %s", DateHelper.ToDateString(session.getSessionTime())));
				System.out.println(String.format("Time: %s",DateHelper.ToTimeString(session.getSessionTime())));
				System.out.println("Seats: "+booking.GetSeatString());
				System.out.println("Booking Name: "+booking.getBookingName());
				System.out.println("Email: "+booking.getBookingEmail());
				System.out.println("Suburb: "+booking.getBookingSuburb());
				DrawListDivider();
			}
		}
		if (isDelete) {
			DrawLineBreak(1);
			System.out.println("Are you sure you want to delete this booking?");
		}
		DrawLineBreak(1);
		System.out.println("Functions");
		if (!isDelete) {
			System.out.println("(s id <id>) Lookup by booking id");
			System.out.println("(s email <email>) Lookup by email");
			System.out.println("(d id <id>) Lookup and delete a booking");
		} else {
			System.out.println("(c) Confirm Delete");
		}
		System.out.println("(m) Main menu");
		
		DrawLineBreak(1);
		try {
			ShellFactory.createConsoleShell("jMoSS:", "", this).commandLoop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Command(name="search", abbrev="s") // Search,
    public void search(String mode, String query) {
		ArrayList<Booking> results = new ArrayList<Booking>();
		if (mode.equals("id")) {
			Booking booking = BookingManager.GetInstance().GetBookingById(Integer.parseInt(query));
			if (booking != null) {
				results.add(booking);
			} else {
				DrawAlert("No results for id: "+query);
				return;
			}
		} else if (mode.equals("email")) {
			ArrayList<Booking> theResults = BookingManager.GetInstance().FindBookingsByEmail(query);
			if (theResults == null || theResults.size() == 0) {
				DrawAlert("No results for email: "+query);
				return;
			} else {
				results = theResults;
			}
		} else {
			DrawAlert("Invalid command!");
			return;
		}
		
		DrawView(results,false);
    }
	
	@Command(name="delete", abbrev="d") // Back,
	public void delete(String mode,String query) {
		ArrayList<Booking> results = new ArrayList<Booking>();
		if (mode.equals("id")) {
			Booking booking = BookingManager.GetInstance().GetBookingById(Integer.parseInt(query));
			if (booking != null) {
				selectedForDelete = booking;
				results.add(booking);
			} else {
				DrawAlert("No results for id: "+query);
				return;
			}
		} else {
			DrawAlert("Invalid command!");
			return;
		}
		DrawView(results,true);
    }
	
	@Command(name="confirm", abbrev="c") // Back,
	public void confirmDelete() {
		DrawLineBreak(1);
		if (selectedForDelete == null) {
			return;
		}
		BookingManager.GetInstance().DeleteBooking(selectedForDelete);
		DrawAlert("Booking deleted!");
		try {
			Thread.sleep(1*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ConsoleController.GotoMenu(Menu.MainMenu);
    }
	
	@Command(name="menu", abbrev="m") // Back,
	public void back() {
		DrawLineBreak(1);
        ConsoleController.GotoMenu(Menu.MainMenu);
    }
}
