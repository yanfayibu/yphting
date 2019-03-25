package com.accp.vo.smy;

import java.util.Date;

public class UserAppVo {
		private int applyID;
		private int stid;//外键，服务编号
		private  String   stname;//服务名称
		private Date submittime;//提交时间
		private Date audittime;//审核时间
		private int auditstatus;//审核状态
		public int getApplyID() {
			return applyID;
		}
		public void setApplyID(int applyID) {
			this.applyID = applyID;
		}
		public int getStid() {
			return stid;
		}
		public void setStid(int stid) {
			this.stid = stid;
		}
		public String getStname() {
			return stname;
		}
		public void setStname(String stname) {
			this.stname = stname;
		}
		public Date getSubmittime() {
			return submittime;
		}
		public void setSubmittime(Date submittime) {
			this.submittime = submittime;
		}
		public Date getAudittime() {
			return audittime;
		}
		public void setAudittime(Date audittime) {
			this.audittime = audittime;
		}
		public int getAuditstatus() {
			return auditstatus;
		}
		public void setAuditstatus(int auditstatus) {
			this.auditstatus = auditstatus;
		}
	
		
		
}
