package com.accp.vo.ydk;

public class Artificiaiintelligence {
	private int aiId;//id
	private int userId;//用户id
	private int firstStid;//服务id
	private int stid;//具体服务id
	
	
	public int getAiId() {
		return aiId;
	}
	public void setAiId(int aiId) {
		this.aiId = aiId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFirstStid() {
		return firstStid;
	}
	public void setFirstStid(int firstStid) {
		this.firstStid = firstStid;
	}
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public Artificiaiintelligence(int aiId, int userId, int firstStid, int stid) {
		super();
		this.aiId = aiId;
		this.userId = userId;
		this.firstStid = firstStid;
		this.stid = stid;
	}
	public Artificiaiintelligence() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Artificiaiintelligence [aiId=" + aiId + ", userId=" + userId + ", firstStid=" + firstStid + ", stid="
				+ stid + "]";
	}
	
	
}
