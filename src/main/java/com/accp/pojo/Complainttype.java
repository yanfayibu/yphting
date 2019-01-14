package com.accp.pojo;
/**
 *投诉类型表
 */
public class Complainttype {
    private Integer ctid;  //编号

    private String ctname; //投诉类型名称

    public Integer getCtid() {
        return ctid;
    }

    public void setCtid(Integer ctid) {
        this.ctid = ctid;
    }

    public String getCtname() {
        return ctname;
    }

    public void setCtname(String ctname) {
        this.ctname = ctname == null ? null : ctname.trim();
    }

	public Complainttype(Integer ctid, String ctname) {
		super();
		this.ctid = ctid;
		this.ctname = ctname;
	}

	public Complainttype() {
		super();
	}
    
}