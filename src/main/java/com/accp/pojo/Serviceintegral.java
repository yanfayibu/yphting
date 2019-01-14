package com.accp.pojo;
/**
 *服务积分表
 */
public class Serviceintegral {
    private Integer serintid;         //编号

    private Integer userid;           //用户编号

    private Integer stid;             //服务类别

    private Integer integral;         //积分

    public Integer getSerintid() {
        return serintid;
    }

    public void setSerintid(Integer serintid) {
        this.serintid = serintid;
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

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

	public Serviceintegral(Integer serintid, Integer userid, Integer stid, Integer integral) {
		super();
		this.serintid = serintid;
		this.userid = userid;
		this.stid = stid;
		this.integral = integral;
	}

	public Serviceintegral() {
		super();
	}
    
}