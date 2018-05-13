package main.java.view.menu;

import java.io.IOException;

import asg.cliche.Command;
import asg.cliche.Input;
import asg.cliche.InputConverter;
import asg.cliche.ShellFactory;
import main.java.controller.ConsoleController;
import main.java.controller.ConsoleController.Menu;
import main.java.model.UserManager;
import main.java.view.ConsoleView;

public class MainMenu extends ConsoleView {
	public MainMenu() {
		DrawTitle("Main Menu");
		DrawMenu();
	}
	
	private void DrawMenu() {
		DrawLineBreak(1);
		System.out.println("Select a function:");
		System.out.println("(s) Search for a movie");
		System.out.println("(e) Edit a booking");
		System.out.println("(l) Logout");
		DrawLineBreak(1);
		try {
			ShellFactory.createConsoleShell("jMoSS:", "", this).commandLoop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Command(name="search", abbrev="s") // Search,
    public void search() {
		DrawLineBreak(1);
        ConsoleController.GotoMenu(Menu.TheatreSelectMenu);
    }
	
	@Command(name="edit", abbrev="e") // Edit,
	public void edit() {
		System.out.println("Edit Selected");
    }
	
	@Command(name="logout", abbrev="l") // Back, // Logout,
	public void logout() {
        UserManager.GetInstance().LogOut();
        DrawLineBreak(1);
        DrawAlert("Logged out");
        DrawLineBreak(1);
        
        ConsoleController.GotoMenu(Menu.LoginMenu);
    }
}
