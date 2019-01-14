package com.accp.pojo;

import java.util.Date;
/**
 *帖子评论表
 */
public class Postcomment {
    private Integer pcid;               //帖子评论ID

    private Integer postid;             //帖子ID

    private Integer commentator;        //评论人ID

    private Integer pid;                //递归ID(pid)

    private Date reviewtime;            //评论内容

    private Integer operatingstate;     //评论时间

    private String content;             //操作状态(1未删除2已删除)

    public Integer getPcid() {
        return pcid;
    }

    public void setPcid(Integer pcid) {
        this.pcid = pcid;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public Integer getCommentator() {
        return commentator;
    }

    public void setCommentator(Integer commentator) {
        this.commentator = commentator;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getReviewtime() {
        return reviewtime;
    }

    public void setReviewtime(Date reviewtime) {
        this.reviewtime = reviewtime;
    }

    public Integer getOperatingstate() {
        return operatingstate;
    }

    public void setOperatingstate(Integer operatingstate) {
        this.operatingstate = operatingstate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public Postcomment(Integer pcid, Integer postid, Integer commentator, Integer pid, Date reviewtime,
			Integer operatingstate, String content) {
		super();
		this.pcid = pcid;
		this.postid = postid;
		this.commentator = commentator;
		this.pid = pid;
		this.reviewtime = reviewtime;
		this.operatingstate = operatingstate;
		this.content = content;
	}

	public Postcomment() {
		super();
	}
    
}