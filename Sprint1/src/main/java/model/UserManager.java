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
	public static UserManager GetInstance() {
		if (_instance == null) {
			_instance = new UserManager();
		}
		return _instance;
	}
	
	private ArrayList<User> users;
	
	private User currentUser;
	public User GetCurrentUser() {
		return currentUser;
	}
	
	public Boolean IsLoggedIn() {
		return currentUser != null;
	}
	
	public UserManager() {
		LoadFromDisk();
	}
	
	private void LoadFromDisk() {
		Gson g = new Gson();
		
		try {
			User[] userArray = g.fromJson(new FileReader("src/main/resources/jMoSS-Users.json"), User[].class);
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
	
	public Boolean VerifyLogin(String username,String password) {
		for (User user : users) {
			if (user.getUsername().toLowerCase().equals(username.toLowerCase()) && user.getPassword().equals(password)) {
				currentUser = user;
			}
		}
		return IsLoggedIn();
	}
	
	public void LogOut() {
		currentUser = null;
	}
}
