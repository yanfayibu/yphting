package com.accp.pojo;

import java.util.Date;
/**
 *浏览记录表
 */
public class Browserecords {
    private Integer brid;         //编号

    private Integer brtype;       //浏览类别(1服务浏览2帖子浏览)
 
    private Integer userid;       //用户编号

    private Integer postid;       //帖子编号

    private Integer serviceid;    //服务编号

    private Date browsetime;      //浏览时间

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public Integer getBrtype() {
        return brtype;
    }

    public void setBrtype(Integer brtype) {
        this.brtype = brtype;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public Date getBrowsetime() {
        return browsetime;
    }

    public void setBrowsetime(Date browsetime) {
        this.browsetime = browsetime;
    }

	public Browserecords(Integer brid, Integer brtype, Integer userid, Integer postid, Integer serviceid,
			Date browsetime) {
		super();
		this.brid = brid;
		this.brtype = brtype;
		this.userid = userid;
		this.postid = postid;
		this.serviceid = serviceid;
		this.browsetime = browsetime;
	}

	public Browserecords() {
		super();
	}
    
}