package com.accp.pojo;

/**
 * 星级服务表
 */
public class Star {
	private int sid; // 编号
	private int stid; // 服务类型编号
	private String stname; // 服务类型
	private String sname; // 位置名
	private int price; // 月租金
	private int status; // 位置状态（已租/未租）
	private int sort; // 排序

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getStid() {
		return stid;
	}

	public void setStid(int stid) {
		this.stid = stid;
	}

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public Star(int sid, int stid, String stname, String sname, int price, int status, int sort) {
		super();
		this.sid = sid;
		this.stid = stid;
		this.stname = stname;
		this.sname = sname;
		this.price = price;
		this.status = status;
		this.sort = sort;
	}

	public Star() {
		super();
	}

}