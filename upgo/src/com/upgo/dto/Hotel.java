package com.upgo.dto;

import java.util.ArrayList;

public class Hotel {
	
	private int no;
	private String name;
	private String region;
	private int grade;
	private long rating;
	private int price;
	private long phoneNo;
	private String homepage;
	private int checkIn;
	private int checkOut;
	private String address;
	
	ArrayList<Room> rooms;
		
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public long getRating() {
		return rating;
	}
	public void setRating(long rating) {
		this.rating = rating;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(int checkIn) {
		this.checkIn = checkIn;
	}
	public int getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(int checkOut) {
		this.checkOut = checkOut;
	}
	
}
