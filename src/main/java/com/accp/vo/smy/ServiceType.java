package com.accp.vo.smy;
//serviceType服务类别表
public class ServiceType {
		private Integer stid;//	主键，自增
		private Integer stPid;//递归编号(父ID)
		private String stName;//服务名称
		private Integer sort;//	排序(层次作用 默认0 0是一级服务 以此类推)
		private Boolean display;//是否显示
		private Integer operationTime;//未操作时间
		private Integer confirmTime;//自动确认时间
		private Integer violatedNumber;//	服务违约天数
		private Integer proportion;//违约金比例
		private Boolean toExamine;//是否审核tinyint(1)
		private String advertisement;//	广告图片地址
		public Integer getStid() {
			return stid;
		}
		public void setStid(Integer stid) {
			this.stid = stid;
		}
		public Integer getStPid() {
			return stPid;
		}
		public void setStPid(Integer stPid) {
			this.stPid = stPid;
		}
		public String getStName() {
			return stName;
		}
		public void setStName(String stName) {
			this.stName = stName;
		}
		public Integer getSort() {
			return sort;
		}
		public void setSort(Integer sort) {
			this.sort = sort;
		}
		public Boolean getDisplay() {
			return display;
		}
		public void setDisplay(Boolean display) {
			this.display = display;
		}
		public Integer getOperationTime() {
			return operationTime;
		}
		public void setOperationTime(Integer operationTime) {
			this.operationTime = operationTime;
		}
		public Integer getConfirmTime() {
			return confirmTime;
		}
		public void setConfirmTime(Integer confirmTime) {
			this.confirmTime = confirmTime;
		}
		public Integer getViolatedNumber() {
			return violatedNumber;
		}
		public void setViolatedNumber(Integer violatedNumber) {
			this.violatedNumber = violatedNumber;
		}
		public Integer getProportion() {
			return proportion;
		}
		public void setProportion(Integer proportion) {
			this.proportion = proportion;
		}
		public Boolean getToExamine() {
			return toExamine;
		}
		public void setToExamine(Boolean toExamine) {
			this.toExamine = toExamine;
		}
		public String getAdvertisement() {
			return advertisement;
		}
		public void setAdvertisement(String advertisement) {
			this.advertisement = advertisement;
		}
		public ServiceType(Integer stid, Integer stPid, String stName, Integer sort, Boolean display,
				Integer operationTime, Integer confirmTime, Integer violatedNumber, Integer proportion,
				Boolean toExamine, String advertisement) {
			super();
			this.stid = stid;
			this.stPid = stPid;
			this.stName = stName;
			this.sort = sort;
			this.display = display;
			this.operationTime = operationTime;
			this.confirmTime = confirmTime;
			this.violatedNumber = violatedNumber;
			this.proportion = proportion;
			this.toExamine = toExamine;
			this.advertisement = advertisement;
		}
		public ServiceType() {
			super();
		}
		
		
}
