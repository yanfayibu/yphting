package com.accp.vo.smy;

import java.util.Date;

//Goldnotes金币流向操作记录表
public class Goldnotes {
	private Integer recordID;	//	记录编号，主键，自增
	private Integer userID;		//外键，用户编号
	private Integer acquisitionMode;//	(1预定服务2服务收益3取消物流订单4其他5充值6线下充值7退款8提现)
	private Date recordDate;	//记录日期
	private String recordDescribe;	//	记录描述
	private Float recordInAndOut;	//记录编号，主键，自增
	private Integer auditStatus;	//审核状态(1待审核2审核成功3未通过)
	
	
	
	public Integer getRecordID() {
		return recordID;
	}



	public void setRecordID(Integer recordID) {
		this.recordID = recordID;
	}



	public Integer getUserID() {
		return userID;
	}



	public void setUserID(Integer userID) {
		this.userID = userID;
	}



	public Integer getAcquisitionMode() {
		return acquisitionMode;
	}



	public void setAcquisitionMode(Integer acquisitionMode) {
		this.acquisitionMode = acquisitionMode;
	}



	public Date getRecordDate() {
		return recordDate;
	}



	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}



	public String getRecordDescribe() {
		return recordDescribe;
	}



	public void setRecordDescribe(String recordDescribe) {
		this.recordDescribe = recordDescribe;
	}



	public Float getRecordInAndOut() {
		return recordInAndOut;
	}



	public void setRecordInAndOut(Float recordInAndOut) {
		this.recordInAndOut = recordInAndOut;
	}



	public Integer getAuditStatus() {
		return auditStatus;
	}



	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}



	public Goldnotes(Integer recordID, Integer userID, Integer acquisitionMode, Date recordDate, String recordDescribe,
			Float recordInAndOut, Integer auditStatus) {
		super();
		this.recordID = recordID;
		this.userID = userID;
		this.acquisitionMode = acquisitionMode;
		this.recordDate = recordDate;
		this.recordDescribe = recordDescribe;
		this.recordInAndOut = recordInAndOut;
		this.auditStatus = auditStatus;
	}



	public Goldnotes() {
		super();
	}
	
	
}
