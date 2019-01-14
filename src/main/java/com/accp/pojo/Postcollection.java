package com.accp.pojo;

import java.util.Date;
/**
 *帖子收藏表
 */
public class Postcollection {
    private Integer collectionid;    //帖子收藏编号

    private Integer pcid;            //帖子编号

    private Integer userid;          //用户编号

    private Date collectiontime;     //收藏时间
    
    private Integer collectionStatus;//收藏状态

    public Integer getCollectionid() {
        return collectionid;
    }

    public void setCollectionid(Integer collectionid) {
        this.collectionid = collectionid;
    }

    public Integer getPcid() {
        return pcid;
    }

    public void setPcid(Integer pcid) {
        this.pcid = pcid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCollectiontime() {
        return collectiontime;
    }

    public void setCollectiontime(Date collectiontime) {
        this.collectiontime = collectiontime;
    }

	public Integer getCollectionStatus() {
		return collectionStatus;
	}

	public void setCollectionStatus(Integer collectionStatus) {
		this.collectionStatus = collectionStatus;
	}

	public Postcollection(Integer collectionid, Integer pcid, Integer userid, Date collectiontime,
			Integer collectionStatus) {
		super();
		this.collectionid = collectionid;
		this.pcid = pcid;
		this.userid = userid;
		this.collectiontime = collectiontime;
		this.collectionStatus = collectionStatus;
	}

	public Postcollection() {
		super();
	}
    
}