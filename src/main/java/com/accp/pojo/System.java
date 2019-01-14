package com.accp.pojo;
/**
 *系统配置表
 */
public class System {
    private Integer sysid;               //编号

    private Integer exchangerate;        //金币汇率

    private Integer charge;              //收费比例

    private Integer signin;              //签到获得积分

    private Integer postintegral;        //发帖获得积分

    private Integer track;               //跟帖获得积分

    private Integer releasebeauty;       //发布美妆获得积分

    private Integer logisticmin;         //普通会员物流重量

    private Integer logisticminseller;   //商家会员物流重量

    private Integer logisticweight;      //上门取货物流重量

    private Integer logisticprice;       //单价/kg

    private Float bond;                  //保证金

    private Integer videosize;           //视频大小/MB

    private Integer closeorderdays;      //订单下单未付款，n天后自动关闭，0为不自动关闭

    private Integer receivedays;         //订单完成后，n天后自动确认服务，0为不自动确认服务

    private Integer refunddays;          //订单完成后，用户在n天内可以发起退款申请，设置0天不允许完成订单退款

    private Integer refundconfirmdays;   //用户发起退款申请后，订单退款申请几天后自动确认

    private Boolean shopfreestatus;      //是否开启店铺免费体验模式

    private Integer freetime;            //店铺免费体验月数

    public Integer getSysid() {
        return sysid;
    }

    public void setSysid(Integer sysid) {
        this.sysid = sysid;
    }

    public Integer getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(Integer exchangerate) {
        this.exchangerate = exchangerate;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public Integer getSignin() {
        return signin;
    }

    public void setSignin(Integer signin) {
        this.signin = signin;
    }

    public Integer getPostintegral() {
        return postintegral;
    }

    public void setPostintegral(Integer postintegral) {
        this.postintegral = postintegral;
    }

    public Integer getTrack() {
        return track;
    }

    public void setTrack(Integer track) {
        this.track = track;
    }

    public Integer getReleasebeauty() {
        return releasebeauty;
    }

    public void setReleasebeauty(Integer releasebeauty) {
        this.releasebeauty = releasebeauty;
    }

    public Integer getLogisticmin() {
        return logisticmin;
    }

    public void setLogisticmin(Integer logisticmin) {
        this.logisticmin = logisticmin;
    }

    public Integer getLogisticminseller() {
        return logisticminseller;
    }

    public void setLogisticminseller(Integer logisticminseller) {
        this.logisticminseller = logisticminseller;
    }

    public Integer getLogisticweight() {
        return logisticweight;
    }

    public void setLogisticweight(Integer logisticweight) {
        this.logisticweight = logisticweight;
    }

    public Integer getLogisticprice() {
        return logisticprice;
    }

    public void setLogisticprice(Integer logisticprice) {
        this.logisticprice = logisticprice;
    }

    public Float getBond() {
        return bond;
    }

    public void setBond(Float bond) {
        this.bond = bond;
    }

    public Integer getVideosize() {
        return videosize;
    }

    public void setVideosize(Integer videosize) {
        this.videosize = videosize;
    }

    public Integer getCloseorderdays() {
        return closeorderdays;
    }

    public void setCloseorderdays(Integer closeorderdays) {
        this.closeorderdays = closeorderdays;
    }

    public Integer getReceivedays() {
        return receivedays;
    }

    public void setReceivedays(Integer receivedays) {
        this.receivedays = receivedays;
    }

    public Integer getRefunddays() {
        return refunddays;
    }

    public void setRefunddays(Integer refunddays) {
        this.refunddays = refunddays;
    }

    public Integer getRefundconfirmdays() {
        return refundconfirmdays;
    }

    public void setRefundconfirmdays(Integer refundconfirmdays) {
        this.refundconfirmdays = refundconfirmdays;
    }

    public Boolean getShopfreestatus() {
        return shopfreestatus;
    }

    public void setShopfreestatus(Boolean shopfreestatus) {
        this.shopfreestatus = shopfreestatus;
    }

    public Integer getFreetime() {
        return freetime;
    }

    public void setFreetime(Integer freetime) {
        this.freetime = freetime;
    }

	public System(Integer sysid, Integer exchangerate, Integer charge, Integer signin, Integer postintegral,
			Integer track, Integer releasebeauty, Integer logisticmin, Integer logisticminseller,
			Integer logisticweight, Integer logisticprice, Float bond, Integer videosize, Integer closeorderdays,
			Integer receivedays, Integer refunddays, Integer refundconfirmdays, Boolean shopfreestatus,
			Integer freetime) {
		super();
		this.sysid = sysid;
		this.exchangerate = exchangerate;
		this.charge = charge;
		this.signin = signin;
		this.postintegral = postintegral;
		this.track = track;
		this.releasebeauty = releasebeauty;
		this.logisticmin = logisticmin;
		this.logisticminseller = logisticminseller;
		this.logisticweight = logisticweight;
		this.logisticprice = logisticprice;
		this.bond = bond;
		this.videosize = videosize;
		this.closeorderdays = closeorderdays;
		this.receivedays = receivedays;
		this.refunddays = refunddays;
		this.refundconfirmdays = refundconfirmdays;
		this.shopfreestatus = shopfreestatus;
		this.freetime = freetime;
	}

	public System() {
		super();
	}
    
}