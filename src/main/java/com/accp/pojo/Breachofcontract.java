package com.accp.pojo;
/**
 *违约规格表
 */
public class Breachofcontract {
    private Integer bcid;                  //编号

    private Integer stid;                  //外键，服务类别(一级服务)

    private Integer operationtime;         //未确认时间(单位/天)

    private Integer confirmationtime;      //自动确认时间(单位/小时)

    private Integer breachofcontracttime;  //违约时间(单位/天)

    private Integer confirmationmoney;     //违约金(百分比)

    public Integer getBcid() {
        return bcid;
    }

    public void setBcid(Integer bcid) {
        this.bcid = bcid;
    }

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public Integer getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(Integer operationtime) {
        this.operationtime = operationtime;
    }

    public Integer getConfirmationtime() {
        return confirmationtime;
    }

    public void setConfirmationtime(Integer confirmationtime) {
        this.confirmationtime = confirmationtime;
    }

    public Integer getBreachofcontracttime() {
        return breachofcontracttime;
    }

    public void setBreachofcontracttime(Integer breachofcontracttime) {
        this.breachofcontracttime = breachofcontracttime;
    }

    public Integer getConfirmationmoney() {
        return confirmationmoney;
    }

    public void setConfirmationmoney(Integer confirmationmoney) {
        this.confirmationmoney = confirmationmoney;
    }

	public Breachofcontract(Integer bcid, Integer stid, Integer operationtime, Integer confirmationtime,
			Integer breachofcontracttime, Integer confirmationmoney) {
		super();
		this.bcid = bcid;
		this.stid = stid;
		this.operationtime = operationtime;
		this.confirmationtime = confirmationtime;
		this.breachofcontracttime = breachofcontracttime;
		this.confirmationmoney = confirmationmoney;
	}

	public Breachofcontract() {
		super();
	}
    
}