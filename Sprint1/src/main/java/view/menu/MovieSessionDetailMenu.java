package main.java.view.menu;

import java.io.IOException;
import java.util.Calendar;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import main.java.controller.ConsoleController;
import main.java.controller.ConsoleController.Menu;
import main.java.helper.DateHelper;
import main.java.model.BookingManager;
import main.java.model.object.Movie;
import main.java.model.object.Session;
import main.java.view.ConsoleView;

public class MovieSessionDetailMenu extends ConsoleView {
	private Session selectedSession;
	public MovieSessionDetailMenu(Session s0) {
		selectedSession = s0;
		DrawTitle("Movie session search: West Theatre");
		DrawView();
	}
	
	public void DrawView() {
		DrawLineBreak(1);
		System.out.println("Session details:");
		System.out.println("Theatre: "+BookingManager.GetInstance().GetSelectedTheatre().getName());
		System.out.println("Movie: "+BookingManager.GetInstance().GetSelectedMovie().getMovieName());
		System.out.println(String.format("Date: %s", DateHelper.ToDateString(selectedSession.getSessionTime())));
		System.out.println(String.format("Time: %s",DateHelper.ToTimeString(selectedSession.getSessionTime())));
	
		DrawLineBreak(1);
		System.out.println("Functions");
		System.out.println("(c) Create booking");
		System.out.println("(m) Main Menu");
		DrawLineBreak(1);
		
		try {
			ShellFactory.createConsoleShell("jMoSS:", "", this).commandLoop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Command(name="create", abbrev="c") // Select,
	public void createBooking() {
		DrawLineBreak(1);
        ConsoleController.GotoMenu(Menu.BookingSeatSelection);
    }
	
	@Command(name="menu", abbrev="m") // Back,
	public void back() {
		DrawLineBreak(1);
        ConsoleController.GotoMenu(Menu.MainMenu);
    }
}
