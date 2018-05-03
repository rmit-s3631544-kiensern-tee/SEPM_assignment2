package main.java;

import main.java.model.BookingManager;
import main.java.model.TheatreManager;
import main.java.model.UserManager;

public class App {

	public static void main(String[] args) {
		// TODO: Change this later, for now we can just call getInstance on each manager to run the parsers
		UserManager.getInstance();
		TheatreManager.getInstance();
		BookingManager.getInstance();
	}

}
