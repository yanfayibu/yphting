package com.accp.vo.smy;

import java.util.Date;

//AppraisalApply鉴定记录
public class AppraisalApply {
		private Integer applyID;//主键，自增
		private Integer userID;//	外键，用户编号
		private Integer stid;//外键，服务编号
					//自驾游
		private String name;//	姓名
		private Integer sex;//性别(1男2女)
		private Integer height;//身高
		private String constellation;//星座
		private Integer age;//年龄
		private String visaType;//签证类型(直接填字符串)
		private Integer documentType;//	证件类型(1身份证2护照)
		private String certificates;//证件号
		private String experience;//经验时长(直接填字符串)
		private Boolean vehicle;//是否有车
		private Boolean guideCard;//是否有导游证
		private String inKorea;//在韩时长
		private String phone;//联系电话
		private String email;//	邮箱地址
		private String country;//国，在韩住址
		private String provincialID;//省，在韩住址
		private String cityID;//市，在韩住址
		private String detailed;//详细，在韩住址
						//微整形
		private String hospitalLicense;//整形医院营业执照
		private String cooperativeHospital;//	合作医院名字
		private String cooperativeHospitalURL;//合作医院官网网址
		private String hospitalPhone;//	医院联系电话
						//翻译
		private Integer translateType;//翻译资质(上传资质文件类型：1证书 2语言成绩)
		private String translate;//资质文件
		private Boolean office;//是否有办公室
		private String officeCountry;//国，办公室所在地
		private String officeProvince;//省，办公室所在地
		private String officeCity;//市，办公室所在地
		private String officeDetailed;//详细，办公室所在地
		private String koreaLicense;//韩国营业执照
		private String translateWebsite;//	网址
					//学习资源
		private String studyMajor;//所学专业
		private String schoolReport;//成绩单(上传文件)
					//留学中介
		private String officialNetworkURL;//留学中介官网网址
		private String strength;//实力展示
		private Date submitTime;//	提交时间
		private Date auditTime;//审核时间
		private String adminOpinion;//	审批备注
		private Integer auditStatus;//审核状态(1待审核2审核成功3未通过)
		
		
		
