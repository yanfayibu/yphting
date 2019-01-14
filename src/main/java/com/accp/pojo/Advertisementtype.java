package com.accp.pojo;
/**
 *广告位模块表
 */
public class Advertisementtype {
    private Integer atid;   //广告位模块编号

    private String atname;  //模块名称

    private String atpx;    //图片要求尺寸

    public Integer getAtid() {
        return atid;
    }

    public void setAtid(Integer atid) {
        this.atid = atid;
    }

    public String getAtname() {
        return atname;
    }

    public void setAtname(String atname) {
        this.atname = atname == null ? null : atname.trim();
    }

    public String getAtpx() {
        return atpx;
    }

    public void setAtpx(String atpx) {
        this.atpx = atpx == null ? null : atpx.trim();
    }

	public Advertisementtype(Integer atid, String atname, String atpx) {
		super();
		this.atid = atid;
		this.atname = atname;
		this.atpx = atpx;
	}

	public Advertisementtype() {
		super();
	}
	
}