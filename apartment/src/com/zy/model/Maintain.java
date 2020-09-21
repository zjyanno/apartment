package com.zy.model;

import java.util.Date;

public class Maintain {
	private int mid;
	private int mhid;
	private int mloid;
	private Date mtime;
	private String mresult;
	@Override
	public String toString() {
		return "maintain [mid=" + mid + ", mhid=" + mhid + ", mloid=" + mloid + ", mtime=" + mtime + ", mresult="
				+ mresult + "]";
	}
	public Maintain() {
		super();
	}
	public Maintain(int mid, int mhid, int mloid, Date mtime, String mresult) {
		super();
		this.mid = mid;
		this.mhid = mhid;
		this.mloid = mloid;
		this.mtime = mtime;
		this.mresult = mresult;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getMhid() {
		return mhid;
	}
	public void setMhid(int mhid) {
		this.mhid = mhid;
	}
	public int getMloid() {
		return mloid;
	}
	public void setMloid(int mloid) {
		this.mloid = mloid;
	}
	public Date getMtime() {
		return mtime;
	}
	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}
	public String getMresult() {
		return mresult;
	}
	public void setMresult(String mresult) {
		this.mresult = mresult;
	}
}
