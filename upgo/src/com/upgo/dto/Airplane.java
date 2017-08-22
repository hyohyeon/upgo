package com.upgo.dto;

import java.util.ArrayList;
import java.util.Date;

public class Airplane {
	
	private int aNo;
	private String aAirline;
	private String aModel;
	private Date aDepartDay;
	private Date aArrivalDay;
	private String aDepartRegion;
	private String aArrivalRegion;
	private long aGrade;
	private int aFlyingTime;
	ArrayList<Airseat> airseats;
	
	public int getaNo() {
		return aNo;
	}
	public void setaNo(int aNo) {
		this.aNo = aNo;
	}
	public String getaAirline() {
		return aAirline;
	}
	public void setaAirline(String aAirline) {
		this.aAirline = aAirline;
	}
	public String getaModel() {
		return aModel;
	}
	public void setaModel(String aModel) {
		this.aModel = aModel;
	}
	public Date getaDepartDay() {
		return aDepartDay;
	}
	public void setaDepartDay(Date aDepartDay) {
		this.aDepartDay = aDepartDay;
	}
	public Date getaArrivalDay() {
		return aArrivalDay;
	}
	public void setaArrivalDay(Date aArrivalDay) {
		this.aArrivalDay = aArrivalDay;
	}
	public int getaFlyingTime() {
		return aFlyingTime;
	}
	public void setaFlyingTime(int aFlyingTime) {
		this.aFlyingTime = aFlyingTime;
	}
	public String getaDepartRegion() {
		return aDepartRegion;
	}
	public void setaDepartRegion(String aDepartRegion) {
		this.aDepartRegion = aDepartRegion;
	}
	public String getaArrivalRegion() {
		return aArrivalRegion;
	}
	public void setaArrivalRegion(String aArrivalRegion) {
		this.aArrivalRegion = aArrivalRegion;
	}
	public long getaGrade() {
		return aGrade;
	}
	public void setaGrade(long aGrade) {
		this.aGrade = aGrade;
	}
	public ArrayList<Airseat> getAirseats() {
		return airseats;
	}
	public void setAirseats(ArrayList<Airseat> airseats) {
		this.airseats = airseats;
	}
	
}
