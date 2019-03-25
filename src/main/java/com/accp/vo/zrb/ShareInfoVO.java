package com.accp.vo.zrb;

public class ShareInfoVO {
	private int serviceID;            //服务编号
	private int userID;               //用户编号
	private String serviceCoverImg;   //商家销售额前三的服务图片
	public int getServiceID() {
		return serviceID;
	}
	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getServiceCoverImg() {
		return serviceCoverImg;
	}
	public void setServiceCoverImg(String serviceCoverImg) {
		this.serviceCoverImg = serviceCoverImg;
	}
	public ShareInfoVO(int serviceID, int userID, String serviceCoverImg) {
		super();
		this.serviceID = serviceID;
		this.userID = userID;
		this.serviceCoverImg = serviceCoverImg;
	}
	public ShareInfoVO() {
		super();
	}
	
}
