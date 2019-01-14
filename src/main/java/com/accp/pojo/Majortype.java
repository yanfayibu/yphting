package com.accp.pojo;
/**
 *专业表
 */
public class Majortype {
    private Integer majorid;   //专业编号

    private Integer category;  //类别编号(1专业2学习资源分类)

    private String majorname;  //专业名称

    public Integer getMajorid() {
        return majorid;
    }

    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname == null ? null : majorname.trim();
    }

	public Majortype(Integer majorid, Integer category, String majorname) {
		super();
		this.majorid = majorid;
		this.category = category;
		this.majorname = majorname;
	}

	public Majortype() {
		super();
	}
    
}