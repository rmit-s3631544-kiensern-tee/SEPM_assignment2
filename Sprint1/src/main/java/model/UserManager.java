package main.java.model;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

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
		
		// Temp print for debug. REMOVE LATER
		System.out.println("******-- Parsed Users*******");
		for (User user : users) {
			System.out.println("Username: "+user.getUsername());
			System.out.println("ID: "+user.getUserId());
			System.out.println("Password: HIDDEN");
		}
	}
	
	private void LoadFromDisk() {
		Gson g = new Gson();
		
		try {
			User[] userArray = g.fromJson(new FileReader("resources/jMoSS-Users.json"), User[].class);
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
}
