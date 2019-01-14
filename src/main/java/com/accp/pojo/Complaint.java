package com.accp.pojo;

import java.util.Date;
/**
 *帖子投诉表
 */
public class Complaint {
    private Integer cid;              //编号

    private Integer posting;          //发帖人编号

    private Integer pcid;             //帖子编号

    private Integer userid;           //投诉人编号

    private Integer ctid;             //投诉类型编号

    private Date timeofcomplaint;     //举报时间

    private Integer auditstatus;      //审核状态(1待审核2审核成功3未通过)

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPosting() {
        return posting;
    }

    public void setPosting(Integer posting) {
        this.posting = posting;
    }

    public Integer getPcid() {
        return pcid;
    }

    public void setPcid(Integer pcid) {
        this.pcid = pcid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCtid() {
        return ctid;
    }

    public void setCtid(Integer ctid) {
        this.ctid = ctid;
    }

    public Date getTimeofcomplaint() {
        return timeofcomplaint;
    }

    public void setTimeofcomplaint(Date timeofcomplaint) {
        this.timeofcomplaint = timeofcomplaint;
    }

    public Integer getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(Integer auditstatus) {
        this.auditstatus = auditstatus;
    }

	public Complaint(Integer cid, Integer posting, Integer pcid, Integer userid, Integer ctid, Date timeofcomplaint,
			Integer auditstatus) {
		super();
		this.cid = cid;
		this.posting = posting;
		this.pcid = pcid;
		this.userid = userid;
		this.ctid = ctid;
		this.timeofcomplaint = timeofcomplaint;
		this.auditstatus = auditstatus;
	}

	public Complaint() {
		super();
	}
    
}