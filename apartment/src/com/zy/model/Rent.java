package com.zy.model;

import java.util.Date;

public class Rent {
	private int rid;
	private int rhid;
	private int rlid;
	private double rprice;
	private Date rpatTime;
	@Override
	public String toString() {
		return "rent [rid=" + rid + ", rhid=" + rhid + ", rlid=" + rlid + ", rprice=" + rprice + ", rpatTime="
				+ rpatTime + "]";
	}
	public Rent() {
		super();
	}
	public Rent(int rid, int rhid, int rlid, double rprice, Date rpatTime) {
		super();
		this.rid = rid;
		this.rhid = rhid;
		this.rlid = rlid;
		this.rprice = rprice;
		this.rpatTime = rpatTime;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getRhid() {
		return rhid;
	}
	public void setRhid(int rhid) {
		this.rhid = rhid;
	}
	public int getRlid() {
		return rlid;
	}
	public void setRlid(int rlid) {
		this.rlid = rlid;
	}
	public double getRprice() {
		return rprice;
	}
	public void setRprice(double rprice) {
		this.rprice = rprice;
	}
	public Date getRpatTime() {
		return rpatTime;
	}
	public void setRpatTime(Date rpatTime) {
		this.rpatTime = rpatTime;
	}
}
