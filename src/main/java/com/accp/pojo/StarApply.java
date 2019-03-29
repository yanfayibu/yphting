package com.accp.pojo;

import java.util.Date;

/**
 * 星级服务申请表
 */
public class StarApply {
	private int id; // 编号
	private int userID; // 用户编号
	private int sid; // 星级编号
	private int money; // 付款金额
	private int rentAMonth; // 租的月数
	private Date startTime; // 开始时间
	private Date endTime; // 结束时间
	private Date applyTime; // 申请时间
	private Date auditTime; // 审核时间
	private int auditStatus; // 审核状态(1待审核2审核成功3未通过)

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getRentAMonth() {
		return rentAMonth;
	}

	public void setRentAMonth(int rentAMonth) {
		this.rentAMonth = rentAMonth;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public int getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(int auditStatus) {
		this.auditStatus = auditStatus;
	}

	public StarApply(int id, int userID, int sid, int money, int rentAMonth, Date startTime, Date endTime,
			Date applyTime, Date auditTime, int auditStatus) {
		super();
		this.id = id;
		this.userID = userID;
		this.sid = sid;
		this.money = money;
		this.rentAMonth = rentAMonth;
		this.startTime = startTime;
		this.endTime = endTime;
		this.applyTime = applyTime;
		this.auditTime = auditTime;
		this.auditStatus = auditStatus;
	}

	public StarApply() {
		super();
	}

}