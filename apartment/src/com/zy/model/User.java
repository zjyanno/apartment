package com.zy.model;

import java.util.Date;

public class User {
	private int uid;
	private String uname;
	private String upassword;
	private String urealname;
	private Date uaddTime;
	private int ustatus;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUrealname() {
		return urealname;
	}
	public void setUrealname(String urealname) {
		this.urealname = urealname;
	}
	public Date getUaddTime() {
		return uaddTime;
	}
	public void setUaddTime(Date uaddTime) {
		this.uaddTime = uaddTime;
	}
	public int getUstatus() {
		return ustatus;
	}
	public void setUstatus(int ustatus) {
		this.ustatus = ustatus;
	}
	public User(int uid, String uname, String upassword, String urealname, Date uaddTime, int ustatus) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.urealname = urealname;
		this.uaddTime = uaddTime;
		this.ustatus = ustatus;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upassword=" + upassword + ", urealname=" + urealname
				+ ", uaddTime=" + uaddTime + ", ustatus=" + ustatus + "]";
	}
	
}
