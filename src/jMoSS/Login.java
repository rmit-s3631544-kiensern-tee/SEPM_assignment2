package jMoSS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Login {
	private String username;
	private String password;
	private List<Login> loginlist = new ArrayList<>();
	
	public Login(String user, String Pass) {
		this.username = user;
		this.password = Pass;	
	}
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public void readfile() {
		final String sourcefile = "user.txt";

		try (Scanner sc = new Scanner(new File(sourcefile))) {
			while (sc.hasNextLine()) {
				String users = sc.nextLine();
				setuser(users);
			}
		} catch (FileNotFoundException fnf) {
			System.err.printf("%s file not found\n", sourcefile);
		}
	}
	
	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}
	
	public void setuser(String users) {
		String[] line = users.split("\\|\\|");
		String user = line[0];
		String pass = line[1];
		Login login = new Login(user, pass);
		loginlist.add(login);
	}
	
	public boolean verifyuser(String user, String pass) {
		readfile();
		for (int i = 0; i < loginlist.size(); i++) {
			if (loginlist.get(i).getUsername().equals(user) && loginlist.get(i).getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return String.format("Username : %s\nPassword: %s\n", 
				this.username, this.password);
	}
	
	public String getAll(){
		readfile();
		return this.loginlist.toString();
	}

	public static void main(String[] args) {
		Login login = new Login();
//		String user = "tee";
//		String pass = "tee123";
//		System.out.println(login.verifyuser(user, pass));
		System.out.println(login.getAll());
	}
	
}
