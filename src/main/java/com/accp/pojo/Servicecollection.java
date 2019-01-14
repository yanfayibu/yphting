package com.accp.pojo;

import java.util.Date;
/**
 *服务收藏(商品收藏)表
 */
public class Servicecollection {
    private Integer sercolleid;   //编号

    private Integer serviceid;    //服务编号(商品表)

    private Integer userid;       //用户编号

    private Date collectiontime;  //收藏时间

    public Integer getSercolleid() {
        return sercolleid;
    }

    public void setSercolleid(Integer sercolleid) {
        this.sercolleid = sercolleid;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
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

	public Servicecollection(Integer sercolleid, Integer serviceid, Integer userid, Date collectiontime) {
		super();
		this.sercolleid = sercolleid;
		this.serviceid = serviceid;
		this.userid = userid;
		this.collectiontime = collectiontime;
	}

	public Servicecollection() {
		super();
	}
    
}