package main.java.model.object;

import java.util.ArrayList;

public class Movie {
	private ArrayList<Session> sessions;
	public ArrayList<Session> getSessions() {
		return sessions;
	}
	private String movieName;
	public String getMovieName() {
		return movieName;
	}
}
