package com.accp.pojo;

import java.util.Date;
/**
 *订单表
 */
public class Orders {
    private String orderid;            //订单编号，主键，算法生成

    private Integer userid;            //用户编号

    private Integer serviceid;         //商品编号(服务编号)

    private Integer resouroeid;        //资源类别

    private Integer ordertype;         //发货方式(1自发2上门取货)

    private Date ordertime;            //下单时间

    private Date paymenttime;          //付款时间

    private Date receipttime;          //接单时间

    private Date provideservicestime;  //提供服务时间

    private Date completetime;         //完成时间

    private Date scheduledstarttime;   //用户预定开始时间

    private Date scheduledendtime;     //用户预定结束时间

    private Integer population;        //人数

    private Integer number;            //份数

    private Float smallplan;           //小计

    private Float totalprice;          //订单总价

    private String uploadpath;         //上传文件路径

    private Double weight;             //订单重量

    private Integer integral;          //订单积分

    private Integer collectgoods;      //收货地址

    private Integer addressid;         //发货地址

    private Integer orderstatus;       //订单状态(1待付款2待接单3待提供服务4已提供服务6服务完成6服务取消7未接单8已退款)

    private Integer commentstatus;     //评论状态(1待评价2用户已评3双方已评)

    private Integer refundstatus;      //退款状态(1退款申请中2不同意3申请管理员介入4管理员拒绝5退款完成6退款取消)

    private Integer filesatus;         //文档状态(1待提供文档2商家已上传文档)

    private String documentpath;       //韩语翻译文档文件路径

    private String remarks;//备注

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public Integer getResouroeid() {
        return resouroeid;
    }

    public void setResouroeid(Integer resouroeid) {
        this.resouroeid = resouroeid;
    }

    public Integer getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Date getPaymenttime() {
        return paymenttime;
    }

    public void setPaymenttime(Date paymenttime) {
        this.paymenttime = paymenttime;
    }

    public Date getReceipttime() {
        return receipttime;
    }

    public void setReceipttime(Date receipttime) {
        this.receipttime = receipttime;
    }

    public Date getProvideservicestime() {
        return provideservicestime;
    }

    public void setProvideservicestime(Date provideservicestime) {
        this.provideservicestime = provideservicestime;
    }

    public Date getCompletetime() {
        return completetime;
    }

    public void setCompletetime(Date completetime) {
        this.completetime = completetime;
    }

    public Date getScheduledstarttime() {
        return scheduledstarttime;
    }

    public void setScheduledstarttime(Date scheduledstarttime) {
        this.scheduledstarttime = scheduledstarttime;
    }

    public Date getScheduledendtime() {
        return scheduledendtime;
    }

    public void setScheduledendtime(Date scheduledendtime) {
        this.scheduledendtime = scheduledendtime;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getSmallplan() {
        return smallplan;
    }

    public void setSmallplan(Float smallplan) {
        this.smallplan = smallplan;
    }

    public Float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Float totalprice) {
        this.totalprice = totalprice;
    }

    public String getUploadpath() {
        return uploadpath;
    }

    public void setUploadpath(String uploadpath) {
        this.uploadpath = uploadpath == null ? null : uploadpath.trim();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getCollectgoods() {
        return collectgoods;
    }

    public void setCollectgoods(Integer collectgoods) {
        this.collectgoods = collectgoods;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Integer getCommentstatus() {
        return commentstatus;
    }

    public void setCommentstatus(Integer commentstatus) {
        this.commentstatus = commentstatus;
    }

    public Integer getRefundstatus() {
        return refundstatus;
    }

    public void setRefundstatus(Integer refundstatus) {
        this.refundstatus = refundstatus;
    }

    public Integer getFilesatus() {
        return filesatus;
    }

    public void setFilesatus(Integer filesatus) {
        this.filesatus = filesatus;
    }

    public String getDocumentpath() {
        return documentpath;
    }

    public void setDocumentpath(String documentpath) {
        this.documentpath = documentpath == null ? null : documentpath.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

	public Orders(String orderid, Integer userid, Integer serviceid, Integer resouroeid, Integer ordertype,
			Date ordertime, Date paymenttime, Date receipttime, Date provideservicestime, Date completetime,
			Date scheduledstarttime, Date scheduledendtime, Integer population, Integer number, Float smallplan,
			Float totalprice, String uploadpath, Double weight, Integer integral, Integer collectgoods,
			Integer addressid, Integer orderstatus, Integer commentstatus, Integer refundstatus, Integer filesatus,
			String documentpath, String remarks) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.serviceid = serviceid;
		this.resouroeid = resouroeid;
		this.ordertype = ordertype;
		this.ordertime = ordertime;
		this.paymenttime = paymenttime;
		this.receipttime = receipttime;
		this.provideservicestime = provideservicestime;
		this.completetime = completetime;
		this.scheduledstarttime = scheduledstarttime;
		this.scheduledendtime = scheduledendtime;
		this.population = population;
		this.number = number;
		this.smallplan = smallplan;
		this.totalprice = totalprice;
		this.uploadpath = uploadpath;
		this.weight = weight;
		this.integral = integral;
		this.collectgoods = collectgoods;
		this.addressid = addressid;
		this.orderstatus = orderstatus;
		this.commentstatus = commentstatus;
		this.refundstatus = refundstatus;
		this.filesatus = filesatus;
		this.documentpath = documentpath;
		this.remarks = remarks;
	}

	public Orders() {
		super();
	}
    
}