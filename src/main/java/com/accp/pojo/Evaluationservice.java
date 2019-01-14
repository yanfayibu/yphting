package com.accp.pojo;

import java.util.Date;
/**
 *商品(服务)评价表
 */
public class Evaluationservice {
    private Integer serviceappraiseid;           //服务评价编号

    private Integer serviceid;                   //服务编号

    private Integer userid;                      //用户编号

    private String serviceappraisecontent;       //内容

    private Date serviceappraisedate;            //评价时间

    private Integer serviceappraiselevel;        //星级

    private Integer serviceappraisepid;          //上级编号，0：表示评价，其他：回复评价

    public Integer getServiceappraiseid() {
        return serviceappraiseid;
    }

    public void setServiceappraiseid(Integer serviceappraiseid) {
        this.serviceappraiseid = serviceappraiseid;
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

    public String getServiceappraisecontent() {
        return serviceappraisecontent;
    }

    public void setServiceappraisecontent(String serviceappraisecontent) {
        this.serviceappraisecontent = serviceappraisecontent == null ? null : serviceappraisecontent.trim();
    }

    public Date getServiceappraisedate() {
        return serviceappraisedate;
    }

    public void setServiceappraisedate(Date serviceappraisedate) {
        this.serviceappraisedate = serviceappraisedate;
    }

    public Integer getServiceappraiselevel() {
        return serviceappraiselevel;
    }

    public void setServiceappraiselevel(Integer serviceappraiselevel) {
        this.serviceappraiselevel = serviceappraiselevel;
    }

    public Integer getServiceappraisepid() {
        return serviceappraisepid;
    }

    public void setServiceappraisepid(Integer serviceappraisepid) {
        this.serviceappraisepid = serviceappraisepid;
    }

	public Evaluationservice(Integer serviceappraiseid, Integer serviceid, Integer userid,
			String serviceappraisecontent, Date serviceappraisedate, Integer serviceappraiselevel,
			Integer serviceappraisepid) {
		super();
		this.serviceappraiseid = serviceappraiseid;
		this.serviceid = serviceid;
		this.userid = userid;
		this.serviceappraisecontent = serviceappraisecontent;
		this.serviceappraisedate = serviceappraisedate;
		this.serviceappraiselevel = serviceappraiselevel;
		this.serviceappraisepid = serviceappraisepid;
	}

	public Evaluationservice() {
		super();
	}
    
}