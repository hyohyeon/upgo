package com.upgo.dto;

import java.util.ArrayList;
import java.util.Date;

public class threeBoard {
	
	private int PrdNo;
	private String PrdName;
	private int PrdPrice;
	private String PrdDesc;
	private Date PrdRegDate;
	private boolean PrdDeleted;
	
	
	
	public int getPrdNo() {
		return PrdNo;
	}
	public void setPrdNo(int prdNo) {
		PrdNo = prdNo;
	}
	public String getPrdName() {
		return PrdName;
	}
	public void setPrdName(String prdName) {
		PrdName = prdName;
	}
	public int getPrdPrice() {
		return PrdPrice;
	}
	public void setPrdPrice(int prdPrice) {
		PrdPrice = prdPrice;
	}
	public String getPrdDesc() {
		return PrdDesc;
	}
	public void setPrdDesc(String prdDesc) {
		PrdDesc = prdDesc;
	}
	public Date getPrdRegDate() {
		return PrdRegDate;
	}
	public void setPrdRegDate(Date prdRegDate) {
		PrdRegDate = prdRegDate;
	}
	public boolean isPrdDeleted() {
		return PrdDeleted;
	}
	public void setPrdDeleted(boolean prdDeleted) {
		PrdDeleted = prdDeleted;
	}
	
	
}	
	