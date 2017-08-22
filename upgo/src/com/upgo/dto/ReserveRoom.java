package com.upgo.dto;

import java.util.Date;

public class ReserveRoom {
	
	private int rrmNo;
	private Date rrmCheckInDate;
	private Date rrmCheckOutDate;
	private int rmNo;
	private int sNo;
	public int getRrmNo() {
		return rrmNo;
	}
	public void setRrmNo(int rrmNo) {
		this.rrmNo = rrmNo;
	}
	public Date getRrmCheckInDate() {
		return rrmCheckInDate;
	}
	public void setRrmCheckInDate(Date rrmCheckInDate) {
		this.rrmCheckInDate = rrmCheckInDate;
	}
	public Date getRrmCheckOutDate() {
		return rrmCheckOutDate;
	}
	public void setRrmCheckOutDate(Date rrmCheckOutDate) {
		this.rrmCheckOutDate = rrmCheckOutDate;
	}
	public int getRmNo() {
		return rmNo;
	}
	public void setRmNo(int rmNo) {
		this.rmNo = rmNo;
	}
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

}