		public String getCityID() {
			return cityID;
		}
		public void setCityID(String cityID) {
			this.cityID = cityID;
		}
		public String getDetailed() {
			return detailed;
		}
		public void setDetailed(String detailed) {
			this.detailed = detailed;
		}
		public Date getAuditTime() {
			return auditTime;
		}
		public void setAuditTime(Date auditTime) {
			this.auditTime = auditTime;
		}
		public Integer getApplyID() {
			return applyID;
		}
		public void setApplyID(Integer applyID) {
			this.applyID = applyID;
		}
		public Integer getUserID() {
			return userID;
		}
		public void setUserID(Integer userID) {
			this.userID = userID;
		}
		public Integer getStid() {
			return stid;
		}
		public void setStid(Integer stid) {
			this.stid = stid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getSex() {
			return sex;
		}
		public void setSex(Integer sex) {
			this.sex = sex;
		}
		public Integer getHeight() {
			return height;
		}
		public void setHeight(Integer height) {
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
		public String getVisaType() {
			return visaType;
		}
		public void setVisaType(String visaType) {
			this.visaType = visaType;
		}
		public Integer getDocumentType() {
			return documentType;
		}
		public void setDocumentType(Integer documentType) {
			this.documentType = documentType;
		}
		public String getCertificates() {
			return certificates;
		}
		public void setCertificates(String certificates) {
			this.certificates = certificates;
		}
		public String getExperience() {
			return experience;
		}
		public void setExperience(String experience) {
			this.experience = experience;
		}
		public Boolean getVehicle() {
			return vehicle;
		}
		public void setVehicle(Boolean vehicle) {
			this.vehicle = vehicle;
		}
		public Boolean getGuideCard() {
			return guideCard;
		}
		public void setGuideCard(Boolean guideCard) {
			this.guideCard = guideCard;
		}
		public String getInKorea() {
			return inKorea;
		}
		public void setInKorea(String inKorea) {
			this.inKorea = inKorea;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getProvincialID() {
			return provincialID;
		}
		public void setProvincialID(String provincialID) {
			this.provincialID = provincialID;
		}
		public String getHospitalLicense() {
			return hospitalLicense;
		}
		public void setHospitalLicense(String hospitalLicense) {
			this.hospitalLicense = hospitalLicense;
		}
		public String getCooperativeHospital() {
			return cooperativeHospital;
		}
		public void setCooperativeHospital(String cooperativeHospital) {
			this.cooperativeHospital = cooperativeHospital;
		}
		public String getCooperativeHospitalURL() {
			return cooperativeHospitalURL;
		}
		public void setCooperativeHospitalURL(String cooperativeHospitalURL) {
			this.cooperativeHospitalURL = cooperativeHospitalURL;
		}
		public String getHospitalPhone() {
			return hospitalPhone;
		}
		public void setHospitalPhone(String hospitalPhone) {
			this.hospitalPhone = hospitalPhone;
		}
		public Integer getTranslateType() {
			return translateType;
		}
		public void setTranslateType(Integer translateType) {
			this.translateType = translateType;
		}
		public String getTranslate() {
			return translate;
		}
		public void setTranslate(String translate) {
			this.translate = translate;
		}
		public Boolean getOffice() {
			return office;
		}
		public void setOffice(Boolean office) {
			this.office = office;
		}
		public String getOfficeCountry() {
			return officeCountry;
		}
		public void setOfficeCountry(String officeCountry) {
			this.officeCountry = officeCountry;
		}
		public String getOfficeProvince() {
			return officeProvince;
		}
		public void setOfficeProvince(String officeProvince) {
			this.officeProvince = officeProvince;
		}
		public String getOfficeCity() {
			return officeCity;
		}
		public void setOfficeCity(String officeCity) {
			this.officeCity = officeCity;
		}
		public String getOfficeDetailed() {
			return officeDetailed;
		}
		public void setOfficeDetailed(String officeDetailed) {
			this.officeDetailed = officeDetailed;
		}
		public String getKoreaLicense() {
			return koreaLicense;
		}
		public void setKoreaLicense(String koreaLicense) {
			this.koreaLicense = koreaLicense;
		}
		public String getTranslateWebsite() {
			return translateWebsite;
		}
		public void setTranslateWebsite(String translateWebsite) {
			this.translateWebsite = translateWebsite;
		}
		public String getStudyMajor() {
			return studyMajor;
		}
		public void setStudyMajor(String studyMajor) {
			this.studyMajor = studyMajor;
		}
		public String getSchoolReport() {
			return schoolReport;
		}
		public void setSchoolReport(String schoolReport) {
			this.schoolReport = schoolReport;
		}
		public String getOfficialNetworkURL() {
			return officialNetworkURL;
		}
		public void setOfficialNetworkURL(String officialNetworkURL) {
			this.officialNetworkURL = officialNetworkURL;
		}
		public String getStrength() {
			return strength;
		}
		public void setStrength(String strength) {
			this.strength = strength;
		}
		public Date getSubmitTime() {
			return submitTime;
		}
		public void setSubmitTime(Date submitTime) {
			this.submitTime = submitTime;
		}
		
		public String getAdminOpinion() {
			return adminOpinion;
		}
		public void setAdminOpinion(String adminOpinion) {
			this.adminOpinion = adminOpinion;
		}
		public Integer getAuditStatus() {
			return auditStatus;
		}
		public void setAuditStatus(Integer auditStatus) {
			this.auditStatus = auditStatus;
		}
		public AppraisalApply(Integer applyID, Integer userID, Integer stid, String name, Integer sex, Integer height,
				String constellation, Integer age, String visaType, Integer documentType, String certificates,
				String experience, Boolean vehicle, Boolean guideCard, String inKorea, String phone, String email,
				String country, String provincialID, String cityID, String detailed, String hospitalLicense,
				String cooperativeHospital, String cooperativeHospitalURL, String hospitalPhone, Integer translateType,
				String translate, Boolean office, String officeCountry, String officeProvince, String officeCity,
				String officeDetailed, String koreaLicense, String translateWebsite, String studyMajor,
				String schoolReport, String officialNetworkURL, String strength, Date submitTime, Date auditTime,
				String adminOpinion, Integer auditStatus) {
			super();
			this.applyID = applyID;
			this.userID = userID;
			this.stid = stid;
			this.name = name;
			this.sex = sex;
			this.height = height;
			this.constellation = constellation;
			this.age = age;
			this.visaType = visaType;
			this.documentType = documentType;
			this.certificates = certificates;
			this.experience = experience;
			this.vehicle = vehicle;
			this.guideCard = guideCard;
			this.inKorea = inKorea;
			this.phone = phone;
			this.email = email;
			this.country = country;
			this.provincialID = provincialID;
			this.cityID = cityID;
			this.detailed = detailed;
			this.hospitalLicense = hospitalLicense;
			this.cooperativeHospital = cooperativeHospital;
			this.cooperativeHospitalURL = cooperativeHospitalURL;
			this.hospitalPhone = hospitalPhone;
			this.translateType = translateType;
			this.translate = translate;
			this.office = office;
			this.officeCountry = officeCountry;
			this.officeProvince = officeProvince;
			this.officeCity = officeCity;
			this.officeDetailed = officeDetailed;
			this.koreaLicense = koreaLicense;
			this.translateWebsite = translateWebsite;
			this.studyMajor = studyMajor;
			this.schoolReport = schoolReport;
			this.officialNetworkURL = officialNetworkURL;
			this.strength = strength;
			this.submitTime = submitTime;
			this.auditTime = auditTime;
			this.adminOpinion = adminOpinion;
			this.auditStatus = auditStatus;
		}
		public AppraisalApply() {
			super();
		}
		
		
		
		
}
