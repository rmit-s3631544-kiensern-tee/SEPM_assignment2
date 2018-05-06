package main.java.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import main.java.model.object.Movie;
import main.java.model.object.Seat;
import main.java.model.object.Session;
import main.java.model.object.Theatre;
import main.java.model.object.User;

public class TheatreManager {
	private static TheatreManager _instance;
	public static TheatreManager getInstance() {
		if (_instance == null) {
			_instance = new TheatreManager();
		}
		return _instance;
	}
	
	private ArrayList<Theatre> theatres;
	
	public TheatreManager() {
		LoadFromDisk();
		
		// Temp print for debug. REMOVE LATER
		System.out.println("******-- Parsed Theatres + Child class Lists*******");
		for (Theatre theatre : theatres) {
			System.out.println("Name: "+theatre.getName());
			System.out.println("ID: "+theatre.getTheatreId());
			System.out.println("-* Movies: ");
			for (Movie movie : theatre.getMovies()) {
				System.out.println("  Name: "+movie.getMovieName());
				System.out.println("  --* Sessions: ");
				for (Session session : movie.getSessions()) {
					System.out.println("    Time: "+session.getSessionTime());
					System.out.println("    ---* Seats: ");
					for (Seat seat : session.getSessionSeats()) {
						System.out.println("       Status: "+seat.getSeatStatus());
						System.out.println("       Location: "+seat.getSeatLocation());
						System.out.println("       ------");
					}
					System.out.println("    ------");
				}
				System.out.println("  ------");
			}
		}
	}
	
	private void LoadFromDisk() {
		Gson g = new Gson();
		
		try {
			Theatre[] theatreArray = g.fromJson(new FileReader("Sprint1/resources/SEPM-JMOSS-THEATRES.json"), Theatre[].class);
			theatres = new ArrayList<Theatre>(Arrays.asList(theatreArray));
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
