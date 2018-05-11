package main.java.view.menu;

import java.util.Scanner;

import main.java.controller.ConsoleController;
import main.java.controller.ConsoleController.Menu;
import main.java.model.UserManager;
import main.java.view.ConsoleView;

public class LoginMenu extends ConsoleView {
	private Scanner s = new Scanner(System.in);
	
	public LoginMenu() {
		DrawIntroView();
		DrawLineBreak(1);
		DrawView();
	}
	
	private void DrawView() {
		System.out.println("Please login with your user identifier:");
		
        String username = s.nextLine();
        if(username == null || username.equals("")) {
        	DrawView();
        	return;
        }
        
        System.out.println("Password:");
        String password = s.nextLine();
        
        if (UserManager.GetInstance().VerifyLogin(username, password)) {
        	// Continue to MainMenu
        	DrawLineBreak(1);
        	DrawAlert("Login Success");
        	try {
				Thread.sleep(1*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	DrawLineBreak(1);
        	ConsoleController.GotoMenu(Menu.MainMenu);
        } else {
        	// Show error and restart.
        	DrawLineBreak(1);
        	DrawAlert("Invalid Username or Password. Please try again.");
        	DrawLineBreak(1);
        	try {
				Thread.sleep(1*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	DrawView();
        }
	}
}
