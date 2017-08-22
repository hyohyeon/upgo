package com.upgo.dto;

import java.util.ArrayList;
import java.util.Date;

/**
 * Scheduling 테이블의 데이터와 매핑되는 DTO클래스
 * 사용자가 가지고있는 여행계획을 관리하는 역할
 * @author Changwooha
 *
 */

public class Scheduling {
	
	private int no;
	private String customer;
	private Date dateS;
	private Date dateF;
	private int budget;
	private int totalday;
	private String interestregion;
	private String departregion;
	private int totalPrice;
	ArrayList<ReserveAirseat> reserveAirseats;
	ArrayList<ReserveRoom> reserveRooms;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Date getDateS() {
		return dateS;
	}
	public void setDateS(Date dateS) {
		this.dateS = dateS;
	}
	public Date getDateF() {
		return dateF;
	}
	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public int getTotalday() {
		return totalday;
	}
	public void setTotalday(int totalday) {
		this.totalday = totalday;
	}
	public String getInterestregion() {
		return interestregion;
	}
	public void setInterestregion(String interestregion) {
		this.interestregion = interestregion;
	}
	public ArrayList<ReserveAirseat> getReserveAirseats() {
		return reserveAirseats;
	}
	public void setReserveAirseats(ArrayList<ReserveAirseat> reserveAirseats) {
		this.reserveAirseats = reserveAirseats;
	}
	public ArrayList<ReserveRoom> getReserveRooms() {
		return reserveRooms;
	}
	public void setReserveRooms(ArrayList<ReserveRoom> reserveRooms) {
		this.reserveRooms = reserveRooms;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getDepartregion() {
		return departregion;
	}
	public void setDepartregion(String departregion) {
		this.departregion = departregion;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}
