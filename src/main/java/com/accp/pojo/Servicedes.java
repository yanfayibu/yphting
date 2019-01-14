package com.accp.pojo;
/**
 *服务描述表
 */
public class Servicedes {
    private Integer servicedesid;            //服务描述编号

    private String servicedestitle;          //服务描述标题

    private String servicedescontentiourl;   //服务描述内容文件路径

    private Integer serviceid;               //服务编号

    public Integer getServicedesid() {
        return servicedesid;
    }

    public void setServicedesid(Integer servicedesid) {
        this.servicedesid = servicedesid;
    }

    public String getServicedestitle() {
        return servicedestitle;
    }

    public void setServicedestitle(String servicedestitle) {
        this.servicedestitle = servicedestitle == null ? null : servicedestitle.trim();
    }

    public String getServicedescontentiourl() {
        return servicedescontentiourl;
    }

    public void setServicedescontentiourl(String servicedescontentiourl) {
        this.servicedescontentiourl = servicedescontentiourl == null ? null : servicedescontentiourl.trim();
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

	public Servicedes(Integer servicedesid, String servicedestitle, String servicedescontentiourl, Integer serviceid) {
		super();
		this.servicedesid = servicedesid;
		this.servicedestitle = servicedestitle;
		this.servicedescontentiourl = servicedescontentiourl;
		this.serviceid = serviceid;
	}

	public Servicedes() {
		super();
	}
    
}