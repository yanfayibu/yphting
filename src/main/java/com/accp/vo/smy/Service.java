package com.accp.vo.smy;

public class Service extends com.accp.vo.smy.Services{
		// 商家
		private User user;
		// 服务类型
		private ServiceType serviceType;

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public ServiceType getServiceType() {
			return serviceType;
		}

		public void setServiceType(ServiceType serviceType) {
			this.serviceType = serviceType;
		}
}
