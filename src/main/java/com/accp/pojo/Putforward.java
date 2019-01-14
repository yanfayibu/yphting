package com.accp.pojo;

import java.util.Date;
/**
 *提现表
 */
public class Putforward {
    private Integer pfid;            //编号

    private Integer userid;          //用户ID

    private String putname;          //提现人姓名

    private Integer bankid;          //银行类别

    private String bankaccount;      //银行账号

    private String openbankname;     //开户行

    private Date submittime;         //提交申请时间

    private Date audittime;          //审核时间

    private Float money;             //提现金额

    private Integer auditstatus;     //审核状态(1待审核2审核成功3未通过)

    public Integer getPfid() {
        return pfid;
    }

    public void setPfid(Integer pfid) {
        this.pfid = pfid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPutname() {
        return putname;
    }

    public void setPutname(String putname) {
        this.putname = putname == null ? null : putname.trim();
    }

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount == null ? null : bankaccount.trim();
    }

    public String getOpenbankname() {
        return openbankname;
    }

    public void setOpenbankname(String openbankname) {
        this.openbankname = openbankname == null ? null : openbankname.trim();
    }

    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public Date getAudittime() {
        return audittime;
    }

    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(Integer auditstatus) {
        this.auditstatus = auditstatus;
    }

	public Putforward(Integer pfid, Integer userid, String putname, Integer bankid, String bankaccount,
			String openbankname, Date submittime, Date audittime, Float money, Integer auditstatus) {
		super();
		this.pfid = pfid;
		this.userid = userid;
		this.putname = putname;
		this.bankid = bankid;
		this.bankaccount = bankaccount;
		this.openbankname = openbankname;
		this.submittime = submittime;
		this.audittime = audittime;
		this.money = money;
		this.auditstatus = auditstatus;
	}

	public Putforward() {
		super();
	}
    
}