package com.accp.pojo;

import java.util.Date;
/**
 *帖子点赞表
 */
public class Postfabulous {
    private Integer postfab;    //帖子点赞编号

    private Integer userid;     //用户编号

    private Integer postid;     //帖子编号

    private Date fabuloustime;  //点赞时间

    public Integer getPostfab() {
        return postfab;
    }

    public void setPostfab(Integer postfab) {
        this.postfab = postfab;
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

    public Date getFabuloustime() {
        return fabuloustime;
    }

    public void setFabuloustime(Date fabuloustime) {
        this.fabuloustime = fabuloustime;
    }

	public Postfabulous(Integer postfab, Integer userid, Integer postid, Date fabuloustime) {
		super();
		this.postfab = postfab;
		this.userid = userid;
		this.postid = postid;
		this.fabuloustime = fabuloustime;
	}

	public Postfabulous() {
		super();
	}
    
}