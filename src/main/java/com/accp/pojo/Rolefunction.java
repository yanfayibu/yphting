package com.accp.pojo;
/**
 *角色权限绑定表
 */
public class Rolefunction {
    private Integer rfid;     //编号

    private Integer roleid;   //角色编号

    private Integer fid;      //权限编号

    public Integer getRfid() {
        return rfid;
    }

    public void setRfid(Integer rfid) {
        this.rfid = rfid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

	public Rolefunction(Integer rfid, Integer roleid, Integer fid) {
		super();
		this.rfid = rfid;
		this.roleid = roleid;
		this.fid = fid;
	}

	public Rolefunction() {
		super();
	}
    
}