package com.accp.vo.smy;
//majorType专业表
public class MajorType {
	private Integer majorID;//专业编号，主键，自增列
	private Integer category;//	类别编号(1专业2学习资源分类)
	private String majorName;//专业名称
	public Integer getMajorID() {
		return majorID;
	}
	public void setMajorID(Integer majorID) {
		this.majorID = majorID;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public MajorType(Integer majorID, Integer category, String majorName) {
		super();
		this.majorID = majorID;
		this.category = category;
		this.majorName = majorName;
	}
	public MajorType() {
		super();
	}
	
	
		
}
