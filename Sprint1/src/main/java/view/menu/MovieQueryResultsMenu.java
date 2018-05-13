package main.java.view.menu;

import java.io.IOException;
import java.util.ArrayList;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import main.java.controller.ConsoleController;
import main.java.controller.ConsoleController.Menu;
import main.java.model.object.Movie;
import main.java.model.object.Theatre;
import main.java.view.ConsoleView;

public class MovieQueryResultsMenu extends ConsoleView {
	private ArrayList<Movie> results;
	
	public MovieQueryResultsMenu(ArrayList<Movie> s0) {
		results = s0;
		DrawView();
	}
	
	private void DrawView() {
		for (int i = 0; i < results.size(); i++) {
			System.out.println("("+(i+1)+") "+results.get(i).getMovieName());
		}
		DrawLineBreak(1);
		System.out.println("Functions");
		System.out.println("(s <1-"+results.size()+">) Select a movie");
		System.out.println("(m) Main Menu");
		DrawLineBreak(1);
		try {
			ShellFactory.createConsoleShell("jMoSS:", "", this).commandLoop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Command(name="select", abbrev="s") // List,
	public void select(int selection) {
		DrawLineBreak(1);
		
		Movie movie = results.get(selection);
		// Goto next view
		ConsoleController.GotoMenu(Menu.MovieSessions, movie);
    }
	
	@Command(name="menu", abbrev="m") // Back,
	public void back() {
		DrawLineBreak(1);
        ConsoleController.GotoMenu(Menu.MainMenu);
    }
}
