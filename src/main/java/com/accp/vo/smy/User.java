package com.accp.vo.smy;

import java.util.Date;

public class User {
	private Integer userID;//用户编号
	private String userImgPath;//用户头像地址(第三方注册成功后复制过来)
	private String userName;//用户名(第三方注册成功后复制过来)
	private String userRealName;//用户真实姓名
	private Integer userSex;//用户性别，1：男，2：女
	private String userPhone;//联系电话
	private String contactMailbox;//联系邮箱
	private Float userMoney;//用户金币
	private Integer userIntegral;//用户积分
	private Integer country;//外键，国编
	private Integer provincialID;//外键，省级地址编号
	private Integer cityID;//外键，市级地址编号
	private Integer countyID;//外键，县/区级地址编号
	private String adDetail;//地址详情
	private Integer merchantType;//商家类别，0：不是商家，1：大陆商家用户，2：海外商家用户
	private Date merchantRegistrationTime;//商家注册时间
	private Integer firstServiceID;//第一个服务类别编号，外键，引用服务类型表
	private Integer secondServiceID;//第二个服务类别编号，外键，引用服务类型表
	private Float firstServiceMoney;//第一个服务交易额
	private Float secondServiceMoney;//第二个服务交易额
	private String hospitalName;//医院名称，申请服务类别有微整形时不能为空，否则可以
	private String shopName;//店铺名称
	private String signature;//店铺签名
	private Float guaranteeMoney;//店铺保证金
	private String shopImg;//商家店铺图片路径
	private Integer identityType;//证件类型，海外用户为空，大陆商家用户：1：身份证号码，2：护照号码
	private String identityNumder;//证件号码
	private String identityRealName;//海外证件真实姓名，大陆商家用户为空
	private String identityPositiveImg;//证件正面图片路径
	private String identityNegativeImg;//证件反面图片路径
	private String identityHandImg;//证件手持图片路径
	private String languageNameText;//服务语言
	private String majorNameText;//擅长专业
	private Integer liveCityID;//所在城市编号
	private String merchantEmail;//商家联系邮箱
	private String merchantPhone;//商家联系电话
	private Float merchantLevel;//商家星级
	private Integer merchantExp;//商家经验值，用来提升星级
	private String qq;//QQ
	private String weChat;//微信
	private String profession;//职业
	private Float height;//身高
	private String constellation;//星座
	private Integer age;//年龄
	private String selfIntroduction;//自我介绍
	private Integer collectCount;//商家被收藏数
	private Integer orderCount;//商家被订单数
	private Integer browseNumber;//商家被浏览数
	private Boolean trusteeship;//托管状态
	private Date trusteeshipStartTime;//托管开始时间
	private Integer trusteeshipMonth;//托管月数
	private Integer businessState;//营业状态(1营业2暂停3关闭)
	private Integer experience;//免费体验月数
	private Boolean experienceStatus;//免费体验状态(true开启false关闭)
	private Integer auditStatus;//审核状态(1待审核2已通过3拒绝)
	private String reason;//管理员理由
	private Boolean authentication;//一号服务平台认证
	private Boolean authenticationer;//二号服务平台认证
	private Integer creditScore;//信誉积分(默认60/满分100 20为1颗星)
	private Boolean stateboolean;//用户状态(可禁用用户true1正常false0禁用)
	private Boolean mailboxVerification;//邮箱验证/邮箱激活
	private String registerIP;//注册IP地址
	private String lastEntry;//最后登入IP地址
	private Date userRegistrationTime;//用户注册时间
	private Date recentEntry;//用户最后登入时间
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
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
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public Integer getUserSex() {
		return userSex;
	}
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getContactMailbox() {
		return contactMailbox;
	}
	public void setContactMailbox(String contactMailbox) {
		this.contactMailbox = contactMailbox;
	}
	public Float getUserMoney() {
		return userMoney;
	}
	public void setUserMoney(Float userMoney) {
		this.userMoney = userMoney;
	}
	public Integer getUserIntegral() {
		return userIntegral;
	}
	public void setUserIntegral(Integer userIntegral) {
		this.userIntegral = userIntegral;
	}
	public Integer getCountry() {
		return country;
	}
	public void setCountry(Integer country) {
		this.country = country;
	}
	public Integer getProvincialID() {
		return provincialID;
	}
	public void setProvincialID(Integer provincialID) {
		this.provincialID = provincialID;
	}
	public Integer getCityID() {
		return cityID;
	}
	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}
	public Integer getCountyID() {
		return countyID;
	}
	public void setCountyID(Integer countyID) {
		this.countyID = countyID;
	}
	public String getAdDetail() {
		return adDetail;
	}
	public void setAdDetail(String adDetail) {
		this.adDetail = adDetail;
	}
	public Integer getMerchantType() {
		return merchantType;
	}
	public void setMerchantType(Integer merchantType) {
		this.merchantType = merchantType;
	}
	public Date getMerchantRegistrationTime() {
		return merchantRegistrationTime;
	}
	public void setMerchantRegistrationTime(Date merchantRegistrationTime) {
		this.merchantRegistrationTime = merchantRegistrationTime;
	}
	public Integer getFirstServiceID() {
		return firstServiceID;
	}
	public void setFirstServiceID(Integer firstServiceID) {
		this.firstServiceID = firstServiceID;
	}
	public Integer getSecondServiceID() {
		return secondServiceID;
	}
	public void setSecondServiceID(Integer secondServiceID) {
		this.secondServiceID = secondServiceID;
	}
	public Float getFirstServiceMoney() {
		return firstServiceMoney;
	}
	public void setFirstServiceMoney(Float firstServiceMoney) {
		this.firstServiceMoney = firstServiceMoney;
	}
	public Float getSecondServiceMoney() {
		return secondServiceMoney;
	}
	public void setSecondServiceMoney(Float secondServiceMoney) {
		this.secondServiceMoney = secondServiceMoney;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public Float getGuaranteeMoney() {
		return guaranteeMoney;
	}
	public void setGuaranteeMoney(Float guaranteeMoney) {
		this.guaranteeMoney = guaranteeMoney;
	}
	public String getShopImg() {
		return shopImg;
	}
	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}
	public Integer getIdentityType() {
		return identityType;
	}
	public void setIdentityType(Integer identityType) {
		this.identityType = identityType;
	}
	public String getIdentityNumder() {
		return identityNumder;
	}
	public void setIdentityNumder(String identityNumder) {
		this.identityNumder = identityNumder;
	}
	public String getIdentityRealName() {
		return identityRealName;
	}
	public void setIdentityRealName(String identityRealName) {
		this.identityRealName = identityRealName;
	}
	public String getIdentityPositiveImg() {
		return identityPositiveImg;
	}
	public void setIdentityPositiveImg(String identityPositiveImg) {
		this.identityPositiveImg = identityPositiveImg;
	}
	public String getIdentityNegativeImg() {
		return identityNegativeImg;
	}
	public void setIdentityNegativeImg(String identityNegativeImg) {
		this.identityNegativeImg = identityNegativeImg;
	}
	public String getIdentityHandImg() {
		return identityHandImg;
	}
	public void setIdentityHandImg(String identityHandImg) {
		this.identityHandImg = identityHandImg;
	}
	public String getLanguageNameText() {
		return languageNameText;
	}
	public void setLanguageNameText(String languageNameText) {
		this.languageNameText = languageNameText;
	}
	public String getMajorNameText() {
		return majorNameText;
	}
	public void setMajorNameText(String majorNameText) {
		this.majorNameText = majorNameText;
	}
	public Integer getLiveCityID() {
		return liveCityID;
	}
	public void setLiveCityID(Integer liveCityID) {
		this.liveCityID = liveCityID;
	}
	public String getMerchantEmail() {
		return merchantEmail;
	}
	public void setMerchantEmail(String merchantEmail) {
		this.merchantEmail = merchantEmail;
	}
	public String getMerchantPhone() {
		return merchantPhone;
	}
	public void setMerchantPhone(String merchantPhone) {
		this.merchantPhone = merchantPhone;
	}
	public Float getMerchantLevel() {
		return merchantLevel;
	}
	public void setMerchantLevel(Float merchantLevel) {
		this.merchantLevel = merchantLevel;
	}
	public Integer getMerchantExp() {
		return merchantExp;
	}
	public void setMerchantExp(Integer merchantExp) {
		this.merchantExp = merchantExp;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWeChat() {
		return weChat;
	}
	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public Float getHeight() {
		return height;
	}
	public void setHeight(Float height) {
		this.height = height;
	}
	public String getConstellation() {
		return constellation;
	}
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSelfIntroduction() {
		return selfIntroduction;
	}
	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}
	public Integer getCollectCount() {
		return collectCount;
	}
	public void setCollectCount(Integer collectCount) {
		this.collectCount = collectCount;
	}
	public Integer getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}
	public Integer getBrowseNumber() {
		return browseNumber;
	}
	public void setBrowseNumber(Integer browseNumber) {
		this.browseNumber = browseNumber;
	}
	public Boolean getTrusteeship() {
		return trusteeship;
	}
	public void setTrusteeship(Boolean trusteeship) {
		this.trusteeship = trusteeship;
	}
	public Date getTrusteeshipStartTime() {
		return trusteeshipStartTime;
	}
	public void setTrusteeshipStartTime(Date trusteeshipStartTime) {
		this.trusteeshipStartTime = trusteeshipStartTime;
	}
	public Integer getTrusteeshipMonth() {
		return trusteeshipMonth;
	}
	public void setTrusteeshipMonth(Integer trusteeshipMonth) {
		this.trusteeshipMonth = trusteeshipMonth;
	}
	public Integer getBusinessState() {
		return businessState;
	}
	public void setBusinessState(Integer businessState) {
		this.businessState = businessState;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public Boolean getExperienceStatus() {
		return experienceStatus;
	}
	public void setExperienceStatus(Boolean experienceStatus) {
		this.experienceStatus = experienceStatus;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Boolean getAuthentication() {
		return authentication;
	}
	public void setAuthentication(Boolean authentication) {
		this.authentication = authentication;
	}
	public Boolean getAuthenticationer() {
		return authenticationer;
	}
	public void setAuthenticationer(Boolean authenticationer) {
		this.authenticationer = authenticationer;
	}
	public Integer getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}
	public Boolean getStateboolean() {
		return stateboolean;
	}
	public void setStateboolean(Boolean stateboolean) {
		this.stateboolean = stateboolean;
	}
	public Boolean getMailboxVerification() {
		return mailboxVerification;
	}
	public void setMailboxVerification(Boolean mailboxVerification) {
		this.mailboxVerification = mailboxVerification;
	}
	public String getRegisterIP() {
		return registerIP;
	}
	public void setRegisterIP(String registerIP) {
		this.registerIP = registerIP;
	}
	public String getLastEntry() {
		return lastEntry;
	}
	public void setLastEntry(String lastEntry) {
		this.lastEntry = lastEntry;
	}
	public Date getUserRegistrationTime() {
		return userRegistrationTime;
	}
	public void setUserRegistrationTime(Date userRegistrationTime) {
		this.userRegistrationTime = userRegistrationTime;
	}
	public Date getRecentEntry() {
		return recentEntry;
	}
	public void setRecentEntry(Date recentEntry) {
		this.recentEntry = recentEntry;
	}
	public User(Integer userID, String userImgPath, String userName, String userRealName, Integer userSex,
			String userPhone, String contactMailbox, Float userMoney, Integer userIntegral, Integer country,
			Integer provincialID, Integer cityID, Integer countyID, String adDetail, Integer merchantType,
			Date merchantRegistrationTime, Integer firstServiceID, Integer secondServiceID, Float firstServiceMoney,
			Float secondServiceMoney, String hospitalName, String shopName, String signature, Float guaranteeMoney,
			String shopImg, Integer identityType, String identityNumder, String identityRealName,
			String identityPositiveImg, String identityNegativeImg, String identityHandImg, String languageNameText,
			String majorNameText, Integer liveCityID, String merchantEmail, String merchantPhone, Float merchantLevel,
			Integer merchantExp, String qq, String weChat, String profession, Float height, String constellation,
			Integer age, String selfIntroduction, Integer collectCount, Integer orderCount, Integer browseNumber,
			Boolean trusteeship, Date trusteeshipStartTime, Integer trusteeshipMonth, Integer businessState,
			Integer experience, Boolean experienceStatus, Integer auditStatus, String reason, Boolean authentication,
			Boolean authenticationer, Integer creditScore, Boolean stateboolean, Boolean mailboxVerification,
			String registerIP, String lastEntry, Date userRegistrationTime, Date recentEntry) {
		super();
		this.userID = userID;
		this.userImgPath = userImgPath;
		this.userName = userName;
		this.userRealName = userRealName;
		this.userSex = userSex;
		this.userPhone = userPhone;
		this.contactMailbox = contactMailbox;
		this.userMoney = userMoney;
		this.userIntegral = userIntegral;
		this.country = country;
		this.provincialID = provincialID;
		this.cityID = cityID;
		this.countyID = countyID;
		this.adDetail = adDetail;
		this.merchantType = merchantType;
		this.merchantRegistrationTime = merchantRegistrationTime;
		this.firstServiceID = firstServiceID;
		this.secondServiceID = secondServiceID;
		this.firstServiceMoney = firstServiceMoney;
		this.secondServiceMoney = secondServiceMoney;
		this.hospitalName = hospitalName;
		this.shopName = shopName;
		this.signature = signature;
		this.guaranteeMoney = guaranteeMoney;
		this.shopImg = shopImg;
		this.identityType = identityType;
		this.identityNumder = identityNumder;
		this.identityRealName = identityRealName;
		this.identityPositiveImg = identityPositiveImg;
		this.identityNegativeImg = identityNegativeImg;
		this.identityHandImg = identityHandImg;
		this.languageNameText = languageNameText;
		this.majorNameText = majorNameText;
		this.liveCityID = liveCityID;
		this.merchantEmail = merchantEmail;
		this.merchantPhone = merchantPhone;
		this.merchantLevel = merchantLevel;
		this.merchantExp = merchantExp;
		this.qq = qq;
		this.weChat = weChat;
		this.profession = profession;
		this.height = height;
		this.constellation = constellation;
		this.age = age;
		this.selfIntroduction = selfIntroduction;
		this.collectCount = collectCount;
		this.orderCount = orderCount;
		this.browseNumber = browseNumber;
		this.trusteeship = trusteeship;
		this.trusteeshipStartTime = trusteeshipStartTime;
		this.trusteeshipMonth = trusteeshipMonth;
		this.businessState = businessState;
		this.experience = experience;
		this.experienceStatus = experienceStatus;
		this.auditStatus = auditStatus;
		this.reason = reason;
		this.authentication = authentication;
		this.authenticationer = authenticationer;
		this.creditScore = creditScore;
		this.stateboolean = stateboolean;
		this.mailboxVerification = mailboxVerification;
		this.registerIP = registerIP;
		this.lastEntry = lastEntry;
		this.userRegistrationTime = userRegistrationTime;
		this.recentEntry = recentEntry;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + "]";
	}
	
	
}
