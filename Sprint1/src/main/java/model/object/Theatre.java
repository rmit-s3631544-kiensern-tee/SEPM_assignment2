package main.java.model.object;

import java.util.ArrayList;

public class Theatre {
	// Json editor online. Goto this url to edit
	// https://jsoneditoronline.org/?id=11670efa35144de58a6503b6eab26446
	
	private String theatreName;
	public String getName() {
		return theatreName;
	}
	private int theatreId;
	public int getTheatreId() {
		return theatreId;
	}
	private ArrayList<Movie> movies;
	public ArrayList<Movie> getMovies() {
		return movies;
	}
	
	public ArrayList<Movie> SearchForMovieByName(String query) {
		ArrayList<Movie> finalList = new ArrayList<Movie>();
		if (movies != null && movies.size() != 0) {
			for (Movie movie : movies) {
				if (movie.getMovieName().toLowerCase().contains(query.toLowerCase())) {
					finalList.add(movie);
				}
			}
		}
		return finalList;
	}
}
