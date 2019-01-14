package com.accp.pojo;

import java.util.Date;
/**
 *下载记录表(用于-论坛资源下载记录)
 */
public class Downloadrecord {
    private Integer drid;        //编号

    private Integer userid;      //用户编号

    private Integer postid;      //帖子编号

    private Date downloadtime;   //下载时间

    public Integer getDrid() {
        return drid;
    }

    public void setDrid(Integer drid) {
        this.drid = drid;
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

    public Date getDownloadtime() {
        return downloadtime;
    }

    public void setDownloadtime(Date downloadtime) {
        this.downloadtime = downloadtime;
    }

	public Downloadrecord(Integer drid, Integer userid, Integer postid, Date downloadtime) {
		super();
		this.drid = drid;
		this.userid = userid;
		this.postid = postid;
		this.downloadtime = downloadtime;
	}

	public Downloadrecord() {
		super();
	}
    
}