package com.zy.model;

import java.util.Date;

public class Lessee {
	private int lid;
	private String lname;
	private String ltel;
	private int lsex;
	private String lnp;
	private String lidCard;
	private Date laddTime;
	@Override
	public String toString() {
		return "lessee [lid=" + lid + ", lname=" + lname + ", ltel=" + ltel + ", lsex=" + lsex + ", lnp=" + lnp
				+ ", lidCard=" + lidCard + ", laddTime=" + laddTime + "]";
	}
	public Lessee() {
		super();
	}
	public Lessee(int lid, String lname, String ltel, int lsex, String lnp, String lidCard, Date laddTime) {
		super();
		this.lid = lid;
		this.lname = lname;
		this.ltel = ltel;
		this.lsex = lsex;
		this.lnp = lnp;
		this.lidCard = lidCard;
		this.laddTime = laddTime;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLtel() {
		return ltel;
	}
	public void setLtel(String ltel) {
		this.ltel = ltel;
	}
	public int getLsex() {
		return lsex;
	}
	public void setLsex(int lsex) {
		this.lsex = lsex;
	}
	public String getLnp() {
		return lnp;
	}
	public void setLnp(String lnp) {
		this.lnp = lnp;
	}
	public String getLidCard() {
		return lidCard;
	}
	public void setLidCard(String lidCard) {
		this.lidCard = lidCard;
	}
	public Date getLaddTime() {
		return laddTime;
	}
	public void setLaddTime(Date laddTime) {
		this.laddTime = laddTime;
	}
}
