package main.java.view.menu;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import main.java.controller.ConsoleController;
import main.java.controller.ConsoleController.Menu;
import main.java.helper.DateHelper;
import main.java.model.BookingManager;
import main.java.model.TheatreManager;
import main.java.model.object.Session;
import main.java.model.object.Theatre;
import main.java.view.ConsoleView;

public class MovieSessionListMenu extends ConsoleView {
	private Date selectedDate;
	private ArrayList<Session> sessionsForDate;
	public MovieSessionListMenu(Date d0) {
		selectedDate = d0;
		sessionsForDate = BookingManager.GetInstance().GetSelectedMovie().GetSessionsForDate(selectedDate);
		
		DrawTitle("Movie session search: West Theatre");
		DrawView();
	}
	
	private void DrawView() {
		DrawLineBreak(1);
		System.out.println(String.format("Date: %s",DateHelper.ToDateString(selectedDate)));
		System.out.println("Select a session time:");
		int i = 1;
		for (Session session : sessionsForDate) {
			System.out.println(String.format("(%d) %s", i,DateHelper.ToTimeString(session.getSessionTime())));
			i++;
		}
		
		DrawLineBreak(1);
		System.out.println("Functions");
		System.out.println("(s <1-"+sessionsForDate.size()+">) Select session");
		System.out.println("(m) Main Menu");
		DrawLineBreak(1);
		
		try {
			ShellFactory.createConsoleShell("jMoSS:", "", this).commandLoop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Command(name="select", abbrev="s") // Select,
	public void select(int selection) {
		DrawLineBreak(1);
		Session session = sessionsForDate.get(selection-1);
        ConsoleController.GotoMenu(Menu.MovieSessionDetails,session);
    }
	
	@Command(name="menu", abbrev="m") // Back,
	public void back() {
		DrawLineBreak(1);
        ConsoleController.GotoMenu(Menu.MainMenu);
    }
}
