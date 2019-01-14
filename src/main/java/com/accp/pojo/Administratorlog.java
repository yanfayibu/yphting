package com.accp.pojo;

import java.util.Date;
/**
 * 管理员日志表
 */
public class Administratorlog {
    private Integer adminlogid;   //管理员日志编号

    private Integer adminid;      //管理员编号

    private Date remarkstime;     //备注(以“修改了会员，ID：113”的方式记录)

    private String remarksip;     //记录时间

    private String remarks;       //做出操作的IP地址

    public Integer getAdminlogid() {
        return adminlogid;
    }

    public void setAdminlogid(Integer adminlogid) {
        this.adminlogid = adminlogid;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public Date getRemarkstime() {
        return remarkstime;
    }

    public void setRemarkstime(Date remarkstime) {
        this.remarkstime = remarkstime;
    }

    public String getRemarksip() {
        return remarksip;
    }

    public void setRemarksip(String remarksip) {
        this.remarksip = remarksip == null ? null : remarksip.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

	public Administratorlog(Integer adminlogid, Integer adminid, Date remarkstime, String remarksip, String remarks) {
		super();
		this.adminlogid = adminlogid;
		this.adminid = adminid;
		this.remarkstime = remarkstime;
		this.remarksip = remarksip;
		this.remarks = remarks;
	}

	public Administratorlog() {
		super();
	}
    
}