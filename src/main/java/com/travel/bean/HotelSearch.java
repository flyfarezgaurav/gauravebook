package com.travel.bean;

import java.util.ArrayList;
import java.util.List;

public class HotelSearch {

	private String stayCity;
	private String checkIn;
	private String checkOut;
	private String guest;
	private List<Room> rooms = new ArrayList<Room>();
	private int numberOfDays;
	
	public String getStayCity() {
		return stayCity;
	}
	public void setStayCity(String stayCity) {
		this.stayCity = stayCity;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public String getGuest() {
		return guest;
	}
	public void setGuest(String guest) {
		this.guest = guest;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	
	
	
}
