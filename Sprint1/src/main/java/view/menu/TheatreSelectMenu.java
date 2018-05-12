package main.java.view.menu;

import java.io.IOException;
import java.util.ArrayList;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import main.java.controller.ConsoleController;
import main.java.controller.ConsoleController.Menu;
import main.java.model.TheatreManager;
import main.java.model.object.Theatre;
import main.java.view.ConsoleView;

public class TheatreSelectMenu extends ConsoleView {
	public TheatreSelectMenu() {
		DrawTitle("Movie session search");
		DrawView();
	}
	
	private void DrawView() {
		DrawLineBreak(1);
		System.out.println("Select Theatre:");
		ArrayList<Theatre> theatres = TheatreManager.GetInstance().GetTheatres();
		for (int i = 0; i < theatres.size(); i++) {
			System.out.println("("+(i+1)+") "+theatres.get(i).getName());
		}
		DrawLineBreak(1);
		System.out.println("Functions");
		System.out.println("(s <1-"+theatres.size()+">) Select theatre");
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
    public void s(int selection) {
		DrawLineBreak(1);
		ArrayList<Theatre> theatres = TheatreManager.GetInstance().GetTheatres();
		if (selection <= theatres.size() && selection > 0) {
			Theatre theatre = theatres.get(selection-1);
			DrawLineBreak(1);
			ConsoleController.GotoMenu(Menu.MovieSelectMenu,theatre);
		} else {
			DrawAlert("Invalid selection.");
		}
    }
	
	@Command // Search,
    public void b() {
		DrawLineBreak(1);
        ConsoleController.GotoMenu(Menu.MainMenu);
    }
}
