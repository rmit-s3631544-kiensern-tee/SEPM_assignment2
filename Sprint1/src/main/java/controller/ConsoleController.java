package main.java.controller;

import java.io.IOException;

import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import main.java.view.ConsoleView;
import main.java.view.menu.LoginMenu;
import main.java.view.menu.MainMenu;

public class ConsoleController {
	private static ConsoleView currentView;
	
	public enum Menu {
		LoginMenu,
		MainMenu
	}
	public static Menu currentMenu;
	
	public static void GotoMenu(Menu menu) {
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
			default:
				break;
		}
	}
}
