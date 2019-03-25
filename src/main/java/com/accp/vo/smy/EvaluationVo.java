package com.accp.vo.smy;

import java.util.Date;


public class EvaluationVo {
	private Integer serviceAppraiseID; // 评价编号
	private Integer serviceID;// 服务编号
	private Integer userID;// 评价用户
	private String userImgPath; // 头像路径
	private String userName; // 评价的用户昵称【买家】
	private String serviceTitle; // 标题
	private String serviceAppraiseContent;// 内容
	private Date serviceAppraiseDate;// 时间
	private Integer serviceAppraiseLevel;// 星级
	private Integer serviceappraisePID;// 上级评价
	private EvaluationVo parentPID; // 回复[多回复]

	public Integer getServiceAppraiseID() {
		return serviceAppraiseID;
	}

	public void setServiceAppraiseID(Integer serviceAppraiseID) {
		this.serviceAppraiseID = serviceAppraiseID;
	}

	public Integer getServiceID() {
		return serviceID;
	}

	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getServiceAppraiseContent() {
		return serviceAppraiseContent;
	}

	public void setServiceAppraiseContent(String serviceAppraiseContent) {
		this.serviceAppraiseContent = serviceAppraiseContent;
	}

	public Date getServiceAppraiseDate() {
		return serviceAppraiseDate;
	}

	public void setServiceAppraiseDate(Date serviceAppraiseDate) {
		this.serviceAppraiseDate = serviceAppraiseDate;
	}

	public Integer getServiceAppraiseLevel() {
		return serviceAppraiseLevel;
	}

	public void setServiceAppraiseLevel(Integer serviceAppraiseLevel) {
		this.serviceAppraiseLevel = serviceAppraiseLevel;
	}

	public Integer getServiceappraisePID() {
		return serviceappraisePID;
	}

	public void setServiceappraisePID(Integer serviceappraisePID) {
		this.serviceappraisePID = serviceappraisePID;
	}

	public EvaluationVo getParentPID() {
		return parentPID;
	}

	public void setParentPID(EvaluationVo parentPID) {
		this.parentPID = parentPID;
	}

	public String getUserImgPath() {
		return userImgPath;
	}

	public void setUserImgPath(String userImgPath) {
		this.userImgPath = userImgPath;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getServiceTitle() {
		return serviceTitle;
	}

	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}

	public EvaluationVo(Integer serviceAppraiseID, Integer serviceID, Integer userID, String userImgPath,
			String userName, String serviceTitle, String serviceAppraiseContent, Date serviceAppraiseDate,
			Integer serviceAppraiseLevel, Integer serviceappraisePID, EvaluationVo parentPID) {
		super();
		this.serviceAppraiseID = serviceAppraiseID;
		this.serviceID = serviceID;
		this.userID = userID;
		this.userImgPath = userImgPath;
		this.userName = userName;
		this.serviceTitle = serviceTitle;
		this.serviceAppraiseContent = serviceAppraiseContent;
		this.serviceAppraiseDate = serviceAppraiseDate;
		this.serviceAppraiseLevel = serviceAppraiseLevel;
		this.serviceappraisePID = serviceappraisePID;
		this.parentPID = parentPID;
	}

	public EvaluationVo(Integer serviceID, Integer userID, String userImgPath, String userName,
			String serviceTitle, String serviceAppraiseContent, Date serviceAppraiseDate, Integer serviceAppraiseLevel,
			Integer serviceappraisePID, EvaluationVo parentPID) {
		super();
		this.serviceID = serviceID;
		this.userID = userID;
		this.userImgPath = userImgPath;
		this.userName = userName;
		this.serviceTitle = serviceTitle;
		this.serviceAppraiseContent = serviceAppraiseContent;
		this.serviceAppraiseDate = serviceAppraiseDate;
		this.serviceAppraiseLevel = serviceAppraiseLevel;
		this.serviceappraisePID = serviceappraisePID;
		this.parentPID = parentPID;
	}

	public EvaluationVo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EvaluationVo [serviceAppraiseID=" + serviceAppraiseID + ", serviceID=" + serviceID
				+ ", userID=" + userID + ", userImgPath=" + userImgPath + ", userName=" + userName + ", serviceTitle="
				+ serviceTitle + ", serviceAppraiseContent=" + serviceAppraiseContent + ", serviceAppraiseDate="
				+ serviceAppraiseDate + ", serviceAppraiseLevel=" + serviceAppraiseLevel + ", serviceappraisePID="
				+ serviceappraisePID + ", parentPID=" + parentPID + "]";
	}
}
