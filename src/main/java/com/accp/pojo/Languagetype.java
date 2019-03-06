package com.accp.pojo;
/**
 *服务语言表
 */
public class Languagetype {
	  private Integer languageid;   //语言编号

	    private String languagename;  //语言名称

	    public Integer getLanguageid() {
	        return languageid;
	    }

	    public void setLanguageid(Integer languageid) {
	        this.languageid = languageid;
	    }

	    public String getLanguagename() {
	        return languagename;
	    }

	    public void setLanguagename(String languagename) {
	        this.languagename = languagename == null ? null : languagename.trim();
	    }

		public Languagetype(Integer languageid, String languagename) {
			super();
			this.languageid = languageid;
			this.languagename = languagename;
		}

		public Languagetype() {
			super();
		}
    
}