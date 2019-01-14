package com.accp.pojo;

import java.util.Date;
/**
 *物流表
 */
public class Logistics {
    private Integer logisticsid;             //编号

    private Integer userid;                  //用户编号

    private String orderid;                  //服务单号

    private String title;                    //物品标题
 
    private String img1;                     //物品图片1

    private String img2;                     //物品图片2

    private String img3;                     //物品图片3

    private String img4;                     //物品图片4

    private String img5;                     //物品图片5

    private Integer kg;                      //重量

    private Integer delivery;                //发货方式(貌似固定1.上门提货/大于30kg2.自发)

    private Integer price;                   //金币(根据重量计算)

    private String userphone;                //发货人电话

    private String username;                 //发货人姓名

    private String useraddr;                 //发货人地址

    private String collectgoods;             //收货人姓名

    private String collectgoodsphone;        //收货人电话

    private String collectgoodsaddr;         //收货地址

    private Date ordertime;                  //下单时间

    private Integer auditstatus;             //审核状态(1待审核2审核成功3未通过)

    private Date audittime;                  //审核通过时间

    private String logisticscompany;         //用户发货物流公司

    private String logisticssinglenumber;    //用户发货物流单号

    private Date submittime;                 //单号提交时间

    private String number1;                  //已发国际EMS单号1

    private String number2;                  //已发国际EMS单号2

    private Date numbertime1;                //发国际EMS单号时间1

    private Date numbertime2;                //发国际EMS单号时间2
 
    private Date confirmationtime;           //用户确认完成时间

    private String describe;                 //物品描述

    public Integer getLogisticsid() {
        return logisticsid;
    }

    public void setLogisticsid(Integer logisticsid) {
        this.logisticsid = logisticsid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1 == null ? null : img1.trim();
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2 == null ? null : img2.trim();
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3 == null ? null : img3.trim();
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4 == null ? null : img4.trim();
    }

    public String getImg5() {
        return img5;
    }

    public void setImg5(String img5) {
        this.img5 = img5 == null ? null : img5.trim();
    }

    public Integer getKg() {
        return kg;
    }

    public void setKg(Integer kg) {
        this.kg = kg;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUseraddr() {
        return useraddr;
    }

    public void setUseraddr(String useraddr) {
        this.useraddr = useraddr == null ? null : useraddr.trim();
    }

    public String getCollectgoods() {
        return collectgoods;
    }

    public void setCollectgoods(String collectgoods) {
        this.collectgoods = collectgoods == null ? null : collectgoods.trim();
    }

    public String getCollectgoodsphone() {
        return collectgoodsphone;
    }

    public void setCollectgoodsphone(String collectgoodsphone) {
        this.collectgoodsphone = collectgoodsphone == null ? null : collectgoodsphone.trim();
    }

    public String getCollectgoodsaddr() {
        return collectgoodsaddr;
    }

    public void setCollectgoodsaddr(String collectgoodsaddr) {
        this.collectgoodsaddr = collectgoodsaddr == null ? null : collectgoodsaddr.trim();
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(Integer auditstatus) {
        this.auditstatus = auditstatus;
    }

    public Date getAudittime() {
        return audittime;
    }

    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    public String getLogisticscompany() {
        return logisticscompany;
    }

    public void setLogisticscompany(String logisticscompany) {
        this.logisticscompany = logisticscompany == null ? null : logisticscompany.trim();
    }

    public String getLogisticssinglenumber() {
        return logisticssinglenumber;
    }

    public void setLogisticssinglenumber(String logisticssinglenumber) {
        this.logisticssinglenumber = logisticssinglenumber == null ? null : logisticssinglenumber.trim();
    }

    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1 == null ? null : number1.trim();
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2 == null ? null : number2.trim();
    }

    public Date getNumbertime1() {
        return numbertime1;
    }

    public void setNumbertime1(Date numbertime1) {
        this.numbertime1 = numbertime1;
    }

    public Date getNumbertime2() {
        return numbertime2;
    }

    public void setNumbertime2(Date numbertime2) {
        this.numbertime2 = numbertime2;
    }

    public Date getConfirmationtime() {
        return confirmationtime;
    }

    public void setConfirmationtime(Date confirmationtime) {
        this.confirmationtime = confirmationtime;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

	public Logistics(Integer logisticsid, Integer userid, String orderid, String title, String img1, String img2,
			String img3, String img4, String img5, Integer kg, Integer delivery, Integer price, String userphone,
			String username, String useraddr, String collectgoods, String collectgoodsphone, String collectgoodsaddr,
			Date ordertime, Integer auditstatus, Date audittime, String logisticscompany, String logisticssinglenumber,
			Date submittime, String number1, String number2, Date numbertime1, Date numbertime2, Date confirmationtime,
			String describe) {
		super();
		this.logisticsid = logisticsid;
		this.userid = userid;
		this.orderid = orderid;
		this.title = title;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.img5 = img5;
		this.kg = kg;
		this.delivery = delivery;
		this.price = price;
		this.userphone = userphone;
		this.username = username;
		this.useraddr = useraddr;
		this.collectgoods = collectgoods;
		this.collectgoodsphone = collectgoodsphone;
		this.collectgoodsaddr = collectgoodsaddr;
		this.ordertime = ordertime;
		this.auditstatus = auditstatus;
		this.audittime = audittime;
		this.logisticscompany = logisticscompany;
		this.logisticssinglenumber = logisticssinglenumber;
		this.submittime = submittime;
		this.number1 = number1;
		this.number2 = number2;
		this.numbertime1 = numbertime1;
		this.numbertime2 = numbertime2;
		this.confirmationtime = confirmationtime;
		this.describe = describe;
	}

	public Logistics() {
		super();
	}
    
}