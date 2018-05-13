package main.java.view.menu;

import java.io.IOException;
import java.util.ArrayList;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import main.java.controller.ConsoleController;
import main.java.controller.ConsoleController.Menu;
import main.java.model.TheatreManager;
import main.java.model.object.Movie;
import main.java.model.object.Theatre;
import main.java.view.ConsoleView;

public class MovieQueryMenu extends ConsoleView {
	private Theatre selectedTheatre;
	public MovieQueryMenu(Theatre s0) {
		selectedTheatre = s0;
		DrawTitle("Movie session search: "+s0.getName());
		DrawView();
	}
	
	private void DrawView() {
		DrawLineBreak(1);
		System.out.println("Functions");
		System.out.println("(s <query>) Search by movie name");
		System.out.println("(l) List all movies");
		System.out.println("(b) Go back");
		DrawLineBreak(1);
		try {
			ShellFactory.createConsoleShell("jMoSS:", "", this).commandLoop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Command(name="search", abbrev="s") // Search,
	public void search(String query) {
		DrawLineBreak(1);
		ArrayList<Movie> results = selectedTheatre.SearchForMovieByName(query);
		
		if (results.size() == 0) {
			DrawAlert("No results for '"+query+"'. Try again");
		} else {
			DrawTitle("Movie session search: "+selectedTheatre.getName());
			DrawAlert("Results for '"+query+"'");
			ConsoleController.GotoMenu(Menu.MovieQueryResultsMenu, results);
		}
    }
	
	@Command(name="list", abbrev="l") // List,
	public void list() {
		DrawLineBreak(1);
		DrawTitle("Movie session search: "+selectedTheatre.getName());
		DrawAlert("All Movies: "+selectedTheatre.getName());
		ArrayList<Movie> movies = selectedTheatre.getMovies();
		ConsoleController.GotoMenu(Menu.MovieQueryResultsMenu, movies);
    }
	
	@Command(name="back", abbrev="b") // Back,
	public void back() {
		DrawLineBreak(1);
        ConsoleController.GotoMenu(Menu.TheatreSelectMenu);
    }
}
