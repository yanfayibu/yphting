package com.accp.pojo;

import java.util.Date;
/**
 *广告位表
 */
public class Advertisement {
    private Integer aid;       //(前台模块放ID，匹配后台广告)

    private Integer atid;      //广告位模块编号

    private String atitle;     //标题

    private Integer aorder;    //排序

    private String aimgpath;   //图片路径

    private String apcurl;     //PC端链接路径

    private String aappurl;    //手机端链接路径

    private Boolean state;     //广告位状态(已租/未租)

    private Date starttime;    //开始时间

    private Integer rentamonth;//租的月数

    private Float price;       //价格(单价/月)

    private String adescribe;  //描述

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getAtid() {
        return atid;
    }

    public void setAtid(Integer atid) {
        this.atid = atid;
    }

    public String getAtitle() {
        return atitle;
    }

    public void setAtitle(String atitle) {
        this.atitle = atitle == null ? null : atitle.trim();
    }

    public Integer getAorder() {
        return aorder;
    }

    public void setAorder(Integer aorder) {
        this.aorder = aorder;
    }

    public String getAimgpath() {
        return aimgpath;
    }

    public void setAimgpath(String aimgpath) {
        this.aimgpath = aimgpath == null ? null : aimgpath.trim();
    }

    public String getApcurl() {
        return apcurl;
    }

    public void setApcurl(String apcurl) {
        this.apcurl = apcurl == null ? null : apcurl.trim();
    }

    public String getAappurl() {
        return aappurl;
    }

    public void setAappurl(String aappurl) {
        this.aappurl = aappurl == null ? null : aappurl.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Integer getRentamonth() {
        return rentamonth;
    }

    public void setRentamonth(Integer rentamonth) {
        this.rentamonth = rentamonth;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getAdescribe() {
        return adescribe;
    }

    public void setAdescribe(String adescribe) {
        this.adescribe = adescribe == null ? null : adescribe.trim();
    }

	public Advertisement(Integer aid, Integer atid, String atitle, Integer aorder, String aimgpath, String apcurl,
			String aappurl, Boolean state, Date starttime, Integer rentamonth, Float price, String adescribe) {
		super();
		this.aid = aid;
		this.atid = atid;
		this.atitle = atitle;
		this.aorder = aorder;
		this.aimgpath = aimgpath;
		this.apcurl = apcurl;
		this.aappurl = aappurl;
		this.state = state;
		this.starttime = starttime;
		this.rentamonth = rentamonth;
		this.price = price;
		this.adescribe = adescribe;
	}

	public Advertisement() {
		super();
	}
    
}