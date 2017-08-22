package com.upgo.dto;

import java.util.ArrayList;

public class Airseat {
	
	private int asNo;
	private int asGrade;
	private int asPrice;
	private int asSeatType;
	private int aNo;
	private int asRealNo;
	
	ArrayList<ReserveAirseat> reserveAirseat;
	
	public int getAsNo() {
		return asNo;
	}
	public void setAsNo(int asNo) {
		this.asNo = asNo;
	}
	public int getAsGrade() {
		return asGrade;
	}
	public void setAsGrade(int asGrade) {
		this.asGrade = asGrade;
	}
	public int getAsPrice() {
		return asPrice;
	}
	public void setAsPrice(int asPrice) {
		this.asPrice = asPrice;
	}
	public int getAsSeatType() {
		return asSeatType;
	}
	public void setAsSeatType(int asSeatType) {
		this.asSeatType = asSeatType;
	}
	public int getaNo() {
		return aNo;
	}
	public void setaNo(int aNo) {
		this.aNo = aNo;
	}
	
	public int getAsRealNo() {
		return asRealNo;
	}
	public void setAsRealNo(int asRealNo) {
		this.asRealNo = asRealNo;
	}
	
	public ArrayList<ReserveAirseat> getReserveAirseat() {
		return reserveAirseat;
	}
	public void setReserveAirseat(ArrayList<ReserveAirseat> reserveAirseat) {
		this.reserveAirseat = reserveAirseat;
	}
	
}
	