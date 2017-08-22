package com.upgo.dto;

import java.util.ArrayList;

public class Room {

	private int no;
	private int price;
	private int grade;
	private int hNo;
	private int floor;
	private int realNo;
	ArrayList<ReserveRoom> reserveRooms;
		
	//private boolean 
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public ArrayList<ReserveRoom> getReserveRooms() {
		return reserveRooms;
	}
	public void setReserveRooms(ArrayList<ReserveRoom> reserveRooms) {
		this.reserveRooms = reserveRooms;
	}
	public int gethNo() {
		return hNo;
	}
	public void sethNo(int hNo) {
		this.hNo = hNo;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getRealNo() {
		return realNo;
	}
	public void setRealNo(int realNo) {
		this.realNo = realNo;
	}
	
}
