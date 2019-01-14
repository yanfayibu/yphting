package com.accp.pojo;
/**
 *角色表
 */
public class Role {
    private Integer roleid;    //编号

    private String rolename;   //角色名称

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

	public Role(Integer roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}

	public Role() {
		super();
	}
    
}