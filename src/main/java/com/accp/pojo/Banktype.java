package com.accp.pojo;

/**
 *银行类别表
 */
public class Banktype {
    private Integer bankid;    //编号

    private String bankname;   //银行名称

    private Boolean show;      //是否显示

    private Integer sort;      //排序

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

	public Banktype(Integer bankid, String bankname, Boolean show, Integer sort) {
		super();
		this.bankid = bankid;
		this.bankname = bankname;
		this.show = show;
		this.sort = sort;
	}

	public Banktype() {
		super();
	}
	
}