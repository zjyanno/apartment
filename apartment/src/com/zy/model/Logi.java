package com.zy.model;

import java.util.Date;

public class Logi {
	private int loid;
	private String loname;
	private String loidCard;
	private String lotel;
	private int losex;
	private Date loaddTime;
	private double losalary;
	@Override
	public String toString() {
		return "logi [loid=" + loid + ", loname=" + loname + ", loidCard=" + loidCard + ", lotel=" + lotel + ", losex="
				+ losex + ", loaddTime=" + loaddTime + ", losalary=" + losalary + "]";
	}
	public Logi() {
		super();
	}
	public Logi(int loid, String loname, String loidCard, String lotel, int losex, Date loaddTime, double losalary) {
		super();
		this.loid = loid;
		this.loname = loname;
		this.loidCard = loidCard;
		this.lotel = lotel;
		this.losex = losex;
		this.loaddTime = loaddTime;
		this.losalary = losalary;
	}
	public int getLoid() {
		return loid;
	}
	public void setLoid(int loid) {
		this.loid = loid;
	}
	public String getLoname() {
		return loname;
	}
	public void setLoname(String loname) {
		this.loname = loname;
	}
	public String getLoidCard() {
		return loidCard;
	}
	public void setLoidCard(String loidCard) {
		this.loidCard = loidCard;
	}
	public String getLotel() {
		return lotel;
	}
	public void setLotel(String lotel) {
		this.lotel = lotel;
	}
	public int getLosex() {
		return losex;
	}
	public void setLosex(int losex) {
		this.losex = losex;
	}
	public Date getLoaddTime() {
		return loaddTime;
	}
	public void setLoaddTime(Date loaddTime) {
		this.loaddTime = loaddTime;
	}
	public double getLosalary() {
		return losalary;
	}
	public void setLosalary(double losalary) {
		this.losalary = losalary;
	}
}
