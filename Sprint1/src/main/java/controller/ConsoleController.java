package main.java.controller;

import java.io.IOException;
import java.util.ArrayList;

import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import main.java.model.object.Movie;
import main.java.model.object.Theatre;
import main.java.view.ConsoleView;
import main.java.view.menu.LoginMenu;
import main.java.view.menu.MainMenu;
import main.java.view.menu.MovieQueryMenu;
import main.java.view.menu.MovieQueryResultsMenu;
import main.java.view.menu.MovieSessionsMenu;
import main.java.view.menu.TheatreSelectMenu;

public class ConsoleController {
	private static ConsoleView currentView;
	
	public enum Menu {
		LoginMenu,
		MainMenu,
		TheatreSelectMenu,
		MovieQueryMenu,
		MovieQueryResultsMenu,
		MovieSessions
	}
	public static Menu currentMenu;
	
	public static void GotoMenu(Menu menu) {
		GotoMenu(menu,null);
	}
	
	public static void GotoMenu(Menu menu,Object arg) {
		currentMenu = menu;
		
		switch (menu) {
			case LoginMenu: {
				currentView = new LoginMenu();
				break;
			}
			case MainMenu: {
				currentView = new MainMenu();
				break;
			}
			case TheatreSelectMenu: {
				currentView = new TheatreSelectMenu();
				break;
			}
			case MovieQueryMenu: {
				if (arg == null || arg.getClass() != Theatre.class) {
					System.out.println("ERROR: Invalid class passed into GotoMenu(Menu.MovieSelectMenu)");
					break;
				}
				currentView = new MovieQueryMenu((Theatre)arg);
				break;
			}
			case MovieQueryResultsMenu: {
				if (arg == null || arg.getClass() != ArrayList.class) {
					System.out.println("ERROR: Invalid class passed into GotoMenu(Menu.MovieQueryResultsMenu)");
					break;
				}
				currentView = new MovieQueryResultsMenu((ArrayList<Movie>)arg);
				break;
			}
			case MovieSessions: {
				if (arg == null || arg.getClass() != Movie.class) {
					System.out.println("ERROR: Invalid class passed into GotoMenu(Menu.MovieQueryResultsMenu)");
					break;
				}
				currentView = new MovieSessionsMenu((Movie)arg);
				break;
			}
			default:
				break;
		}
	}
}
