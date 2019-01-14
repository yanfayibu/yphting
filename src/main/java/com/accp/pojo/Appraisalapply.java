package com.accp.pojo;

import java.util.Date;
/**
 *鉴定记录表
 */
public class Appraisalapply {
    private Integer applyid;         //编号

    private Integer userid;          //用户编号

    private Integer stid;            //服务编号

    private String name;             //姓名

    private Integer sex;             //性别(1男2女)

    private Integer height;          //身高

    private String constellation;    //星座

    private Integer age;             //年龄

    private String visatype;         //签证类型(直接填字符串)

    private Integer documenttype;    //证件类型(1身份证2护照)

    private String certificates;     //证件号

    private String experience;       //经验时长(直接填字符串)

    private Boolean vehicle;         //是否有车

    private Boolean guidecard;       //是否有导游证

    private String inkorea;          //在韩时长

    private String phone;            //联系电话

    private String email;            //邮箱地址

    private String country;          //国，在韩住址

    private String provincialid;     //省，在韩住址

    private String cityid;           //市，在韩住址

    private String detailed;         //详细，在韩住址

    private String hospitallicense;        //整形医院营业执照

    private String cooperativehospital;    //合作医院名字

    private String cooperativehospitalurl; //合作医院官网网址

    private String hospitalphone;          //医院联系电话

    private Integer translatetype;         //翻译资质(上传资质文件类型：1证书 2语言成绩)

    private String translate;              //资质文件

    private Boolean office;                //是否有办公室

    private String officecountry;          //国，办公室所在地

    private String officeprovince;         //省，办公室所在地

    private String officecity;             //市，办公室所在地

    private String officedetailed;         //详细，办公室所在地

    private String korealicense;           //韩国营业执照

    private String translatewebsite;       //网址

    private String studymajor;             //所学专业

    private String schoolreport;           //成绩单(上传文件)

    private String officialnetworkurl;     //留学中介官网网址

    private Date submittime;               //提交时间

    private Date audittime;                //审核时间

    private Integer auditstatus;           //审核状态(1待审核2审核成功3未通过)

    private String adminopinion;           //审批备注

    public Integer getApplyid() {
        return applyid;
    }

