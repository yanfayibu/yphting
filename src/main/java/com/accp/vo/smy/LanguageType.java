package com.accp.vo.smy;
//languageType服务语言表
public class LanguageType {
		private Integer languageID;//语言编号，主键，自增列
		private String languageName;//语言名称
		public Integer getLanguageID() {
			return languageID;
		}
		public void setLanguageID(Integer languageID) {
			this.languageID = languageID;
		}
		public String getLanguageName() {
			return languageName;
		}
		public void setLanguageName(String languageName) {
			this.languageName = languageName;
		}
		public LanguageType(Integer languageID, String languageName) {
			super();
			this.languageID = languageID;
			this.languageName = languageName;
		}
		public LanguageType() {
			super();
		}
		
		
		
}
