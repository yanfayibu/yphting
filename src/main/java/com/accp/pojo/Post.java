package com.accp.pojo;

import java.util.Date;
/**
 *帖子表
 */
public class Post {
	private Integer postid;              //帖子编号

	private Integer userid;              //用户ID

	private Integer browsenumber;        //浏览数

	private Integer commentnumber;       //评论数

	private Integer fabulousnumber;      //点赞数

	private Integer collectionnumber;    //收藏数

	private Integer fmid;                //论坛板块管理表(里边有帖子类别，也相当于板块类别，填最低层级编号)

	private String title;                //标题

	private Date releasetime;            //发布时间

	private Integer operatingstate;      //操作状态(1未删除2已删除)

	private Boolean essence;             //加精

	private Boolean solid;               //加固

	private Integer majorid;             //专业类别

	private String resourcespath;        //资源地址

	private String servicecosttypeid;    //逻辑外键，费用说明

	private Integer integral;            //所需积分

	private Integer goldcoin;            //所需金币

	private String videopath;            //上传视频

	private String coverpath;            //视频封面

	private String time;                 //视频时长(0分0秒)

	private Integer auditstatus;         //审核状态(1待审核2审核成功3未通过)

	private String content;              //内容

	private String adminopinion;         //管理员意见

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getAdminopinion() {
		return adminopinion;
	}

	public void setAdminopinion(String adminopinion) {
		this.adminopinion = adminopinion == null ? null : adminopinion.trim();
	}

	public Integer getPostid() {
		return postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getBrowsenumber() {
		return browsenumber;
	}

	public void setBrowsenumber(Integer browsenumber) {
		this.browsenumber = browsenumber;
	}

	public Integer getCommentnumber() {
		return commentnumber;
	}

	public void setCommentnumber(Integer commentnumber) {
		this.commentnumber = commentnumber;
	}

	public Integer getFabulousnumber() {
		return fabulousnumber;
	}

	public void setFabulousnumber(Integer fabulousnumber) {
		this.fabulousnumber = fabulousnumber;
	}

	public Integer getCollectionnumber() {
		return collectionnumber;
	}

	public void setCollectionnumber(Integer collectionnumber) {
		this.collectionnumber = collectionnumber;
	}

	public Integer getFmid() {
		return fmid;
	}

	public void setFmid(Integer fmid) {
		this.fmid = fmid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public Date getReleasetime() {
		return releasetime;
	}

	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
	}

	public Integer getOperatingstate() {
		return operatingstate;
	}

	public void setOperatingstate(Integer operatingstate) {
		this.operatingstate = operatingstate;
	}

	public Boolean getEssence() {
		return essence;
	}

	public void setEssence(Boolean essence) {
		this.essence = essence;
	}

	public Boolean getSolid() {
		return solid;
	}

	public void setSolid(Boolean solid) {
		this.solid = solid;
	}

	public Integer getMajorid() {
		return majorid;
	}

	public void setMajorid(Integer majorid) {
		this.majorid = majorid;
	}

	public String getResourcespath() {
		return resourcespath;
	}

	public void setResourcespath(String resourcespath) {
		this.resourcespath = resourcespath == null ? null : resourcespath.trim();
	}

	public String getServicecosttypeid() {
		return servicecosttypeid;
	}

	public void setServicecosttypeid(String servicecosttypeid) {
		this.servicecosttypeid = servicecosttypeid == null ? null : servicecosttypeid.trim();
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getGoldcoin() {
		return goldcoin;
	}

	public void setGoldcoin(Integer goldcoin) {
		this.goldcoin = goldcoin;
	}

	public String getVideopath() {
		return videopath;
	}

	public void setVideopath(String videopath) {
		this.videopath = videopath == null ? null : videopath.trim();
	}

	public String getCoverpath() {
		return coverpath;
	}

	public void setCoverpath(String coverpath) {
		this.coverpath = coverpath == null ? null : coverpath.trim();
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time == null ? null : time.trim();
	}

	public Integer getAuditstatus() {
		return auditstatus;
	}

	public void setAuditstatus(Integer auditstatus) {
		this.auditstatus = auditstatus;
	}

	public Post(Integer postid, Integer userid, Integer browsenumber, Integer commentnumber, Integer fabulousnumber,
			Integer collectionnumber, Integer fmid, String title, Date releasetime, Integer operatingstate,
			Boolean essence, Boolean solid, Integer majorid, String resourcespath, String servicecosttypeid,
			Integer integral, Integer goldcoin, String videopath, String coverpath, String time, Integer auditstatus,
			String content, String adminopinion) {
		super();
		this.postid = postid;
		this.userid = userid;
		this.browsenumber = browsenumber;
		this.commentnumber = commentnumber;
		this.fabulousnumber = fabulousnumber;
		this.collectionnumber = collectionnumber;
		this.fmid = fmid;
		this.title = title;
		this.releasetime = releasetime;
		this.operatingstate = operatingstate;
		this.essence = essence;
		this.solid = solid;
		this.majorid = majorid;
		this.resourcespath = resourcespath;
		this.servicecosttypeid = servicecosttypeid;
		this.integral = integral;
		this.goldcoin = goldcoin;
		this.videopath = videopath;
		this.coverpath = coverpath;
		this.time = time;
		this.auditstatus = auditstatus;
		this.content = content;
		this.adminopinion = adminopinion;
	}

	public Post() {
		super();
	}
	
}