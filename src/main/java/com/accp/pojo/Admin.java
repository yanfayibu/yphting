package com.accp.pojo;

import java.util.Date;
/**
 * 管理员表
 */
public class Admin {
    private Integer adminid;       //管理员编号
 
    private Integer admintype;     //管理员类别(1超级管理员2普通管理员)

    private String name;           //管理员账号

    private String password;       //管理员密码

    private Date creationtime;     //创建时间

    private Integer roleid;        //角色编号

    private String creationip;     //创建IP

    private Integer founder;       //创建人编号

    private Date recententry;      //用户最后登入时间

    private String ip;             //最后登入IP地址

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public Integer getAdmintype() {
        return admintype;
    }

    public void setAdmintype(Integer admintype) {
        this.admintype = admintype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getCreationip() {
        return creationip;
    }

    public void setCreationip(String creationip) {
        this.creationip = creationip == null ? null : creationip.trim();
    }

    public Integer getFounder() {
        return founder;
    }

    public void setFounder(Integer founder) {
        this.founder = founder;
    }

    public Date getRecententry() {
        return recententry;
    }

    public void setRecententry(Date recententry) {
        this.recententry = recententry;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

	public Admin(Integer adminid, Integer admintype, String name, String password, Date creationtime, Integer roleid,
			String creationip, Integer founder, Date recententry, String ip) {
		super();
		this.adminid = adminid;
		this.admintype = admintype;
		this.name = name;
		this.password = password;
		this.creationtime = creationtime;
		this.roleid = roleid;
		this.creationip = creationip;
		this.founder = founder;
		this.recententry = recententry;
		this.ip = ip;
	}

	public Admin() {
		super();
	}
}