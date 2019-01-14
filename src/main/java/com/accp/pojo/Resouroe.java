package com.accp.pojo;
/**
 *资源类别表(用于-发布服务-资源类别)
 */
public class Resouroe {
    private Integer resouroeid;    //编号

    private String resouroename;   //类别名称

    public Integer getResouroeid() {
        return resouroeid;
    }

    public void setResouroeid(Integer resouroeid) {
        this.resouroeid = resouroeid;
    }

    public String getResouroename() {
        return resouroename;
    }

    public void setResouroename(String resouroename) {
        this.resouroename = resouroename == null ? null : resouroename.trim();
    }

	public Resouroe(Integer resouroeid, String resouroename) {
		super();
		this.resouroeid = resouroeid;
		this.resouroename = resouroename;
	}

	public Resouroe() {
		super();
	}
    
}