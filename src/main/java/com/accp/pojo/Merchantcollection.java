package com.accp.pojo;

import java.util.Date;
/**
 *商家收藏表
 */
public class Merchantcollection {
    private Integer collectid;                  //收藏编号

    private Integer userid;                     //用户编号

    private Integer merchantorservicebyid;      //商家编号

    private Integer collecttype;                //收藏类别

    private Date collectiontime;                //收藏时间

    public Integer getCollectid() {
        return collectid;
    }

    public void setCollectid(Integer collectid) {
        this.collectid = collectid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getMerchantorservicebyid() {
        return merchantorservicebyid;
    }

    public void setMerchantorservicebyid(Integer merchantorservicebyid) {
        this.merchantorservicebyid = merchantorservicebyid;
    }

    public Integer getCollecttype() {
        return collecttype;
    }

    public void setCollecttype(Integer collecttype) {
        this.collecttype = collecttype;
    }

    public Date getCollectiontime() {
        return collectiontime;
    }

    public void setCollectiontime(Date collectiontime) {
        this.collectiontime = collectiontime;
    }

	public Merchantcollection(Integer collectid, Integer userid, Integer merchantorservicebyid, Integer collecttype,
			Date collectiontime) {
		super();
		this.collectid = collectid;
		this.userid = userid;
		this.merchantorservicebyid = merchantorservicebyid;
		this.collecttype = collecttype;
		this.collectiontime = collectiontime;
	}

	public Merchantcollection() {
		super();
	}
    
}