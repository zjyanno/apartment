package com.zy.model;

import java.util.Date;

public class Contract {
	private int cid;
	private String cnum;
	private int chid;
	private int clid;
	private Date ctime;
	private Date cstartTime;
	private Date cendTime;
	private double ctotalMoney;
	private int cpayType;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCnum() {
		return cnum;
	}
	public void setCnum(String cnum) {
		this.cnum = cnum;
	}
	public int getChid() {
		return chid;
	}
	public void setChid(int chid) {
		this.chid = chid;
	}
	public int getClid() {
		return clid;
	}
	public void setClid(int clid) {
		this.clid = clid;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public Date getCstartTime() {
		return cstartTime;
	}
	public void setCstartTime(Date cstartTime) {
		this.cstartTime = cstartTime;
	}
	public Date getCendTime() {
		return cendTime;
	}
	public void setCendTime(Date cendTime) {
		this.cendTime = cendTime;
	}
	public double getCtotalMoney() {
		return ctotalMoney;
	}
	public void setCtotalMoney(double ctotalMoney) {
		this.ctotalMoney = ctotalMoney;
	}
	public int getCpayType() {
		return cpayType;
	}
	public void setCpayType(int cpayType) {
		this.cpayType = cpayType;
	}
	public Contract(int cid, String cnum, int chid, int clid, Date ctime, Date cstartTime, Date cendTime,
			double ctotalMoney, int cpayType) {
		super();
		this.cid = cid;
		this.cnum = cnum;
		this.chid = chid;
		this.clid = clid;
		this.ctime = ctime;
		this.cstartTime = cstartTime;
		this.cendTime = cendTime;
		this.ctotalMoney = ctotalMoney;
		this.cpayType = cpayType;
	}
	public Contract() {
		super();
	}
	@Override
	public String toString() {
		return "Contract [cid=" + cid + ", cnum=" + cnum + ", chid=" + chid + ", clid=" + clid + ", ctime=" + ctime
				+ ", cstartTime=" + cstartTime + ", cendTime=" + cendTime + ", ctotalMoney=" + ctotalMoney
				+ ", cpayType=" + cpayType + "]";
	}
	
}
