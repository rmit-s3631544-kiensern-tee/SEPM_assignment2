package main.java.model;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import main.java.model.object.User;

public class UserManager {
	private static UserManager _instance;
	public static UserManager getInstance() {
		if (_instance == null) {
			_instance = new UserManager();
		}
		return _instance;
	}
	
	private ArrayList<User> users;
	
	public UserManager() {
		LoadFromDisk();
	}
	
	private void LoadFromDisk() {
		Gson g = new Gson();
		
		try {
			User[] userArray = g.fromJson(new FileReader("Sprint1/resources/jMoSS-Users.json"), User[].class);
			users = new ArrayList<User>(Arrays.asList(userArray));
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean user_input() {
		boolean logged_in = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER USERNAME : ");
		String name = sc.nextLine();
		System.out.println("ENTER PASSWORD : ");
		String password = sc.nextLine();
		System.out.println("******-- Parsed Users*******");
		for (User user : users) {
			if (user.getUsername().equals(name) && user.getPassword().equals(password)) {
				System.out.println(user.getUserId());
				logged_in = true;
			}
		}
		return logged_in;
	}
}
