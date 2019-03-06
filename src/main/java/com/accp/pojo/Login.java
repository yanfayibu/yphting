package com.accp.pojo;
/**
 *登入方式表
 */
public class Login {
    private Integer loginid;     //编号

    private Integer userid;      //用户编号

    private String opentid;      //第三方登入成功后返回的一个ID

    private Integer logintype;   //登入方式，第三方登入类别(1.邮箱/2.QQ/3.VX/4.微博/5.F啥的)

    private String useremail;    //用户邮箱账号(邮箱登入时用到，默认null)

    private String userpwd;      //用户密码(邮箱登入时用到，默认null)

    public Integer getLoginid() {
        return loginid;
    }

    public void setLoginid(Integer loginid) {
        this.loginid = loginid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getOpentid() {
        return opentid;
    }

    public void setOpentid(String opentid) {
        this.opentid = opentid == null ? null : opentid.trim();
    }

    public Integer getLogintype() {
        return logintype;
    }

    public void setLogintype(Integer logintype) {
        this.logintype = logintype;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

	public Login(Integer loginid, Integer userid, String opentid, Integer logintype, String useremail, String userpwd) {
		super();
		this.loginid = loginid;
		this.userid = userid;
		this.opentid = opentid;
		this.logintype = logintype;
		this.useremail = useremail;
		this.userpwd = userpwd;
	}

	public Login() {
		super();
	}

	/**   
	 * @Title:  Login   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:  @param useremail  
	 * @throws   
	 */
	public Login(String useremail) {
		super();
		this.useremail = useremail;
	}
    
}