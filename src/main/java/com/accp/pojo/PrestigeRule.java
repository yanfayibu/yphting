package com.accp.pojo;

/**
 * 信誉分规则表
 */
public class PrestigeRule {
	private Integer id; // 编号

	private Integer name; // 规则名称

	private Integer minnum; // 最低数

	private Integer maxnum; // 最高数

	private Integer score; // 信誉分

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getName() {
		return name;
	}

	public void setName(Integer name) {
		this.name = name;
	}

	public Integer getMinnum() {
		return minnum;
	}

	public void setMinnum(Integer minnum) {
		this.minnum = minnum;
	}

	public Integer getMaxnum() {
		return maxnum;
	}

	public void setMaxnum(Integer maxnum) {
		this.maxnum = maxnum;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public PrestigeRule(Integer id, Integer name, Integer minnum, Integer maxnum, Integer score) {
		super();
		this.id = id;
		this.name = name;
		this.minnum = minnum;
		this.maxnum = maxnum;
		this.score = score;
	}

	public PrestigeRule() {
		super();
	}

}