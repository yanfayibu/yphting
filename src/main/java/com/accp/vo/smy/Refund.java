package com.accp.vo.smy;

import java.util.Date;

public class Refund {
	private Integer refundID;//退款编号、主键，自增
	private Integer point;//退款申请指向，1：商家，2：管理员
	private String orderID;//外键，订单编号
	private Integer userID;//外键，用户编号
	private String refundReason;//退款原因
	private String refundExplain;//退款说明
	private String refundImg;//退款附带图片
	private Float applyRefundMoney;//申请退款金额
	private Float ActualRefundMoney;//实际退款金额
	private Date applicationTime;//申请时间
	private String businessRemarks;//商家审核备注
	private Date auditTime;//商家审核时间
	private Integer auditStatus;//商家审核状态(1待审核2审核成功3未通过)
	private String adminRemarks;//管理员审核备注
	private Date adminTime;//管理员审核时间
	private Integer adminStatus;//管理员审核状态(1待审核2审核成功3未通过)
	public Integer getRefundID() {
		return refundID;
	}
	public void setRefundID(Integer refundID) {
		this.refundID = refundID;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getRefundReason() {
		return refundReason;
	}
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	public String getRefundExplain() {
		return refundExplain;
	}
	public void setRefundExplain(String refundExplain) {
		this.refundExplain = refundExplain;
	}
	public String getRefundImg() {
		return refundImg;
	}
	public void setRefundImg(String refundImg) {
		this.refundImg = refundImg;
	}
	public Float getApplyRefundMoney() {
		return applyRefundMoney;
	}
	public void setApplyRefundMoney(Float applyRefundMoney) {
		this.applyRefundMoney = applyRefundMoney;
	}
	public Float getActualRefundMoney() {
		return ActualRefundMoney;
	}
	public void setActualRefundMoney(Float actualRefundMoney) {
		ActualRefundMoney = actualRefundMoney;
	}
	public Date getApplicationTime() {
		return applicationTime;
	}
	public void setApplicationTime(Date applicationTime) {
		this.applicationTime = applicationTime;
	}
	public String getBusinessRemarks() {
		return businessRemarks;
	}
	public void setBusinessRemarks(String businessRemarks) {
		this.businessRemarks = businessRemarks;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public String getAdminRemarks() {
		return adminRemarks;
	}
	public void setAdminRemarks(String adminRemarks) {
		this.adminRemarks = adminRemarks;
	}
	public Date getAdminTime() {
		return adminTime;
	}
	public void setAdminTime(Date adminTime) {
		this.adminTime = adminTime;
	}
	public Integer getAdminStatus() {
		return adminStatus;
	}
	public void setAdminStatus(Integer adminStatus) {
		this.adminStatus = adminStatus;
	}
	public Refund(Integer refundID, Integer point, String orderID, Integer userID, String refundReason,
			String refundExplain, String refundImg, Float applyRefundMoney, Float actualRefundMoney,
			Date applicationTime, String businessRemarks, Date auditTime, Integer auditStatus, String adminRemarks,
			Date adminTime, Integer adminStatus) {
		super();
		this.refundID = refundID;
		this.point = point;
		this.orderID = orderID;
		this.userID = userID;
		this.refundReason = refundReason;
		this.refundExplain = refundExplain;
		this.refundImg = refundImg;
		this.applyRefundMoney = applyRefundMoney;
		ActualRefundMoney = actualRefundMoney;
		this.applicationTime = applicationTime;
		this.businessRemarks = businessRemarks;
		this.auditTime = auditTime;
		this.auditStatus = auditStatus;
		this.adminRemarks = adminRemarks;
		this.adminTime = adminTime;
		this.adminStatus = adminStatus;
	}
	public Refund() {
		super();
	}
	
	
	
}
