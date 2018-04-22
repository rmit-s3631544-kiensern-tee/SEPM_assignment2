package jMoSS;

import java.util.Date;

public class Movies {
	
	private String id;
	private String name;
	private String date;
	private String time;
	
	public Movies(String id, String name, String date, String time){
		this.id = id;
		this.name = name;
		this.date = date;
		this.time = time;
	}
	
	public String getID(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public String getTime(){
		return this.time;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDate(String date){
		this.date = date;
	}
	
	public void setTime(String time){
		this.time = time;
	}
	
	@Override
	public String toString(){
		return String.format("Movie id : %s\nMovie name : %s\nDate : %s\nTime : %s\n", 
				this.id,this.name,this.date,this.time);
	}
}
