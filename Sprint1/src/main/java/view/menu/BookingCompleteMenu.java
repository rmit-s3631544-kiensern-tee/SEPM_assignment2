package main.java.view.menu;

import java.io.IOException;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import main.java.controller.ConsoleController;
import main.java.controller.ConsoleController.Menu;
import main.java.helper.DateHelper;
import main.java.model.BookingManager;
import main.java.model.object.Booking;
import main.java.view.ConsoleView;

public class BookingCompleteMenu extends ConsoleView {
	private Booking selectedBooking;
	public BookingCompleteMenu(Booking b0) {
		selectedBooking = b0;
		DrawTitle("Booking Complete!");
		DrawView();
	}
	
	public void DrawView() {
		DrawLineBreak(1);
		System.out.println("The booking has been created!");
		System.out.println("Booking details:");
		DrawLineBreak(1);
		System.out.println("Theatre: "+BookingManager.GetInstance().GetSelectedTheatre().getName());
		System.out.println("Movie: "+BookingManager.GetInstance().GetSelectedMovie().getMovieName());
		System.out.println(String.format("Date: %s", DateHelper.ToDateString(BookingManager.GetInstance().GetSelectedSession().getSessionTime())));
		System.out.println(String.format("Time: %s",DateHelper.ToTimeString(BookingManager.GetInstance().GetSelectedSession().getSessionTime())));
		System.out.println("Seats: "+BookingManager.GetInstance().GetPendingBookingSeatString());
		System.out.println("Booking Name: "+selectedBooking.getBookingName());
		System.out.println("Email: "+selectedBooking.getBookingEmail());
		System.out.println("Suburb: "+selectedBooking.getBookingSuburb());
		DrawLineBreak(1);
        System.out.println("Functions");
		System.out.println("(m) Main Menu");
		try {
			ShellFactory.createConsoleShell("jMoSS:", "", this).commandLoop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Command(name="menu", abbrev="m") // Back,
	public void back() {
		DrawLineBreak(1);
        ConsoleController.GotoMenu(Menu.MainMenu);
    }
}
