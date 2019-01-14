package com.accp.pojo;
/**
 *中韩行政地区表
 */
public class Sharea { 
    private Integer areaid;        //编号

    private Integer pid;           //递归，父编号

    private String name;           //地区名称

    private String mergername;     //地区全称

    private Integer level;         //层级012国省市

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMergername() {
        return mergername;
    }

    public void setMergername(String mergername) {
        this.mergername = mergername == null ? null : mergername.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

	public Sharea(Integer areaid, Integer pid, String name, String mergername, Integer level) {
		super();
		this.areaid = areaid;
		this.pid = pid;
		this.name = name;
		this.mergername = mergername;
		this.level = level;
	}

	public Sharea() {
		super();
	}
    
}