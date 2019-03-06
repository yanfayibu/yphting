
package com.accp.vo.lz;

import java.util.Date;

import com.accp.pojo.Services;
import com.accp.pojo.Servicetype;
import com.accp.pojo.User;

public class OrderVO {

	
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
    
    private Services service;//服务
    
    private Servicetype servicetype;//类别
    private User user;//商家
    private User thisuser;//自己
	/**  
	 * @Title:  getOrderid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public String getOrderid() {
		return orderid;
	}
	/**  
	 * @Title:  setOrderid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	/**  
	 * @Title:  getUserid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getUserid() {
		return userid;
	}
	/**  
	 * @Title:  setUserid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**  
	 * @Title:  getServiceid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getServiceid() {
		return serviceid;
	}
	/**  
	 * @Title:  setServiceid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setServiceid(Integer serviceid) {
		this.serviceid = serviceid;
	}
	/**  
	 * @Title:  getResouroeid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getResouroeid() {
		return resouroeid;
	}
	/**  
	 * @Title:  setResouroeid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setResouroeid(Integer resouroeid) {
		this.resouroeid = resouroeid;
	}
	/**  
	 * @Title:  getOrdertype <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getOrdertype() {
		return ordertype;
	}
	/**  
	 * @Title:  setOrdertype <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setOrdertype(Integer ordertype) {
		this.ordertype = ordertype;
	}
	/**  
	 * @Title:  getOrdertime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public Date getOrdertime() {
		return ordertime;
	}
	/**  
	 * @Title:  setOrdertime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	/**  
	 * @Title:  getPaymenttime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public Date getPaymenttime() {
		return paymenttime;
	}
	/**  
	 * @Title:  setPaymenttime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public void setPaymenttime(Date paymenttime) {
		this.paymenttime = paymenttime;
	}
	/**  
	 * @Title:  getReceipttime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public Date getReceipttime() {
		return receipttime;
	}
	/**  
	 * @Title:  setReceipttime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public void setReceipttime(Date receipttime) {
		this.receipttime = receipttime;
	}
	/**  
	 * @Title:  getProvideservicestime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public Date getProvideservicestime() {
		return provideservicestime;
	}
	/**  
	 * @Title:  setProvideservicestime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public void setProvideservicestime(Date provideservicestime) {
		this.provideservicestime = provideservicestime;
	}
	/**  
	 * @Title:  getCompletetime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public Date getCompletetime() {
		return completetime;
	}
	/**  
	 * @Title:  setCompletetime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public void setCompletetime(Date completetime) {
		this.completetime = completetime;
	}
	/**  
	 * @Title:  getScheduledstarttime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public Date getScheduledstarttime() {
		return scheduledstarttime;
	}
	/**  
	 * @Title:  setScheduledstarttime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public void setScheduledstarttime(Date scheduledstarttime) {
		this.scheduledstarttime = scheduledstarttime;
	}
	/**  
	 * @Title:  getScheduledendtime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public Date getScheduledendtime() {
		return scheduledendtime;
	}
	/**  
	 * @Title:  setScheduledendtime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public void setScheduledendtime(Date scheduledendtime) {
		this.scheduledendtime = scheduledendtime;
	}
	/**  
	 * @Title:  getPopulation <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getPopulation() {
		return population;
	}
	/**  
	 * @Title:  setPopulation <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setPopulation(Integer population) {
		this.population = population;
	}
	/**  
	 * @Title:  getNumber <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getNumber() {
		return number;
	}
	/**  
	 * @Title:  setNumber <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	/**  
	 * @Title:  getSmallplan <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Float <BR>  
	 */
	public Float getSmallplan() {
		return smallplan;
	}
	/**  
	 * @Title:  setSmallplan <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Float <BR>  
	 */
	public void setSmallplan(Float smallplan) {
		this.smallplan = smallplan;
	}
	/**  
	 * @Title:  getTotalprice <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Float <BR>  
	 */
	public Float getTotalprice() {
		return totalprice;
	}
	/**  
	 * @Title:  setTotalprice <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Float <BR>  
	 */
	public void setTotalprice(Float totalprice) {
		this.totalprice = totalprice;
	}
	/**  
	 * @Title:  getUploadpath <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public String getUploadpath() {
		return uploadpath;
	}
	/**  
	 * @Title:  setUploadpath <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public void setUploadpath(String uploadpath) {
		this.uploadpath = uploadpath;
	}
	/**  
	 * @Title:  getWeight <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Double <BR>  
	 */
	public Double getWeight() {
		return weight;
	}
	/**  
	 * @Title:  setWeight <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Double <BR>  
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	/**  
	 * @Title:  getIntegral <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getIntegral() {
		return integral;
	}
	/**  
	 * @Title:  setIntegral <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	/**  
	 * @Title:  getCollectgoods <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getCollectgoods() {
		return collectgoods;
	}
	/**  
	 * @Title:  setCollectgoods <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setCollectgoods(Integer collectgoods) {
		this.collectgoods = collectgoods;
	}
	/**  
	 * @Title:  getAddressid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getAddressid() {
		return addressid;
	}
	/**  
	 * @Title:  setAddressid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}
	/**  
	 * @Title:  getOrderstatus <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getOrderstatus() {
		return orderstatus;
	}
	/**  
	 * @Title:  setOrderstatus <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setOrderstatus(Integer orderstatus) {
		this.orderstatus = orderstatus;
	}
	/**  
	 * @Title:  getCommentstatus <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getCommentstatus() {
		return commentstatus;
	}
	/**  
	 * @Title:  setCommentstatus <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setCommentstatus(Integer commentstatus) {
		this.commentstatus = commentstatus;
	}
	/**  
	 * @Title:  getRefundstatus <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getRefundstatus() {
		return refundstatus;
	}
	/**  
	 * @Title:  setRefundstatus <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setRefundstatus(Integer refundstatus) {
		this.refundstatus = refundstatus;
	}
	/**  
	 * @Title:  getFilesatus <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getFilesatus() {
		return filesatus;
	}
	/**  
	 * @Title:  setFilesatus <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setFilesatus(Integer filesatus) {
		this.filesatus = filesatus;
	}
	/**  
	 * @Title:  getDocumentpath <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public String getDocumentpath() {
		return documentpath;
	}
	/**  
	 * @Title:  setDocumentpath <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public void setDocumentpath(String documentpath) {
		this.documentpath = documentpath;
	}
	/**  
	 * @Title:  getRemarks <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public String getRemarks() {
		return remarks;
	}
	/**  
	 * @Title:  setRemarks <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**  
	 * @Title:  getService <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Services <BR>  
	 */
	public Services getService() {
		return service;
	}
	/**  
	 * @Title:  setService <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Services <BR>  
	 */
	public void setService(Services service) {
		this.service = service;
	}
	/**  
	 * @Title:  getServicetype <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Servicetype <BR>  
	 */
	public Servicetype getServicetype() {
		return servicetype;
	}
	/**  
	 * @Title:  setServicetype <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Servicetype <BR>  
	 */
	public void setServicetype(Servicetype servicetype) {
		this.servicetype = servicetype;
	}
	/**  
	 * @Title:  getUser <BR>  
	 * @Description: please write your description <BR>  
	 * @return: User <BR>  
	 */
	public User getUser() {
		return user;
	}
	/**  
	 * @Title:  setUser <BR>  
	 * @Description: please write your description <BR>  
	 * @return: User <BR>  
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**  
	 * @Title:  getThisuser <BR>  
	 * @Description: please write your description <BR>  
	 * @return: User <BR>  
	 */
	public User getThisuser() {
		return thisuser;
	}
	/**  
	 * @Title:  setThisuser <BR>  
	 * @Description: please write your description <BR>  
	 * @return: User <BR>  
	 */
	public void setThisuser(User thisuser) {
		this.thisuser = thisuser;
	}
	/**   
	 * @Title:  OrderVO   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:    
	 * @throws   
	 */
	public OrderVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**   
	 * @Title:  OrderVO   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:  @param orderid
	 * @param:  @param userid
	 * @param:  @param orderstatus
	 * @param:  @param commentstatus  
	 * @throws   
	 */
	public OrderVO(String orderid, Integer userid, Integer orderstatus, Integer commentstatus) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.orderstatus = orderstatus;
		this.commentstatus = commentstatus;
	}

    
    
    
	
}
