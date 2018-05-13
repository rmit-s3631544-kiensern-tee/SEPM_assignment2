package main.java;

import main.java.controller.ConsoleController;
import main.java.controller.ConsoleController.Menu;
import main.java.model.BookingManager;
import main.java.model.TheatreManager;
import main.java.model.UserManager;
import main.java.view.ConsoleView;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import java.io.IOException;

public class App {
	public static final Boolean verbose = true;
	
	public static void main(String[] args) {
		// Init model (Parse Json)
		UserManager.GetInstance();
		BookingManager.GetInstance();
		TheatreManager.GetInstance();
		
		// Begin console session
		if (verbose) {
			ConsoleController.GotoMenu(Menu.MainMenu);
		} else {
			ConsoleController.GotoMenu(Menu.LoginMenu);
		}
	}
}
