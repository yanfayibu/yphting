package com.accp.vo.smy;

import java.util.Date;

public class Services {
	private Integer serviceID;//服务编号，主键，自增
	private Integer stid;//服务类别编号，外键
	private Integer userID;//外键，用户编号
	private Integer resourceID;//资源类别编号
	private String serviceTitle;//服务标题
	private String serviceFuTitle;//服务副标题
	private String downloadTitle;//下载标题
	private Integer servicePrice;//金币价格
	private String serviceCoverImg;//封面图
	private String serviceImgUrlOne;//细节图1
	private String serviceImgUrlTwo;//细节图2
	private String serviceImgUrlThree;//细节图3
	private String serviceImgUrlFour;//细节图4
	private String serviceCostTypeID;//费用说明
	private String serviceIntro;//服务介绍
	private String serviceCity;//服务城市(可填多个)
	private Integer country;//外键，国编
	private String serviceCostInclude;//服务费用包含
	private Date serviceStartDate;//可预定日期-起始
	private Date serviceEndDate;//可预定日期-结束
	private String schoolRegion;//学校地区
	private String schoolNameByCN;//学科-中文-学校
	private String majoyNameByCN;//学科-中文-专业
	private String schoolNameByROK;//学科-韩文-学校
	private String majoyNameByROK;//学科-韩文-专业
	private String goodAtMajoy;//擅长专业
	private String hospitalName;//医院名称
	private Integer serviceHour;//小时/天
	private String uploadDataUrl;//上传资料
	private Date releaseTime;//发布时间
	private Integer browseNumber;//浏览数
	private Float weight;//重量
	private Boolean recommendBool;//服务推荐(true推荐)
	private String adminOpinion;//管理员意见
	private Integer shelfState;//上架状态(1上架2下架)
	private Integer auditStatus;//审核状态(1待审核2审核成功3未通过)
	public Integer getServiceID() {
		return serviceID;
	}
	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getResourceID() {
		return resourceID;
	}
	public void setResourceID(Integer resourceID) {
		this.resourceID = resourceID;
	}
	public String getServiceTitle() {
		return serviceTitle;
	}
	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
	public String getServiceFuTitle() {
		return serviceFuTitle;
	}
	public void setServiceFuTitle(String serviceFuTitle) {
		this.serviceFuTitle = serviceFuTitle;
	}
	public String getDownloadTitle() {
		return downloadTitle;
	}
	public void setDownloadTitle(String downloadTitle) {
		this.downloadTitle = downloadTitle;
	}
	public Integer getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(Integer servicePrice) {
		this.servicePrice = servicePrice;
	}
	public String getServiceCoverImg() {
		return serviceCoverImg;
	}
	public void setServiceCoverImg(String serviceCoverImg) {
		this.serviceCoverImg = serviceCoverImg;
	}
	public String getServiceImgUrlOne() {
		return serviceImgUrlOne;
	}
	public void setServiceImgUrlOne(String serviceImgUrlOne) {
		this.serviceImgUrlOne = serviceImgUrlOne;
	}
	public String getServiceImgUrlTwo() {
		return serviceImgUrlTwo;
	}
	public void setServiceImgUrlTwo(String serviceImgUrlTwo) {
		this.serviceImgUrlTwo = serviceImgUrlTwo;
	}
	public String getServiceImgUrlThree() {
		return serviceImgUrlThree;
	}
	public void setServiceImgUrlThree(String serviceImgUrlThree) {
		this.serviceImgUrlThree = serviceImgUrlThree;
	}
	public String getServiceImgUrlFour() {
		return serviceImgUrlFour;
	}
	public void setServiceImgUrlFour(String serviceImgUrlFour) {
		this.serviceImgUrlFour = serviceImgUrlFour;
	}
	public String getServiceCostTypeID() {
		return serviceCostTypeID;
	}
	public void setServiceCostTypeID(String serviceCostTypeID) {
		this.serviceCostTypeID = serviceCostTypeID;
	}
	public String getServiceIntro() {
		return serviceIntro;
	}
	public void setServiceIntro(String serviceIntro) {
		this.serviceIntro = serviceIntro;
	}
	public String getServiceCity() {
		return serviceCity;
	}
	public void setServiceCity(String serviceCity) {
		this.serviceCity = serviceCity;
	}
	public Integer getCountry() {
		return country;
	}
	public void setCountry(Integer country) {
		this.country = country;
	}
	public String getServiceCostInclude() {
		return serviceCostInclude;
	}
	public void setServiceCostInclude(String serviceCostInclude) {
		this.serviceCostInclude = serviceCostInclude;
	}
	public Date getServiceStartDate() {
		return serviceStartDate;
	}
	public void setServiceStartDate(Date serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}
	public Date getServiceEndDate() {
		return serviceEndDate;
	}
	public void setServiceEndDate(Date serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}
	public String getSchoolRegion() {
		return schoolRegion;
	}
	public void setSchoolRegion(String schoolRegion) {
		this.schoolRegion = schoolRegion;
	}
	public String getSchoolNameByCN() {
		return schoolNameByCN;
	}
	public void setSchoolNameByCN(String schoolNameByCN) {
		this.schoolNameByCN = schoolNameByCN;
	}
	public String getMajoyNameByCN() {
		return majoyNameByCN;
	}
	public void setMajoyNameByCN(String majoyNameByCN) {
		this.majoyNameByCN = majoyNameByCN;
	}
	public String getSchoolNameByROK() {
		return schoolNameByROK;
	}
	public void setSchoolNameByROK(String schoolNameByROK) {
		this.schoolNameByROK = schoolNameByROK;
	}
	public String getMajoyNameByROK() {
		return majoyNameByROK;
	}
	public void setMajoyNameByROK(String majoyNameByROK) {
		this.majoyNameByROK = majoyNameByROK;
	}
	public String getGoodAtMajoy() {
		return goodAtMajoy;
	}
	public void setGoodAtMajoy(String goodAtMajoy) {
		this.goodAtMajoy = goodAtMajoy;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public Integer getServiceHour() {
		return serviceHour;
	}
	public void setServiceHour(Integer serviceHour) {
		this.serviceHour = serviceHour;
	}
	public String getUploadDataUrl() {
		return uploadDataUrl;
	}
	public void setUploadDataUrl(String uploadDataUrl) {
		this.uploadDataUrl = uploadDataUrl;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public Integer getBrowseNumber() {
		return browseNumber;
	}
	public void setBrowseNumber(Integer browseNumber) {
		this.browseNumber = browseNumber;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public Boolean getRecommendBool() {
		return recommendBool;
	}
	public void setRecommendBool(Boolean recommendBool) {
		this.recommendBool = recommendBool;
	}
	public String getAdminOpinion() {
		return adminOpinion;
	}
	public void setAdminOpinion(String adminOpinion) {
		this.adminOpinion = adminOpinion;
	}
	public Integer getShelfState() {
		return shelfState;
	}
	public void setShelfState(Integer shelfState) {
		this.shelfState = shelfState;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public Services(Integer serviceID, Integer stid, Integer userID, Integer resourceID, String serviceTitle,
			String serviceFuTitle, String downloadTitle, Integer servicePrice, String serviceCoverImg,
			String serviceImgUrlOne, String serviceImgUrlTwo, String serviceImgUrlThree, String serviceImgUrlFour,
			String serviceCostTypeID, String serviceIntro, String serviceCity, Integer country,
			String serviceCostInclude, Date serviceStartDate, Date serviceEndDate, String schoolRegion,
			String schoolNameByCN, String majoyNameByCN, String schoolNameByROK, String majoyNameByROK,
			String goodAtMajoy, String hospitalName, Integer serviceHour, String uploadDataUrl, Date releaseTime,
			Integer browseNumber, Float weight, Boolean recommendBool, String adminOpinion, Integer shelfState,
			Integer auditStatus) {
		super();
		this.serviceID = serviceID;
		this.stid = stid;
		this.userID = userID;
		this.resourceID = resourceID;
		this.serviceTitle = serviceTitle;
		this.serviceFuTitle = serviceFuTitle;
		this.downloadTitle = downloadTitle;
		this.servicePrice = servicePrice;
		this.serviceCoverImg = serviceCoverImg;
		this.serviceImgUrlOne = serviceImgUrlOne;
		this.serviceImgUrlTwo = serviceImgUrlTwo;
		this.serviceImgUrlThree = serviceImgUrlThree;
		this.serviceImgUrlFour = serviceImgUrlFour;
		this.serviceCostTypeID = serviceCostTypeID;
		this.serviceIntro = serviceIntro;
		this.serviceCity = serviceCity;
		this.country = country;
		this.serviceCostInclude = serviceCostInclude;
		this.serviceStartDate = serviceStartDate;
		this.serviceEndDate = serviceEndDate;
		this.schoolRegion = schoolRegion;
		this.schoolNameByCN = schoolNameByCN;
		this.majoyNameByCN = majoyNameByCN;
		this.schoolNameByROK = schoolNameByROK;
		this.majoyNameByROK = majoyNameByROK;
		this.goodAtMajoy = goodAtMajoy;
		this.hospitalName = hospitalName;
		this.serviceHour = serviceHour;
		this.uploadDataUrl = uploadDataUrl;
		this.releaseTime = releaseTime;
		this.browseNumber = browseNumber;
		this.weight = weight;
		this.recommendBool = recommendBool;
		this.adminOpinion = adminOpinion;
		this.shelfState = shelfState;
		this.auditStatus = auditStatus;
	}
	public Services() {
		super();
	}
	@Override
	public String toString() {
		return "Services [serviceID=" + serviceID + ", stid=" + stid + ", userID=" + userID + ", resourceID="
				+ resourceID + ", serviceTitle=" + serviceTitle + ", serviceFuTitle=" + serviceFuTitle
				+ ", downloadTitle=" + downloadTitle + ", servicePrice=" + servicePrice + ", serviceCoverImg="
				+ serviceCoverImg + ", serviceImgUrlOne=" + serviceImgUrlOne + ", serviceImgUrlTwo=" + serviceImgUrlTwo
				+ ", serviceImgUrlThree=" + serviceImgUrlThree + ", serviceImgUrlFour=" + serviceImgUrlFour
				+ ", serviceCostTypeID=" + serviceCostTypeID + ", serviceIntro=" + serviceIntro + ", serviceCity="
				+ serviceCity + ", country=" + country + ", serviceCostInclude=" + serviceCostInclude
				+ ", serviceStartDate=" + serviceStartDate + ", serviceEndDate=" + serviceEndDate + ", schoolRegion="
				+ schoolRegion + ", schoolNameByCN=" + schoolNameByCN + ", majoyNameByCN=" + majoyNameByCN
				+ ", schoolNameByROK=" + schoolNameByROK + ", majoyNameByROK=" + majoyNameByROK + ", goodAtMajoy="
				+ goodAtMajoy + ", hospitalName=" + hospitalName + ", serviceHour=" + serviceHour + ", uploadDataUrl="
				+ uploadDataUrl + ", releaseTime=" + releaseTime + ", browseNumber=" + browseNumber + ", weight="
				+ weight + ", recommendBool=" + recommendBool + ", adminOpinion=" + adminOpinion + ", shelfState="
				+ shelfState + ", auditStatus=" + auditStatus + "]";
	}
	
	
	
}
