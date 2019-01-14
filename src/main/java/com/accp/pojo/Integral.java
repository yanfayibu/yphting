package com.accp.pojo;
/**
 *积分规格表(干什么事，加多少积分)
 */
public class Integral {
    private Integer integralid;     //编号

    private Integer viceid;         //递归，父编号

    private String integralname;    //规格名称

    private Integer require;        //要求达到此次数,才可以加积分

    private Integer integral;       //积分

    public Integer getIntegralid() {
        return integralid;
    }

    public void setIntegralid(Integer integralid) {
        this.integralid = integralid;
    }

    public Integer getViceid() {
        return viceid;
    }

    public void setViceid(Integer viceid) {
        this.viceid = viceid;
    }

    public String getIntegralname() {
        return integralname;
    }

    public void setIntegralname(String integralname) {
        this.integralname = integralname == null ? null : integralname.trim();
    }

    public Integer getRequire() {
        return require;
    }

    public void setRequire(Integer require) {
        this.require = require;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

	public Integral(Integer integralid, Integer viceid, String integralname, Integer require, Integer integral) {
		super();
		this.integralid = integralid;
		this.viceid = viceid;
		this.integralname = integralname;
		this.require = require;
		this.integral = integral;
	}

	public Integral() {
		super();
	}
    
}