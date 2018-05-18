package main.java.model.object;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Movie {
	private ArrayList<Session> sessions;
	public ArrayList<Session> getSessions() {
		return sessions;
	}
	private String movieName;
	public String getMovieName() {
		return movieName;
	}
	
	private int movieId;
	public int getMovieId() {
		return movieId;
	}
	
	public Boolean HasSessionForDate(Date date) {
		Calendar queryCal = Calendar.getInstance();
		queryCal.setTime(date);
		
		for (Session session : sessions) {
			Calendar sessionCal = Calendar.getInstance();
			sessionCal.setTime(session.getSessionTime());
			
			int year1 = queryCal.get(Calendar.YEAR);
			int year2 = sessionCal.get(Calendar.YEAR);
			int month1 = queryCal.get(Calendar.DAY_OF_YEAR);
			int month2 = sessionCal.get(Calendar.DAY_OF_YEAR);
			if (queryCal.get(Calendar.YEAR) == sessionCal.get(Calendar.YEAR) && queryCal.get(Calendar.DAY_OF_YEAR) == sessionCal.get(Calendar.DAY_OF_YEAR)) 
			{
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Session> GetSessionsForDate(Date date) {
		Calendar queryCal = Calendar.getInstance();
		queryCal.setTime(date);
		
		ArrayList<Session> sessionsForDate = new ArrayList<Session>();
		for (Session session : sessions) {
			Calendar sessionCal = Calendar.getInstance();
			sessionCal.setTime(session.getSessionTime());
			
			int year1 = queryCal.get(Calendar.YEAR);
			int year2 = sessionCal.get(Calendar.YEAR);
			int month1 = queryCal.get(Calendar.DAY_OF_YEAR);
			int month2 = sessionCal.get(Calendar.DAY_OF_YEAR);
			if (queryCal.get(Calendar.YEAR) == sessionCal.get(Calendar.YEAR) && queryCal.get(Calendar.DAY_OF_YEAR) == sessionCal.get(Calendar.DAY_OF_YEAR)) 
			{
				sessionsForDate.add(session);
			}
		}
		return sessionsForDate;
	}
	
	public Session GetSessionById(int id) {
		for (Session session : sessions) {
			if (session.getSessionId() == id) {
				return session;
			}
		}
		return null;
	}
}
