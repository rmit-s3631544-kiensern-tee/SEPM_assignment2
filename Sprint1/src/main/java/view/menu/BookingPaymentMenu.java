package main.java.view.menu;

import java.io.IOException;
import java.util.Scanner;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import main.java.controller.ConsoleController;
import main.java.controller.ConsoleController.Menu;
import main.java.helper.DateHelper;
import main.java.model.BookingManager;
import main.java.model.UserManager;
import main.java.model.object.Booking;
import main.java.model.object.Session;
import main.java.view.ConsoleView;

public class BookingPaymentMenu extends ConsoleView {
	private String nameTyped;
	private String emailTyped;
	private String suburbTyped;
	
	public BookingPaymentMenu() {
		DrawTitle("New Booking");
		DrawView();
	}
	
	public void DrawView() {
		DrawLineBreak(1);
		System.out.println("Booking details:");
		System.out.println("Theatre: "+BookingManager.GetInstance().GetSelectedTheatre().getName());
		System.out.println("Movie: "+BookingManager.GetInstance().GetSelectedMovie().getMovieName());
		System.out.println(String.format("Date: %s", DateHelper.ToDateString(BookingManager.GetInstance().GetSelectedSession().getSessionTime())));
		System.out.println(String.format("Time: %s",DateHelper.ToTimeString(BookingManager.GetInstance().GetSelectedSession().getSessionTime())));
		System.out.println("Seats: "+BookingManager.GetInstance().GetPendingBookingSeatString());
		DrawLineBreak(1);
		
		System.out.println("Please enter booking details:");
		
		DrawLineBreak(1);
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Booking Name:");
		nameTyped = s.nextLine();
        DrawLineBreak(1);
        
        System.out.println("Email:");
        emailTyped = s.nextLine();
        DrawLineBreak(1);
        
        System.out.println("Suburb:");
        suburbTyped = s.nextLine();
        DrawLineBreak(1);
        
        System.out.println("Make payment...");
        DrawLineBreak(1);
        System.out.println("Functions");
		System.out.println("(c) Confirm payment");
		System.out.println("(m) Discard booking and return to main menu");
        
		try {
			ShellFactory.createConsoleShell("jMoSS:", "", this).commandLoop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Command(name="continue", abbrev="c") // Back,
	public void continueBooking() {
		DrawLineBreak(1);
		Booking newBooking = BookingManager.GetInstance().CreateBooking(nameTyped, emailTyped, suburbTyped);
        ConsoleController.GotoMenu(Menu.BookingCompleteMenu,newBooking);
    }
	
	@Command(name="menu", abbrev="m") // Back,
	public void back() {
		DrawLineBreak(1);
    	DrawAlert("Booking canceled!");
    	DrawLineBreak(1);
    	try {
			Thread.sleep(1*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ConsoleController.GotoMenu(Menu.MainMenu);
    }
}
