package main.java.controller;

import java.io.IOException;

import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import main.java.model.object.Theatre;
import main.java.view.ConsoleView;
import main.java.view.menu.LoginMenu;
import main.java.view.menu.MainMenu;
import main.java.view.menu.MovieSelectMenu;
import main.java.view.menu.TheatreSelectMenu;

public class ConsoleController {
	private static ConsoleView currentView;
	
	public enum Menu {
		LoginMenu,
		MainMenu,
		TheatreSelectMenu,
		MovieSelectMenu
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
			case MovieSelectMenu: {
				if (arg == null || arg.getClass() != Theatre.class) {
					System.out.println("ERROR: Invalid class passed into GotoMenu(Menu.MovieSelectMenu)");
					break;
				}
				currentView = new MovieSelectMenu((Theatre)arg);
				break;
			}
			default:
				break;
		}
	}
}
