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

public class MovieSelectMenu extends ConsoleView {
	private Theatre selectedTheatre;
	public MovieSelectMenu(Theatre s0) {
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
	
	@Command // Search,
    public void s(String query) {
		DrawLineBreak(1);
		ArrayList<Movie> results = selectedTheatre.SearchForMovieByName(query);
		
		if (results.size() == 0) {
			DrawAlert("No results for '"+query+"'. Try again");
		} else {
			
		}
    }
	
	@Command // List,
    public void l() {
		DrawLineBreak(1);
		DrawAlert("All Movies:");
		ArrayList<Movie> movies = selectedTheatre.getMovies();
		for (int i = 0; i < movies.size(); i++) {
			System.out.println("("+(i+1)+") "+movies.get(i).getMovieName());
		}
    }
	
	@Command // Back,
    public void b() {
		DrawLineBreak(1);
        ConsoleController.GotoMenu(Menu.TheatreSelectMenu);
    }
}
