package com.zy.model;

import java.util.Date;

public class Activity {
	private int aid;
	private Date atime;
	private String asubject;
	private String aintr;
	private String aaddress;
	private double aprince;
	@Override
	public String toString() {
		return "activity [aid=" + aid + ", atime=" + atime + ", asubject=" + asubject + ", aintr=" + aintr
				+ ", aaddress=" + aaddress + ", aprince=" + aprince + "]";
	}
	public Activity() {
		super();
	}
	public Activity(int aid, Date atime, String asubject, String aintr, String aaddress, double aprince) {
		super();
		this.aid = aid;
		this.atime = atime;
		this.asubject = asubject;
		this.aintr = aintr;
		this.aaddress = aaddress;
		this.aprince = aprince;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public Date getAtime() {
		return atime;
	}
	public void setAtime(Date atime) {
		this.atime = atime;
	}
	public String getAsubject() {
		return asubject;
	}
	public void setAsubject(String asubject) {
		this.asubject = asubject;
	}
	public String getAintr() {
		return aintr;
	}
	public void setAintr(String aintr) {
		this.aintr = aintr;
	}
	public String getAaddress() {
		return aaddress;
	}
	public void setAaddress(String aaddress) {
		this.aaddress = aaddress;
	}
	public double getAprince() {
		return aprince;
	}
	public void setAprince(double aprince) {
		this.aprince = aprince;
	}
	
}
