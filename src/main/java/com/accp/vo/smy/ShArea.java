package com.accp.vo.smy;
//ShArea(中韩行政地区表)
public class ShArea {
		private Integer areaID;//主键，编号
		private Integer pid ;//递归，父编号
		private String name;//地区名称
		private String mergerName;//地区全称
		private Integer level;//层级012国省市
		public Integer getAreaID() {
			return areaID;
		}
		public void setAreaID(Integer areaID) {
			this.areaID = areaID;
		}
		public Integer getPid() {
			return pid;
		}
		public void setPid(Integer pid) {
			this.pid = pid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMergerName() {
			return mergerName;
		}
		public void setMergerName(String mergerName) {
			this.mergerName = mergerName;
		}
		public Integer getLevel() {
			return level;
		}
		public void setLevel(Integer level) {
			this.level = level;
		}
		public ShArea(Integer areaID, Integer pid, String name, String mergerName, Integer level) {
			super();
			this.areaID = areaID;
			this.pid = pid;
			this.name = name;
			this.mergerName = mergerName;
			this.level = level;
		}
		public ShArea() {
			super();
		}
		
		
}
