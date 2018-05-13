package main.java.view.menu;

import java.io.FilterInputStream;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.omg.CORBA.DynAnyPackage.Invalid;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import main.java.controller.ConsoleController;
import main.java.controller.ConsoleController.Menu;
import main.java.model.object.Movie;
import main.java.view.ConsoleView;

public class MovieSessionsMenu extends ConsoleView {
	private Movie selectedMovie;
	public MovieSessionsMenu(Movie movie) {
		selectedMovie = movie;
		DrawTitle("Movie session search: West Theatre");
		DrawView();
	}
	
	public void DrawView() {
		DrawLineBreak(1);
		System.out.println("Please select a date to view session time");
		DrawLineBreak(1);
		System.out.println("Functions");
		System.out.println("(t) Choose today's date");
		System.out.println("(s <D> <M> (optional:<Y>)) Choose date e.g. 's 24 12 18'");
		System.out.println("(m) Main Menu");
		DrawLineBreak(1);
		
		try {
			ShellFactory.createConsoleShell("jMoSS:", "", this).commandLoop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Command(name="today", abbrev="t") // List,
	public void select() {
		select(String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)),
			   String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1));
	}
	
	@Command(name="select", abbrev="s") // List,
	public void select(String d,String m) {
		select(d, m, String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
	}
	
	@Command(name="select", abbrev="s") // List,
	public void select(String d,String m,String y) {
		DrawLineBreak(1);
		
		//Try and fix 1 numbered date (e.g. 2 into 02)
		if (d.length() == 1) {
			d = "0"+d;
		}
		if (m.length() == 1) {
			m = "0"+m;
		}
		if (y.length() == 1) {
			y = "0"+y;
		}
		
		// Fix 4 numbered years (e.g. 2018 to 18)
		if (y.length() == 4) {
			y = y.substring(2, 4);
		}
		
		Boolean isError = (d == null || d == "" || d.length() != 2) || 
				  		  (m == null || m == "" || m.length() != 2) ||
				  		  ((y != null && y != "") && (y.length() != 2));
		
		if (isError) {
			DrawAlert("Invalid date, please follow this format: 's DD MM YY'");
			return;
		}
		
		String string = d+m+y;
		DateFormat format = new SimpleDateFormat("ddMMyy", Locale.ENGLISH);
		Date date = null;
		try {
			date = format.parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (date == null) {
			DrawAlert("Invalid date, please follow this format: 's DD MM YY'");
			return;
		}
		
		System.out.println("Date Selected: "+date);
		System.out.println("Continue to session selection and booking...");
		// Continue to next scene
    }
	
	@Command(name="menu", abbrev="m") // Back,
	public void back() {
		DrawLineBreak(1);
        ConsoleController.GotoMenu(Menu.MainMenu);
    }
}