    public void setApplyid(Integer applyid) {
        this.applyid = applyid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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
        this.name = name == null ? null : name.trim();
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
        this.constellation = constellation == null ? null : constellation.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getVisatype() {
        return visatype;
    }

    public void setVisatype(String visatype) {
        this.visatype = visatype == null ? null : visatype.trim();
    }

    public Integer getDocumenttype() {
        return documenttype;
    }

    public void setDocumenttype(Integer documenttype) {
        this.documenttype = documenttype;
    }

    public String getCertificates() {
        return certificates;
    }

    public void setCertificates(String certificates) {
        this.certificates = certificates == null ? null : certificates.trim();
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience == null ? null : experience.trim();
    }

    public Boolean getVehicle() {
        return vehicle;
    }

    public void setVehicle(Boolean vehicle) {
        this.vehicle = vehicle;
    }

    public Boolean getGuidecard() {
        return guidecard;
    }

    public void setGuidecard(Boolean guidecard) {
        this.guidecard = guidecard;
    }

    public String getInkorea() {
        return inkorea;
    }

    public void setInkorea(String inkorea) {
        this.inkorea = inkorea == null ? null : inkorea.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvincialid() {
        return provincialid;
    }

    public void setProvincialid(String provincialid) {
        this.provincialid = provincialid == null ? null : provincialid.trim();
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid == null ? null : cityid.trim();
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed == null ? null : detailed.trim();
    }

    public String getHospitallicense() {
        return hospitallicense;
    }

    public void setHospitallicense(String hospitallicense) {
        this.hospitallicense = hospitallicense == null ? null : hospitallicense.trim();
    }

    public String getCooperativehospital() {
        return cooperativehospital;
    }

    public void setCooperativehospital(String cooperativehospital) {
        this.cooperativehospital = cooperativehospital == null ? null : cooperativehospital.trim();
    }

    public String getCooperativehospitalurl() {
        return cooperativehospitalurl;
    }

    public void setCooperativehospitalurl(String cooperativehospitalurl) {
        this.cooperativehospitalurl = cooperativehospitalurl == null ? null : cooperativehospitalurl.trim();
    }

    public String getHospitalphone() {
        return hospitalphone;
    }

    public void setHospitalphone(String hospitalphone) {
        this.hospitalphone = hospitalphone == null ? null : hospitalphone.trim();
    }

    public Integer getTranslatetype() {
        return translatetype;
    }

    public void setTranslatetype(Integer translatetype) {
        this.translatetype = translatetype;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate == null ? null : translate.trim();
    }

    public Boolean getOffice() {
        return office;
    }

    public void setOffice(Boolean office) {
        this.office = office;
    }

    public String getOfficecountry() {
        return officecountry;
    }

    public void setOfficecountry(String officecountry) {
        this.officecountry = officecountry == null ? null : officecountry.trim();
    }

    public String getOfficeprovince() {
        return officeprovince;
    }

    public void setOfficeprovince(String officeprovince) {
        this.officeprovince = officeprovince == null ? null : officeprovince.trim();
    }

    public String getOfficecity() {
        return officecity;
    }

    public void setOfficecity(String officecity) {
        this.officecity = officecity == null ? null : officecity.trim();
    }

    public String getOfficedetailed() {
        return officedetailed;
    }

    public void setOfficedetailed(String officedetailed) {
        this.officedetailed = officedetailed == null ? null : officedetailed.trim();
    }

    public String getKorealicense() {
        return korealicense;
    }

    public void setKorealicense(String korealicense) {
        this.korealicense = korealicense == null ? null : korealicense.trim();
    }

    public String getTranslatewebsite() {
        return translatewebsite;
    }

    public void setTranslatewebsite(String translatewebsite) {
        this.translatewebsite = translatewebsite == null ? null : translatewebsite.trim();
    }

    public String getStudymajor() {
        return studymajor;
    }

    public void setStudymajor(String studymajor) {
        this.studymajor = studymajor == null ? null : studymajor.trim();
    }

    public String getSchoolreport() {
        return schoolreport;
    }

    public void setSchoolreport(String schoolreport) {
        this.schoolreport = schoolreport == null ? null : schoolreport.trim();
    }

    public String getOfficialnetworkurl() {
        return officialnetworkurl;
    }

    public void setOfficialnetworkurl(String officialnetworkurl) {
        this.officialnetworkurl = officialnetworkurl == null ? null : officialnetworkurl.trim();
    }

    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public Date getAudittime() {
        return audittime;
    }

    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    public Integer getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(Integer auditstatus) {
        this.auditstatus = auditstatus;
    }

    public String getAdminopinion() {
        return adminopinion;
    }

    public void setAdminopinion(String adminopinion) {
        this.adminopinion = adminopinion == null ? null : adminopinion.trim();
    }

	public Appraisalapply(Integer applyid, Integer userid, Integer stid, String name, Integer sex, Integer height,
			String constellation, Integer age, String visatype, Integer documenttype, String certificates,
			String experience, Boolean vehicle, Boolean guidecard, String inkorea, String phone, String email,
			String country, String provincialid, String cityid, String detailed, String hospitallicense,
			String cooperativehospital, String cooperativehospitalurl, String hospitalphone, Integer translatetype,
			String translate, Boolean office, String officecountry, String officeprovince, String officecity,
			String officedetailed, String korealicense, String translatewebsite, String studymajor, String schoolreport,
			String officialnetworkurl, Date submittime, Date audittime, Integer auditstatus, String adminopinion) {
		super();
		this.applyid = applyid;
		this.userid = userid;
		this.stid = stid;
		this.name = name;
		this.sex = sex;
		this.height = height;
		this.constellation = constellation;
		this.age = age;
		this.visatype = visatype;
		this.documenttype = documenttype;
		this.certificates = certificates;
		this.experience = experience;
		this.vehicle = vehicle;
		this.guidecard = guidecard;
		this.inkorea = inkorea;
		this.phone = phone;
		this.email = email;
		this.country = country;
		this.provincialid = provincialid;
		this.cityid = cityid;
		this.detailed = detailed;
		this.hospitallicense = hospitallicense;
		this.cooperativehospital = cooperativehospital;
		this.cooperativehospitalurl = cooperativehospitalurl;
		this.hospitalphone = hospitalphone;
		this.translatetype = translatetype;
		this.translate = translate;
		this.office = office;
		this.officecountry = officecountry;
		this.officeprovince = officeprovince;
		this.officecity = officecity;
		this.officedetailed = officedetailed;
		this.korealicense = korealicense;
		this.translatewebsite = translatewebsite;
		this.studymajor = studymajor;
		this.schoolreport = schoolreport;
		this.officialnetworkurl = officialnetworkurl;
		this.submittime = submittime;
		this.audittime = audittime;
		this.auditstatus = auditstatus;
		this.adminopinion = adminopinion;
	}

	public Appraisalapply() {
		super();
	}
	
}