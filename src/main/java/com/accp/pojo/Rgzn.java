package com.accp.pojo;

import java.util.Date;

public class Rgzn {
	private int id;// int(11) NOT NULL
	private int userid;// int(11) NULL用户id
	private int stid;// int(11) NULL服务id
	private int fwtempid;// int(11) NULL1.国家 2.类别 3.级别 4.鉴定
	private int oftenid;// int(11) NULL所有id
	private Date checktime;// date NULL点击时间

	public Rgzn() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getStid() {
		return stid;
	}

	public void setStid(int stid) {
		this.stid = stid;
	}

	public int getFwtempid() {
		return fwtempid;
	}

	public void setFwtempid(int fwtempid) {
		this.fwtempid = fwtempid;
	}

	public int getOftenid() {
		return oftenid;
	}

	public void setOftenid(int oftenid) {
		this.oftenid = oftenid;
	}

	public Date getChecktime() {
		return checktime;
	}

	public void setChecktime(Date checktime) {
		this.checktime = checktime;
	}
}
