package com.accp.vo.smy;

public class RefundVO extends com.accp.vo.smy.Refund{
	//订单
	private Order order;
	//买家
	private Users user;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
}
